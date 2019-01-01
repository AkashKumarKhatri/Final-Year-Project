/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.BloodModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface BloodDAO {
    public List<BloodModel> getAllBloodGroups();
    public Integer addBloodGroup(BloodModel bloodModel);
    public Integer updateBloodGroup(BloodModel bloodModel);
    public Integer deleteBloodGroup(BloodModel bloodModel);
    public ResultSet getAllBloodGroupResultSet();
    public BloodModel getBloodGroupWithId(Integer bloodId);
    public BloodModel getBloodGroupWithName(String bloodGroup);
    public Boolean isAvailableBloodGroup(BloodModel bloodModel);
}
