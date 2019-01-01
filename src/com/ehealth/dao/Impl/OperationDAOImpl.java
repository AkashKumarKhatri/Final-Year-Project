/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.OperationDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.OperationModel;
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
public class OperationDAOImpl implements OperationDAO {
    
    Connection con = DBConnection.getConnection();

    @Override
    public List<OperationModel> getAllOperations() {
        List<OperationModel> operationModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from operation where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               OperationModel operationModel = new OperationModel();
               operationModel.setOperationId(rs.getInt("operation_id"));
               operationModel.setOperationType(rs.getString("operation_type"));
               operationModel.setOperationCharges(rs.getInt("charges"));
               operationModel.setCreatedBy(rs.getInt("created_by"));
               operationModel.setModifiedBy(rs.getInt("modified_by"));
               operationModels.add(operationModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return operationModels;
    }

    @Override
    public Integer addOperation(OperationModel operationModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into operation (operation_type,charges,created_by) values (?,?,?)");
            preparedStatement.setString(1, operationModel.getOperationType());
            preparedStatement.setInt(2, operationModel.getOperationCharges());
            preparedStatement.setInt(3, operationModel.getCreatedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateOperation(OperationModel operationModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update operation set operation_type = ?,charges = ?,modified_by = ? where operation_id = ?");
            preparedStatement.setString(1, operationModel.getOperationType());
            preparedStatement.setInt(2, operationModel.getOperationCharges());
            preparedStatement.setInt(3, operationModel.getModifiedBy());
            preparedStatement.setInt(4, operationModel.getOperationId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteOperation(OperationModel operationModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update operation set active = 0 where operation_id = ?");
        preparedStatement.setInt(1, operationModel.getOperationId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllOperationResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select operation_id as 'Operation ID',operation_type as 'Type',charges as 'Charges' from operation where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public OperationModel getOperationWithId(Integer operationId) {
        OperationModel operationModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from operation where operation_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1,operationId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                operationModel = new OperationModel();
                operationModel.setOperationType(rs.getString("operation_type"));
                operationModel.setOperationCharges(rs.getInt("charges"));
                operationModel.setCreatedBy(rs.getInt("created_by"));
                operationModel.setModifiedBy(rs.getInt("modified_by"));                
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return operationModel;
    }

    @Override
    public OperationModel getOperationIdWithOperationType(String operationName) {
        OperationModel operationModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from operation where operation_type = ? "
                    + "and active = 1");
            preparedStatement.setString(1, operationName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                operationModel = new OperationModel();
                operationModel.setOperationId(resultSet.getInt("operation_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return operationModel;
    }
}
