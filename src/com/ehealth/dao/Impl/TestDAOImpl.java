/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.TestDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.TestModel;
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
public class TestDAOImpl implements TestDAO {
    
    Connection con = DBConnection.getConnection();

    @Override
    public List<TestModel> getAllTests() {
        List<TestModel> testModels = new ArrayList<>();
        TestModel testModel;
        try {
            PreparedStatement ps = con.prepareStatement("select * from test where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                testModel = new TestModel();
                testModel.setName(rs.getString("name"));
                testModels.add(testModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testModels;
    }

    @Override
    public Integer addTest(TestModel testModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("insert into test (name,charge,duration) values (?,?,?)");
        preparedStatement.setString(1, testModel.getName());
        preparedStatement.setInt(2, testModel.getCharge());
        preparedStatement.setString(3, testModel.getDuration());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateTest(TestModel testModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update test set name = ?,charge = ?,duration = ? where test_id = ?");
        preparedStatement.setString(1, testModel.getName());
        preparedStatement.setInt(2, testModel.getCharge());
        preparedStatement.setString(3, testModel.getDuration());
        preparedStatement.setInt(4, testModel.getTestId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteTest(TestModel testModel) {
        int row = 0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update test set active = 0 where test_id = ?");
        preparedStatement.setInt(1,testModel.getTestId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllTestResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select test_id as 'Test ID',name as 'Test',charge as"
                    + " 'Charges',duration as 'Duration' from test where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rst;
    }

    @Override
    public TestModel getTestWithId(Integer testId) {
        TestModel testModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from test where test_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1, testId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testModel = new TestModel();
                testModel.setName(resultSet.getString("name"));
                testModel.setCharge(resultSet.getInt("charge"));
                testModel.setDuration(resultSet.getString("duration"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return testModel;
    }

    @Override
    public TestModel getTestIdWithName(String testName) {
        TestModel testModel = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from test where name = ? "
                    + "and active = 1");
            preparedStatement.setString(1, testName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testModel = new TestModel();
                testModel.setTestId(resultSet.getInt("test_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return testModel;
    }
}
