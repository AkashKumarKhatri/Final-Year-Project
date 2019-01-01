/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.TestPatientModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface TestPatientDAO {
    public List<TestPatientModel> getAllTestPatient();
    public Integer addTestPatient(TestPatientModel testPatientModel);
    public Integer updateTestPatient(TestPatientModel testPatientModel);
    public Integer deleteTestPatient(TestPatientModel testModel);
    public ResultSet getAllTestPatientResultSet();
    public TestPatientModel getTesPatienttWithId(Integer testId);
    public TestPatientModel getTestPatientIdWithName(String testName);
    public ResultSet getTesPatientWithAppointmentId(Integer appointmentId);
}
