/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.RoomAlotmentDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.PatientModel;
import com.ehealth.models.RoomAlotmentModel;
import com.ehealth.models.RoomModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Akash
 */
public class RoomAlotmentDAOImpl implements RoomAlotmentDAO {

    Connection con = DBConnection.getConnection();
    
    @Override
    public List<RoomAlotmentModel> getAllRoomAlotments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer addRoomAlotment(RoomAlotmentModel roomAlotmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into room_alotment (appointment_id,room_id,alotment_date,discharge_date,fees,status,created_by) "
                    + "values (?,?,?,?,?,?,?)");
            ps.setInt(1, roomAlotmentModel.getAppointmentModel().getAppointmentId());
            ps.setInt(2, roomAlotmentModel.getRoomModel().getRoomId());
            ps.setTimestamp(3, roomAlotmentModel.getAlotmentDate());
            ps.setTimestamp(4, roomAlotmentModel.getDischargeDate());
            ps.setString(5, roomAlotmentModel.getFees());
            ps.setString(6, roomAlotmentModel.getStatus());
            ps.setInt(7, roomAlotmentModel.getCreatedBy());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateRoomAlotment(RoomAlotmentModel roomAlotmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update room_alotment set appointment_id = ?,room_id = ?,alotment_date = ?,"
                    + "discharge_date = ?,fees = ?,status = ?,modified_by = ? where alotment_id = ?");
            ps.setInt(1, roomAlotmentModel.getAppointmentModel().getAppointmentId());
            ps.setInt(2, roomAlotmentModel.getRoomModel().getRoomId());
            ps.setTimestamp(3, roomAlotmentModel.getAlotmentDate());
            ps.setTimestamp(4, roomAlotmentModel.getDischargeDate());
            ps.setString(5, roomAlotmentModel.getFees());
            ps.setString(6, roomAlotmentModel.getStatus());
            ps.setInt(7, roomAlotmentModel.getModifiedBy());
            ps.setInt(8, roomAlotmentModel.getRoomAlotmentId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteRoomAlotment(RoomAlotmentModel roomAlotmentModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update room_alotment set active = 0 where alotment_id = ?");
            ps.setInt(1, roomAlotmentModel.getRoomAlotmentId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllRoomAlotmentResultSet() {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select ra.alotment_id as 'ID', p.name as 'Patient', r.room_no as"
                    + " 'Room No',rt.room_type_name as 'Room Type', ra.alotment_date as 'Alotment Date', ra.discharge_date"
                    + " as 'Discharge Date', ra.status as 'Status', ra.fees as 'Fees' from room_alotment ra, rooms r, room_type rt, "
                    + " patients p, appointments ap where ra.appointment_id = ap.appointment_id and ap.patient_id "
                    + " = p.patient_id and ra.room_id = r.room_id and r.room_type_id = rt.room_type_id and ra.active = 1");
            rs = ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    @Override
    public RoomAlotmentModel getRoomAlotmentWithId(Integer roomAlotmentId) {
        RoomAlotmentModel roomAlotmentModel = null;
        RoomModel roomModel;
        AppointmentModel appointmentModel;
        PatientModel patientModel;
        
        try {
            String sql = "select p.name, r.room_no, rt.room_type_name, ra.alotment_date, ra.discharge_date, "
                    + "ra.status, ra.fees from room_alotment ra, rooms r, room_type rt, appointments ap, patients p "
                    + "where ra.appointment_id = ap.appointment_id and ap.patient_id = p.patient_id and "
                    + "ra.room_id = r.room_id and r.room_type_id = rt.room_type_id and ra.alotment_id = ? and "
                    + "ra.active = 1";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, roomAlotmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                roomModel = new RoomModel();
                roomAlotmentModel = new RoomAlotmentModel();
                appointmentModel = new AppointmentModel();
                patientModel = new PatientModel();
                patientModel.setName(resultSet.getString("p.name"));
                appointmentModel.setPatientModel(patientModel);
                roomAlotmentModel.setAppointmentModel(appointmentModel);
                roomModel.setRoomNo(resultSet.getString("room_no"));
                roomAlotmentModel.setRoomModel(roomModel);
                roomAlotmentModel.setAlotmentDate(resultSet.getTimestamp("alotment_date"));
                roomAlotmentModel.setDischargeDate(resultSet.getTimestamp("discharge_date"));
                roomAlotmentModel.setStatus(resultSet.getString("status"));
                roomAlotmentModel.setFees(resultSet.getString("fees"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return roomAlotmentModel;
    }

    @Override
    public ResultSet getRoomAlotmentWithAppointmentId(Integer appointmentId) {
        ResultSet rs = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select ra.alotment_id as 'ID', p.name as 'Patient', r.room_no as"
                    + " 'Room No',rt.room_type_name as 'Room Type', ra.alotment_date as 'Alotment Date', ra.discharge_date"
                    + " as 'Discharge Date', ra.status as 'Status',ra.fees as 'Fees' from room_alotment ra, rooms r, room_type rt, "
                    + " patients p, appointments ap where ra.appointment_id = ap.appointment_id and ap.patient_id "
                    + " = p.patient_id and ra.room_id = r.room_id and r.room_type_id = rt.room_type_id and ap.appointment_id = ?"
                    + " and ra.active = 1");
            ps.setInt(1, appointmentId);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
