/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.TestPatientDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.PatientModel;
import com.ehealth.models.TestModel;
import com.ehealth.models.TestPatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akash
 */
public class TestPatientDAOImpl implements TestPatientDAO {
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<TestPatientModel> getAllTestPatient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addTestPatient(TestPatientModel testPatientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into test_patient (appointment_id,test_id,test_date,result_date,fees,outcome,status,created_by) "
                    + "values (?,?,?,?,?,?,?,?)");
            ps.setInt(1, testPatientModel.getAppointmentModel().getAppointmentId());
            ps.setInt(2, testPatientModel.getTestModel().getTestId());
            ps.setTimestamp(3, testPatientModel.getTestDate());
            ps.setTimestamp(4, testPatientModel.getResultDate());
            ps.setString(5, testPatientModel.getFees());
            ps.setString(6, testPatientModel.getOutcome());
            ps.setString(7, testPatientModel.getStatus());
            ps.setInt(8, testPatientModel.getCreatedBy());
           // ps.setTimestamp(7, appointmentModel.getCreatedDate());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateTestPatient(TestPatientModel testPatientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update test_patient set appointment_id = ?,test_id = ?,test_date = ?,"
                    + "result_date = ?,fees = ?,outcome = ?,status = ?,modified_by = ? where test_patient_id = ?");
            ps.setInt(1, testPatientModel.getAppointmentModel().getAppointmentId());
            ps.setInt(2, testPatientModel.getTestModel().getTestId());
            ps.setTimestamp(3, testPatientModel.getTestDate());
            ps.setTimestamp(4, testPatientModel.getResultDate());
            ps.setString(5, testPatientModel.getFees());
            ps.setString(6, testPatientModel.getOutcome());
            ps.setString(7, testPatientModel.getStatus());
            ps.setInt(8, testPatientModel.getModifiedBy());
            ps.setInt(9, testPatientModel.getTestPatientId());
           // ps.setTimestamp(7, appointmentModel.getCreatedDate());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteTestPatient(TestPatientModel testPatientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update test_patient set active = 0 where test_patient_id = ?");
            ps.setInt(1, testPatientModel.getTestPatientId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllTestPatientResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select tp.test_patient_id as 'ID',p.name as 'Patient',t.name as 'Test',"
                    + " tp.test_date as 'Test Date', tp.result_date as 'Result Date', tp.outcome as 'Outcome', tp.status as 'Status',"
                    + " tp.fees from test_patient tp, appointments ap, patients p, test t where tp.appointment_id = ap.appointment_id"
                    + " and tp.test_id = t.test_id and ap.patient_id = p.patient_id and tp.active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public TestPatientModel getTesPatienttWithId(Integer testPatientId) {
        TestPatientModel testPatientModel = null;
        TestModel testModel;
        AppointmentModel appointmentModel;
        PatientModel patientModel;
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select p.name,t.name ,tp.test_date, tp.result_date, tp.outcome,"
                    + " tp.status,tp.fees from test_patient tp, appointments ap, patients p, test t where "
                    + "tp.appointment_id = ap.appointment_id and tp.test_id = t.test_id and ap.patient_id = p.patient_id"
                    + " and tp.test_patient_id = ? and tp.active = 1");
            preparedStatement.setInt(1, testPatientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testModel = new TestModel();
                testPatientModel = new TestPatientModel();
                appointmentModel = new AppointmentModel();
                patientModel = new PatientModel();
                patientModel.setName(resultSet.getString("p.name"));
                appointmentModel.setPatientModel(patientModel);
                testPatientModel.setAppointmentModel(appointmentModel);
                testModel.setName(resultSet.getString("t.name"));
                testPatientModel.setTestModel(testModel);
                testPatientModel.setTestDate(resultSet.getTimestamp("test_date"));
                testPatientModel.setResultDate(resultSet.getTimestamp("result_date"));
                testPatientModel.setOutcome(resultSet.getString("outcome"));
                testPatientModel.setStatus(resultSet.getString("status"));
                testPatientModel.setFees(resultSet.getString("fees"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return testPatientModel;
    }

    @Override
    public TestPatientModel getTestPatientIdWithName(String testName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getTesPatientWithAppointmentId(Integer appointmentId) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select tp.test_patient_id as 'ID',p.name as 'Patient',t.name as 'Test',"
                    + " tp.test_date as 'Test Date', tp.result_date as 'Result Date', tp.outcome as 'Outcome', tp.status as 'Status',"
                    + " tp.fees from test_patient tp, appointments ap, patients p, test t where tp.appointment_id = ap.appointment_id"
                    + " and tp.test_id = t.test_id and ap.patient_id = p.patient_id and ap.appointment_id = ? and tp.active = 1");
            ps.setInt(1, appointmentId);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    
}
