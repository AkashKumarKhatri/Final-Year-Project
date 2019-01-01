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
public class RoomAlotmentModel extends Models{
    private Integer roomAlotmentId;
    private Timestamp alotmentDate;
    private Timestamp dischargeDate;
    private String status;
    private AppointmentModel appointmentModel;
    private RoomModel roomModel;
    private String fees;
    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
    
    public Integer getRoomAlotmentId() {
        return roomAlotmentId;
    }

    public void setRoomAlotmentId(Integer roomAlotmentId) {
        this.roomAlotmentId = roomAlotmentId;
    }

    public Timestamp getAlotmentDate() {
        return alotmentDate;
    }

    public void setAlotmentDate(Timestamp alotmentDate) {
        this.alotmentDate = alotmentDate;
    }

    public Timestamp getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Timestamp dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AppointmentModel getAppointmentModel() {
        return appointmentModel;
    }

    public void setAppointmentModel(AppointmentModel appointmentModel) {
        this.appointmentModel = appointmentModel;
    }

    public RoomModel getRoomModel() {
        return roomModel;
    }

    public void setRoomModel(RoomModel roomModel) {
        this.roomModel = roomModel;
    }
    
}
