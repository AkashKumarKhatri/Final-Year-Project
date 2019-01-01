/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.OperationResultDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.OperationModel;
import com.ehealth.models.OperationResultModel;
import com.ehealth.models.PatientModel;
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
public class OperationResultDAOImpl implements OperationResultDAO {
    
    Connection con = DBConnection.getConnection();

    @Override
    public List<OperationResultModel> getAllOperationResult() {
        List<OperationResultModel> operationResultModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from operation_result where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               OperationResultModel operationResultModel = new OperationResultModel();
               operationResultModel.setOperationResultId(rs.getInt("operation_result_id"));
               operationResultModel.setResult(rs.getString("result"));
               operationResultModel.setStatus(rs.getString("status"));
               operationResultModel.setCreatedBy(rs.getInt("created_by"));
               operationResultModel.setModifiedBy(rs.getInt("modified_by"));
               operationResultModels.add(operationResultModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return operationResultModels;
    }

    @Override
    public Integer addOperationResult(OperationResultModel operationResultModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into operation_result (appointment_id,operation_id,"
                    + "operation_date,result,status,fees) values (?,?,?,?,?,?)");
            preparedStatement.setInt(1, operationResultModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setInt(2, operationResultModel.getOperationModel().getOperationId());
            preparedStatement.setTimestamp(3, operationResultModel.getOperationDate());
            preparedStatement.setString(4, operationResultModel.getResult());
            preparedStatement.setString(5, operationResultModel.getStatus());
            preparedStatement.setString(6, operationResultModel.getFees());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateOperationResult(OperationResultModel operationResultModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update operation_result set appointment_id = ?,operation_id = ?,"
                    + "operation_date = ?,result = ?,status = ?,fees = ? where operation_result_id = ?");
            preparedStatement.setInt(1, operationResultModel.getAppointmentModel().getAppointmentId());
            preparedStatement.setInt(2, operationResultModel.getOperationModel().getOperationId());
            preparedStatement.setTimestamp(3, operationResultModel.getOperationDate());
            preparedStatement.setString(4, operationResultModel.getResult());
            preparedStatement.setString(5, operationResultModel.getStatus());
            preparedStatement.setString(6, operationResultModel.getFees());
            preparedStatement.setInt(7, operationResultModel.getOperationResultId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteOperationResult(OperationResultModel operationResultModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update operation_result set active = 0 where operation_result_id = ?");
        preparedStatement.setInt(1, operationResultModel.getOperationResultId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllOperationResultResultSet() {
        ResultSet rst = null;
        String sql = "select or.operation_result_id as 'ID', p.name as 'Patient', "
                    + "op.operation_type as 'Operation Type', or.operation_date as 'Operation Date',"
                    + "op.charges as 'Charges', or.result as 'Result', or.status as 'Status', or.fees as 'Fees' from "
                    + "operation_result `or`, operation op, appointments ap, patients p where "
                    + "or.operation_id = op.operation_id and or.appointment_id = ap.appointment_id and "
                    + "ap.patient_id = p.patient_id and or.active = 1";
        try {
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public OperationResultModel getOperationResultWithId(Integer operationResultId) {
        OperationResultModel operationResultModel = null;
        AppointmentModel appointmentModel;
        PatientModel patientModel;
        OperationModel operationModel;
        
        String sql = "select or.operation_result_id, p.name, op.operation_type, or.operation_date,op.charges,"
                + "or.result, or.fees, or.status from operation_result `or`, operation op, appointments ap, patients p "
                + "where or.operation_id = op.operation_id and or.appointment_id = ap.appointment_id and "
                + "ap.patient_id = p.patient_id and or.operation_result_id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,operationResultId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                operationResultModel = new OperationResultModel();
                operationModel = new OperationModel();
                appointmentModel = new AppointmentModel();
                patientModel = new PatientModel();
                operationResultModel.setResult(rs.getString("result"));
                operationResultModel.setStatus(rs.getString("status"));
                operationResultModel.setFees(rs.getString("fees"));
                patientModel.setName(rs.getString("p.name"));
                appointmentModel.setPatientModel(patientModel);
                operationResultModel.setAppointmentModel(appointmentModel);
                operationModel.setOperationType(rs.getString("operation_type"));
                operationResultModel.setOperationModel(operationModel);
                operationResultModel.setOperationDate(rs.getTimestamp("operation_date"));
                
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return operationResultModel;
    }

    @Override
    public ResultSet getOperationResultWithAppointmentId(Integer appointmentId) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select or.operation_result_id as 'ID', p.name as 'Patient', "
                    + "op.operation_type as 'Operation Type', or.operation_date as 'Operation Date',"
                    + "op.charges as 'Charges', or.result as 'Result', or.status as 'Status',or.fees as 'Fees' from "
                    + "operation_result `or`, operation op, appointments ap, patients p where "
                    + "or.operation_id = op.operation_id and or.appointment_id = ap.appointment_id and "
                    + "ap.patient_id = p.patient_id and ap.appointment_id = ? and or.active = 1");
            ps.setInt(1, appointmentId);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}