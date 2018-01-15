package com.upc.database.serviceImpl;

import com.upc.database.dao.AuthDao;
import com.upc.database.model.Leave;
import com.upc.database.model.Student;
import com.upc.database.model.Teacher;
import com.upc.database.service.Auth;

public class AuthImpl implements Auth {

    private AuthDao authDao = new AuthDao();
    @Override
    public Student studentLogin(int number, String password) throws Exception {
        return authDao.studentLogin(number,password);
    }

    @Override
    public Teacher teacherLogin(int number, String password) throws Exception {
        return authDao.teacherLogin(number,password);
    }

    @Override
    public boolean addLeave(int studentId, int teacherId, String message) throws Exception {
        Leave leave = new Leave();
        leave.setDestory(0);
        leave.setMessage(message);
        leave.setStudentId(studentId);
        leave.setTeacherId(teacherId);
        return authDao.addLeave(leave);
    }

    @Override
    public boolean updateLeave(int id) throws Exception {
        return authDao.updateLeave(id);
    }
}
