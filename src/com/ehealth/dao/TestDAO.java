/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.TestModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface TestDAO {
    public List<TestModel> getAllTests();
    public Integer addTest(TestModel testModel);
    public Integer updateTest(TestModel testModel);
    public Integer deleteTest(TestModel testModel);
    public ResultSet getAllTestResultSet();
    public TestModel getTestWithId(Integer testId);
    public TestModel getTestIdWithName(String testName);
}
