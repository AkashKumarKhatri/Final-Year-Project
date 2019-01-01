package com.ehealth.dao;

import com.ehealth.models.EmployeeTypeModel;
import com.ehealth.models.RoomTypeModel;
import java.sql.ResultSet;
import java.util.List;

public interface EmployeeTypeDAO {
    public List<EmployeeTypeModel> getAllEmployeeType();
    public Integer addEmployeeType(EmployeeTypeModel employeeTypeModel);
    public Integer updateEmployeeType(EmployeeTypeModel employeeTypeModel);
    public Integer deleteEmployeeType(EmployeeTypeModel employeeTypeModel);
    public ResultSet getAllEmployeeTypeResultSet();
    public EmployeeTypeModel getEmployeeTypeWithId(Integer employeeTypeId);
    public EmployeeTypeModel getEmployeeTypeWithName(String employeeTypeName);
    public Boolean isAvailableEmployeeType(EmployeeTypeModel employeeTypeModel);
}
