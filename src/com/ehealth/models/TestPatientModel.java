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
public class TestPatientModel extends Models {
    private Integer testPatientId;
    private TestModel testModel;
    private AppointmentModel appointmentModel;
    private Timestamp testDate;
    private Timestamp resultDate;
    private String outcome;
    private String status;
    private String fees;

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public Integer getTestPatientId() {
        return testPatientId;
    }

    public void setTestPatientId(Integer testPatientId) {
        this.testPatientId = testPatientId;
    }

    public TestModel getTestModel() {
        return testModel;
    }

    public void setTestModel(TestModel testModel) {
        this.testModel = testModel;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public void setAppointmentModel(AppointmentModel appointmentModel) {
        this.appointmentModel = appointmentModel;
    }

    public Timestamp getTestDate() {
        return testDate;
    }

    public void setTestDate(Timestamp testDate) {
        this.testDate = testDate;
    }

    public Timestamp getResultDate() {
        return resultDate;
    }

    public void setResultDate(Timestamp resultDate) {
        this.resultDate = resultDate;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
