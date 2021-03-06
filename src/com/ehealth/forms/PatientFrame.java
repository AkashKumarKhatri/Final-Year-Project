/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.forms;

import com.ehealth.dao.BloodDAO;
import com.ehealth.dao.Impl.BloodDAOImpl;
import com.ehealth.dao.Impl.PatientDAOImpl;
import com.ehealth.dao.Impl.UserPermissionDAOImpl;
import com.ehealth.dao.PatientDAO;
import com.ehealth.dao.UserPermissionDAO;
import com.ehealth.models.BloodModel;
import com.ehealth.models.PatientModel;
import com.ehealth.models.UserPermissionModel;
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
public class PatientFrame extends javax.swing.JFrame {

    private Integer patientId;

    /**
     * Creates new form PatientFrame
     */
    public PatientFrame() {
        initComponents();
        setIcon();
        populateMyTable();
        populateBloodGroupCombo();
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
        PatientLabel = new javax.swing.JLabel();
        patientBar = new javax.swing.JSeparator();
        lbPatientName = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        lbPatientAddress = new javax.swing.JLabel();
        txtPatientFatherName = new javax.swing.JTextField();
        lbPatientBloodGroup = new javax.swing.JLabel();
        txtPatientContact = new javax.swing.JTextField();
        lbPatientContact = new javax.swing.JLabel();
        patientBloodGroupCombo = new javax.swing.JComboBox<>();
        lbPatientFatherName1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPatientAddress = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Registrations");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanel.setBackground(new java.awt.Color(29, 29, 29));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PatientLabel.setForeground(new java.awt.Color(255, 255, 255));
        PatientLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Physical_Therapy_32px.png"))); // NOI18N
        PatientLabel.setText("Patient Registration");
        backgroundPanel.add(PatientLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 30));
        backgroundPanel.add(patientBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 680, 10));

        lbPatientName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPatientName.setForeground(new java.awt.Color(255, 255, 255));
        lbPatientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPatientName.setText("Name");
        backgroundPanel.add(lbPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, 30));

        txtPatientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientNameActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 190, 30));

        lbPatientAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPatientAddress.setForeground(new java.awt.Color(255, 255, 255));
        lbPatientAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPatientAddress.setText("Address");
        backgroundPanel.add(lbPatientAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 30));

        txtPatientFatherName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientFatherNameActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtPatientFatherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 190, 30));

        lbPatientBloodGroup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPatientBloodGroup.setForeground(new java.awt.Color(255, 255, 255));
        lbPatientBloodGroup.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPatientBloodGroup.setText("Blood Group");
        backgroundPanel.add(lbPatientBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 90, 30));

        txtPatientContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientContactActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtPatientContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 190, 30));

        lbPatientContact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPatientContact.setForeground(new java.awt.Color(255, 255, 255));
        lbPatientContact.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPatientContact.setText("Contact");
        backgroundPanel.add(lbPatientContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 70, 30));

        patientBloodGroupCombo.setBackground(backgroundPanel.getBackground());
        patientBloodGroupCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----SELECT GROUP----" }));
        backgroundPanel.add(patientBloodGroupCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 190, 30));

        lbPatientFatherName1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPatientFatherName1.setForeground(new java.awt.Color(255, 255, 255));
        lbPatientFatherName1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPatientFatherName1.setText("Father's Name");
        backgroundPanel.add(lbPatientFatherName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        txtPatientAddress.setColumns(20);
        txtPatientAddress.setRows(5);
        jScrollPane1.setViewportView(txtPatientAddress);

        backgroundPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 490, -1));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Insert_24px.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 115, 30));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Reset_24px.png"))); // NOI18N
        btnClear.setText("RESET");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 260, 115, 30));

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
        backgroundPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 260, 120, 30));

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Renew_24px_2.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 260, -1, 30));

        tablePanel.setBackground(backgroundPanel.getBackground());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Patients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        tablePanel.setOpaque(false);
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientTable.setModel(new javax.swing.table.DefaultTableModel(
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
        patientTable.setToolTipText("Patient Records");
        patientTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientTable.setFocusable(false);
        patientTable.setSelectionBackground(java.awt.Color.red);
        patientTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(patientTable);

        tablePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 640, 180));

        backgroundPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 660, 210));

        getContentPane().add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if((txtPatientName.getText().trim().isEmpty()) || (txtPatientFatherName.getText().trim().isEmpty()) || 
                (txtPatientContact.getText().trim().isEmpty()) || (patientBloodGroupCombo.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else  {
            PatientModel patientModel = new PatientModel();
            BloodModel bloodModel = new BloodModel();
            patientModel.setName(txtPatientName.getText().trim());
            patientModel.setFatherName(txtPatientFatherName.getText().trim());
            patientModel.setContact(txtPatientContact.getText().trim());
            patientModel.setAddress(txtPatientAddress.getText().trim());
            BloodDAO bloodDAO = new BloodDAOImpl();
            bloodModel = bloodDAO.getBloodGroupWithName(patientBloodGroupCombo.getSelectedItem().toString());
            patientModel.setCreatedBy(1);
            patientModel.setBloodModel(bloodModel);
            if(patientBloodGroupCombo.getSelectedItem().equals("----Select----")) {
                bloodModel.setBloodGroup(null);
                patientModel.setBloodModel(bloodModel);
            }
            else {
                PatientDAO patientDAO = new PatientDAOImpl();
                Boolean isAvailable = patientDAO.isPatientAvailable(patientModel);
                if(isAvailable == true) {
                    JOptionPane.showMessageDialog(rootPane, "Patient is Already Exist");
                }
                else {
                    int row = patientDAO.addPatient(patientModel);
                    if(row>0) {
                        populateMyTable();
                        clearFields();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Record Not ADDED");
                    }
                }
            }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(confirm == 0) {
            PatientModel patientModel = new PatientModel();
            patientModel.setPatientId(patientId);
            PatientDAO patientDAO = new PatientDAOImpl();
            int row = patientDAO.deletePatient(patientModel);
            System.out.println(row);
            if(row>0) {
                populateMyTable();
                clearFields();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Record Not Deleted");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if((txtPatientName.getText().trim().isEmpty()) && (txtPatientFatherName.getText().trim().isEmpty()) && 
                (txtPatientContact.getText().trim().isEmpty()) || (patientBloodGroupCombo.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else  {
            PatientModel patientModel = new PatientModel();
            BloodModel bloodModel = new BloodModel();
            patientModel.setPatientId(patientId);
            patientModel.setName(txtPatientName.getText().trim());
            patientModel.setFatherName(txtPatientFatherName.getText().trim());
            patientModel.setContact(txtPatientContact.getText().trim());
            patientModel.setAddress(txtPatientAddress.getText().trim());
            BloodDAO bloodDAO = new BloodDAOImpl();
            bloodModel = bloodDAO.getBloodGroupWithName(patientBloodGroupCombo.getSelectedItem().toString());
            patientModel.setModifiedBy(1);
            patientModel.setBloodModel(bloodModel);
            if(patientBloodGroupCombo.getSelectedIndex() == 0) {
                bloodModel.setBloodGroup(null);
                patientModel.setBloodModel(bloodModel);
            }
            else {
                PatientDAO patientDAO = new PatientDAOImpl();
//                Boolean isAvailable = patientDAO.isPatientAvailableForUpdate(patientModel);
//                if(isAvailable == true) {
//                    JOptionPane.showMessageDialog(rootPane, "Patient is Already Exist With Name "+txtPatientName.getText()+""
//                            + " AND Number "+txtPatientContact.getText());
//                }
                //else {
                    int row = patientDAO.updatePatient(patientModel);
                    if(row>0) {
                        populateMyTable();
                        clearFields();
                        btnAdd.setEnabled(true);
                        btnDelete.setEnabled(false);
                        btnUpdate.setEnabled(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Record Not UPDATED");
                    }
                //}
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        patientId = (Integer) patientTable.getValueAt(patientTable.getSelectedRow(),0);
        PatientDAO patientDAO = new PatientDAOImpl();
        PatientModel patientModel = patientDAO.getPatientWithId(patientId);
        txtPatientName.setText(patientModel.getName());
        txtPatientFatherName.setText(patientModel.getFatherName());
        txtPatientContact.setText(patientModel.getContact());
        txtPatientAddress.setText(patientModel.getAddress());
        patientBloodGroupCombo.setSelectedItem(patientModel.getBloodModel().getBloodGroup());
    }//GEN-LAST:event_patientTableMouseClicked

    private void txtPatientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientNameActionPerformed
        txtPatientContact.requestFocus();
    }//GEN-LAST:event_txtPatientNameActionPerformed

    private void txtPatientContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientContactActionPerformed
        txtPatientFatherName.requestFocus();
    }//GEN-LAST:event_txtPatientContactActionPerformed

    private void txtPatientFatherNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientFatherNameActionPerformed
        patientBloodGroupCombo.requestFocus();
    }//GEN-LAST:event_txtPatientFatherNameActionPerformed

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
//            java.util.logging.Logger.getLogger(PatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PatientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PatientFrame().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbPatientAddress;
    private javax.swing.JLabel lbPatientBloodGroup;
    private javax.swing.JLabel lbPatientContact;
    private javax.swing.JLabel lbPatientFatherName1;
    private javax.swing.JLabel lbPatientName;
    private javax.swing.JSeparator patientBar;
    private javax.swing.JComboBox<String> patientBloodGroupCombo;
    private javax.swing.JTable patientTable;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextArea txtPatientAddress;
    private javax.swing.JTextField txtPatientContact;
    private javax.swing.JTextField txtPatientFatherName;
    private javax.swing.JTextField txtPatientName;
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
        PatientDAO patientDAO = new PatientDAOImpl();
        ResultSet rs= patientDAO.getAllPatientResultSet();
        DefaultTableModel dtm=null;
        try {
            dtm = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        patientTable.setModel(dtm);
    }
    private void clearFields() {
        txtPatientAddress.setText(null);
        txtPatientContact.setText(null);
        txtPatientFatherName.setText(null);
        txtPatientName.setText(null);
        patientBloodGroupCombo.setSelectedIndex(0);
    }
    private void populateBloodGroupCombo() {
        BloodDAO bloodDAO = new BloodDAOImpl();
        List<BloodModel> allBloodGroup = bloodDAO.getAllBloodGroups();
        for (BloodModel bloodModel : allBloodGroup) {
            patientBloodGroupCombo.addItem(bloodModel.getBloodGroup());
        }
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
    }

    private void checkPermissions() {
        UserPermissionDAO permissionDAO = new UserPermissionDAOImpl();
        List<UserPermissionModel> permissionModels = permissionDAO.getAssignedPermissions(LoginFrame.userType);
        for (UserPermissionModel permissionModel : permissionModels) {
            if(permissionModel.getPermissionModel().getName().equals("ADD_PATIENT")) {
                btnAdd.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("UPDATE_PATIENT")) {
                btnUpdate.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("DELETE_PATIENT")) {
                btnDelete.setVisible(true);
            }
        }
    }
}
