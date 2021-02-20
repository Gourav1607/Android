package com.gourav1607.studentdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gourav1607 on 1/12/17.
 */

public class StudentDataSource {

    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_NAME, MySQLiteHelper.COLUMN_COLLEGE,
            MySQLiteHelper.COLUMN_SUBJECT };

    public StudentDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Student createStudent(String name, String college, String subject) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NAME, name);
        values.put(MySQLiteHelper.COLUMN_COLLEGE, college);
        values.put(MySQLiteHelper.COLUMN_SUBJECT, subject);

        long insertId = database.insert(MySQLiteHelper.TABLE_NAME, null, values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, allColumns,
                MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Student newStudent = cursorToStudent(cursor);
        cursor.close();
        return newStudent;
    }

    public void deleteStudent(Student student) {
        long id = student.getId();
        System.out.println("Student deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_NAME, MySQLiteHelper.COLUMN_ID + " = " + id, null);
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_NAME, allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Student student = cursorToStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return students;
    }

    private Student cursorToStudent(Cursor cursor) {
        Student student = new Student();
        student.setId(cursor.getLong(0));
        student.setName(cursor.getString(1));
        student.setCollege(cursor.getString(2));
        student.setSubject(cursor.getString(3));
        return student;
    }
}
