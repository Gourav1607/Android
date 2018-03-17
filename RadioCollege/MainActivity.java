package com.gourav1607.radiocollege;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RadioGroup radioGroup;
    private RadioButton computerscience, mathematics, economics, electronics, zoology, physics,
            english, hindi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        computerscience = (RadioButton) findViewById(R.id.computerScience);
        mathematics = (RadioButton) findViewById(R.id.mathematics);
        economics = (RadioButton) findViewById(R.id.economics);
        electronics = (RadioButton) findViewById(R.id.electronics);
        zoology = (RadioButton) findViewById(R.id.zoology);
        physics = (RadioButton) findViewById(R.id.physics);
        english = (RadioButton) findViewById(R.id.english);
        hindi = (RadioButton) findViewById(R.id.hindi);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                String string = null;
                switch (checkedId) {
                    case R.id.computerScience:
                        string = new String("Dr. Baljeet Kaur");
                        break;
                    case R.id.mathematics:
                        string = mathematics.getText().toString();
                        break;
                    case R.id.economics:
                        string = economics.getText().toString();
                        break;
                    case R.id.electronics:
                        string = electronics.getText().toString();
                        break;
                    case R.id.zoology:
                        string = zoology.getText().toString();
                        break;
                    case R.id.physics:
                        string = physics.getText().toString();
                        break;
                    case R.id.english:
                        string = english.getText().toString();
                        break;
                    case R.id.hindi:
                        string = hindi.getText().toString();
                        break;
                }

                textView.setText(string);
            }
        });

    }
}
