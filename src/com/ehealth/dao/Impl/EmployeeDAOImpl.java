/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao.Impl;

import com.ehealth.dao.EmployeeDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.BloodModel;
import com.ehealth.models.EmployeeModel;
import com.ehealth.models.EmployeeTypeModel;
import com.ehealth.models.ShiftModel;
import com.ehealth.models.SpecializationModel;
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
public class EmployeeDAOImpl implements EmployeeDAO {
    
    Connection con = DBConnection.getConnection();
    
    @Override
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select * from employees where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               EmployeeModel employeeModel = new EmployeeModel();
               employeeModel.setEmployeeId(rs.getInt("employee_id"));
               employeeModel.setName(rs.getString("name"));
               employeeModel.setCnic(rs.getString("cnic"));
               employeeModel.setContact(rs.getString("contact"));
               employeeModel.setGender(rs.getString("gender"));
               employeeModel.setFees(rs.getInt("fees"));
               employeeModel.setSalary(rs.getInt("salary"));
               employeeModel.setCreatedBy(rs.getInt("created_by"));
               employeeModel.setModifiedBy(rs.getInt("modified_by"));
               employeeModel.setAddress(rs.getString("address"));
               employeeModels.add(employeeModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return employeeModels;
    }

    @Override
    public Integer addEmployee(EmployeeModel employeeModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("insert into employees (name,cnic,contact,address,gender,"
                    + "fees,salary,employee_type_id,blood_id,specialization_id,shift_id,date_of_joining) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, employeeModel.getName());
            preparedStatement.setString(2, employeeModel.getCnic());
            preparedStatement.setString(3, employeeModel.getContact());
            preparedStatement.setString(4, employeeModel.getAddress());
            preparedStatement.setString(5, employeeModel.getGender());
            preparedStatement.setInt(6, employeeModel.getFees());
            preparedStatement.setInt(7, employeeModel.getSalary());
            preparedStatement.setInt(8, employeeModel.getEmployeeTypeModel().getEmployeeTypeId());
            preparedStatement.setInt(9, employeeModel.getBloodModel().getBloodId());
            preparedStatement.setInt(10, employeeModel.getSpecializationModel().getSpecializationId());
            preparedStatement.setInt(11, employeeModel.getShiftModel().getShiftId());
            preparedStatement.setTimestamp(12, employeeModel.getDateOfJoining());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer updateEmployee(EmployeeModel employeeModel) {
        int row = 0;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update employees set name = ?,cnic = ?,contact = ?,address = ?,"
                    + "gender = ?,fees = ?,salary = ?,employee_type_id = ?,blood_id = ?,specialization_id = ?,shift_id = ?, "
                    + "date_of_joining = ? where employee_id = ?");
            preparedStatement.setString(1, employeeModel.getName());
            preparedStatement.setString(2, employeeModel.getCnic());
            preparedStatement.setString(3, employeeModel.getContact());
            preparedStatement.setString(4, employeeModel.getAddress());
            preparedStatement.setString(5, employeeModel.getGender());
            preparedStatement.setInt(6, employeeModel.getFees());
            preparedStatement.setInt(7, employeeModel.getSalary());
            preparedStatement.setInt(8, employeeModel.getEmployeeTypeModel().getEmployeeTypeId());
            preparedStatement.setInt(9, employeeModel.getBloodModel().getBloodId());
            preparedStatement.setInt(10, employeeModel.getSpecializationModel().getSpecializationId());
            preparedStatement.setInt(11, employeeModel.getShiftModel().getShiftId());
            preparedStatement.setTimestamp(12, employeeModel.getDateOfJoining());
            preparedStatement.setInt(13, employeeModel.getEmployeeId());
            row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteEmployee(EmployeeModel employeeModel) {
        int row=0;
        try {
        PreparedStatement preparedStatement;
        preparedStatement = con.prepareStatement("update employees set active = 0 where employee_id = ?");
        preparedStatement.setInt(1, employeeModel.getEmployeeId());
        row = preparedStatement.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllEmployeeResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement pstmt= con.prepareStatement("SELECT e.employee_id as 'ID',e.name as 'Name',e.cnic "
                    + "as 'CNIC',et.employee_type_name as 'Type', s.specialization as 'Specialization', b.blood_group "
                    + "as 'Blood Group',sf.shift as 'Shift',e.date_of_joining as 'Joining' FROM employees e,employee_type et, "
                    + "blood b, specializations s,shifts sf WHERE e.employee_type_id = et.employee_type_id AND "
                    + "e.blood_id = b.blood_id AND e.specialization_id = s.specialization_id AND e.shift_id = sf.shift_id "
                    + "AND e.active = 1");
            rst= pstmt.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }

    @Override
    public EmployeeModel getEmployeeWithId(Integer employeeId) {
        EmployeeModel employeeModel = null;
        EmployeeTypeModel employeeTypeModel = null;
        BloodModel bloodModel = null;
        SpecializationModel specializationModel = null;
        ShiftModel shiftModel = null;
        try {
            String sql = "select * from employees e inner join employee_type et"
                    + " on e.employee_type_id = et.employee_type_id inner join blood b on e.blood_id = b.blood_id inner join "
                    + "specializations s on e.specialization_id = s.specialization_id inner join shifts sf on e.shift_id = "
                    + "sf.shift_id where e.employee_id = ? and e.active = 1";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,employeeId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                employeeModel = new EmployeeModel();
                employeeTypeModel = new EmployeeTypeModel();
                bloodModel = new BloodModel();
                specializationModel = new SpecializationModel();
                shiftModel = new ShiftModel();
                employeeModel.setName(rs.getString("name"));
                employeeModel.setCnic(rs.getString("cnic"));
                employeeModel.setContact(rs.getString("contact"));
                employeeModel.setGender(rs.getString("gender"));
                employeeModel.setFees(rs.getInt("fees"));
                employeeModel.setSalary(rs.getInt("salary"));
                employeeModel.setCreatedBy(rs.getInt("created_by"));
                employeeModel.setModifiedBy(rs.getInt("modified_by"));
                employeeModel.setAddress(rs.getString("address"));
                employeeModel.setDateOfJoining(rs.getTimestamp("date_of_joining"));
                employeeTypeModel.setEmployeeType(rs.getString("employee_type_name"));
                employeeModel.setEmployeeTypeModel(employeeTypeModel);
                bloodModel.setBloodGroup(rs.getString("blood_group"));
                employeeModel.setBloodModel(bloodModel);
                specializationModel.setSpecialization(rs.getString("specialization"));
                employeeModel.setSpecializationModel(specializationModel);
                shiftModel.setShift(rs.getString("shift"));
                employeeModel.setShiftModel(shiftModel);
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return employeeModel;
    }

    @Override
    public Boolean isEmployeeAvailable(EmployeeModel employeeModel) {
        Boolean isAvailable = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from employees where cnic = ? and name = ? and active = 1");
            ps.setString(1, employeeModel.getCnic());
            ps.setString(2, employeeModel.getName());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailable = true;
            }
        } catch (Exception e) {
        }
        return isAvailable;
    }

    @Override
    public Boolean isEmployeeAvailableForUpdate(EmployeeModel employeeModel) {
        Boolean isAvailable = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from employees where cnic = ? and contact = ? and name = ? and active = 1");
            ps.setString(1, employeeModel.getCnic());
            ps.setString(2, employeeModel.getContact());
            ps.setString(3, employeeModel.getName());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailable = true;
            }
        } catch (Exception e) {
        }
        return isAvailable;
    }

    @Override
    public EmployeeModel getEmployeeIdWithName(String employeeName) {
        EmployeeModel employeeModel = null;
        try {
            employeeModel = new EmployeeModel();
            PreparedStatement ps = con.prepareStatement("select * from employees where name = ? and active = 1");
            ps.setString(1, employeeName);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                employeeModel = new EmployeeModel();
                employeeModel.setEmployeeId(rs.getInt("employee_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> getAllDoctors() {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("select employee_id as 'Doctor ID', name as 'Name', cnic as 'CNIC',"
                    + "contact as 'Contact', gender as 'Gender', fees as 'Fees' from employees where employee_type_id = "
                    + "(select employee_type_id from employee_type where employee_type_name = 'Doctor' and active = 1) "
                    + "and  active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               EmployeeModel employeeModel = new EmployeeModel();
               employeeModel.setEmployeeId(rs.getInt("employee_id"));
               employeeModel.setName(rs.getString("name"));
               employeeModel.setCnic(rs.getString("cnic"));
               employeeModel.setContact(rs.getString("contact"));
               employeeModel.setGender(rs.getString("gender"));
               employeeModel.setFees(rs.getInt("fees"));
               employeeModel.setSalary(rs.getInt("salary"));
               employeeModel.setCreatedBy(rs.getInt("created_by"));
               employeeModel.setModifiedBy(rs.getInt("modified_by"));
               employeeModel.setAddress(rs.getString("address"));
               employeeModels.add(employeeModel);
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return employeeModels;
    }

    @Override
    public ResultSet getAllDoctorsResultSet() {
        ResultSet rst = null;
        try {
            PreparedStatement ps = con.prepareStatement("select employee_id as 'Doctor ID', name as 'Name', cnic as 'CNIC',"
                    + "contact as 'Contact', gender as 'Gender', fees as 'Fees' from employees where employee_type_id = "
                    + "(select employee_type_id from employee_type where employee_type_name = 'Doctor' and active = 1) "
                    + "and  active = 1");
            rst= ps.executeQuery();
        } catch (SQLException ex) {
        }
        return rst;
    }
}
