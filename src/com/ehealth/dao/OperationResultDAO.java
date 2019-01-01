/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.OperationResultModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface OperationResultDAO {
    public List<OperationResultModel> getAllOperationResult();
    public Integer addOperationResult(OperationResultModel operationResultModel);
    public Integer updateOperationResult(OperationResultModel operationResultModel);
    public Integer deleteOperationResult(OperationResultModel operationResultModel);
    public ResultSet getAllOperationResultResultSet();
    public OperationResultModel getOperationResultWithId(Integer employeeId);
    public ResultSet getOperationResultWithAppointmentId(Integer appointmentId);
}
