/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.BloodDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.BloodModel;
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
public class BloodDAOImpl implements BloodDAO{
    Connection con = DBConnection.getConnection();
    @Override
    public List<BloodModel> getAllBloodGroups() {
        List<BloodModel> bloodModels = new ArrayList<>();
        BloodModel bloodModel = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select * from blood where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bloodModel = new BloodModel();
                bloodModel.setBloodId(rs.getInt("blood_id"));
                bloodModel.setBloodGroup(rs.getString("blood_group"));
                bloodModel.setCreatedBy(rs.getInt("created_by"));
                bloodModel.setModifiedBy(rs.getInt("modified_by"));
                bloodModels.add(bloodModel);
            }
        } catch (Exception e) {
        }
        return bloodModels;
    }

    @Override
    public Integer addBloodGroup(BloodModel bloodModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into blood (blood_group)"
                    + "values (?)");
            ps.setString(1, bloodModel.getBloodGroup());
            //ps.setInt(2, bloodModel.getCreatedBy());
            //ps.setInt(3, bloodModel.getModifiedBy());
            row = ps.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public Integer updateBloodGroup(BloodModel bloodModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update blood set blood_group = ? where blood_id = ?");//,created_by = ?,modified_by = ?");
            ps.setString(1, bloodModel.getBloodGroup());
            ps.setInt(2, bloodModel.getBloodId());
            //ps.setInt(2, bloodModel.getCreatedBy());
            //ps.setInt(3, bloodModel.getModifiedBy());
            row = ps.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    @Override
    public Integer deleteBloodGroup(BloodModel bloodModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update blood set active = 0 where blood_id = ?");
            ps.setInt(1, bloodModel.getBloodId());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllBloodGroupResultSet() {
        ResultSet rs = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("select * from blood where active = 1");
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    @Override
    public BloodModel getBloodGroupWithId(Integer bloodId) {
        BloodModel bloodModel = null;
        try {
            bloodModel = new BloodModel();
            PreparedStatement ps = con.prepareStatement("select * from blood where blood_id = ?");
            ps.setInt(1, bloodId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                bloodModel = new BloodModel();
                bloodModel.setBloodGroup(rs.getString("blood_group"));
                bloodModel.setCreatedBy(rs.getInt("created_by"));
                bloodModel.setModifiedBy(rs.getInt("modified_by"));
            }
        } catch (Exception e) {
        }
        return bloodModel;
    }

    @Override
    public BloodModel getBloodGroupWithName(String bloodGroup) {
        BloodModel bloodModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from blood where "
                    + "blood_group = ? and active = 1");
            preparedStatement.setString(1,bloodGroup);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                bloodModel = new BloodModel();
                bloodModel.setBloodId(resultSet.getInt("blood_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return bloodModel;
    }

    @Override
    public Boolean isAvailableBloodGroup(BloodModel bloodModel) {
        Boolean isAvailable = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from blood where blood_group = ? and active = 1");
            ps.setString(1, bloodModel.getBloodGroup());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailable = true;
            }
        } catch (Exception e) {
        }
        return isAvailable;
    }
}
