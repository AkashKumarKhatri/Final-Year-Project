/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.PermissionModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface PermissionDAO {
    public List<PermissionModel> getAllPermissions();
    public Integer addPermission(PermissionModel permissionModel);
    public Integer updatePermission(PermissionModel permissionModel);
    public Integer deletePermission(PermissionModel permissionModel);
    public ResultSet getAllPermissionResultSet();
    public PermissionModel getPermissionWithId(Integer permissionId);
    public PermissionModel getPermissionWithPermissionType(String permissionType);
}
