package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentsdetails")
public class StudentsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "S_NO")
    private int sNo;

    @Column(name = "STUDENT_ID")
    private int studentId;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "COURSES")
    private int courses;

    // Default constructor is needed for JPA
    public StudentsDetails() {
    }

  

    public StudentsDetails(int studentId, String studentName, int courses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public int getSNo() {
        return sNo;
    }

    public void setSNo(int sNo) {
        this.sNo = sNo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCourses() {
        return courses;
    }

    public void setCourses(int courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "StudentsDetails [ studentId=" + studentId + ", studentName=" + studentName
                + ", courses=" + courses + "]";
    }
}
