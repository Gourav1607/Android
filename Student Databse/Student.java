package com.gourav1607.studentdatabase;

import java.io.Serializable;

/**
 * Created by gourav1607 on 1/12/17.
 */

public class Student implements Serializable {
    private long id;
    private String name, college, subject;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return name;
    }
}
