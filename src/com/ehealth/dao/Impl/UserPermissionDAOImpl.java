/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.UserPermissionDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.PermissionModel;
import com.ehealth.models.UserPermissionModel;
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
public class UserPermissionDAOImpl implements UserPermissionDAO {

    Connection con = DBConnection.getConnection();
    
    @Override
    public List<UserPermissionModel> getAllUserPermissions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addUserPermission(UserPermissionModel userPermissionModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into user_permission (user_type_id,permission_id) values (?,?)");
            ps.setInt(1, userPermissionModel.getUserTypeModel().getUserTypeId());
            ps.setInt(2, userPermissionModel.getPermissionModel().getPermissionId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateUserPermission(UserPermissionModel userPermissionModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer deleteUserPermission(UserPermissionModel userPermissionModel) {
        int row = 0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("delete from user_permission where user_type_id = ?");
        preparedStatement.setInt(1, userPermissionModel.getUserTypeModel().getUserTypeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllUserPermissionResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserPermissionModel getUserPermissionWithId(Integer employeeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserPermissionModel> getAssignedPermissions(String userType) {
        List<UserPermissionModel> userPermissionModels = new ArrayList<>();
        UserPermissionModel userPermissionModel = null;
        PermissionModel permissionModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT u.user_type,p.name FROM user_types "
                    + "u,`permissions` p,`user_permission` up WHERE u.`user_type_id` = up.`user_type_id` AND "
                    + "up.`permission_id` = p.`permission_id` AND u.`active` = 1 AND p.`active` = 1 AND "
                    + "up.`active` = 1 AND user_type = ?");
            preparedStatement.setString(1,userType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                userPermissionModel = new UserPermissionModel();
                permissionModel = new PermissionModel();
                permissionModel.setName(resultSet.getString("name"));
                userPermissionModel.setPermissionModel(permissionModel);
                userPermissionModels.add(userPermissionModel);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return userPermissionModels;
    }

    @Override
    public List<UserPermissionModel> getUnassignedPermissions(String userType) {
        List<UserPermissionModel> userPermissionModels = new ArrayList<>();
        UserPermissionModel userPermissionModel = null;
        PermissionModel permissionModel = null;
        try {
            String query = "SELECT name FROM permissions WHERE permission_id NOT IN (SELECT p.`permission_id` FROM user_permission utp INNER JOIN user_types ut ON utp.`user_type_id`=ut.`user_type_id` INNER JOIN permissions p ON p.permission_id = utp.`permission_id` WHERE ut.`user_type`=? AND utp.`active`=1)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,userType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                userPermissionModel = new UserPermissionModel();
                permissionModel = new PermissionModel();
                permissionModel.setName(resultSet.getString("name"));
                userPermissionModel.setPermissionModel(permissionModel);
                userPermissionModels.add(userPermissionModel);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return userPermissionModels;
    }
    
}
