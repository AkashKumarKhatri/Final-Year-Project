/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.UserDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.EmployeeModel;
import com.ehealth.models.UserModel;
import com.ehealth.models.UserTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Akash
 */
public class UserDAOImpl implements UserDAO {
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<UserModel> getAllUsers() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    @Override
    public Integer addUser(UserModel userModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into user (name,password,user_type_id,employee_id,created_by) values (?,?,?,?,?)");
            preparedStatement.setString(1, userModel.getName());
            preparedStatement.setString(2, userModel.getPassword());
            preparedStatement.setInt(3, userModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(4, userModel.getEmployeeModel().getEmployeeId());
            preparedStatement.setInt(5, userModel.getCreatedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateUser(UserModel userModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update user set name = ?,password = ?,user_type_id = ?,employee_id = ?,modified_by = ? where user_id = ?");
            preparedStatement.setString(1, userModel.getName());
            preparedStatement.setString(2, userModel.getPassword());
            preparedStatement.setInt(3, userModel.getUserTypeModel().getUserTypeId());
            preparedStatement.setInt(4, userModel.getEmployeeModel().getEmployeeId());
            preparedStatement.setInt(5, userModel.getModifiedBy());
            preparedStatement.setInt(6, userModel.getUserId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteUser(UserModel userModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update user set active = 0 where user_id = ?");
        preparedStatement.setInt(1, userModel.getUserId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllUserResultSet() {
        ResultSet rst = null;
        try {
            String sql = "SELECT u.user_id as 'User ID', u.`name` as 'Username'  , u.`password` as 'Password',"
                    + " e.name as 'Employee', ut.`user_type` as 'User Type' FROM user u  INNER JOIN user_types"
                    + " ut ON u.user_type_id = ut.user_type_id inner join employees e on u.employee_id = "
                    + "e.employee_id AND u.active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public UserModel getUserWithId(Integer userId) {
        UserModel userModel = null;
        UserTypeModel userTypeModel;
        EmployeeModel employeeModel;
        
        String sql = "SELECT * FROM user u INNER JOIN user_types ut ON u.user_type_id = ut.user_type_id "
                + " inner join employees e on u.employee_id = e.employee_id where u.user_id = ? AND u.active = 1";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,userId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                userModel = new UserModel();
                userTypeModel = new UserTypeModel();
                employeeModel = new EmployeeModel();
                userModel.setName(rs.getString("u.name"));
                userModel.setPassword(rs.getString("password"));
                userTypeModel.setUserType(rs.getString("user_type"));
                userModel.setUserTypeModel(userTypeModel);
                employeeModel.setName(rs.getString("e.name"));
                userModel.setEmployeeModel(employeeModel);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return userModel;
    }

    @Override
    public UserModel getUser(String username, String password) {
        UserModel userModel = null;
        UserTypeModel userTypeModel;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT u.user_id, ut.user_type,u.`name`,u.`password` FROM USER u INNER JOIN user_types ut \n" +
"ON u.user_type_id = ut.user_type_id WHERE u.`name` = ? AND u.`password` = ? AND u.active = 1");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next())
            {
                userModel = new UserModel();
                userTypeModel = new UserTypeModel();
                userModel.setUserId(resultSet.getInt("user_id"));
                userModel.setName(resultSet.getString("name"));
                userModel.setPassword(resultSet.getString("password"));
                userTypeModel.setUserType(resultSet.getString("user_type"));
                userModel.setUserTypeModel(userTypeModel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return userModel;
    }
}
    

