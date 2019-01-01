/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.EquipmentTypeModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface EquipmentTypeDAO {
    public List<EquipmentTypeModel> getAllEquipmentTypes();
    public Integer addEquipmentType(EquipmentTypeModel equipmentTypeModel);
    public Integer updateEquipmentType(EquipmentTypeModel equipmentTypeModel);
    public Integer deleteEquipmentType(EquipmentTypeModel equipmentTypeModel);
    public ResultSet getAllEquipmentTypeResultSet();
    public EquipmentTypeModel getEquipmentTypeWithId(Integer equipmentTypeId);
    public EquipmentTypeModel getEquipmentTypeIdWithName(String toString);
}
