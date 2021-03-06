/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ehealth.forms;

import com.ehealth.dao.BillDAO;
import com.ehealth.dao.Impl.BillDAOImpl;
import com.ehealth.models.BillModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akash
 */
public class BillFrame extends javax.swing.JFrame {

    private Integer appointmentId;
    private String patientName;

    /** Creates new form BillFrame */
    public BillFrame() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        setSize(width, height);
        setTitle("Patient Bills");
        setIcon();
        populatePatientBillsTable();
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
        patientBillPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientBillTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbLogout = new javax.swing.JLabel();
        lbBack = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Bill");

        backgroundPanel.setBackground(new java.awt.Color(29, 29, 29));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientBillPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "Patient Bill Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        patientBillPanel.setOpaque(false);
        patientBillPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientBillTable.setModel(new javax.swing.table.DefaultTableModel(
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
        patientBillTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientBillTable.setFocusable(false);
        patientBillTable.setSelectionBackground(java.awt.Color.pink);
        patientBillTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientBillTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientBillTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(patientBillTable);

        patientBillPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1220, 520));

        backgroundPanel.add(patientBillPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1260, 570));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ehealth/images/icons8_Money_48px_1.png"))); // NOI18N
        jLabel1.setText(" Patient Bill");
        backgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 360, 50));

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
        backgroundPanel.add(lbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 20, 150, 60));

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
        backgroundPanel.add(lbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 140, 60));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Copyright © 2018 Geeks. All rights reserved");
        backgroundPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, 240, 30));

        getContentPane().add(backgroundPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseEntered
        lbLogout.setLocation(lbLogout.getX()+1,lbLogout.getY());
    }//GEN-LAST:event_lbLogoutMouseEntered

    private void lbLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseExited
        lbLogout.setLocation(lbLogout.getX()-1,lbLogout.getY());
    }//GEN-LAST:event_lbLogoutMouseExited

    private void lbBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseEntered
        lbBack.setLocation(lbBack.getX()-1,lbBack.getY());
    }//GEN-LAST:event_lbBackMouseEntered

    private void lbBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseExited
        lbBack.setLocation(lbBack.getX()+1,lbBack.getY());
    }//GEN-LAST:event_lbBackMouseExited

    private void lbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackMouseClicked
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbBackMouseClicked

    private void lbLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogoutMouseClicked
        new LoginFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbLogoutMouseClicked

    private void patientBillTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientBillTableMouseClicked
        appointmentId = (Integer) patientBillTable.getValueAt(patientBillTable.getSelectedRow(),0);
        patientName = (String) patientBillTable.getValueAt(patientBillTable.getSelectedRow(), 1);
        Integer grandTotal = (int) (long) patientBillTable.getValueAt(patientBillTable.getSelectedRow(), 7);
        //Integer totalOperationCharges = (int) patientBillTable.getValueAt(patientBillTable.getSelectedRow(), 6);
        BillDAO billDAO = new BillDAOImpl();
        BillModel billModel = billDAO.getPatientRoomCharges(appointmentId);
        System.out.println(appointmentId);
        new BillDetailFrame(appointmentId).setVisible(true);
        System.out.println(billModel.getAlotmentModel().getAppointmentModel().getAppointmentDate());
        Date date = billModel.getAlotmentModel().getAppointmentModel().getAppointmentDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t\t"+patientName+" \n\n\tAppointment Date : \t"+dateFormat.format(date.getTime())+"\t\t\t\t\t\t\t\t\t      Appointment Fees\t  Fees Status");
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    "+billModel.getAlotmentModel().getAppointmentModel().getEmployeeModel().getFees()+"\t\t"+billModel.getAlotmentModel().getAppointmentModel().getFeesStatus());
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\n\tRoom Alotment Charges :\n\t\tRoom #No\tRoom Type \tAlototment Date \tDischarge Date \t   Per Day \tTotal Days\tTotal Charges\t  Fees Status");
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t"+billModel.getAlotmentModel().getRoomModel().getRoomNo()+"\t\t"+billModel.getAlotmentModel().getRoomModel().getRoomTypeModel().getRoomType());
        date = billModel.getAlotmentModel().getAlotmentDate();
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t"+dateFormat.format(date.getTime()));
        date = billModel.getAlotmentModel().getDischargeDate();
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t\t"+dateFormat.format(date.getTime())
        +"\t     "+billModel.getAlotmentModel().getRoomModel().getRoomTypeModel().getRoomCharges()+"\t    "+billModel.getTotaDays()+"\t\t    "+billModel.getGrandTotal()+"\t    "+billModel.getAlotmentModel().getFees());
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\n\n\tPatient Test Charges :\n\t\tTest Name\t\t\tTest Date \t\tResult Date \t   Outcome \tTest Status \tTest Charges \t  Fees Status");
        List<BillModel> billModels = billDAO.getPatientTestCharges(appointmentId);
        for (BillModel billModel1 : billModels) {
            BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t"+billModel1.getTestPatientModel().getTestModel().getName());
            Date date1 =  billModel1.getTestPatientModel().getTestDate();
            BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t\t"+dateFormat.format(date1.getTime()));
            date1 = billModel1.getTestPatientModel().getResultDate();
            BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t\t"+dateFormat.format(date1.getTime())+" \t   "+billModel1.getTestPatientModel().getOutcome()+" \t  "+billModel1.getTestPatientModel().getStatus()+
                    "\t\t    "+billModel1.getTestPatientModel().getTestModel().getCharge()+"      \t    "+billModel1.getTestPatientModel().getFees());
        }
        Integer totatTestCharges = billDAO.getTotalTestCharges(appointmentId);
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t-------------");
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Total = "+totatTestCharges);
        List<BillModel> billModels1 = billDAO.getPatientOperationCharges(appointmentId);
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\tPatient Operation Charges :\n\t\tOperation Type\t\t\tOperation Date \t\tResult \t\t   Status \tOperation Charges \t\t  Fees Status");
        for (BillModel billModel1 : billModels1) {
            BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t"+billModel1.getOperationResultModel().getOperationModel().getOperationType());
            Date date1 = billModel1.getOperationResultModel().getOperationDate();
            BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\t\t\t\t"+dateFormat.format(date1.getTime())+"\t\t"+billModel1.getOperationResultModel().getResult()
            +"\t\t    "+billModel1.getOperationResultModel().getStatus()+"\t\t"+billModel1.getOperationResultModel().getOperationModel().getOperationCharges()+"\t\t\t      "+billModel1.getOperationResultModel().getFees());
        }
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t   ---------------");
        Integer totalOperationCharges = billDAO.getTotalOperationCharges(appointmentId);
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\tTotal = "+totalOperationCharges);
        BillDetailFrame.txtBillDetail.setText(BillDetailFrame.txtBillDetail.getText()+"\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Grand Total = "+grandTotal);
        
        this.dispose();
    }//GEN-LAST:event_patientBillTableMouseClicked

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
//            java.util.logging.Logger.getLogger(BillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(BillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(BillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(BillFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new BillFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBack;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JPanel patientBillPanel;
    private javax.swing.JTable patientBillTable;
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
    
    private void populatePatientBillsTable() {  
        BillDAO billDAO = new BillDAOImpl();
        ResultSet rs = billDAO.getAllPatientsBill();
        DefaultTableModel dtm=null;
        try {
            dtm = buildTableModel(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        patientBillTable.setModel(dtm);
    }
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameIcon.png")));
    }
}
