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
public class OperationResultModel extends Models{
    private Integer operationResultId;
    private String result;
    private String status;
    private String fees;
    private OperationModel operationModel;
    private AppointmentModel appointmentModel;
    private Timestamp operationDate;

    public Timestamp getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Timestamp operationDate) {
        this.operationDate = operationDate;
    }
    
    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public OperationModel getOperationModel() {
        return operationModel;
    }

    public void setOperationModel(OperationModel operationModel) {
        this.operationModel = operationModel;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public void setAppointmentModel(AppointmentModel appointmentModel) {
        this.appointmentModel = appointmentModel;
    }
    
    public Integer getOperationResultId() {
        return operationResultId;
    }

    public void setOperationResultId(Integer operationResultId) {
        this.operationResultId = operationResultId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
