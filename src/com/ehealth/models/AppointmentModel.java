/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.models;

import java.sql.Timestamp;

/**
 *
 * @author Akaash
 */
public class AppointmentModel extends Models {
    private Integer appointmentId;
    private String symptom;
    private String feesStatus;
    private PatientModel patientModel;
    private EmployeeModel employeeModel;
    private Timestamp appointmentDate;

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
    
    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symtom) {
        this.symptom = symtom;
    }

    public String getFeesStatus() {
        return feesStatus;
    }

    public void setFeesStatus(String feesStatus) {
        this.feesStatus = feesStatus;
    }
    
}
