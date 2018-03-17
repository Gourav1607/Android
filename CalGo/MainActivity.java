package com.gourav1607.calgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String display = "";
    private String currentOperator = "";
    private boolean operatorMem = false;
    private Double result = 0.0;
    private boolean hasResult = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText(display);
    }


    public void updateScreen() {
        textView.setText(display);
    }

    public void onClickNumber(View v) {
        if (hasResult & !operatorMem) {
            clear();
            updateScreen();
        }

        Button btn = (Button) v;
        display += btn.getText().toString();
        updateScreen();
    }

    public void onClickOperator(View v) {
        if (display.equals(""))
            return;

        Button btn = (Button) v;
        currentOperator = btn.getText().toString();

        // Replace Operator if already in memory... that is... clicked two different ones
        if (operatorMem)
            if (display.charAt(display.length() - 1) == '*' || display.charAt(display.length() - 1) == '/'
                    || display.charAt(display.length() - 1) == '-' || display.charAt(display.length() - 1) == '+') {
                display = display.substring(0, display.length() - 1);
            } else { //calculate result when second operator in clicked
                String[] operation = display.split(Pattern.quote(currentOperator));
                if (operation.length < 2)
                    return;

                result = operate(operation[0], operation[1], currentOperator);
                textView.setText(display + "\n" + String.valueOf(result));

                operatorMem = false;
                display = String.valueOf(result);
                hasResult = true;
            }

        display += currentOperator;
        updateScreen();
        operatorMem = true;
    }

    private void clear() {
        display = "";
        currentOperator = "";
        operatorMem = false;
        hasResult = false;
    }

    public void onClickClear(View v) {
        clear();
        updateScreen();
    }

    private double operate(String a, String b, String op) {
        switch (op) {
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            case "/":
                try {
                    return Double.valueOf(a) / Double.valueOf(b);
                } catch (Exception e) {
                    Log.d("Calc ", e.getMessage());
                }
            default:
                return -1;
        }
    }

    public void onClickEqual(View v) {
        if (display.equals(""))
            return;
        String[] operation = display.split(Pattern.quote(currentOperator));
        if (operation.length < 2)
            return;

        result = operate(operation[0], operation[1], currentOperator);
        textView.setText(display + "\n" + String.valueOf(result));

        operatorMem = false;
        display = String.valueOf(result);
        hasResult = true;
    }
}
