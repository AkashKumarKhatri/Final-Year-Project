/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.ScreenModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface ScreenDAO {
    public List<ScreenModel> getAllScreens();
    public Integer addScreen(ScreenModel screenModel);
    public Integer updateScreen(ScreenModel screenModel);
    public Integer deleteScreen(ScreenModel screenModel);
    public ResultSet getAllScreenResultSet();
    public ScreenModel getScreenWithId(Integer employeeId);
}
