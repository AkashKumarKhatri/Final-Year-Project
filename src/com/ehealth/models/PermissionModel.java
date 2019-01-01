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
public class PermissionModel extends Models {
    private Integer permissionId;
    private String name;
    private ScreenModel screenModel;

    public ScreenModel getScreenModel() {
        return screenModel;
    }

    public void setScreenModel(ScreenModel screenModel) {
        this.screenModel = screenModel;
    }
    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
