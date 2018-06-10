package allguis;

import guiConsoleController.MainWindowController;
import tegakari.Lobby;

/**
 * Window that the application starts at
 * @author anhnguyen
 * @version 11/30/15 add logo image
 */
public class MainWindow extends javax.swing.JFrame
{
    HelpDialog help;
    /**
     * The lobby model for LobbyGUI when called
     */

    /**
     * Creates new form MainWindow
     * @param ctrl The controller that contains logic for buttons pressed
     */
    public MainWindow(MainWindowController ctrl)
    {
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        
        playButton.addActionListener(ctrl);
        playButton.setActionCommand("JOIN LOBBY");
        playButton.addKeyListener(ctrl);
        
        help = new HelpDialog(this, true);
        help.setLocationRelativeTo(this);
        help.setVisible(false);
        
        helpButton.addActionListener(ctrl);
        helpButton.setActionCommand("HELP");
        helpButton.addKeyListener(ctrl);
        
        unableToJoin.setVisible(false);
        
        this.setFocusable(true);
        this.addKeyListener(ctrl);
    }
    
    /**
     * Gives message when unable to join game.
     */
    public void failToJoin()
    {
        unableToJoin.setVisible(true);
    }

    /**
     * Sets help visible.
     */
    public void openHelp()
    {
        help.setVisible(true);
    }
    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        tegakariImage = new javax.swing.JLabel();
        subtextText = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        unableToJoin = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setName("panel1"); // NOI18N

        tegakariImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        subtextText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtextText.setText("\"Clue\" in Japanese");
        subtextText.setName("descText"); // NOI18N

        playButton.setText("(J)OIN LOBBY");
        playButton.setName("playButton"); // NOI18N
        playButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                playButtonActionPerformed(evt);
            }
        });

        helpButton.setText("(H)ELP");
        helpButton.setName("helpButton"); // NOI18N
        helpButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                helpButtonActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tekagari.png"))); // NOI18N
        jLabel2.setName("titleIMG"); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(555, 170));

        unableToJoin.setForeground(new java.awt.Color(255, 51, 51));
        unableToJoin.setText("Unable to connect to server.");

        quitButton.setName("quitButton"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(tegakariImage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, subtextText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(unableToJoin)
                .add(386, 386, 386))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 432, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(helpButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(playButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(408, 408, 408))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(quitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(196, 196, 196))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(quitButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(27, 27, 27)
                .add(tegakariImage)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(subtextText)
                .add(18, 18, 18)
                .add(unableToJoin)
                .add(14, 14, 14)
                .add(playButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(26, 26, 26)
                .add(helpButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action for play button. Asks user for name and join lobby.
     * @param evt button pressed
     */
    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        
    }//GEN-LAST:event_playButtonActionPerformed

    /**
     * Action for help button. Displays help window
     * @param evt button pressed
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        //HelpDialog help = new HelpDialog(this, true);
        //help.setLocationRelativeTo(this);
        //help.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_helpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton playButton;
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel subtextText;
    private javax.swing.JLabel tegakariImage;
    private javax.swing.JLabel unableToJoin;
    // End of variables declaration//GEN-END:variables
}
