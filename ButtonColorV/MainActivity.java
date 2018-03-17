package com.gourav1607.buttoncolorv;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button RedRB, GreenRB, BlueRB;
    private RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RedRB = (Button) findViewById(R.id.RedRB);
        GreenRB = (Button) findViewById(R.id.GreenRB);
        BlueRB = (Button) findViewById(R.id.BlueRB);

        RedRB.setOnClickListener(this);
        GreenRB.setOnClickListener(this);
        BlueRB.setOnClickListener(this);

        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.RedRB:
                rootLayout.setBackgroundColor(Color.RED);
                break;
            case R.id.GreenRB:
                rootLayout.setBackgroundColor(Color.GREEN);
                break;
            case R.id.BlueRB:
                rootLayout.setBackgroundColor(Color.BLUE);
                break;
        }
    }
}
