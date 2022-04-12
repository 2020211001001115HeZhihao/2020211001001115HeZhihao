package com.HeZhihao.dao;

import com.HeZhihao.week7.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String gender = user.getGender();
        String Birthdate = user.getBirthdate();
        String in = "insert into HeZhihaotable values ('"+username+"','"+password+"','"+email+"','"+
                gender+"','"+Birthdate+"')";
        PreparedStatement ps = null;
        ps = con.prepareStatement(in);
        System.out.println("6*6 = 666666");
        ps.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {

        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {

        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {

        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select * from HeZhihaotable where username = '"+username+
                "' and password = '"+password+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        User user = null;
        if(rs.next()){
            user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getString("Birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {

        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
