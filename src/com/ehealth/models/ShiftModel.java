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
public class ShiftModel extends Models{
    private Integer shiftId;
    private String shift;
    private String timingFrom;
    private String timingTo;
    private EmployeeModel employeeModel;

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getTimingFrom() {
        return timingFrom;
    }

    public void setTimingFrom(String timingFrom) {
        this.timingFrom = timingFrom;
    }

    public String getTimingTo() {
        return timingTo;
    }

    public void setTimingTo(String timingTo) {
        this.timingTo = timingTo;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
}
