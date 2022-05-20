package COM.Dao;

import COM.Bean.student;
import COM.Util.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mannger {
    public void stulist(ArrayList<student> stulist) {
        try {
            String sql ="select * from student";
            //创建语句传输对象
            Connection connection = utils.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
            while(rs.next()) {
                student A = new student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                stulist.add(A);
            }
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public int delete(String id) {
        int i = 0;
    try {
        Connection connection = utils.getConnection();
        String sql ="delete from student where id=?";
        //创建语句传输对象
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        i=ps.executeUpdate();

    } catch (SQLException | ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return i;
    }

    public int update(student student)  {
        int i = 0;
        try {
            //创建语句传输对象
            Connection connection = utils.getConnection();
            String sql = "update student set name = ?,sex = ?,birthday = ? where id = ?";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1,student.getName());
            ps.setString(2,student.getSex());
            ps.setString(3,student.getBirthday());
            ps.setString(4,student.getId());
            i=ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {

        }
        return i;
    }

    public int add(student stu){
        int i=0;
        try {
            Connection connection = utils.getConnection();
            String sql = "insert into student(id,name,sex,birthday) values(?,?,?,?)";
            PreparedStatement ps = null;
            ps = connection.prepareStatement(sql);
            ps.setString(1,stu.getId());
            ps.setString(2, stu.getName());
            ps.setString(3,stu.getSex());
            ps.setString(4,stu.getBirthday());
            i = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public void select(ArrayList<student> stulist, String id) {
        try {
            String sql = "select * from student where id=?";
            //创建语句传输对象
            Connection connection = utils.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student A = new student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                stulist.add(A);
            }
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
