package com.ehealth.dao;

import com.ehealth.models.EmployeeModel;
import java.sql.ResultSet;
import java.util.List;

public interface EmployeeDAO {
    public List<EmployeeModel> getAllEmployees();
    public Integer addEmployee(EmployeeModel employeeModel);
    public Integer updateEmployee(EmployeeModel employeeModel);
    public Integer deleteEmployee(EmployeeModel employeeModel);
    public ResultSet getAllEmployeeResultSet();
    public EmployeeModel getEmployeeWithId(Integer employeeId);
    public EmployeeModel getEmployeeIdWithName(String employeeName);
    public Boolean isEmployeeAvailable(EmployeeModel employeeModel);
    public Boolean isEmployeeAvailableForUpdate(EmployeeModel employeeModel);
    public List<EmployeeModel> getAllDoctors();
    public ResultSet getAllDoctorsResultSet();
}
