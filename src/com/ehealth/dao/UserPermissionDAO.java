/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.UserPermissionModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface UserPermissionDAO {
    public List<UserPermissionModel> getAllUserPermissions();
    public Integer addUserPermission(UserPermissionModel userPermissionModel);
    public Integer updateUserPermission(UserPermissionModel userPermissionModel);
    public Integer deleteUserPermission(UserPermissionModel userPermissionModel);
    public ResultSet getAllUserPermissionResultSet();
    public UserPermissionModel getUserPermissionWithId(Integer userPermissionId);
    public List<UserPermissionModel> getUnassignedPermissions(String userType);
    public List<UserPermissionModel> getAssignedPermissions(String userType);
}
