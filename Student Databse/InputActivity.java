package com.gourav1607.studentdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private EditText nameET, collegeET, subjectET;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        nameET = (EditText) findViewById(R.id.nameET);
        collegeET = (EditText) findViewById(R.id.collegeET);
        subjectET = (EditText) findViewById(R.id.subjectET);

        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setId(0);
                student.setName(nameET.getText().toString());
                student.setCollege(collegeET.getText().toString());
                student.setSubject(subjectET.getText().toString());

                int resultCode = 1;
                Intent resultIntent = new Intent(String.valueOf(resultCode));
                resultIntent.putExtra("student data", student);
                setResult(resultCode, resultIntent);
                finish();
            }
        });
    }
}
