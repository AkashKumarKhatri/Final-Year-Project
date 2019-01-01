/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.UserTypeModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface UserTypeDAO {
    public List<UserTypeModel> getAllUserTypes();
    public Integer addUserType(UserTypeModel userTypeModel);
    public Integer updateUserType(UserTypeModel userTypeModel);
    public Integer deleteUserType(UserTypeModel userTypeModel);
    public ResultSet getAllUserTypeResultSet();
    public UserTypeModel getUserTypeWithId(Integer userId);
    public UserTypeModel getUserTypeIdWithName(String userType);
}
