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
public class EquipmentModel extends Models{
    private String equipmentName;
    private Integer equipmentId;
    private String warrenty;
    private String manufactures;
    private String quality;
    private EquipmentTypeModel equipmentTypeModel;
    private Timestamp purchaseDate;

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public EquipmentTypeModel getEquipmentTypeModel() {
        return equipmentTypeModel;
    }

    public void setEquipmentTypeModel(EquipmentTypeModel equipmentTypeModel) {
        this.equipmentTypeModel = equipmentTypeModel;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getWarrenty() {
        return warrenty;
    }

    public void setWarrenty(String warrenty) {
        this.warrenty = warrenty;
    }

    public String getManufactures() {
        return manufactures;
    }

    public void setManufactures(String manufactures) {
        this.manufactures = manufactures;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
    
}
