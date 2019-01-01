/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.SpecializationModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface SpecializationDAO {
    public List<SpecializationModel> getAllSpecialization();
    public Integer addSpecialization(SpecializationModel specializationModel);
    public Integer updateSpecialization(SpecializationModel specializationModel);
    public Integer deleteSpecialization(SpecializationModel specializationModel);
    public ResultSet getAllSpecializationResultSet();
    public SpecializationModel getSpecializationWithId(Integer specializationId);
    public SpecializationModel getSpecializationWithName(String spectialization);
    public Boolean isSpecializationAvailable(SpecializationModel specializationModel);
}
