package allguis;

/**
 * Help window shown for players unfamiliar with the game
 *
 * @author anhnguyen
 */
public class HelpDialog extends javax.swing.JDialog
{

    /**
     * Creates new form HelpDialog
     *
     * @param parent the parent frame, either MainWindow or GameTable
     * @param modal modal setting for JDialog
     */
    public HelpDialog(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setTitle("Tegakari");
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
        
        setNames();
    }
    
    private void setNames()
    {
        quitButton.setName("quitButton");
        
    }

    /**
     * NetBeans generated code
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel43 = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jPanel46 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jPanel48 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("PLAY\n\nThe player who connected first to the server starts the game. Play passes to the left. On your turn, you:\n1. Take the top Action card from the Draw Pile and add it to your hand.\n2. Play one of your two Action cards (see \"Playing Action Cards\" below).\n3. Conclude your turn by checking off the identity of any Clue cards you were shown during your turn. Feel free to keep notes on your notesheet, such as what you see happening during other players' turns.\n4. Unless you are ready to make an Accusation (see \"Making an Accusation\"), your turn now ends. Place the Action card you just played on the discard pile. The player to your left now takes his turn.\n\nPlaying Action Cards\nThere are five different types of Action cards. To play an Action card (except a Private Tip), simply take the card from your hand and place it face up on the table in front of you.\n\n* MAKE A SUGGESTION from any destination\nDecide which Destination will be part of your Suggestion. If the destination is different than the one you are in, exchange your current Destination Marker for the desired destination. If another player has this Destination Marker, give that player yours in return. If the desired marker is by the tray, exchange it with your marker. once the desired Destination Marker is before you, make your Suggestion(see \"Making a Suggestion\").\n\n* MAKE A SUGGESTION from current destination (or move)\nYou may only make a Suggestion from the destination whose Destination Marker is currently before you OR you can exchange the Destination Marker for another - but if you do so, you end your turn without making a Suggestion (see \"Making a Suggestion\").\n\n* SNOOP\nSelect an opponent to lay his entire hand, face down, on the table. Pick any one card and look at it, taking care that no other player sees its identity. Return the card to the opponent who then picks up his entire hand.\n\n* ALL SNOOP means that each player will place his entire hand face down towards the player indicated on the card. Each player then snoops on the hand offered to him.\n\n* SUPER SLEUTH\nRead aloud the card and show it to your opponents. Each, in turn, must now show you one Clue card with the specified feature. (For example, \"Show me a destination in the south.\")  If a player doesn't have a card of the kind specified, he shows nothing.\n\n* PRIVATE TIP\nPass this card face down to an opponent who picks it up and reads it to himself. He then returns this card, along with one Clue card of the type requested (or all cards held of this type, if so instructed by the Private Tip card). If the opponent has no cards of the type requested, he returns only the Private Tip card. Return Clue card(s) to the opponent after studying them. IMPORTANT: After playing a \"Private Tip\" card place, it under the discard pile, face-down\n\n\nEnding your Turn\nAfter you have played an Action card, place it face up in the discard pile, unless you played a Private Tip. The identity of these cards needs to be kept secret from your opponents, so place them down.\n\nMaking a Suggestion\n\nTo make a Suggestion, name a Suspect, Vehicle and the Destination whose marker is before you.\n\nExample: \"I suggest that Professor Plum is traveling in the Hot Air Balloon, to the Grand Canyon.\"\n\nMaking Suggestions throughout the game will help you to determine - by process of elimination - which three cards comprise the SOLUTION.\n\nProving a Suggestion True or False\nAs soon as you make a Suggestion, your opponents, in turn, try to prove it false. The first to try is the player on your left. That player looks at his cards to see if one of the three cards you just named is there. If so, he must show it to you and no one else. If the player has more than one of the cards named, he selects just one to show you. If that opponent has none of the cards that you named, then the chance to prove your Suggestion false passes, in turn, to the next player on the left.\n\nAs soon as any opponent shows you one of the cards you named, it is proof that this card cannot be part of the solution. End your turn by checking off this card on your notesheet. (Some players also find it helpful to mark the initials of the player who showed the card.) If no one is able to prove your Suggestion false, you may either end your turn or make an Accusation.\n\nSpecial Note about Suggestions\nWhen you make a Suggestion, you may, if you wish, name one or more of the cards that you hold in your hand. This can help to pinpoint information or to mislead your opponents.\n\n\nMaking an Accusation\n\nWhen you think you have figured out which three cards comprise the Solution, you should make an Accusation on your turn. You may do so after you play an Action card, or if you are convinced you know the Solution, you may make an Accusation without playing an Action card. Do so by naming the three elements you believe will be in found in the Solution. Begin by saying, \"I accuse (Suspect) of committing the crime. He/she in traveling to (Destination) in the (Vehicle).\" Then, taking care that no one else sees, look at the three Clue cards of the Solution.\n\nNote: In a Suggestion, the Destination you name must be the same as the Destination Marker before you. In an Accusation, you may name any destination. Also remember that you may make only one Accusation per game.\n\nWinning\n\nIf your Accusation is correct (that is, the three elements you named are in the Solution), show the other players the cards and claim your victory. Great detective work! You win!\n\nIf your Accusation is incorrect...\nSecretly return all three cards of the Solution face-down.\nBe careful not to blurt out any part of the solution.\nYou remain in the game but make no further plays, so you cannot win.\nYou continue to try to prove your opponents' Suggestions false.\nOpponents may still exchange Destination markers with you as usual.");
        jScrollPane2.setViewportView(jTextArea2);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View Rules", jPanel3);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);
        jTextArea3.setText("This product is a computer based adaptation of the detective card game CLUE.\n" +
            "This version will allow players from all over world to compete against each other to be the first to solve the mystery.\n"+
            "The rise of internet gaming and social media interactions have outdated the original version of the game.\n"+
            "People now spend most of their time on their computer and this product will reflect that change in behavior by allowing\n"+
            "users to play the game with each other without being limited by location.\n"+
            "Also, another advantage to a computer based game is that players will no longer have to manually deal cards, as this \n" +
            "process is automated for a faster game play experience.\n"+

            "\nVersion: 2.0\n"+
            "\nAuthor: Honey Badgers\n");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("About", jPanel1);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Aphrodite.jpg"))); // NOI18N
        jPanel38.add(jLabel29);

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Ares.jpg"))); // NOI18N
        jPanel38.add(jLabel30);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Artemis.jpg"))); // NOI18N
        jPanel38.add(jLabel31);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Dionysus.jpg"))); // NOI18N
        jPanel38.add(jLabel32);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Hera.jpg"))); // NOI18N
        jPanel38.add(jLabel33);

        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Suspects-Hermes.jpg"))); // NOI18N
        jPanel38.add(jLabel77);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel38, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel38, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Suspect", jPanel7);

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-ApollosChariot.jpg"))); // NOI18N
        jPanel39.add(jLabel79);

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-AthenaHorse.jpg"))); // NOI18N
        jPanel39.add(jLabel80);

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-ErosWings.jpg"))); // NOI18N
        jPanel39.add(jLabel81);

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-HadesDogs.jpg"))); // NOI18N
        jPanel39.add(jLabel82);

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-HermesWingSandals.jpg"))); // NOI18N
        jPanel39.add(jLabel83);

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Transportation-PoseidonShip.jpg"))); // NOI18N
        jPanel39.add(jLabel84);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel39, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel11Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Vehicle", jPanel11);

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-Athena-Forest.jpg"))); // NOI18N
        jPanel41.add(jLabel86);

        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-Athens.jpg"))); // NOI18N
        jPanel41.add(jLabel87);

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-AtlasSky.jpg"))); // NOI18N
        jPanel41.add(jLabel88);

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-Dionysus-Vineyard.jpg"))); // NOI18N
        jPanel41.add(jLabel89);

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-HadesUnderworld.jpg"))); // NOI18N
        jPanel41.add(jLabel90);

        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-HephaestusVolcano.jpg"))); // NOI18N
        jPanel41.add(jLabel91);

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-MountOlympus.jpg"))); // NOI18N
        jPanel41.add(jLabel92);

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Location-Phobe-Moon.jpg"))); // NOI18N
        jPanel41.add(jLabel110);

        org.jdesktop.layout.GroupLayout jPanel40Layout = new org.jdesktop.layout.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel41, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel40Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(513, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Destination", jPanel40);

        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuggestionAny.jpg"))); // NOI18N
        jPanel44.add(jLabel93);

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuggestionCurrent.jpg"))); // NOI18N
        jPanel44.add(jLabel94);

        org.jdesktop.layout.GroupLayout jPanel43Layout = new org.jdesktop.layout.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel44, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel43Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Suggestion", jPanel43);

        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-AllSnoopLeft.jpg"))); // NOI18N
        jPanel46.add(jLabel95);

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-AllSnoopRight.jpg"))); // NOI18N
        jPanel46.add(jLabel96);

        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-Snoop.jpg"))); // NOI18N
        jPanel46.add(jLabel97);

        org.jdesktop.layout.GroupLayout jPanel45Layout = new org.jdesktop.layout.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel46, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel45Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Snoop", jPanel45);

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthAir.jpg"))); // NOI18N
        jPanel48.add(jLabel98);

        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthBlue.jpg"))); // NOI18N
        jPanel48.add(jLabel99);

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthFemale.jpg"))); // NOI18N
        jPanel48.add(jLabel100);

        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthMale.jpg"))); // NOI18N
        jPanel48.add(jLabel101);

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthSouth.jpg"))); // NOI18N
        jPanel48.add(jLabel102);

        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-SuperSleuthWest.jpg"))); // NOI18N
        jPanel48.add(jLabel103);

        org.jdesktop.layout.GroupLayout jPanel47Layout = new org.jdesktop.layout.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel48, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel47Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Super Sleuth", jPanel47);

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipAllDestination.jpg"))); // NOI18N
        jPanel50.add(jLabel104);

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipAllSuspect.jpg"))); // NOI18N
        jPanel50.add(jLabel105);

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipAllVehicle.jpg"))); // NOI18N
        jPanel50.add(jLabel106);

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipFemale.jpg"))); // NOI18N
        jPanel50.add(jLabel107);

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipNorthern.jpg"))); // NOI18N
        jPanel50.add(jLabel108);

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Action-PrivateTipRed.jpg"))); // NOI18N
        jPanel50.add(jLabel109);

        org.jdesktop.layout.GroupLayout jPanel49Layout = new org.jdesktop.layout.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel50, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel49Layout.createSequentialGroup()
                .add(28, 28, 28)
                .add(jPanel50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Private Tip", jPanel49);

        org.jdesktop.layout.GroupLayout jPanel42Layout = new org.jdesktop.layout.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane8)
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane8)
        );

        jTabbedPane7.addTab("Action", jPanel42);

        jTabbedPane1.addTab("View Cards", jTabbedPane7);

        quitButton.setText("Quit Help");
        quitButton.setName("Quit Help"); // NOI18N
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane1)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(quitButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(quitButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jTabbedPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 725, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action for quit button. Closes window
     *
     * @param evt button pressed
     */
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_quitButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables
}
