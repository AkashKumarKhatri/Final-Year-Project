/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.AppointmentDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.EmployeeModel;
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
public class AppointmentDAOImpl implements AppointmentDAO{
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<AppointmentModel> getAllAppointments() {
        List<AppointmentModel> appointmentModels = new ArrayList<>();
        AppointmentModel appointmentModel = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select * from appointments where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                appointmentModel = new AppointmentModel();
                appointmentModel.setAppointmentId(rs.getInt("appointment_id"));
                appointmentModel.setSymptom(rs.getString("symptoms"));
                appointmentModel.setFeesStatus(rs.getString("fees_status"));
                appointmentModel.setCreatedBy(rs.getInt("created_by"));
                appointmentModel.setModifiedBy(rs.getInt("modified_by"));
                appointmentModels.add(appointmentModel);
            }
        } catch (Exception e) {
        }
        return appointmentModels;
    }

    @Override
    public Integer addAppointment(AppointmentModel appointmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into appointments (patient_id,doctor_id,symptoms,fees_status,date,created_by) "
                    + "values (?,?,?,?,?,?)");
            ps.setInt(1, appointmentModel.getPatientModel().getPatientId());
            ps.setInt(2, appointmentModel.getEmployeeModel().getEmployeeId());
            ps.setString(3, appointmentModel.getSymptom());
            ps.setString(4, appointmentModel.getFeesStatus());
            ps.setTimestamp(5, appointmentModel.getAppointmentDate());
            ps.setInt(6, appointmentModel.getCreatedBy());
           // ps.setTimestamp(7, appointmentModel.getCreatedDate());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateAppointment(AppointmentModel appointmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update appointments set symptoms = ?,fees_status = ?,modified_by = ?,"
                    + "patient_id = ?,doctor_id = ?,date = ? where appointment_id = ? ");
            ps.setString(1, appointmentModel.getSymptom());
            ps.setString(2, appointmentModel.getFeesStatus());
            ps.setInt(3, appointmentModel.getModifiedBy());
            ps.setInt(4, appointmentModel.getPatientModel().getPatientId());
            ps.setInt(5, appointmentModel.getEmployeeModel().getEmployeeId());
            ps.setTimestamp(6, appointmentModel.getAppointmentDate());
            ps.setInt(7, appointmentModel.getAppointmentId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteAppointment(AppointmentModel appointmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update appointments set active = 0 where appointment_id = ?");
            ps.setInt(1, appointmentModel.getAppointmentId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllAppointmentsResultSet() {
        ResultSet rs = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT ap.appointment_id as 'Appointment ID', p.name as 'Patient',"
                    + "e.name as 'Doctor',ap.date as 'Date',ap.fees_status as 'Fees Status',ap.symptoms as 'Symptom' FROM appointments ap,"
                    + "patients p,employees e WHERE ap.patient_id = p.patient_id AND ap.doctor_id = e.employee_id AND "
                    + "ap.active = 1");
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    @Override
    public AppointmentModel getAppointmentWithId(Integer appointmentId) {
        AppointmentModel appointmentModel = null;
        PatientModel patientModel = null;
        EmployeeModel employeeModel = null;
        try {
            appointmentModel = new AppointmentModel();
            PreparedStatement ps = con.prepareStatement("SELECT ap.symptoms,ap.date,ap.fees_status,p.name,e.name FROM"
                    + " appointments ap,patients p,employees e WHERE ap.patient_id = p.patient_id AND ap.doctor_id = e.employee_id AND ap.appointment_id = ?");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                appointmentModel = new AppointmentModel();
                appointmentModel.setAppointmentDate(rs.getTimestamp("date"));
                appointmentModel.setSymptom(rs.getString("symptoms"));
                appointmentModel.setFeesStatus(rs.getString("fees_status"));
                patientModel = new PatientModel();
                patientModel.setName(rs.getString("p.name"));
                appointmentModel.setPatientModel(patientModel);
                employeeModel = new EmployeeModel();
                employeeModel.setName(rs.getString("e.name"));
                appointmentModel.setEmployeeModel(employeeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentModel;
    }

    @Override
    public ResultSet getAllAppointmentWithPatientId(Integer patientId) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT ap.appointment_id as 'Appointment ID',p.name as 'Patient',e.name as 'Doctor', ap.date as 'Date', ap.symptoms as 'Symptom', ap.fees_status as 'Fees' FROM"
                    + " appointments ap,patients p,employees e WHERE ap.patient_id = p.patient_id AND "
                    + "ap.doctor_id = e.employee_id AND p.patient_id = ? and ap.active = 1");
            ps.setInt(1, patientId);
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    @Override
    public AppointmentModel getAppointmentIdWithPatientId(Integer patientId) {
       AppointmentModel appointmentModel = null;
        PatientModel patientModel = null;
        EmployeeModel employeeModel = null;
        try {
            appointmentModel = new AppointmentModel();
            PreparedStatement ps = con.prepareStatement("SELECT ap.appointment_id, ap.symptoms,ap.date,ap.fees_status,p.name,e.name FROM"
                    + " appointments ap,patients p,employees e WHERE ap.patient_id = p.patient_id AND ap.doctor_id = e.employee_id AND p.patient_id = ?");
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                appointmentModel = new AppointmentModel();
                appointmentModel.setAppointmentDate(rs.getTimestamp("date"));
                appointmentModel.setSymptom(rs.getString("symptoms"));
                appointmentModel.setFeesStatus(rs.getString("fees_status"));
                patientModel = new PatientModel();
                patientModel.setName(rs.getString("p.name"));
                appointmentModel.setPatientModel(patientModel);
                employeeModel = new EmployeeModel();
                employeeModel.setName(rs.getString("e.name"));
                appointmentModel.setAppointmentId(rs.getInt("appointment_id"));
                appointmentModel.setEmployeeModel(employeeModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointmentModel;
    }
    
}
