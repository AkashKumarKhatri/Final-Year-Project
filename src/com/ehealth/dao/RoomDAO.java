/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.RoomModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface RoomDAO {
    public List<RoomModel> getAllRooms();
    public Integer addRoom(RoomModel roomModel);
    public Integer updateRoom(RoomModel roomModel);
    public Integer deleteRoom(RoomModel roomModel);
    public ResultSet getAllRoomResultSet();
    public RoomModel getRoomWithId(Integer roomId);
    public Boolean isRoomAvailable(RoomModel roomModel);
    public RoomModel getRoomIdWithRoomNo(String roomName);
}
