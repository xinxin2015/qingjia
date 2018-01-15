package com.upc.database.model;

public class Student {

    private int id;
    private int number;
    private String name;
    private int times;
    private int classes;
    private String password;
    private int daoyuanId;
    private Teacher daoyuan;

    public int getDaoyuanId() {
        return daoyuanId;
    }

    public void setDaoyuanId(int daoyuanId) {
        this.daoyuanId = daoyuanId;
    }

    public Teacher getDaoyuan() {
        return daoyuan;
    }

    public void setDaoyuan(Teacher daoyuan) {
        this.daoyuan = daoyuan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", times=" + times +
                ", classes=" + classes +
                ", password='" + password + '\'' +
                ", daoyuanId=" + daoyuanId +
                ", daoyuan=" + daoyuan +
                '}';
    }
}
