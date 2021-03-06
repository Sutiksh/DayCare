/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.view.ui.classroom;

import edu.neu.csye6200.controller.ClassroomController;
import edu.neu.csye6200.controller.GroupController;
import edu.neu.csye6200.model.Classroom;
import edu.neu.csye6200.model.Group;
import edu.neu.csye6200.view.ui.groups.GroupJPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 *
 * @author nagashreeseshadri
 */
public class GoToGroupsJPanel extends JPanel {
    private int classroomId;

    /**
     * Creates new form GoToGroupsJPanel
     */
    private JPanel userProcessContainer;
    
    public GoToGroupsJPanel(JPanel userProcessContainer, int classroomId) {
        this.classroomId = classroomId;
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        lblStudentInfoHeading1 = new javax.swing.JLabel();
        lblClassroomID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGroupInfo = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        lblStudentInfoHeading1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblStudentInfoHeading1.setText("Hello, you are in Classroom: " + classroomId);

        lblClassroomID.setText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Classroom ID", "Group ID", "Teacher ID"
            }
        ));

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        GroupController controller = new GroupController();
        List<Group> groupList;
        if(classroomId < 0){
            groupList = controller.getAllGroupsInClassroom(0);
        }
        else{
            groupList = controller.getAllGroupsInClassroom(classroomId);
        }

        for(Group group: groupList){
            String groupId = String.valueOf(group.getGroupId());
            String teacherID = String.valueOf(group.getTeacherId());
            Object[] row = {classroomId, groupId, teacherID};
            model.addRow(row);
        }

        jScrollPane2.setViewportView(jTable1);

        btnGroupInfo.setText("View Group Info");
        btnGroupInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroupInfoActionPerformed(evt);
            }
        });

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGroupInfo)
                .addGap(225, 225, 225))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(101, 101, 101)
                        .addComponent(lblStudentInfoHeading1)
                        .addGap(18, 18, 18)
                        .addComponent(lblClassroomID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStudentInfoHeading1)
                    .addComponent(lblClassroomID)
                    .addComponent(btnBack))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnGroupInfo)
                .addContainerGap(89, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGroupInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupInfoActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();
        if(selectedRowIndex < 0){
            selectedRowIndex = 0;
        }
        int groupId = Integer.parseInt(jTable1.getModel()
                .getValueAt(selectedRowIndex, 1).toString());

        GroupJPanel groupJPanel = new GroupJPanel(userProcessContainer, classroomId, groupId);
        userProcessContainer.add("Student Panel Opening", groupJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnGroupInfoActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGroupInfo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblClassroomID;
    private javax.swing.JLabel lblStudentInfoHeading1;
    // End of variables declaration//GEN-END:variables
}
