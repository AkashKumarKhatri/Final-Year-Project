/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealth.forms;

import com.ehealth.dao.EquipmentDAO;
import com.ehealth.dao.EquipmentTypeDAO;
import com.ehealth.dao.Impl.EquipmentDAOImpl;
import com.ehealth.dao.Impl.EquipmentTypeDAOImpl;
import com.ehealth.dao.Impl.UserPermissionDAOImpl;
import com.ehealth.dao.UserPermissionDAO;
import com.ehealth.models.EquipmentModel;
import com.ehealth.models.EquipmentTypeModel;
import com.ehealth.models.UserPermissionModel;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class EquipmentFrame extends javax.swing.JFrame {

    private Integer equipmentId;

    /**
     * Creates new form EquipmentFrame
     */
    public EquipmentFrame() {
        initComponents();
        setIcon();
        populateMyTable();
        populateEquipmentTypeCombo();
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
        equipmentLabel = new javax.swing.JLabel();
        equipmentBar = new javax.swing.JSeparator();
        lbEquipmentType = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        comboEquipmentType = new javax.swing.JComboBox<>();
        lbEquipmentName = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        comboPurchaseDate = new com.toedter.calendar.JDateChooser();
        lbWarrenty = new javax.swing.JLabel();
        txtMenufactures = new javax.swing.JTextField();
        lbPuchaseDate = new javax.swing.JLabel();
        lbMenufactures = new javax.swing.JLabel();
        txtEquipmentName = new javax.swing.JTextField();
        txtWarrenty = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        equipmentTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equipment Details");

        backgroundPanel.setBackground(new java.awt.Color(29, 29, 29));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        equipmentLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        equipmentLabel.setForeground(new java.awt.Color(255, 255, 255));
        equipmentLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Maintenance_32px.png"))); // NOI18N
        equipmentLabel.setText("Equipment Details");
        backgroundPanel.add(equipmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 30));
        backgroundPanel.add(equipmentBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 750, 10));

        lbEquipmentType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEquipmentType.setForeground(new java.awt.Color(255, 255, 255));
        lbEquipmentType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEquipmentType.setText("Equipment Type");
        backgroundPanel.add(lbEquipmentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 120, 30));

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 210, 30));

        comboEquipmentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Select----" }));
        backgroundPanel.add(comboEquipmentType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 210, 30));

        lbEquipmentName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbEquipmentName.setForeground(new java.awt.Color(255, 255, 255));
        lbEquipmentName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbEquipmentName.setText("Name");
        backgroundPanel.add(lbEquipmentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, 30));

        lbQuantity.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbQuantity.setForeground(new java.awt.Color(255, 255, 255));
        lbQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbQuantity.setText("Quantity");
        backgroundPanel.add(lbQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 110, 30));

        comboPurchaseDate.setBackground(backgroundPanel.getBackground());
        comboPurchaseDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        backgroundPanel.add(comboPurchaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 210, 30));

        lbWarrenty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbWarrenty.setForeground(new java.awt.Color(255, 255, 255));
        lbWarrenty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbWarrenty.setText("Warrenty");
        backgroundPanel.add(lbWarrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        txtMenufactures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMenufacturesActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtMenufactures, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 210, 30));

        lbPuchaseDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbPuchaseDate.setForeground(new java.awt.Color(255, 255, 255));
        lbPuchaseDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPuchaseDate.setText("Puchase Date");
        backgroundPanel.add(lbPuchaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        lbMenufactures.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMenufactures.setForeground(new java.awt.Color(255, 255, 255));
        lbMenufactures.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMenufactures.setText("Menufactures");
        backgroundPanel.add(lbMenufactures, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 110, 30));

        txtEquipmentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEquipmentNameActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtEquipmentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 210, 30));

        txtWarrenty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWarrentyActionPerformed(evt);
            }
        });
        backgroundPanel.add(txtWarrenty, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, 30));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Insert_24px.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, 40));

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
        backgroundPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 140, 40));

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
        backgroundPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 140, 40));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Reset_24px.png"))); // NOI18N
        btnClear.setText("RESET");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        backgroundPanel.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 140, 40));

        tablePanel.setBackground(backgroundPanel.getBackground());
        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Equipments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        tablePanel.setOpaque(false);
        tablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        equipmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        equipmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        equipmentTable.setFocusable(false);
        equipmentTable.setSelectionBackground(java.awt.Color.red);
        equipmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        equipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipmentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(equipmentTable);

        tablePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 690, 230));

        backgroundPanel.add(tablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 710, 260));

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void txtMenufacturesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMenufacturesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenufacturesActionPerformed

    private void txtEquipmentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEquipmentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEquipmentNameActionPerformed

    private void txtWarrentyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWarrentyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWarrentyActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if((txtEquipmentName.getText().trim().isEmpty()) || (txtMenufactures.getText().trim().isEmpty()) || 
                (txtQuantity.getText().trim().isEmpty()) ||(txtWarrenty.getText().trim().isEmpty()) || 
                (comboEquipmentType.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else {
            EquipmentModel equipmentModel = new EquipmentModel();
            equipmentModel.setEquipmentName(txtEquipmentName.getText().trim());
            EquipmentTypeDAO equipmentTypeDAO = new EquipmentTypeDAOImpl();
            EquipmentTypeModel equipmentTypeModel = equipmentTypeDAO.getEquipmentTypeIdWithName(comboEquipmentType.getSelectedItem().toString());
            equipmentModel.setEquipmentTypeModel(equipmentTypeModel);
            equipmentModel.setManufactures(txtMenufactures.getText().trim());
            equipmentModel.setQuality(txtQuantity.getText().trim());
            equipmentModel.setWarrenty(txtWarrenty.getText().trim());
            Date puchaseDate = comboPurchaseDate.getDate();
            equipmentModel.setPurchaseDate(new Timestamp(puchaseDate.getTime()));
            equipmentModel.setCreatedBy(1);
            EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
            int row = equipmentDAO.addEquipment(equipmentModel);
            if(row > 0) {
                populateMyTable();
                clearAllFields();
            }else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Added");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if((txtEquipmentName.getText().trim().isEmpty()) || (txtMenufactures.getText().trim().isEmpty()) || 
                (txtQuantity.getText().trim().isEmpty()) ||(txtWarrenty.getText().trim().isEmpty()) || 
                (comboEquipmentType.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }
        else {
            EquipmentModel equipmentModel = new EquipmentModel();
            equipmentModel.setEquipmentName(txtEquipmentName.getText().trim());
            EquipmentTypeDAO equipmentTypeDAO = new EquipmentTypeDAOImpl();
            EquipmentTypeModel equipmentTypeModel = equipmentTypeDAO.getEquipmentTypeIdWithName(comboEquipmentType.getSelectedItem().toString());
            equipmentModel.setEquipmentTypeModel(equipmentTypeModel);
            equipmentModel.setManufactures(txtMenufactures.getText().trim());
            equipmentModel.setQuality(txtQuantity.getText().trim());
            equipmentModel.setWarrenty(txtWarrenty.getText().trim());
            Date puchaseDate = comboPurchaseDate.getDate();
            equipmentModel.setPurchaseDate(new Timestamp(puchaseDate.getTime()));
            equipmentModel.setCreatedBy(1);
            equipmentModel.setEquipmentId(equipmentId);
            EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
            int row = equipmentDAO.updateEquipment(equipmentModel);
            if(row > 0) {
                populateMyTable();
                clearAllFields();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            }else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Updated");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete", "Delete", JOptionPane.YES_NO_OPTION);
        if(confirm == 0) {
            EquipmentModel equipmentModel = new EquipmentModel();
            equipmentModel.setEquipmentId(equipmentId);
            EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
            int row = equipmentDAO.deleteEquipment(equipmentModel);
            if(row > 0) {
                populateMyTable();
                clearAllFields();
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
                btnUpdate.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Deleted");
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearAllFields();
        btnAdd.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }//GEN-LAST:event_btnClearActionPerformed

    private void equipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTableMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        equipmentId = (Integer) equipmentTable.getValueAt(equipmentTable.getSelectedRow(), 0);
        EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
        EquipmentModel equipmentModel = equipmentDAO.getEquipmentWithId(equipmentId);
        txtEquipmentName.setText(equipmentModel.getEquipmentName().trim());
        txtMenufactures.setText(equipmentModel.getManufactures().trim());
        txtQuantity.setText(equipmentModel.getQuality().trim());
        txtWarrenty.setText(equipmentModel.getWarrenty().trim());
        comboEquipmentType.setSelectedItem(equipmentModel.getEquipmentTypeModel().getEquipmentType());
        comboPurchaseDate.setDate(equipmentModel.getPurchaseDate());
    }//GEN-LAST:event_equipmentTableMouseClicked

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
//            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EquipmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EquipmentFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboEquipmentType;
    private com.toedter.calendar.JDateChooser comboPurchaseDate;
    private javax.swing.JSeparator equipmentBar;
    private javax.swing.JLabel equipmentLabel;
    private javax.swing.JTable equipmentTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbEquipmentName;
    private javax.swing.JLabel lbEquipmentType;
    private javax.swing.JLabel lbMenufactures;
    private javax.swing.JLabel lbPuchaseDate;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbWarrenty;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField txtEquipmentName;
    private javax.swing.JTextField txtMenufactures;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtWarrenty;
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
        EquipmentDAO equipmentDAO = new EquipmentDAOImpl();
        ResultSet rs= equipmentDAO.getAllEquipmentResultSet();
        DefaultTableModel dtm=null;
        try {
            dtm = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        equipmentTable.setModel(dtm);
    }
    private void populateEquipmentTypeCombo() {
        EquipmentTypeDAO equipmentTypeDAO = new EquipmentTypeDAOImpl();
        List<EquipmentTypeModel> equipmentTypeModels = equipmentTypeDAO.getAllEquipmentTypes();
        for (EquipmentTypeModel equipmentTypeModel : equipmentTypeModels) {
            comboEquipmentType.addItem(equipmentTypeModel.getEquipmentType());
        }
    }

    private void clearAllFields() {
        txtEquipmentName.setText(null);
        txtMenufactures.setText(null);
        txtQuantity.setText(null);
        txtWarrenty.setText(null);
        comboEquipmentType.setSelectedIndex(0);
        comboPurchaseDate.setDate(null);
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
    }

    private void checkPermissions() {
        UserPermissionDAO permissionDAO = new UserPermissionDAOImpl();
        List<UserPermissionModel> permissionModels = permissionDAO.getAssignedPermissions(LoginFrame.userType);
        for (UserPermissionModel permissionModel : permissionModels) {
            if(permissionModel.getPermissionModel().getName().equals("ADD_EQUIPMENT")) {
                btnAdd.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("UPDATE_EQUIPMENT")) {
                btnUpdate.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("DELETE_EQUIPMENT")) {
                btnDelete.setVisible(true);
            }
        }
    }
}
