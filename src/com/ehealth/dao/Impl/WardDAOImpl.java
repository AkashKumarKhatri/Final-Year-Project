/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.WardDAO;
import com.ehealth.dao.connection.DBConnection;
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
public class WardDAOImpl implements WardDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public List<WardModel> getAllWards() {
        List<WardModel> wardModels = new ArrayList<WardModel>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from wards where active = 1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                WardModel wardModel = new WardModel();
                wardModel.setWardId(rs.getInt("ward_id"));
                wardModel.setName(rs.getString("name"));
                wardModels.add(wardModel);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return wardModels;
    }

    @Override
    public Integer addWard(WardModel wardModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("insert into wards (name) values (?)");
        preparedStatement.setString(1, wardModel.getName());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateWard(WardModel wardModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update wards set name = ? where ward_id = ?");
        preparedStatement.setString(1, wardModel.getName());
        preparedStatement.setInt(2, wardModel.getWardId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteWard(WardModel wardModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update wards set active = 0 where ward_id = ?");
        preparedStatement.setInt(1, wardModel.getWardId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllWardResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select ward_id as 'Ward ID',name as 'Ward Name' from wards where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public WardModel getWardWithId(Integer wardId) {
        WardModel wardModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from wards where ward_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1, wardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wardModel = new WardModel();
                wardModel.setName(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return wardModel;
    }

    public WardModel getWardIdByName(String wardName) {
        WardModel wardModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from wards where name = ? "
                    + "and active = 1");
            preparedStatement.setString(1, wardName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                wardModel = new WardModel();
                wardModel.setWardId(resultSet.getInt("ward_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return wardModel;
    }
}
