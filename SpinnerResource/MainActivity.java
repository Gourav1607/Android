package com.gourav1607.spinnerresource;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button showButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        showButton = (Button) findViewById(R.id.showButton);
        imageView = (ImageView) findViewById(R.id.imageView);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (String.valueOf(spinner.getSelectedItem())) {
                    case "France":
                        imageView.setImageResource(R.drawable.france);
                        break;
                    case "India":
                        imageView.setImageResource(R.drawable.india);
                        break;
                    case "Indonesia":
                        imageView.setImageResource(R.drawable.indonesia);
                        break;
                    case "Italy":
                        imageView.setImageResource(R.drawable.italy);
                        break;
                    case "Malaysia":
                        imageView.setImageResource(R.drawable.malaysia);
                        break;
                    case "New Zealand":
                        imageView.setImageResource(R.drawable.newzealand);
                        break;
                    case "Singapore":
                        imageView.setImageResource(R.drawable.singapore);
                        break;
                    case "United States":
                        imageView.setImageResource(R.drawable.unitedstates);
                        break;
                }
            }
        });
    }
}
