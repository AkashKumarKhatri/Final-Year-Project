package com.ehealth.dao.Impl;

import com.ehealth.dao.RoomTypeDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.RoomTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDAOImpl implements RoomTypeDAO{

    static Connection con = DBConnection.getConnection();
    @Override
    public List<RoomTypeModel> getAllRoomTypes() {
        List<RoomTypeModel> roomTypeModels = new ArrayList<>();
        try {
        PreparedStatement ps = con.prepareStatement("select * from room_type where active = 1");
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
           RoomTypeModel roomTypeModel = new RoomTypeModel();
           roomTypeModel.setRoomType(rs.getString("room_type_name"));
           roomTypeModel.setRoomCharges(rs.getString("charges"));
           roomTypeModels.add(roomTypeModel);
        }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
         return roomTypeModels;
    }

    @Override
    public Integer addRoomType(RoomTypeModel roomTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("insert into room_type (room_type_name,charges)"
                + " values (?,?)");
        preparedStatement.setString(1, roomTypeModel.getRoomType());
        preparedStatement.setString(2, roomTypeModel.getRoomCharges());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateRoomType(RoomTypeModel roomTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update room_type set room_type_name = ?,charges = ?"
                + " where room_type_id = ?");
        preparedStatement.setString(1, roomTypeModel.getRoomType());
        preparedStatement.setString(2, roomTypeModel.getRoomCharges());
        preparedStatement.setInt(3, roomTypeModel.getRoomTypeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteRoomType(RoomTypeModel roomTypeModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update room_type set active = 0 where"
                    + " room_type_id = ?");
            preparedStatement.setInt(1, roomTypeModel.getRoomTypeId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    
    @Override
    public ResultSet getAllRoomTypeResultSet(){
        ResultSet rst = null;
        try {
            Connection con=DBConnection.getConnection();
            PreparedStatement pstmt= con.prepareStatement("select room_type_id as 'Room Type Id', room_type_name "
                    + "as 'Room Type', charges as 'Charges' from room_type where active = ?");
            pstmt.setInt(1, 1);
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public RoomTypeModel getRoomTypeWithId(Integer roomTypeId){
        RoomTypeModel roomTypeModel1 = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from room_type "
                    + "where room_type_id = ? and active = 1");
            preparedStatement.setInt(1,roomTypeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                roomTypeModel1 = new RoomTypeModel();
                roomTypeModel1.setRoomType(resultSet.getString("room_type_name"));
                roomTypeModel1.setRoomCharges(resultSet.getString("charges"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return roomTypeModel1;
    }
    
    @Override
    public RoomTypeModel getRoomTypeIdByName(String roomTypeName) {
        RoomTypeModel roomTypeModel1 = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from room_type where "
                    + "room_type_name = ? and active = 1");
            preparedStatement.setString(1,roomTypeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                roomTypeModel1 = new RoomTypeModel();
                roomTypeModel1.setRoomTypeId(resultSet.getInt("room_type_id"));
                roomTypeModel1.setRoomCharges(resultSet.getString("charges"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return roomTypeModel1;
    }

    @Override
    public Boolean isAvailableRoomType(RoomTypeModel roomTypeModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from room_type where room_type_name = ?  and active = 1");
            ps.setString(1, roomTypeModel.getRoomType());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailalbe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailalbe;
    }
}
