package com.ehealth.models;

public class RoomTypeModel {
    private Integer roomTypeId;
    private String roomType;
    private String roomCharges;

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomCharges() {
        return roomCharges;
    }

    public void setRoomCharges(String roomCharges) {
        this.roomCharges = roomCharges;
    }
    
}
