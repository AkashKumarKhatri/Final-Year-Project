/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.UserTypeDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.UserTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akash
 */
public class UserTypeDAOImpl implements UserTypeDAO {
    Connection con = DBConnection.getConnection();

    @Override
    public List<UserTypeModel> getAllUserTypes() {
        List<UserTypeModel> userTypeModels = new ArrayList<UserTypeModel>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from user_types where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                UserTypeModel userTypeModel = new UserTypeModel();
               userTypeModel.setUserTypeId(rs.getInt("user_type_id"));
               userTypeModel.setUserType(rs.getString("user_type"));
               userTypeModel.setCreatedBy(rs.getInt("created_by"));
               userTypeModel.setModifiedBy(rs.getInt("modified_by"));
               userTypeModels.add(userTypeModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
         return userTypeModels;
    }

    @Override
    public Integer addUserType(UserTypeModel userTypeModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into user_types (user_type,created_by) values (?,?)");
            ps.setString(1, userTypeModel.getUserType());
            ps.setInt(2, userTypeModel.getCreatedBy());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateUserType(UserTypeModel userTypeModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update user_types set user_type = ?,modified_by = ? where user_type_id = ?");
            ps.setString(1, userTypeModel.getUserType());
            ps.setInt(2, userTypeModel.getModifiedBy());
            ps.setInt(3, userTypeModel.getUserTypeId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteUserType(UserTypeModel userTypeModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update user_types set active = 0 where user_type_id = ?");
            ps.setInt(1, userTypeModel.getUserTypeId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllUserTypeResultSet() {
        ResultSet rs = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("select user_type_id as 'User Type ID', user_type as 'User Type' from user_types where active = 1");
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public UserTypeModel getUserTypeWithId(Integer userTypeId) {
        UserTypeModel userTypeModel = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from user_types where user_type_id = ?");
            ps.setInt(1, userTypeId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                userTypeModel = new UserTypeModel();
                userTypeModel.setUserType(rs.getString("user_type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userTypeModel;
    }

    @Override
    public UserTypeModel getUserTypeIdWithName(String userType) {
        UserTypeModel userTypeModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from user_types where "
                    + "user_type = ? and active = 1");
            preparedStatement.setString(1,userType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                userTypeModel = new UserTypeModel();
                userTypeModel.setUserTypeId(resultSet.getInt("user_type_id"));
                userTypeModel.setUserType(resultSet.getString("user_type"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return userTypeModel;
    }
    
}
