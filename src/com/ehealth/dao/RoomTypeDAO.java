package com.ehealth.dao;

import com.ehealth.models.RoomTypeModel;
import java.sql.ResultSet;
import java.util.List;

public interface RoomTypeDAO {
    public List<RoomTypeModel> getAllRoomTypes();
    public Integer addRoomType(RoomTypeModel roomTypeModel);
    public Integer updateRoomType(RoomTypeModel roomTypeModel);
    public Integer deleteRoomType(RoomTypeModel roomTypeModel);
    public ResultSet getAllRoomTypeResultSet();
    public RoomTypeModel getRoomTypeWithId(Integer roomTypeId);
    public RoomTypeModel getRoomTypeIdByName(String roomTypeName);
    public Boolean isAvailableRoomType(RoomTypeModel roomTypeModel);
}