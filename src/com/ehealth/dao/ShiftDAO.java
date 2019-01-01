/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.ShiftModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface ShiftDAO {
    public List<ShiftModel> getAllShifts();
    public Integer addShift(ShiftModel shiftModel);
    public Integer updateShift(ShiftModel shiftModel);
    public Integer deleteShift(ShiftModel shiftModel);
    public ResultSet getAllShiftResultSet();
    public ShiftModel getShiftWithId(Integer shiftId);
    public ShiftModel getShiftWithName(String shiftName);
}
