/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.PermissionDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.PermissionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akaash
 */
public class PermissionDAOImpl implements PermissionDAO{
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<PermissionModel> getAllPermissions() {
       List<PermissionModel> permissionModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from permission where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               PermissionModel permissionModel = new PermissionModel();
               permissionModel.setPermissionId(rs.getInt("permission_id"));
               permissionModel.setName(rs.getString("name"));
               permissionModel.setCreatedBy(rs.getInt("created_by"));
               permissionModel.setModifiedBy(rs.getInt("modified_by"));
               permissionModels.add(permissionModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return permissionModels;
    }

    @Override
    public Integer addPermission(PermissionModel permissionModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into permission (name,created_by,modified_by) values (?,?,?,?)");
            preparedStatement.setString(1, permissionModel.getName());
            preparedStatement.setInt(2, permissionModel.getCreatedBy());
            preparedStatement.setInt(3, permissionModel.getModifiedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updatePermission(PermissionModel permissionModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update employees set name = ?,created_by = ?,modified_by = ?");
            preparedStatement.setString(1, permissionModel.getName());
            preparedStatement.setInt(2, permissionModel.getCreatedBy());
            preparedStatement.setInt(3, permissionModel.getModifiedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deletePermission(PermissionModel permissionModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update permission set active = 0,where employee_id = ?");
        preparedStatement.setInt(1, permissionModel.getPermissionId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllPermissionResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select * from permission where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public PermissionModel getPermissionWithId(Integer employeeId) {
        PermissionModel permissionModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from permission where permission_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1,employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                permissionModel = new PermissionModel();
                permissionModel.setPermissionId(rs.getInt("permission_id"));
                permissionModel.setName(rs.getString("name"));
                permissionModel.setCreatedBy(rs.getInt("created_by"));
                permissionModel.setModifiedBy(rs.getInt("modified_by"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return permissionModel;
    }

    @Override
    public PermissionModel getPermissionWithPermissionType(String permissionType) {
        PermissionModel permissionModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from permissions where name = ? "
                    + "and active = 1");
            preparedStatement.setString(1,permissionType);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                permissionModel = new PermissionModel();
                permissionModel.setPermissionId(rs.getInt("permission_id"));
                permissionModel.setName(rs.getString("name"));
                permissionModel.setCreatedBy(rs.getInt("created_by"));
                permissionModel.setModifiedBy(rs.getInt("modified_by"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return permissionModel;
    }
}
