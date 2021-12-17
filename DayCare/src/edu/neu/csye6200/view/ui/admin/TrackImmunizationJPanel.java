/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view.ui.admin;

import edu.neu.csye6200.controller.ImmunizationController;
import edu.neu.csye6200.model.Immunization;
import edu.neu.csye6200.model.Student;
import edu.neu.csye6200.utils.ConvertUtil;

import java.awt.CardLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nagashreeseshadri
 */
public class TrackImmunizationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Immunization
     */
    private JPanel userProcessContainer;
    long studentId;

//    public TrackImmunizationJPanel(JPanel userProcessContainer) {
//        initComponents();
//
//        this.userProcessContainer = userProcessContainer;
//    }

    public TrackImmunizationJPanel(JPanel userProcessContainer, long studentId) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.studentId = studentId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStudentInfoHeading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImmunizationInfo = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblStudentID = new javax.swing.JLabel();
        btnPopulateTable = new javax.swing.JButton();
        lblStuID = new javax.swing.JLabel();

        lblStudentInfoHeading.setText("Track Student Immunization Information");

        tblImmunizationInfo.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Vaccine Name", "Dose 1 ID", "Date for Dose 1", "Dose 2 ID", "Dose 2 Date", "Dose 3 ID", "Dose 3 Date", "Dose 4 ID", "Dose 4 Date"
                }
        ));
        jScrollPane1.setViewportView(tblImmunizationInfo);

        btnRefresh.setText("Refresh");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStudentID.setText("Student ID:");

        btnPopulateTable.setText("Populate Table");
        btnPopulateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPopulateTableActionPerformed(evt);
            }
        });

        lblStuID.setText(String.valueOf(studentId));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnBack)
                                                                .addGap(428, 428, 428))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(lblStudentID, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblStuID)
                                                                .addGap(357, 357, 357)))
                                                .addComponent(lblStudentInfoHeading)))
                                .addContainerGap(118, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(btnPopulateTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh)
                                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnBack))
                                        .addComponent(lblStudentInfoHeading))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblStudentID)
                                        .addComponent(lblStuID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnRefresh)
                                        .addComponent(btnPopulateTable))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(330, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPopulateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPopulateTableActionPerformed
        // TODO add your handling code here:
//        lblStuID.setText(selectedStudent.getFirstName());
        populateImmTable();
    }//GEN-LAST:event_btnPopulateTableActionPerformed

    public void populateImmTable(){
        DefaultTableModel model = (DefaultTableModel) tblImmunizationInfo.getModel();
        ImmunizationController controller = new ImmunizationController();
        List<Immunization> immunizations = controller.getImmunizationByIdDao(studentId);
        for(Immunization vaccine: immunizations){
            String vaccineName = vaccine.getImmunizationName();
            String dose1Id = ConvertUtil.longToString(vaccine.getDoseId1());
            String dose1Date = ConvertUtil.dateToString(vaccine.getDoseDate1());
            String dose2Id = ConvertUtil.longToString(vaccine.getDoseId1());
            String dose2Date = ConvertUtil.dateToString(vaccine.getDoseDate1());
            String dose3Id = ConvertUtil.longToString(vaccine.getDoseId1());
            String dose3Date = ConvertUtil.dateToString(vaccine.getDoseDate1());
            String dose4Id = ConvertUtil.longToString(vaccine.getDoseId1());
            String dose4Date = ConvertUtil.dateToString(vaccine.getDoseDate1());
            Object[] row = {vaccineName, dose1Id, dose1Date, dose2Id, dose2Date, dose3Id, dose3Date, dose4Id, dose4Date};
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPopulateTable;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStuID;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentInfoHeading;
    private javax.swing.JTable tblImmunizationInfo;
    // End of variables declaration//GEN-END:variables
}




