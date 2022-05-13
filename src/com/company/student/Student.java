package com.company.student;

import java.util.List;

public class Student {
    String cno;
    String cname;
    String grade;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
