/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.ShiftDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.ShiftModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akash
 */
public class ShiftDAOImpl implements ShiftDAO {
    
    static Connection con = DBConnection.getConnection();

    @Override
    public List<ShiftModel> getAllShifts() {
        List<ShiftModel> shiftModels = new ArrayList<ShiftModel>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from shifts where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               ShiftModel shiftModel = new ShiftModel();
               shiftModel.setShiftId(rs.getInt("shift_id"));
               shiftModel.setShift(rs.getString("shift"));
               shiftModel.setCreatedBy(rs.getInt("created_by"));
               shiftModel.setModifiedBy(rs.getInt("modified_by"));
               shiftModels.add(shiftModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
         return shiftModels;
    }

    @Override
    public Integer addShift(ShiftModel shiftModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into shifts (shift,timing_from,timing_to,created_by) values (?,?,?,?)");
            preparedStatement.setString(1, shiftModel.getShift());
            preparedStatement.setString(2, shiftModel.getTimingFrom());
            preparedStatement.setString(3, shiftModel.getTimingTo());
            preparedStatement.setInt(4, shiftModel.getCreatedBy());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateShift(ShiftModel shiftModel) {
        int row=0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update shifts set shift = ?,timing_from = ?,timing_to = ?,modified_by = ? where shift_id = ?");
            preparedStatement.setString(1, shiftModel.getShift());
            preparedStatement.setString(2, shiftModel.getTimingFrom());
            preparedStatement.setString(3, shiftModel.getTimingTo());
            preparedStatement.setInt(4, shiftModel.getModifiedBy());
            preparedStatement.setInt(5, shiftModel.getShiftId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteShift(ShiftModel shiftModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAllShiftResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select shift_id as 'Shift ID',shift as 'Shift',timing_from as 'From',timing_to as 'To' from shifts where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public ShiftModel getShiftWithId(Integer shiftId) {
        ShiftModel shiftModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from shifts where shift_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1,shiftId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                shiftModel = new ShiftModel();
                shiftModel.setShift(rs.getString("shift"));
                shiftModel.setTimingFrom(rs.getString("timing_from"));
                shiftModel.setTimingTo(rs.getString("timing_to"));
                shiftModel.setCreatedBy(rs.getInt("created_by"));
                shiftModel.setModifiedBy(rs.getInt("modified_by"));                
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return shiftModel;
    }

    @Override
    public ShiftModel getShiftWithName(String shiftName) {
        ShiftModel shiftModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from shifts where "
                    + "shift = ? and active = 1");
            preparedStatement.setString(1,shiftName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                shiftModel = new ShiftModel();
                shiftModel.setShiftId(resultSet.getInt("shift_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return shiftModel;
    }
    
}
