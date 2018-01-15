package com.upc.database.service;

import com.upc.database.model.Leave;
import com.upc.database.model.Student;
import com.upc.database.model.Teacher;

public interface Auth {

    public Student studentLogin(int number,String password) throws Exception;
    public Teacher teacherLogin(int number,String password) throws Exception;
    public boolean addLeave(int studentId,int teacherId,String message) throws Exception;
    public boolean updateLeave(int id) throws Exception;
}
