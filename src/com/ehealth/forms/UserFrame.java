/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.forms;

import com.ehealth.dao.EmployeeDAO;
import com.ehealth.dao.Impl.EmployeeDAOImpl;
import com.ehealth.dao.Impl.UserDAOImpl;
import com.ehealth.dao.Impl.UserPermissionDAOImpl;
import com.ehealth.dao.Impl.UserTypeDAOImpl;
import com.ehealth.dao.UserDAO;
import com.ehealth.dao.UserPermissionDAO;
import com.ehealth.dao.UserTypeDAO;
import com.ehealth.models.EmployeeModel;
import com.ehealth.models.UserModel;
import com.ehealth.models.UserPermissionModel;
import com.ehealth.models.UserTypeModel;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class UserFrame extends javax.swing.JFrame {

    private Integer userId;

    /**
     * Creates new form UserFrame
     */
    public UserFrame() {
        initComponents();
        setIcon();
        populateMyTable();
        populateUserTypeCombo();
        btnAdd.setVisible(false);
        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
        checkPermissions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        lbEmployeeName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        PatientLabel = new javax.swing.JLabel();
        patientBar = new javax.swing.JSeparator();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        txtUserPassword = new javax.swing.JTextField();
        lbEmployeeName1 = new javax.swing.JLabel();
        comboUserType = new javax.swing.JComboBox<>();
        lbEmployeeName2 = new javax.swing.JLabel();
        lbEmployeeName3 = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("User Registration");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanel.setBackground(new java.awt.Color(29, 29, 29));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEmployeeName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmployeeName.setForeground(new java.awt.Color(255, 255, 255));
        lbEmployeeName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmployeeName.setText("Username");
        backgroundPanel.add(lbEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 80, 30));
        backgroundPanel.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 200, 30));

        PatientLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PatientLabel.setForeground(new java.awt.Color(255, 255, 255));
        PatientLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Male_User_32px.png"))); // NOI18N
        PatientLabel.setText(" User Registrations");
        backgroundPanel.add(PatientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));
        backgroundPanel.add(patientBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 520, 10));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Insert_24px.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 160, 30));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Reset_24px.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 160, 30));

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Delete_Document_24px.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 160, 30));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Reset_24px.png"))); // NOI18N
        btnClear.setText("RESET");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 160, 30));

        tablePanel.setBackground(backgroundPanel.getBackground());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Users", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        tablePanel.setOpaque(false);
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userTable.setToolTipText("Patient Records");
        userTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userTable.setFocusable(false);
        userTable.setSelectionBackground(java.awt.Color.red);
        userTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        tablePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 480, 230));

        backgroundPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 500, 260));
        backgroundPanel.add(txtUserPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 200, 30));

        lbEmployeeName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmployeeName1.setForeground(new java.awt.Color(255, 255, 255));
        lbEmployeeName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmployeeName1.setText("User Type");
        backgroundPanel.add(lbEmployeeName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 80, 30));

        comboUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select----" }));
        backgroundPanel.add(comboUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 200, 30));

        lbEmployeeName2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmployeeName2.setForeground(new java.awt.Color(255, 255, 255));
        lbEmployeeName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmployeeName2.setText("Password");
        backgroundPanel.add(lbEmployeeName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 80, 30));

        lbEmployeeName3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEmployeeName3.setForeground(new java.awt.Color(255, 255, 255));
        lbEmployeeName3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEmployeeName3.setText("Employee Name");
        backgroundPanel.add(lbEmployeeName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 30));

        txtEmployeeName.setEditable(false);
        txtEmployeeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmployeeNameMouseClicked(evt);
            }
        });
        txtEmployeeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeNameActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtEmployeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 200, 30));

        getContentPane().add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if((txtUsername.getText().trim().isEmpty()) || (txtUserPassword.getText().trim().isEmpty()) ||
                (comboUserType.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else {
            UserModel userModel = new UserModel();
            userModel.setName(txtUsername.getText().trim());
            userModel.setPassword(txtUserPassword.getText().trim());
            UserTypeDAO userTypeDAO = new UserTypeDAOImpl();
            UserTypeModel userTypeModel = userTypeDAO.getUserTypeIdWithName(comboUserType.getSelectedItem().toString());
            userModel.setUserTypeModel(userTypeModel);
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            EmployeeModel employeeModel = employeeDAO.getEmployeeIdWithName(txtEmployeeName.getText());
            userModel.setEmployeeModel(employeeModel);
            userModel.setCreatedBy(1);
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.addUser(userModel);
            if(row>0) {
                txtUsername.setText(null);
                txtUserPassword.setText(null);
                txtEmployeeName.setText(null);
                comboUserType.setSelectedIndex(0);
                populateMyTable();
            }
            else {
                JOptionPane.showMessageDialog(null, "Record Not Added");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if((txtUsername.getText().trim().isEmpty()) || (txtUserPassword.getText().trim().isEmpty()) ||
                (comboUserType.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else {
            UserModel userModel = new UserModel();
            userModel.setName(txtUsername.getText().trim());
            userModel.setPassword(txtUserPassword.getText().trim());
            UserTypeDAO userTypeDAO = new UserTypeDAOImpl();
            UserTypeModel userTypeModel = userTypeDAO.getUserTypeIdWithName(comboUserType.getSelectedItem().toString());
            userModel.setUserTypeModel(userTypeModel);
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            EmployeeModel employeeModel = employeeDAO.getEmployeeIdWithName(txtEmployeeName.getText());
            userModel.setEmployeeModel(employeeModel);
            userModel.setModifiedBy(1);
            userModel.setUserId(userId);
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.updateUser(userModel);
            if(row>0) {
                txtUsername.setText(null);
                txtUserPassword.setText(null);
                txtEmployeeName.setText(null);
                comboUserType.setSelectedIndex(0);
                populateMyTable();
                btnAdd.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Record Not Updated");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(confirm==0) {
            UserModel userModel = new UserModel();
            userModel.setUserId(userId);
            UserDAO userDAO = new UserDAOImpl();
            int row = userDAO.deleteUser(userModel);
            if(row>0) {
                txtUsername.setText(null);
                txtUserPassword.setText(null);
                txtEmployeeName.setText(null);
                comboUserType.setSelectedIndex(0);
                populateMyTable();
                btnAdd.setEnabled(true);
                btnUpdate.setEnabled(false);
                btnDelete.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Record Not Deleted");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        txtUsername.setText(null);
        txtUserPassword.setText(null);
        txtEmployeeName.setText(null);
        comboUserType.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        userId = (Integer) userTable.getValueAt(userTable.getSelectedRow(), 0);
        UserDAO userDAO = new UserDAOImpl();
        UserModel userModel = userDAO.getUserWithId(userId);
        txtUsername.setText(userModel.getName());
        txtUserPassword.setText(userModel.getPassword());
        comboUserType.setSelectedItem(userModel.getUserTypeModel().getUserType());
        txtEmployeeName.setText(userModel.getEmployeeModel().getName());
    }//GEN-LAST:event_userTableMouseClicked

    private void txtEmployeeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmployeeNameMouseClicked
        new EmployeeTableFrame().setVisible(true);
    }//GEN-LAST:event_txtEmployeeNameMouseClicked

    private void txtEmployeeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeNameActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UserFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UserFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PatientLabel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboUserType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbEmployeeName;
    private javax.swing.JLabel lbEmployeeName1;
    private javax.swing.JLabel lbEmployeeName2;
    private javax.swing.JLabel lbEmployeeName3;
    private javax.swing.JSeparator patientBar;
    private javax.swing.JPanel tablePanel;
    public static javax.swing.JTextField txtEmployeeName;
    private javax.swing.JTextField txtUserPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
    private void populateMyTable() {
       
        UserDAO userDAO = new UserDAOImpl();
        ResultSet rs= userDAO.getAllUserResultSet();
        DefaultTableModel dtm=null;
        try {
            dtm = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        userTable.setModel(dtm);
    }

    private void populateUserTypeCombo() {
        UserTypeDAO userTypeDAO = new UserTypeDAOImpl();
        List<UserTypeModel> allUserTypes = userTypeDAO.getAllUserTypes();
        for (UserTypeModel allUserType : allUserTypes) {
            comboUserType.addItem(allUserType.getUserType());
        }
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
    }

    private void checkPermissions() {
        UserPermissionDAO permissionDAO = new UserPermissionDAOImpl();
        List<UserPermissionModel> permissionModels = permissionDAO.getAssignedPermissions(LoginFrame.userType);
        for (UserPermissionModel permissionModel : permissionModels) {
            if(permissionModel.getPermissionModel().getName().equals("ADD_USER")) {
                btnAdd.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("UPDATE_USER")) {
                btnUpdate.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("DELETE_USER")) {
                btnDelete.setVisible(true);
            }
        }
    }
}
