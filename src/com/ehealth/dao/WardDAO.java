/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.WardModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface WardDAO {
    public List<WardModel> getAllWards();
    public Integer addWard(WardModel wardModel);
    public Integer updateWard(WardModel wardModel);
    public Integer deleteWard(WardModel wardModel);
    public ResultSet getAllWardResultSet();
    public WardModel getWardWithId(Integer employeeId);
    public WardModel getWardIdByName(String wardName);
}
