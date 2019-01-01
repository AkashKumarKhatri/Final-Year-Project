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
public class RoomModel extends Models{
    private Integer roomId;
    private String roomNo;
    private RoomTypeModel roomTypeModel;
    private WardModel wardModel;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public RoomTypeModel getRoomTypeModel() {
        return roomTypeModel;
    }

    public void setRoomTypeModel(RoomTypeModel roomTypeModel) {
        this.roomTypeModel = roomTypeModel;
    }

    public WardModel getWardModel() {
        return wardModel;
    }

    public void setWardModel(WardModel wardModel) {
        this.wardModel = wardModel;
    }
    
}
