/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.RoomAlotmentModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface RoomAlotmentDAO {
    public List<RoomAlotmentModel> getAllRoomAlotments();
    public Integer addRoomAlotment(RoomAlotmentModel roomAlotmentModel);
    public Integer updateRoomAlotment(RoomAlotmentModel roomAlotmentModel);
    public Integer deleteRoomAlotment(RoomAlotmentModel roomAlotmentModel);
    public ResultSet getAllRoomAlotmentResultSet();
    public RoomAlotmentModel getRoomAlotmentWithId(Integer employeeId);
    public ResultSet getRoomAlotmentWithAppointmentId(Integer appointmentId);
}
