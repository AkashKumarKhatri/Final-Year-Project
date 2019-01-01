/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.BillModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface BillDAO {
    public ResultSet getAllPatientsBill();
    public BillModel getPatientRoomCharges(Integer appointmentId);
    public BillModel getPatientAppointmentCharges(Integer appointmentId);
    public List<BillModel> getPatientTestCharges(Integer appointmentId);
    public Integer getTotalTestCharges(Integer appointmentId);
    public List<BillModel> getPatientOperationCharges(Integer appointmentId);
    public Integer getTotalOperationCharges(Integer appointmentId);
}
