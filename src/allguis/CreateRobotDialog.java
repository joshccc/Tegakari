/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package allguis;
import guiConsoleController.CreateRobotController;
import guiConsoleController.I_CreateRobot;
import java.awt.Color;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import tegakari.*;

/**
 *
 * @author Tarrant
 */
public class CreateRobotDialog extends javax.swing.JDialog 
implements I_CreateRobot
{
    /**
     * The Game Engine to call addRobot which will 
     * send an AILevel to the server
     */
    private Lobby lobby;
    
    /**
     * The AILevel to send to the server
     */
    private AILevel level;
    
    private ButtonGroup group;
    
    private ButtonModel one;
    private ButtonModel two;
    
    /**
     * Creates new form CreateRobotDialog
     * 
     * @param parent the parent Frame
     * @param modal modal setting for JDialog
     * @param lobby the lobby for all the players prior to game start
     * @param ctrl controller, eventHandler for CreateRobotDialog
     */
    public CreateRobotDialog(java.awt.Frame parent, boolean modal, Lobby lobby,
            CreateRobotController ctrl) 
    {
        super(parent, modal);
        initComponents();
        
        this.lobby = lobby;
        
        setNames();
        setToSmart();
        
        
        group = new ButtonGroup();
        group.add(setToBasic);
        group.add(setToSmart);
        
        setToBasic.addActionListener(ctrl);
        setToBasic.addKeyListener(ctrl);
        setToBasic.setActionCommand("Basic");
        
        setToSmart.addActionListener(ctrl);
        setToSmart.addKeyListener(ctrl);
        setToSmart.setActionCommand("Smart");
        
        addRobot.addActionListener(ctrl);
        addRobot.addKeyListener(ctrl);
        addRobot.setActionCommand("Create");
    }

    private void setNames()
    {
        addRobot.setName("addRobot");
        descriptionLabel.setName("descriptionLabel");
        jLabel1.setName("jLabel1");
        setToBasic.setName("setToBasic");
        setToSmart.setName("setToSmart");
        
        currentSelection.setName("currentSelection");
    }
    
    /** 
     * Creates and adds a robot to the lobby, which then sends it to the server
     */
    public void addRobot()
    {
        // send AILevel to server
        lobby.addRobot(level);
        // close window
        this.dispose();
    }
    
    public void setToSmart()
    {
        // enable the add robot button
        addRobot.setEnabled(true);
        
        currentSelection.setText("Current: SMART");
        
        setToSmart.setSelected(true);
       // setToBasic.setEnabled(true);
       // setToSmart.setEnabled(true);
        // set AILevel to be SMART
        level = AILevel.SMART;
    }
    
    public void setToBasic()
    {
        // enable the add robot button
        addRobot.setEnabled(true);
        
        currentSelection.setText("Current: BASIC");
        setToBasic.setSelected(true);
        //setToBasic.setEnabled(true);
       // setToSmart.setEnabled(true);
        // set AILevel to be BASIC
        level = AILevel.BASIC;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        addRobot = new javax.swing.JButton();
        setToBasic = new javax.swing.JRadioButton();
        setToSmart = new javax.swing.JRadioButton();
        currentSelection = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 36)); // NOI18N
        jLabel1.setText("Create a Robot Player");

        descriptionLabel.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 18)); // NOI18N
        descriptionLabel.setText("Difficulty of the Robot Player");

        addRobot.setText("Add Robot Player (SPACE)");
        addRobot.setEnabled(false);
        addRobot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRobotActionPerformed(evt);
            }
        });

        setToBasic.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        setToBasic.setText("(B)ASIC");

        setToSmart.setFont(new java.awt.Font("Lucida Sans Typewriter", 1, 14)); // NOI18N
        setToSmart.setText("(S)MART");
        setToSmart.setName("smartButton"); // NOI18N

        currentSelection.setText("Current: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(descriptionLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(setToBasic)
                                .addGap(54, 54, 54)
                                .addComponent(setToSmart)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addRobot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(currentSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(descriptionLabel)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(setToBasic)
                    .addComponent(setToSmart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(currentSelection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addRobot)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addRobotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRobotActionPerformed

    }//GEN-LAST:event_addRobotActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRobot;
    private javax.swing.JLabel currentSelection;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton setToBasic;
    private javax.swing.JRadioButton setToSmart;
    // End of variables declaration//GEN-END:variables
}
