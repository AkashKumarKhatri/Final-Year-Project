/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.RoomDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.RoomModel;
import com.ehealth.models.RoomTypeModel;
import com.ehealth.models.WardModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akaash
 */
public class RoomDAOImpl implements RoomDAO{
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<RoomModel> getAllRooms() {
        List<RoomModel> roomModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from rooms where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               RoomModel roomModel = new RoomModel();
               roomModel.setRoomId(rs.getInt("room_id"));
               roomModel.setRoomNo(rs.getString("room_no"));
               roomModels.add(roomModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return roomModels;
    }

    @Override
    public Integer addRoom(RoomModel roomModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into rooms (room_no,room_type_id,ward_id,created_by) values (?,?,?,?)");
            preparedStatement.setString(1, roomModel.getRoomNo());
            preparedStatement.setInt(2, roomModel.getRoomTypeModel().getRoomTypeId());
            preparedStatement.setInt(3, roomModel.getWardModel().getWardId());
            preparedStatement.setInt(4, roomModel.getCreatedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateRoom(RoomModel roomModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update rooms set room_no = ?,room_type_id = ?,ward_id = ?,modified_by = ? where room_id = ?");
            preparedStatement.setString(1, roomModel.getRoomNo());
            preparedStatement.setInt(2, roomModel.getRoomTypeModel().getRoomTypeId());
            preparedStatement.setInt(3, roomModel.getWardModel().getWardId());
            preparedStatement.setInt(4, roomModel.getModifiedBy());
            preparedStatement.setInt(5, roomModel.getRoomId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteRoom(RoomModel roomModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update rooms set active = 0 where room_id = ?");
        preparedStatement.setInt(1, roomModel.getRoomId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllRoomResultSet() {
        ResultSet rst = null;
        try {
            String sql = "SELECT r.`room_id` , r.`room_no` , rt.`room_type_name` , w.name "
                    + "FROM rooms r INNER JOIN room_type rt ON r.room_type_id = rt.room_type_id "
                    + "INNER JOIN wards w ON r.`ward_id`=w.`ward_id` AND r.active = 1";
            PreparedStatement pstmt= con.prepareStatement(sql);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public RoomModel getRoomWithId(Integer roomId) {
        RoomModel roomModel = null; 
        RoomTypeModel roomTypeModel = null;
        WardModel wardModel = null;
        
        String sql = "SELECT * FROM rooms r INNER JOIN room_type rt ON r.room_type_id = rt.room_type_id "
                + "INNER JOIN wards w ON r.`ward_id`=w.`ward_id` where r.room_id = ? AND r.active = 1";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,roomId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                roomModel = new RoomModel();
                roomTypeModel = new RoomTypeModel();
                wardModel = new WardModel();
                roomModel.setRoomNo(rs.getString("room_no"));
                roomTypeModel.setRoomType(rs.getString("room_type_name"));
                roomModel.setRoomTypeModel(roomTypeModel);
                wardModel.setName(rs.getString("name"));
                roomModel.setWardModel(wardModel);
                roomModel.setCreatedBy(rs.getInt("created_by"));
                roomModel.setModifiedBy(rs.getInt("modified_by"));    
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return roomModel;
    } 

    @Override
    public Boolean isRoomAvailable(RoomModel roomModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from rooms where room_no = ?  and active = 1");
            ps.setString(1, roomModel.getRoomNo());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailalbe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailalbe;
    }

    @Override
    public RoomModel getRoomIdWithRoomNo(String roomNo) {
        RoomModel roomModel = null; 
        String sql = "SELECT room_id FROM rooms r where r.room_no = ? AND r.active = 1";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println(sql);
            preparedStatement.setString(1,roomNo);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                roomModel = new RoomModel();
                roomModel.setRoomId(rs.getInt("room_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return roomModel;
    }
}
