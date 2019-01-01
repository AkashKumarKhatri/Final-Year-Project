/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.PatientModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akash
 */
public interface PatientDAO {
    public List<PatientModel> getAllPatients();
    public Integer addPatient(PatientModel patientModel);
    public Integer updatePatient(PatientModel patientModel);
    public Integer deletePatient(PatientModel patientModel);
    public ResultSet getAllPatientResultSet();
    public PatientModel getPatientWithId(Integer patientId);
    public PatientModel getPatientIdWithName(String patientName);
    public Boolean isPatientAvailable(PatientModel patientModel);
    public Boolean isPatientAvailableForUpdate(PatientModel patientModel);
}
