/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.dao;

import com.ehealth.models.UserModel;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Akaash
 */
public interface UserDAO {
    public List<UserModel> getAllUsers();
    public Integer addUser(UserModel userModel);
    public Integer updateUser(UserModel userModel);
    public Integer deleteUser(UserModel userModel);
    public ResultSet getAllUserResultSet();
    public UserModel getUserWithId(Integer userId);
    public UserModel getUser(String username,String password);
}
