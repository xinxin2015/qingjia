package com.upc.database.dao;

import com.upc.database.model.Leave;
import com.upc.database.model.Student;
import com.upc.database.model.Teacher;
import com.upc.database.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthDao {

    public Student studentLogin(int number,String password) throws Exception {
        Student student = null;
        String sql = "select * from student where number = ? and password = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,number);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setClasses(rs.getInt("classes"));
            student.setTimes(rs.getInt("times"));
            student.setName(rs.getString("name"));
            student.setNumber(number);
            student.setPassword(rs.getString("password"));
            student.setDaoyuanId(rs.getInt("daoyuanId"));
            Teacher daoyuan = getTeacherById(rs.getInt("daoyuanId"));
            student.setDaoyuan(daoyuan);
        }
        return student;
    }

    public Teacher teacherLogin(int number, String password) throws Exception {
        Teacher teacher = null;
        String sql = "select * from teacher where number = ? and password = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,number);
        ps.setString(2,password);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            teacher.setNumber(number);
            teacher.setPassword(rs.getString("password"));
            teacher.setType(rs.getInt("type"));
        }
        return teacher;
    }

    public Teacher getTeacherById(int id) throws Exception {
        Teacher teacher = null;
        String sql = "select * from teacher where id = " + id;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            teacher.setNumber(rs.getInt("number"));
            teacher.setPassword(rs.getString("password"));
            teacher.setType(rs.getInt("type"));
        }
        return teacher;
    }

    public boolean addLeave(Leave leave) throws Exception {
        String sql = "insert into `leave` values(null,?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,leave.getStudentId());
        ps.setInt(2,leave.getDestory());
        ps.setInt(3,leave.getTeacherId());
        ps.setString(4,leave.getMessage());
        return ps.execute();
    }

    public Student getStudentById(int id) throws Exception {
        Student student = null;
        String sql = "select * from student where id = " + id;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setDaoyuanId(rs.getInt("daoyuanId"));
            student.setName(rs.getString("name"));
            student.setPassword(rs.getString("password"));
            student.setTimes(rs.getInt("times"));
            student.setClasses(rs.getInt("classes"));
            Teacher daoyuan = getTeacherById(rs.getInt("daoyuanId"));
            student.setDaoyuan(daoyuan);
        }
        return student;
    }

    public List<Leave> getLeaveByStuId(int studentId) throws Exception {
        List<Leave> leaves = new ArrayList<>();
        String sql = "select * from `leave` where studentId = " + studentId;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leave leave = new Leave();
            Teacher teacher = getTeacherById(rs.getInt("teacherId"));
            leave.setTeacher(teacher);
            Student student = getStudentById(rs.getInt("studentId"));
            leave.setStudent(student);
            leave.setMessage(rs.getString("message"));
            leave.setDestory(rs.getInt("destory"));
            leave.setId(rs.getInt("id"));
            leaves.add(leave);
        }
        return leaves;
    }

    public List<Leave> getLeaveByTId(int teacherId) throws Exception {
        List<Leave> leaves = new ArrayList<>();
        String sql = "select * from `leave` where teacherId = " + teacherId;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Leave leave = new Leave();
            Teacher teacher = getTeacherById(rs.getInt("teacherId"));
            leave.setTeacher(teacher);
            Student student = getStudentById(rs.getInt("studentId"));
            leave.setStudent(student);
            leave.setMessage(rs.getString("message"));
            leave.setDestory(rs.getInt("destory"));
            leave.setId(rs.getInt("id"));
            leaves.add(leave);
        }
        return leaves;
    }

    public boolean updateLeave(int id) throws Exception {
        String sql = "update `leave` set destory = 1 where id = " + id;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        return ps.execute();
    }
}
