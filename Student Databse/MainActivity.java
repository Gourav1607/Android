package com.gourav1607.studentdatabase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentDataSource datasource;
    ListView listView;
    public final static int REQ_CODE_CHILD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list);

        datasource = new StudentDataSource(this);
        datasource.open();

        List<Student> values = datasource.getAllStudents();

        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this,
                android.R.layout.simple_list_item_1, values);

        listView.setAdapter(adapter);
    }

    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Student> adapter = (ArrayAdapter<Student>) listView.getAdapter();
        Student student = null;
        switch (view.getId()) {
            case R.id.addButton:
                Intent child = new Intent(getPackageName(), Uri.parse("com.gourav1607.studentdatabase.InputActivity"));
                startActivityForResult(child, REQ_CODE_CHILD);
                break;
            case R.id.deleteButton:
                if (adapter.getCount() > 0) {
                    student = (Student) adapter.getItem(0);
                    datasource.deleteStudent(student);
                    adapter.remove(student);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQ_CODE_CHILD) {
            Student st = (Student) data.getExtras().getSerializable("student data");
            Student student = datasource.createStudent(st.getName(), st.getCollege(), st.getSubject());
            ArrayAdapter<Student> adapter = (ArrayAdapter<Student>) listView.getAdapter();
            adapter.add(student);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
