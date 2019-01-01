/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.BillDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.BillModel;
import com.ehealth.models.EmployeeModel;
import com.ehealth.models.OperationModel;
import com.ehealth.models.OperationResultModel;
import com.ehealth.models.RoomAlotmentModel;
import com.ehealth.models.RoomModel;
import com.ehealth.models.RoomTypeModel;
import com.ehealth.models.TestModel;
import com.ehealth.models.TestPatientModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Akash
 */
public class BillDAOImpl implements BillDAO {
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public ResultSet getAllPatientsBill() {
        ResultSet rs = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT ap.appointment_id as 'Appointment ID', p.name AS 'Patient Name',ap.date AS 'Appointment Date',"
                    + "appointmentFees (ap.appointment_id) AS 'Appointment Fees',totalRoomCharges (ap.`appointment_id`)"
                    + " AS 'Room Charges',totalTestCharges (ap.`appointment_id`) AS 'Test Charges',totatOperationCharges "
                    + "(ap.`appointment_id`) AS 'Operaion Charges',appointmentFees (ap.appointment_id) + totalRoomCharges "
                    + "(ap.`appointment_id`) + totalTestCharges (ap.`appointment_id`) + totatOperationCharges (ap.`appointment_id`) "
                    + "AS 'Grand Total' FROM appointments ap INNER JOIN patients p ON ap.`patient_id` = p.`patient_id` "
                    + "WHERE ap.`active` = 1 ");
            rs = preparedStatement.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }

    @Override
    public  BillModel getPatientRoomCharges(Integer appointmentId) {
        BillModel billModel = null;
        RoomAlotmentModel alotmentModel;
        RoomModel roomModel;
        RoomTypeModel roomTypeModel;
        AppointmentModel appointmentModel;
        EmployeeModel employeeModel;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT r.room_no AS 'Room #No', rt.room_type_name AS 'Room Type',"
                    + " ra.alotment_date AS 'Alotment Date', ra.discharge_date AS 'Discharge Date', rt.charges AS 'Per Day',"
                    + " DATEDIFF(ra.discharge_date,ra.alotment_date) AS 'Total Days',DATEDIFF(ra.discharge_date,ra.alotment_date)"
                    + " * rt.charges AS 'Total Charges',ra.fees as 'Fees Status',ap.date as 'Appointment Date', d.fees as 'Fees',ap.fees_status as 'Fees Appointment' FROM room_alotment ra"
                    + " INNER JOIN rooms r ON ra.room_id = r.room_id INNER JOIN room_type rt ON r.room_type_id = rt.room_type_id "
                    + " INNER JOIN appointments ap ON ra.appointment_id = ap.appointment_id inner join employees d on ap.doctor_id "
                    + " = d.employee_id WHERE ap.appointment_id = ?");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                employeeModel = new EmployeeModel();
                billModel = new BillModel();
                roomModel = new RoomModel();
                roomTypeModel = new RoomTypeModel();
                appointmentModel = new AppointmentModel();
                alotmentModel = new RoomAlotmentModel();
                roomTypeModel.setRoomType(rs.getString("Room Type"));
                roomTypeModel.setRoomCharges(rs.getString("Per Day"));
                roomModel.setRoomTypeModel(roomTypeModel);
                roomModel.setRoomNo(rs.getString("Room #No"));
                alotmentModel.setRoomModel(roomModel);
                appointmentModel.setAppointmentDate(rs.getTimestamp("Appointment Date"));
                employeeModel.setFees(rs.getInt("Fees"));
                appointmentModel.setEmployeeModel(employeeModel);
                appointmentModel.setFeesStatus(rs.getString("Fees Appointment"));
                alotmentModel.setAppointmentModel(appointmentModel);
                alotmentModel.setAlotmentDate(rs.getTimestamp("Alotment Date"));
                alotmentModel.setDischargeDate(rs.getTimestamp("Discharge Date"));
                alotmentModel.setFees(rs.getString("Fees Status"));
                billModel.setAlotmentModel(alotmentModel);
                billModel.setTotaDays(rs.getInt("Total Days"));
                billModel.setGrandTotal(rs.getInt("Total Charges"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return billModel;
    }

    @Override
    public BillModel getPatientAppointmentCharges(Integer appointmentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillModel> getPatientTestCharges(Integer appointmentId) {
        List<BillModel> billModels = new ArrayList<>();
        BillModel billModel;
        TestPatientModel testPatientModel;
        TestModel testModel;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT t.name AS 'Test Name', t.charge AS 'Test Charges', tp.test_date AS 'Test Date', "
                    + "tp.result_date AS 'Result Date',tp.status AS 'Test Status',tp.`outcome` as 'Test Outcome', tp.fees AS 'Fees Status',totalTestCharges(ap.`appointment_id`) "
                    + "AS 'Totol Test Charges' FROM test_patient tp INNER JOIN test t ON tp.`test_id` = t.`test_id` INNER JOIN appointments ap ON "
                    + "tp.`appointment_id` = ap.`appointment_id` WHERE ap.`appointment_id` = ?");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                billModel = new BillModel();
                testPatientModel = new TestPatientModel();
                testModel = new TestModel();
                testModel.setName(rs.getString("Test Name"));
                testModel.setCharge(rs.getInt("Test Charges"));
                testPatientModel.setTestModel(testModel);
                testPatientModel.setTestDate(rs.getTimestamp("Test Date"));
                testPatientModel.setResultDate(rs.getTimestamp("Result Date"));
                testPatientModel.setStatus(rs.getString("Test Status"));
                testPatientModel.setFees(rs.getString("Fees Status"));
                testPatientModel.setOutcome(rs.getString("Test Outcome"));
                billModel.setTestPatientModel(testPatientModel);
                billModel.setTotalTestCharges(rs.getInt("Totol Test Charges"));
                billModels.add(billModel);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return billModels;
    }

    @Override
    public List<BillModel> getPatientOperationCharges(Integer appointmentId) {
        List<BillModel> billModels = new ArrayList<>();
        BillModel billModel;
        OperationResultModel operationResultModel;
        OperationModel operationModel;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT op.operation_type AS 'Operation Type', op.charges AS 'Operation Charges', opr.operation_date"
                    + " AS 'Operation Date', opr.status AS 'Operation Status', opr.result AS 'Operation Result', opr.fees AS 'Fees Status', "
                    + "totatOperationCharges(ap.`appointment_id`) AS 'Total Operation Fees' FROM operation_result opr INNER JOIN operation op ON "
                    + "opr.`operation_id` = op.`operation_id` INNER JOIN appointments ap ON opr.`appointment_id` = ap.`appointment_id` WHERE "
                    + "ap.`appointment_id` = ?");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                billModel = new BillModel();
                operationModel = new OperationModel();
                operationResultModel = new OperationResultModel();
                operationModel.setOperationType(rs.getString("Operation Type"));
                operationModel.setOperationCharges(rs.getInt("Operation Charges"));
                operationResultModel.setOperationModel(operationModel);
                operationResultModel.setOperationDate(rs.getTimestamp("Operation Date"));
                operationResultModel.setStatus(rs.getString("Operation Status"));
                operationResultModel.setResult(rs.getString("Operation Result"));
                operationResultModel.setFees(rs.getString("Fees Status"));
                billModel.setOperationResultModel(operationResultModel);
                billModel.setTotalOperationCharges(rs.getInt("Total Operation Fees"));
                billModels.add(billModel);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return billModels;
    }

    @Override
    public Integer getTotalTestCharges(Integer appointmentId) {
       Integer totalTestCharges = 0;
        try {
            PreparedStatement ps = con.prepareStatement("Select totalTestCharges(?) as 'Total Charges'");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                totalTestCharges = rs.getInt("Total Charges");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalTestCharges;
    }
    public Integer getTotalOperationCharges(Integer appointmentId) {
       Integer totalOperationCharges = 0;
        try {
            PreparedStatement ps = con.prepareStatement("Select totatOperationCharges(?) as 'Total Charges'");
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                totalOperationCharges = rs.getInt("Total Charges");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalOperationCharges;
    }
}
