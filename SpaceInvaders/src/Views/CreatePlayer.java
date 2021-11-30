/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

import Controllers.PlayerController;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author fuzzyrock
 */
public class CreatePlayer extends javax.swing.JDialog {

    /**
     * Creates new form LeaderboardWindow
     */
    WindowView window;
    public CreatePlayer(java.awt.Frame parent, boolean modal, WindowView w, String prevName) {
        super(parent, modal);
        initComponents();
        
        //Sets Window properties.
        setEarlyWindowProperties();
        
        //Initialize controllers.
        this.window = w;
        
        //Set txtPlayerName to the previous name.
        this.txtPlayerName.setText(prevName);
    }
    
    /**
     * Set early window properties like background color and Window title.
     */
    public void setEarlyWindowProperties(){
        getContentPane().setBackground(Color.BLACK);
        this.setTitle("Create Player");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWindowTitle = new javax.swing.JLabel();
        buttonCreatePlayer = new javax.swing.JButton();
        lblPlayerName = new javax.swing.JLabel();
        txtPlayerName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblWindowTitle.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        lblWindowTitle.setForeground(new java.awt.Color(255, 204, 51));
        lblWindowTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWindowTitle.setText("CREATE PLAYER");

        buttonCreatePlayer.setBackground(new java.awt.Color(0, 0, 0));
        buttonCreatePlayer.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        buttonCreatePlayer.setForeground(new java.awt.Color(255, 255, 255));
        buttonCreatePlayer.setText("PLAY");
        buttonCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreatePlayerActionPerformed(evt);
            }
        });

        lblPlayerName.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(255, 255, 255));
        lblPlayerName.setText("PLAYER NAME");

        txtPlayerName.setBackground(new java.awt.Color(0, 0, 0));
        txtPlayerName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPlayerName.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(lblWindowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(buttonCreatePlayer))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblPlayerName)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblWindowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCreatePlayer)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreatePlayerActionPerformed
        String name = this.txtPlayerName.getText();
        if(!name.equals("")){
            this.window.setPlayerCon(new PlayerController(name));
        } else {
            this.window.setPlayerCon(new PlayerController("player000"));
        }
        this.dispose();
    }//GEN-LAST:event_buttonCreatePlayerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreatePlayer;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblWindowTitle;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables
}
