package com.ehealth.models;

import java.sql.Timestamp;

public class EmployeeModel extends Models {
    private Integer employeeId;
    private String name;
    private String cnic;
    private String contact;
    private String gender;
    private Integer salary;
    private Integer fees;
    private String address;
    private Timestamp dateOfJoining;
    private EmployeeTypeModel employeeTypeModel;
    private BloodModel bloodModel;
    private SpecializationModel specializationModel;
    private ShiftModel shiftModel;

    public Timestamp getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Timestamp dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public EmployeeTypeModel getEmployeeTypeModel() {
        return employeeTypeModel;
    }

    public void setEmployeeTypeModel(EmployeeTypeModel employeeTypeModel) {
        this.employeeTypeModel = employeeTypeModel;
    }

   

    public BloodModel getBloodModel() {
        return bloodModel;
    }

    public void setBloodModel(BloodModel bloodModel) {
        this.bloodModel = bloodModel;
    }

    public SpecializationModel getSpecializationModel() {
        return specializationModel;
    }

    public void setSpecializationModel(SpecializationModel specializationModel) {
        this.specializationModel = specializationModel;
    }

    public ShiftModel getShiftModel() {
        return shiftModel;
    }

    public void setShiftModel(ShiftModel shiftModel) {
        this.shiftModel = shiftModel;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getFees() {
        return fees;
    }

    public void setFees(Integer fees) {
        this.fees = fees;
    }

    
}
