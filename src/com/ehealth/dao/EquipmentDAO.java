/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.EquipmentModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface EquipmentDAO {
    public List<EquipmentModel> getAllEquipments();
    public Integer addEquipment(EquipmentModel equipmentModel);
    public Integer updateEquipment(EquipmentModel equipmentModel);
    public Integer deleteEquipment(EquipmentModel equipmentModel);
    public ResultSet getAllEquipmentResultSet();
    public EquipmentModel getEquipmentWithId(Integer equipmentId);
}
