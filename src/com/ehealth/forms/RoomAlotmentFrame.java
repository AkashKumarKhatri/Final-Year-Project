/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehealth.forms;

import com.ehealth.dao.AppointmentDAO;
import com.ehealth.dao.Impl.AppointmentDAOImpl;
import com.ehealth.dao.Impl.PatientDAOImpl;
import com.ehealth.dao.Impl.RoomAlotmentDAOImpl;
import com.ehealth.dao.Impl.RoomDAOImpl;
import com.ehealth.dao.Impl.UserPermissionDAOImpl;
import com.ehealth.dao.PatientDAO;
import com.ehealth.dao.RoomAlotmentDAO;
import com.ehealth.dao.RoomDAO;
import com.ehealth.dao.UserPermissionDAO;
import com.ehealth.models.AppointmentModel;
import com.ehealth.models.PatientModel;
import com.ehealth.models.RoomAlotmentModel;
import com.ehealth.models.RoomModel;
import com.ehealth.models.UserPermissionModel;
import java.awt.Dimension;
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
public class RoomAlotmentFrame extends javax.swing.JFrame {

    private Integer appointmentId;
    private Integer patientId;
    DefaultTableModel dtmAppointment = null;
    DefaultTableModel dtmAlotment = null;
    private Integer roomAlotmentId;

    /** Creates new form RoomAlotmentFrame */
    public RoomAlotmentFrame() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        setSize(width, height);
        setTitle("Room Alotment Window");
        setIcon();
        populateRoomCombo();
        populateAppointmentTable();
        populatePatientTable();
        populateAlotmentTable();
        btnAdd.setVisible(false);
        btnDelete.setVisible(false);
        btnUpdate.setVisible(false);
        checkPermissions();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        PatientTablePanel = new javax.swing.JPanel();
        patientScroll = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        appointmentTablePanel = new javax.swing.JPanel();
        appointmentScroll = new javax.swing.JScrollPane();
        appointmentTable = new javax.swing.JTable();
        RoomAlotmentPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboFees = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboDischargeDate = new com.toedter.calendar.JDateChooser();
        comboAoltmentDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        comboRoomNo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        txtRoomStatus = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        alotmentTablePanel = new javax.swing.JPanel();
        testScroll = new javax.swing.JScrollPane();
        roomAlotmentTable = new javax.swing.JTable();
        lbBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Room Alotment");

        backgroundPanel.setBackground(new java.awt.Color(29, 29, 29));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PatientTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        PatientTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Patient Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        PatientTablePanel.setOpaque(false);
        PatientTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        patientScroll.setViewportView(patientTable);

        PatientTablePanel.add(patientScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 630, 260));

        backgroundPanel.add(PatientTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 397, 650, 290));

        appointmentTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        appointmentTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Appointment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        appointmentTablePanel.setOpaque(false);
        appointmentTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        appointmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appointmentTable.setFocusable(false);
        appointmentTable.setName(""); // NOI18N
        appointmentTable.setSelectionBackground(java.awt.Color.red);
        appointmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        appointmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointmentTableMouseClicked(evt);
            }
        });
        appointmentScroll.setViewportView(appointmentTable);

        appointmentTablePanel.add(appointmentScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 630, 260));

        backgroundPanel.add(appointmentTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 397, 650, 290));

        RoomAlotmentPanel.setBackground(new java.awt.Color(255, 255, 255));
        RoomAlotmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Room Alotment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        RoomAlotmentPanel.setOpaque(false);
        RoomAlotmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient Name");
        RoomAlotmentPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, 30));

        comboFees.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "PAID", "UNPAID" }));
        RoomAlotmentPanel.add(comboFees, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 170, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Room No");
        RoomAlotmentPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alotment Date");
        RoomAlotmentPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        comboDischargeDate.setBackground(backgroundPanel.getBackground());
        RoomAlotmentPanel.add(comboDischargeDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 170, 30));

        comboAoltmentDate.setBackground(backgroundPanel.getBackground());
        RoomAlotmentPanel.add(comboAoltmentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Discharge Date");
        RoomAlotmentPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));

        comboRoomNo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        RoomAlotmentPanel.add(comboRoomNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 170, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fees");
        RoomAlotmentPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 90, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status");
        RoomAlotmentPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, 30));

        txtPatientName.setEditable(false);
        RoomAlotmentPanel.add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 170, 30));
        RoomAlotmentPanel.add(txtRoomStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 170, 30));

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        RoomAlotmentPanel.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 160, 50));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/save.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        RoomAlotmentPanel.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 160, 50));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        RoomAlotmentPanel.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 160, 50));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        RoomAlotmentPanel.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 160, 50));

        backgroundPanel.add(RoomAlotmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 520, 310));

        alotmentTablePanel.setBackground(new java.awt.Color(255, 255, 255));
        alotmentTablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Room Alotment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        alotmentTablePanel.setForeground(new java.awt.Color(255, 255, 255));
        alotmentTablePanel.setOpaque(false);
        alotmentTablePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomAlotmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        roomAlotmentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        roomAlotmentTable.setFocusable(false);
        roomAlotmentTable.setSelectionBackground(java.awt.Color.red);
        roomAlotmentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomAlotmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomAlotmentTableMouseClicked(evt);
            }
        });
        testScroll.setViewportView(roomAlotmentTable);

        alotmentTablePanel.add(testScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 760, 280));

        backgroundPanel.add(alotmentTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 780, 310));

        lbBack.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbBack.setForeground(new java.awt.Color(255, 255, 255));
        lbBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Back_48px.png"))); // NOI18N
        lbBack.setText("   Back");
        lbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbBackMouseExited(evt);
            }
        });
        backgroundPanel.add(lbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Two_Beds_48px.png"))); // NOI18N
        jLabel1.setText("Room Alotment");
        backgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 360, 50));

        lbLogout.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbLogout.setForeground(new java.awt.Color(255, 255, 255));
        lbLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Export_48px_4.png"))); // NOI18N
        lbLogout.setText("Logout");
        lbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogout.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lbLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbLogoutMouseExited(evt);
            }
        });
        backgroundPanel.add(lbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 150, 60));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Copyright © 2018 Geeks. All rights reserved");
        backgroundPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 688, 240, -1));

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void patientTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientTableMouseClicked
        patientId = (Integer) patientTable.getValueAt(patientTable.getSelectedRow(),0);
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        ResultSet appointmentModels = appointmentDAO.getAllAppointmentWithPatientId(patientId);
        try {
            dtmAppointment = buildTableModel(appointmentModels);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        appointmentTable.setModel(dtmAppointment);
    }//GEN-LAST:event_patientTableMouseClicked

    private void appointmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentTableMouseClicked
        txtRoomStatus.setText(null);
        comboRoomNo.setSelectedIndex(0);
        comboAoltmentDate.setDate(null);
        comboDischargeDate.setDate(null);
        comboFees.setSelectedIndex(0);
        appointmentId = (Integer) appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 0);
        String patientName = (String) appointmentTable.getValueAt(appointmentTable.getSelectedRow(), 1);
        RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
        ResultSet roomAlotments = roomAlotmentDAO.getRoomAlotmentWithAppointmentId(appointmentId);
        try {
            dtmAlotment = buildTableModel(roomAlotments);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        txtPatientName.setText(patientName);
        roomAlotmentTable.setModel(dtmAlotment);
    }//GEN-LAST:event_appointmentTableMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearFields();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if((txtPatientName.getText().trim().isEmpty()) || (comboRoomNo.getSelectedIndex()==0) || (comboDischargeDate.getDate()==null)
            || (comboDischargeDate.getDate()==null) || (comboFees.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }else {
            RoomAlotmentModel roomAlotmentModel = new RoomAlotmentModel();
            RoomDAO roomDAO = new RoomDAOImpl();
            RoomModel roomModel = roomDAO.getRoomIdWithRoomNo(comboRoomNo.getSelectedItem().toString());
            roomAlotmentModel.setRoomModel(roomModel);
            PatientDAO patientDAO = new PatientDAOImpl();
            PatientModel patientModel = patientDAO.getPatientIdWithName(txtPatientName.getText().trim());
            AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
            AppointmentModel appointmentModel = appointmentDAO.getAppointmentIdWithPatientId(patientModel.getPatientId());
            roomAlotmentModel.setAppointmentModel(appointmentModel);
            Date date = comboAoltmentDate.getDate();
            roomAlotmentModel.setAlotmentDate(new Timestamp(date.getTime()));
            date = comboDischargeDate.getDate();
            roomAlotmentModel.setDischargeDate(new Timestamp(date.getTime()));
            roomAlotmentModel.setStatus(txtRoomStatus.getText().trim());
            roomAlotmentModel.setFees(comboFees.getSelectedItem().toString());
            roomAlotmentModel.setCreatedBy(1);
            RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
            int row = roomAlotmentDAO.addRoomAlotment(roomAlotmentModel);
            if(row > 0) {
                populateAlotmentTable();
                txtPatientName.setText(null);
                txtRoomStatus.setText(null);
                comboRoomNo.setSelectedIndex(0);
                comboAoltmentDate.setDate(null);
                comboDischargeDate.setDate(null);
                comboFees.setSelectedIndex(0);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Added");
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if((txtPatientName.getText().trim().isEmpty()) || (comboRoomNo.getSelectedIndex()==0) || (comboDischargeDate.getDate()==null)
            || (comboDischargeDate.getDate()==null) || (comboFees.getSelectedIndex()==0)) {
            JOptionPane.showMessageDialog(rootPane, "Please Fill Fields");
        }else {
            RoomAlotmentModel roomAlotmentModel = new RoomAlotmentModel();
            RoomDAO roomDAO = new RoomDAOImpl();
            RoomModel roomModel = roomDAO.getRoomIdWithRoomNo(comboRoomNo.getSelectedItem().toString());
            roomAlotmentModel.setRoomModel(roomModel);
            PatientDAO patientDAO = new PatientDAOImpl();
            PatientModel patientModel = patientDAO.getPatientIdWithName(txtPatientName.getText().trim());
            AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
            AppointmentModel appointmentModel = appointmentDAO.getAppointmentIdWithPatientId(patientModel.getPatientId());
            roomAlotmentModel.setAppointmentModel(appointmentModel);
            Date date = comboAoltmentDate.getDate();
            roomAlotmentModel.setAlotmentDate(new Timestamp(date.getTime()));
            date = comboDischargeDate.getDate();
            roomAlotmentModel.setDischargeDate(new Timestamp(date.getTime()));
            roomAlotmentModel.setStatus(txtRoomStatus.getText().trim());
            roomAlotmentModel.setFees(comboFees.getSelectedItem().toString());
            roomAlotmentModel.setModifiedBy(1);
            roomAlotmentModel.setRoomAlotmentId(roomAlotmentId);
            RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
            int row = roomAlotmentDAO.updateRoomAlotment(roomAlotmentModel);
            if(row > 0) {
                populateAlotmentTable();
                txtPatientName.setText(null);
                txtRoomStatus.setText(null);
                comboRoomNo.setSelectedIndex(0);
                comboAoltmentDate.setDate(null);
                comboDischargeDate.setDate(null);
                comboFees.setSelectedIndex(0);
                btnUpdate.setEnabled(false);
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Updated");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        RoomAlotmentModel roomAlotmentModel = new RoomAlotmentModel();
        roomAlotmentModel.setRoomAlotmentId(roomAlotmentId);
        RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
        int row = roomAlotmentDAO.deleteRoomAlotment(roomAlotmentModel);
        if(row > 0) {
                populateAlotmentTable();
                txtPatientName.setText(null);
                txtRoomStatus.setText(null);
                comboRoomNo.setSelectedIndex(0);
                comboAoltmentDate.setDate(null);
                comboDischargeDate.setDate(null);
                comboFees.setSelectedIndex(0);
                btnUpdate.setEnabled(false);
                btnAdd.setEnabled(true);
                btnDelete.setEnabled(false);
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Record Not Deleted");
            }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void roomAlotmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roomAlotmentTableMouseClicked
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        roomAlotmentId = (Integer) roomAlotmentTable.getValueAt(roomAlotmentTable.getSelectedRow(), 0);
        System.out.println(roomAlotmentId);
        RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
        RoomAlotmentModel roomAlotmentModel = roomAlotmentDAO.getRoomAlotmentWithId(roomAlotmentId);
        txtPatientName.setText(roomAlotmentModel.getAppointmentModel().getPatientModel().getName());
        txtRoomStatus.setText(roomAlotmentModel.getStatus());
        comboRoomNo.setSelectedItem(roomAlotmentModel.getRoomModel().getRoomNo());
        comboAoltmentDate.setDate(roomAlotmentModel.getAlotmentDate());
        comboDischargeDate.setDate(roomAlotmentModel.getDischargeDate());
        comboFees.setSelectedItem(roomAlotmentModel.getFees());
    }//GEN-LAST:event_roomAlotmentTableMouseClicked

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbBackMouseClicked

    private void lbBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseEntered
        lbBack.setLocation(lbBack.getX()-1,lbBack.getY());
    }//GEN-LAST:event_lbBackMouseEntered

    private void lbBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseExited
        lbBack.setLocation(lbBack.getX()+1,lbBack.getY());
    }//GEN-LAST:event_lbBackMouseExited

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void lbLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseEntered
        lbLogout.setLocation(lbLogout.getX()+1,lbLogout.getY());
    }//GEN-LAST:event_lbLogoutMouseEntered

    private void lbLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseExited
        lbLogout.setLocation(lbLogout.getX()-1,lbLogout.getY());
    }//GEN-LAST:event_lbLogoutMouseExited

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
//            java.util.logging.Logger.getLogger(RoomAlotmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RoomAlotmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RoomAlotmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RoomAlotmentFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RoomAlotmentFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatientTablePanel;
    private javax.swing.JPanel RoomAlotmentPanel;
    private javax.swing.JPanel alotmentTablePanel;
    private javax.swing.JScrollPane appointmentScroll;
    private javax.swing.JTable appointmentTable;
    private javax.swing.JPanel appointmentTablePanel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private com.toedter.calendar.JDateChooser comboAoltmentDate;
    private com.toedter.calendar.JDateChooser comboDischargeDate;
    private javax.swing.JComboBox<String> comboFees;
    private javax.swing.JComboBox<String> comboRoomNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JScrollPane patientScroll;
    private javax.swing.JTable patientTable;
    private javax.swing.JTable roomAlotmentTable;
    private javax.swing.JScrollPane testScroll;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtRoomStatus;
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
    
    private void populateAppointmentTable() {  
        AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
        ResultSet rs= appointmentDAO.getAllAppointmentsResultSet();
        try {
            dtmAppointment = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        appointmentTable.setModel(dtmAppointment);
    }
    private void populatePatientTable() {  
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
    private void populateAlotmentTable() {  
        RoomAlotmentDAO roomAlotmentDAO = new RoomAlotmentDAOImpl();
        ResultSet rs= roomAlotmentDAO.getAllRoomAlotmentResultSet();
        try {
            dtmAlotment = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        roomAlotmentTable.setModel(dtmAlotment);
    }
    
    private void populateRoomCombo() {
        RoomDAO roomDAO = new RoomDAOImpl();
        List<RoomModel> allRoom = roomDAO.getAllRooms();
        for (RoomModel roomModel : allRoom) {
            comboRoomNo.addItem(roomModel.getRoomNo());
        }
    }
    
    private void clearFields() {
        populateAlotmentTable();
        populateAppointmentTable();
        txtPatientName.setText(null);
        txtRoomStatus.setText(null);
        comboRoomNo.setSelectedIndex(0);
        comboAoltmentDate.setDate(null);
        comboDischargeDate.setDate(null);
        comboFees.setSelectedIndex(0);
        btnUpdate.setEnabled(false);
        btnAdd.setEnabled(true);
        btnDelete.setEnabled(false);
    }
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
    }

    private void checkPermissions() {
        UserPermissionDAO permissionDAO = new UserPermissionDAOImpl();
        List<UserPermissionModel> permissionModels = permissionDAO.getAssignedPermissions(LoginFrame.userType);
        for (UserPermissionModel permissionModel : permissionModels) {
            if(permissionModel.getPermissionModel().getName().equals("ADD_ROOM_ALOTMENT")) {
                btnAdd.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("UPDATE_ROOM_ALOTMENT")) {
                btnUpdate.setVisible(true);
            }
            if(permissionModel.getPermissionModel().getName().equals("DELETE_ROOM_ALOTMENT")) {
                btnDelete.setVisible(true);
            }
        }
    }
}
