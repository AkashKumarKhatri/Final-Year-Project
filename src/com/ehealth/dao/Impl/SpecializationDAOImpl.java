package com.ehealth.dao.Impl;

import com.ehealth.dao.SpecializationDAO;
import com.ehealth.dao.connection.DBConnection;
import com.ehealth.models.SpecializationModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {
    
    static Connection con = DBConnection.getConnection();

    @Override
    public List<SpecializationModel> getAllSpecialization() {
        List<SpecializationModel> specializationModels = new ArrayList<>();
        SpecializationModel specializationModel = null;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("select * from specializations where active = 1");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                specializationModel = new SpecializationModel();
                specializationModel.setSpecializationId(rs.getInt("specialization_id"));
                specializationModel.setSpecialization(rs.getString("specialization"));
                specializationModel.setCreatedBy(rs.getInt("created_by"));
                specializationModel.setModifiedBy(rs.getInt("modified_by"));
                specializationModels.add(specializationModel);
            }
        } catch (Exception e) {
        }
        return specializationModels;
    }

    @Override
    public Integer addSpecialization(SpecializationModel specializationModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("insert into specializations (specialization,created_by) values (?,?)");
            ps.setString(1, specializationModel.getSpecialization());
            ps.setInt(2, specializationModel.getCreatedBy());
            row = ps.executeUpdate();
        } catch (Exception e) {}
        return row;
    }

    @Override
    public Integer updateSpecialization(SpecializationModel specializationModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update specializations set specialization = ?,modified_by = ? where specialization_id = ?");
            ps.setString(1, specializationModel.getSpecialization());
            ps.setInt(2, specializationModel.getCreatedBy());
            ps.setInt(3, specializationModel.getSpecializationId());
            row = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public Integer deleteSpecialization(SpecializationModel specializationModel) {
        int row = 0;
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("update specializations set active = 0 where specialization_id = ?");
            ps.setInt(1, specializationModel.getSpecializationId());
            row = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    @Override
    public ResultSet getAllSpecializationResultSet() {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("SELECT specialization_id as 'Specialization ID',specialization as 'Specialization' "
                    + "from specializations where active = 1");
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
        }
        return resultSet;
    }

    @Override
    public SpecializationModel getSpecializationWithId(Integer specializationId) {
        SpecializationModel specializationModel = null;
        try {
            specializationModel = new SpecializationModel();
            PreparedStatement ps = con.prepareStatement("select * from specializations where specialization_id = ?");
            ps.setInt(1, specializationId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                specializationModel = new SpecializationModel();
                specializationModel.setSpecialization(rs.getString("specialization"));
                specializationModel.setCreatedBy(rs.getInt("created_by"));
                specializationModel.setModifiedBy(rs.getInt("modified_by"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return specializationModel;
    }

    @Override
    public SpecializationModel getSpecializationWithName(String spectialization) {
        SpecializationModel specializationModel = null; 
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from specializations where "
                    + "specialization = ? and active = 1");
            preparedStatement.setString(1,spectialization);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                specializationModel = new SpecializationModel();
                specializationModel.setSpecializationId(resultSet.getInt("specialization_id"));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
        }
        return specializationModel;
    }

    @Override
    public Boolean isSpecializationAvailable(SpecializationModel specializationModel) {
        Boolean isAvailalbe = false;
        try {
            PreparedStatement ps = con.prepareStatement("select * from specializations where specialization = ?  and active = 1");
            ps.setString(1, specializationModel.getSpecialization());
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                isAvailalbe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAvailalbe;
    }
}
