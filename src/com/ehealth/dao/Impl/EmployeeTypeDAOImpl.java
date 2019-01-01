package com.ehealth.dao.Impl;

import com.ehealth.dao.EmployeeTypeDAO;
//import static ehealth.dao.Impl.RoomTypeDAOImpl.con;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.EmployeeTypeModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTypeDAOImpl implements EmployeeTypeDAO{
    Connection con = DBConnection.getConnection();
    @Override
    public List<EmployeeTypeModel> getAllEmployeeType() {
        List<EmployeeTypeModel> employeeTypeModels = new ArrayList<EmployeeTypeModel>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from employee_type where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               EmployeeTypeModel employeeTypeModel = new EmployeeTypeModel();
               employeeTypeModel.setEmployeeTypeId(rs.getInt("employee_type_id"));
               employeeTypeModel.setEmployeeType(rs.getString("employee_type_name"));
               employeeTypeModel.setCreatedBy(rs.getInt("created_by"));
               employeeTypeModel.setModifiedBy(rs.getInt("modified_by"));
               employeeTypeModels.add(employeeTypeModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
         return employeeTypeModels;
    }

    @Override
    public Integer addEmployeeType(EmployeeTypeModel employeeTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("insert into employee_type (employee_type_name) values (?)");//created_by,"
                //+ "modified_by) values (?,?,?)");
        preparedStatement.setString(1, employeeTypeModel.getEmployeeType());
        //preparedStatement.setInt(2, employeeTypeModel.getCreatedBy());
        //preparedStatement.setInt(3, employeeTypeModel.getModifiedBy());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateEmployeeType(EmployeeTypeModel employeeTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update employee_type set employee_type_name = ? where employee_type_id = ?");//, created_by = ?,"
                //+ "modified_by = ? where employee_type_id = ?");
        preparedStatement.setString(1, employeeTypeModel.getEmployeeType());
//        preparedStatement.setInt(2, employeeTypeModel.getCreatedBy());
  //      preparedStatement.setInt(3, employeeTypeModel.getModifiedBy());
        preparedStatement.setInt(2, employeeTypeModel.getEmployeeTypeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteEmployeeType(EmployeeTypeModel employeeTypeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update employee_type set active = 0 where employee_type_id = ?");
        preparedStatement.setInt(1, employeeTypeModel.getEmployeeTypeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllEmployeeTypeResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("select employee_type_id as 'ID',employee_type_name as 'Type' from employee_type where active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public EmployeeTypeModel getEmployeeTypeWithId(Integer employeeTypeId) {
        EmployeeTypeModel employeeTypeModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from employee_type where employee_type_id = ? "
                    + "and active = 1");
            preparedStatement.setInt(1,employeeTypeId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
               employeeTypeModel = new EmployeeTypeModel();
               employeeTypeModel.setEmployeeTypeId(rs.getInt("employee_type_id"));
               employeeTypeModel.setEmployeeType(rs.getString("employee_type_name"));
               employeeTypeModel.setCreatedBy(rs.getInt("created_by"));
               employeeTypeModel.setModifiedBy(rs.getInt("modified_by"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return employeeTypeModel;
    }

    @Override
    public EmployeeTypeModel getEmployeeTypeWithName(String employeeTypeName) {
       EmployeeTypeModel employeeTypeModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from employee_type where "
                    + "employee_type_name = ? and active = 1");
            preparedStatement.setString(1,employeeTypeName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                employeeTypeModel = new EmployeeTypeModel();
                employeeTypeModel.setEmployeeTypeId(resultSet.getInt("employee_type_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return employeeTypeModel;
    }

    @Override
    public Boolean isAvailableEmployeeType(EmployeeTypeModel employeeTypeModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from employee_type where employee_type_name = ?  and active = 1");
            ps.setString(1, employeeTypeModel.getEmployeeType());
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
