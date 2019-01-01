/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.AppointmentModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface AppointmentDAO {
    public List<AppointmentModel> getAllAppointments();
    public Integer addAppointment(AppointmentModel appointmentModel);
    public Integer updateAppointment(AppointmentModel appointmentModel);
    public Integer deleteAppointment(AppointmentModel appointmentModel);
    public ResultSet getAllAppointmentsResultSet();
    public AppointmentModel getAppointmentWithId(Integer appointmentId);
    public ResultSet getAllAppointmentWithPatientId(Integer patientId);
    public AppointmentModel getAppointmentIdWithPatientId(Integer patientId);
}
