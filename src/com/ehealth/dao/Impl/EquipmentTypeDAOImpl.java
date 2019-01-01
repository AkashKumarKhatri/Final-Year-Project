package com.ehealth.dao.Impl;


import com.ehealth.dao.EquipmentTypeDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.EquipmentTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akaash
 */
public class EquipmentTypeDAOImpl implements EquipmentTypeDAO{

    Connection con = DBConnection.getConnection();
    
    @Override
    public List<EquipmentTypeModel> getAllEquipmentTypes() {
        List<EquipmentTypeModel> equipmentTypeModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from equipment_type where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               EquipmentTypeModel equipmentTypeModel = new EquipmentTypeModel();
               equipmentTypeModel.setEquipmentTypeId(rs.getInt("equipment_type_id"));
               equipmentTypeModel.setEquipmentType(rs.getString("type"));
               equipmentTypeModel.setCreatedBy(rs.getInt("created_by"));
               equipmentTypeModel.setModifiedBy(rs.getInt("modified_by"));
               equipmentTypeModels.add(equipmentTypeModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return equipmentTypeModels;
    }

    @Override
    public Integer addEquipmentType(EquipmentTypeModel equipmentTypeModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into equipment_type (type,created_by) values (?,?)");
            preparedStatement.setString(1, equipmentTypeModel.getEquipmentType());
            preparedStatement.setInt(2, equipmentTypeModel.getCreatedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateEquipmentType(EquipmentTypeModel equipmentTypeModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update equipment_type set type = ?,modified_by = ? where equipment_type_id = ?");
            preparedStatement.setString(1, equipmentTypeModel.getEquipmentType());
            preparedStatement.setInt(2, equipmentTypeModel.getModifiedBy());
            preparedStatement.setInt(3, equipmentTypeModel.getEquipmentTypeId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteEquipmentType(EquipmentTypeModel equipmentTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update equipment_type set active = 0 where equipment_type_id = ?");
        preparedStatement.setInt(1, equipmentTypeModel.getEquipmentTypeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllEquipmentTypeResultSet() {
        ResultSet rst = null;
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pstmt= con.prepareStatement("select equipment_type_id as 'Equipment Type ID',type as 'Equipment Type' from equipment_type where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public EquipmentTypeModel getEquipmentTypeWithId(Integer equipmentTypeId) {
        EquipmentTypeModel equipmentTypeModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from equipment_type where equipment_type_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1,equipmentTypeId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                equipmentTypeModel = new EquipmentTypeModel();
                equipmentTypeModel.setEquipmentType(rs.getString("type"));
                equipmentTypeModel.setCreatedBy(rs.getInt("created_by"));
                equipmentTypeModel.setModifiedBy(rs.getInt("modified_by"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return equipmentTypeModel;
    }

    @Override
    public EquipmentTypeModel getEquipmentTypeIdWithName(String equipmentTypeName) {
        EquipmentTypeModel equipmentTypeModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from equipment_type where type = ? "
                    + "and active = 1");
            preparedStatement.setString(1,equipmentTypeName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                equipmentTypeModel = new EquipmentTypeModel();
                equipmentTypeModel.setEquipmentTypeId(rs.getInt("equipment_type_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return equipmentTypeModel;
    }
}
