/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.models;

/**
 *
 * @author Akaash
 */
public class UserModel extends Models {
    private Integer userId;
    private String name;
    private String password;
    private UserTypeModel userTypeModel;
    private EmployeeModel employeeModel;

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserTypeModel getUserTypeModel() {
        return userTypeModel;
    }

    public void setUserTypeModel(UserTypeModel userTypeModel) {
        this.userTypeModel = userTypeModel;
    }
    
}
