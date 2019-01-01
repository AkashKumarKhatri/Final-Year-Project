/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.EquipmentDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.EquipmentModel;
import com.ehealth.models.EquipmentTypeModel;
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
public class EquipmentDAOImpl implements EquipmentDAO {
    Connection con = DBConnection.getConnection();

    @Override
    public List<EquipmentModel> getAllEquipments() {
        List<EquipmentModel> equipmentModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from equipment where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               EquipmentModel equipmentModel = new EquipmentModel();
               equipmentModel.setEquipmentId(rs.getInt("equipment_id"));
               equipmentModel.setWarrenty(rs.getString("warrenty"));
               equipmentModel.setQuality(rs.getString("quality"));
               equipmentModel.setManufactures(rs.getString("manufactures"));
               equipmentModel.setCreatedBy(rs.getInt("created_by"));
               equipmentModel.setModifiedBy(rs.getInt("modified_by"));
               equipmentModels.add(equipmentModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return equipmentModels;
    }

    @Override
    public Integer addEquipment(EquipmentModel equipmentModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into equipment (warrenty,quality,manufactures,"
                    + "created_by,equipment_name,equipment_type_id,purchase_date) values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, equipmentModel.getWarrenty());
            preparedStatement.setString(2, equipmentModel.getQuality());
            preparedStatement.setString(3, equipmentModel.getManufactures());
            preparedStatement.setInt(4, equipmentModel.getCreatedBy());
            preparedStatement.setString(5, equipmentModel.getEquipmentName());
            preparedStatement.setInt(6, equipmentModel.getEquipmentTypeModel().getEquipmentTypeId());
            preparedStatement.setTimestamp(7, equipmentModel.getPurchaseDate());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateEquipment(EquipmentModel equipmentModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update equipment set warrenty = ?,quality = ?,manufactures = ?,"
                    + "created_by = ?,equipment_name = ?,equipment_type_id = ?,purchase_date = ? where equipment_id = ?");
            preparedStatement.setString(1, equipmentModel.getWarrenty());
            preparedStatement.setString(2, equipmentModel.getQuality());
            preparedStatement.setString(3, equipmentModel.getManufactures());
            preparedStatement.setInt(4, equipmentModel.getCreatedBy());
            preparedStatement.setString(5, equipmentModel.getEquipmentName());
            preparedStatement.setInt(6, equipmentModel.getEquipmentTypeModel().getEquipmentTypeId());
            preparedStatement.setTimestamp(7, equipmentModel.getPurchaseDate());
            preparedStatement.setInt(8, equipmentModel.getEquipmentId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteEquipment(EquipmentModel equipmentModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update equipment set active = 0 where equipment_id = ?");
        preparedStatement.setInt(1, equipmentModel.getEquipmentId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllEquipmentResultSet() {
        ResultSet rst = null;
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pstmt= con.prepareStatement("select e.equipment_id as 'Equipment ID', e.equipment_name as 'Name',et.type as Type,"
                    + "e.purchase_date as 'Purchase Date',e.warrenty as 'Warrenty',e.manufactures as 'Manufactures'"
                    + ",e.quality as 'Quality' from equipment e, equipment_type et where e.equipment_type_id ="
                    + " et.equipment_type_id and e.active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public EquipmentModel getEquipmentWithId(Integer equipmentId) {
        EquipmentModel equipmentModel = null; 
        EquipmentTypeModel equipmentTypeModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from equipment e,equipment_type"
                    + " et where e.equipment_type_id = et.equipment_type_id and e.equipment_id = ? and e.active = 1");
            preparedStatement.setInt(1,equipmentId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                equipmentModel = new EquipmentModel();
                equipmentTypeModel = new EquipmentTypeModel();
                equipmentModel.setEquipmentName(rs.getString("equipment_name"));
                equipmentModel.setManufactures(rs.getString("manufactures"));
                equipmentModel.setPurchaseDate(rs.getTimestamp("purchase_date"));
                equipmentModel.setQuality(rs.getString("quality"));
                equipmentModel.setWarrenty(rs.getString("warrenty"));
                equipmentTypeModel.setEquipmentType(rs.getString("type"));
                equipmentModel.setEquipmentTypeModel(equipmentTypeModel);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return equipmentModel;
    }
    
}
