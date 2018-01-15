package com.upc.database.model;

public class Leave {
    private int studentId;
    private int teacherId;
    private String message;
    private int destory;
    private Teacher teacher;
    private Student student;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "studentId=" + studentId +
                ", teacherId=" + teacherId +
                ", message='" + message + '\'' +
                ", destory=" + destory +
                ", teacher=" + teacher +
                ", student=" + student +
                ", id=" + id +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDestory() {
        return destory;
    }

    public void setDestory(int destory) {
        this.destory = destory;
    }

}
