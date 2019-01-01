/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.OperationModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface OperationDAO {
    public List<OperationModel> getAllOperations();
    public Integer addOperation(OperationModel operationModel);
    public Integer updateOperation(OperationModel operationModel);
    public Integer deleteOperation(OperationModel operationModel);
    public ResultSet getAllOperationResultSet();
    public OperationModel getOperationWithId(Integer operationId);
    public OperationModel getOperationIdWithOperationType(String operationName);
}
