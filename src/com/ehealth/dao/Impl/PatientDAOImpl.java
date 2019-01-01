/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.PatientDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.BloodModel;
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
public class PatientDAOImpl implements PatientDAO{
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<PatientModel> getAllPatients() {
        List<PatientModel> patientModels = new ArrayList<>();
        PatientModel patientModel = null;
        BloodModel bloodModel = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select * from patients where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                patientModel = new PatientModel();
                bloodModel = new BloodModel();
                patientModel.setPatientId(rs.getInt("patient_id"));
                patientModel.setName(rs.getString("name"));
                patientModel.setAddress(rs.getString("address"));
                patientModel.setFatherName(rs.getString("father_name"));
                patientModel.setContact(rs.getString("contact"));
                patientModel.setCreatedBy(rs.getInt("created_by"));
                patientModel.setModifiedBy(rs.getInt("modified_by"));
                bloodModel.setBloodId(rs.getInt("blood_id"));
                patientModel.setBloodModel(bloodModel);
                patientModels.add(patientModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientModels;
    }

    @Override
    public Integer addPatient(PatientModel patientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into patients (name,father_name,contact,address,blood_id,created_by)"
                    + "values (?,?,?,?,?,?)");
            ps.setString(1, patientModel.getName());
            ps.setString(2, patientModel.getFatherName());
            ps.setString(3, patientModel.getContact());
            ps.setString(4, patientModel.getAddress());
            ps.setInt(5, patientModel.getBloodModel().getBloodId());
            ps.setInt(6, patientModel.getCreatedBy());
            
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updatePatient(PatientModel patientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update patients set name = ?,father_name = ?,contact = ?,address = ?,blood_id = ?,"
                    + "modified_by = ? where patient_id = ?");
            ps.setString(1, patientModel.getName());
            ps.setString(2, patientModel.getFatherName());
            ps.setString(3, patientModel.getContact());
            ps.setString(4, patientModel.getAddress());
            ps.setInt(5, patientModel.getBloodModel().getBloodId());
            ps.setInt(6, patientModel.getModifiedBy());
            ps.setInt(7, patientModel.getPatientId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deletePatient(PatientModel patientModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update patients set active = 0 where patient_id = ?");
            ps.setInt(1, patientModel.getPatientId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllPatientResultSet() {
        ResultSet rs = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("select p.patient_id as 'Patient ID',p.name as 'Name',p.father_name as "
                    + "'Father Name',p.contact as 'Contact',p.address as 'Address',b.blood_group as 'Blood Group' from "
                    + "patients p,blood b where p.blood_id = b.blood_id and p.active = 1");
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public PatientModel getPatientWithId(Integer patientId) {
        PatientModel patientModel = null;
        try {
            patientModel = new PatientModel();
            PreparedStatement ps = con.prepareStatement("select * from patients where patient_id = ?");
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                patientModel = new PatientModel();
                BloodModel bloodModel = new BloodModel();
                BloodDAOImpl bloodDAOImp= new BloodDAOImpl();
                bloodModel=bloodDAOImp.getBloodGroupWithId(rs.getInt("blood_id"));
                patientModel.setBloodModel(bloodModel);
                patientModel.setPatientId(rs.getInt("patient_id"));
                patientModel.setName(rs.getString("name"));
                patientModel.setAddress(rs.getString("address"));
                patientModel.setFatherName(rs.getString("father_name"));
                patientModel.setContact(rs.getString("contact"));
                patientModel.setCreatedBy(rs.getInt("created_by"));
                patientModel.setModifiedBy(rs.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientModel;
    }

    @Override
    public PatientModel getPatientIdWithName(String patientName) {
       PatientModel patientModel = null;
        try {
            patientModel = new PatientModel();
            PreparedStatement ps = con.prepareStatement("select patient_id from patients where name = ? and active = 1");
            ps.setString(1, patientName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                patientModel = new PatientModel();
                patientModel.setPatientId(rs.getInt("patient_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientModel;
    }

    @Override
    public Boolean isPatientAvailable(PatientModel patientModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from patients where contact = ? and active = 1");
            ps.setString(1, patientModel.getContact());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailalbe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailalbe;
    }

    @Override
    public Boolean isPatientAvailableForUpdate(PatientModel patientModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from patients where contact = ? and name = ? and active = 1");
            ps.setString(1, patientModel.getContact());
            ps.setString(2, patientModel.getName());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailalbe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailalbe;
    }
}
