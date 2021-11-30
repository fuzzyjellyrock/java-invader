/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.LeaderboardController;
import Controllers.PlayerController;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Este bloque es la interfaz principal del videojuego basado SpaceInvaders
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class WindowView extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        game = new Views.ActionScreenView();
        gameBar1 = new Views.PlayerStatusBarView(game.getTanque());
        buttonStart = new javax.swing.JButton();
        txtPlayerName = new javax.swing.JTextField();
        lblPlayerName = new javax.swing.JLabel();
        buttonShowLeaderboard = new javax.swing.JButton();
        panelPlayerStats = new javax.swing.JPanel();
        lblCurrentLevelTitle = new javax.swing.JLabel();
        lblCurrentLevel = new javax.swing.JLabel();
        lblCurrentScoreTitle = new javax.swing.JLabel();
        lblCurrentScore = new javax.swing.JLabel();
        lblHighScoreTitle = new javax.swing.JLabel();
        lblHighScore = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        game.setBackground(new java.awt.Color(0, 0, 0));
        game.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 7), 2));
        game.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout gameLayout = new javax.swing.GroupLayout(game);
        game.setLayout(gameLayout);
        gameLayout.setHorizontalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        gameBar1.setBackground(new java.awt.Color(0, 0, 0));
        gameBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 7), 2));

        javax.swing.GroupLayout gameBar1Layout = new javax.swing.GroupLayout(gameBar1);
        gameBar1.setLayout(gameBar1Layout);
        gameBar1Layout.setHorizontalGroup(
            gameBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        gameBar1Layout.setVerticalGroup(
            gameBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        buttonStart.setBackground(new java.awt.Color(0, 0, 0));
        buttonStart.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        buttonStart.setForeground(new java.awt.Color(0, 255, 7));
        buttonStart.setText("START");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        txtPlayerName.setBackground(new java.awt.Color(0, 0, 0));
        txtPlayerName.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        txtPlayerName.setForeground(new java.awt.Color(0, 255, 7));

        lblPlayerName.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblPlayerName.setForeground(new java.awt.Color(0, 255, 7));
        lblPlayerName.setText("PLAYER NAME");

        buttonShowLeaderboard.setBackground(new java.awt.Color(0, 0, 0));
        buttonShowLeaderboard.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        buttonShowLeaderboard.setForeground(new java.awt.Color(102, 255, 51));
        buttonShowLeaderboard.setText("LEADERBOARD");
        buttonShowLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowLeaderboardActionPerformed(evt);
            }
        });

        panelPlayerStats.setBackground(new java.awt.Color(0, 0, 0));

        lblCurrentLevelTitle.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentLevelTitle.setForeground(new java.awt.Color(0, 255, 7));
        lblCurrentLevelTitle.setText("LEVEL");

        lblCurrentLevel.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentLevel.setForeground(new java.awt.Color(0, 255, 7));
        lblCurrentLevel.setText("0");

        lblCurrentScoreTitle.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentScoreTitle.setForeground(new java.awt.Color(0, 255, 7));
        lblCurrentScoreTitle.setText("CURRENT SCORE:");

        lblCurrentScore.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentScore.setForeground(new java.awt.Color(0, 255, 7));
        lblCurrentScore.setText("0");

        lblHighScoreTitle.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblHighScoreTitle.setForeground(new java.awt.Color(0, 255, 7));
        lblHighScoreTitle.setText("HIGH SCORE: ");

        lblHighScore.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblHighScore.setForeground(new java.awt.Color(0, 255, 7));
        lblHighScore.setText("0");

        javax.swing.GroupLayout panelPlayerStatsLayout = new javax.swing.GroupLayout(panelPlayerStats);
        panelPlayerStats.setLayout(panelPlayerStatsLayout);
        panelPlayerStatsLayout.setHorizontalGroup(
            panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                        .addComponent(lblCurrentLevelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCurrentLevel))
                    .addComponent(lblCurrentScoreTitle)
                    .addComponent(lblHighScoreTitle)
                    .addComponent(lblHighScore)
                    .addComponent(lblCurrentScore))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPlayerStatsLayout.setVerticalGroup(
            panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurrentLevelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentScoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblCurrentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblHighScoreTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHighScore)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panelPlayerStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPlayerName)
                                            .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(buttonShowLeaderboard)
                                .addContainerGap(27, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPlayerStats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonShowLeaderboard)
                        .addGap(86, 86, 86)
                        .addComponent(lblPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStart))
                    .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//-----------------Constructor---------------------------------------- 
    //hilos
    private Thread aliens;
    private ArrayList<Thread> aliensBullets;
    private Thread shipBullets;
    private Thread moveShip;

    //Leaderboard
    LeaderboardController lbCon;
    
    //usuario
    private PlayerController playerCon;
    
    //Game variables
    boolean moveAliens;
    
    //estado de game over
    private int dead;

    //nivel actaul al que pasa el usuario
    private int round = 0;
    private int increaseLevel = 0;

    public WindowView() {
        initComponents();
        
        //Set JFrame properties.
        setEarlyWindowProperties();
        
        //Controllers init.
        this.lbCon = new LeaderboardController();
        
        
        //Fill window elements with info from controllers.
        fillWindowElements();
        
        //Set game properties.
        dead = 1;
        moveAliens = false;
        
        //Closing event calls.
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                windowClosingEvent();
            }
        });
    }
    
    /**
     * Fills elements from the Window with info from Controllers.
     */
    public void fillWindowElements(){
        showHighScore();
    }
    
    /**
     * Set early window properties like background color and Window title.
     */
    public void setEarlyWindowProperties(){
        getContentPane().setBackground(Color.BLACK);
        this.setTitle("Space Invaders");
    }
    
    //botones
    /**
     * Dispara una "bala/superBala" o mueve el tanque a la derecha/izquierda
     *
     * @param evt Evento del teclado para disparar desde el tanque o mover el
     * mismo
     */
    private void gameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameKeyPressed
        /**
         * VK_SPACE --> 32 • 37 – Para la fecha a la izquierda • 38 – Fecha
         * hacia arriba • 39 – Flecha a la derecha • 40 – Fecha hacia abajo
         *
         */

        if (dead == 0) {
            moveShip = new Thread(game);
            switch (evt.getKeyCode()) {
                //super bala (space)
                case 32:
                    tankShoot(1);
                    break;
                //bala flecha arriba
                case 38:
                    tankShoot(0);
                    break;
                //mover tanque izquierda
                case 37:
                    game.setOperation(0);
                    moveShip.start();
                    break;
                //mover tanque derecha
                case 39:
                    game.setOperation(1);
                    moveShip.start();
                    break;
            }
        }

    }//GEN-LAST:event_gameKeyPressed

    //reinicia el juego o lo activa
    /**
     * boton de inicio y reinicio del juego
     * @param evt evento del boton
     */
    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed

        if (dead == 1) {
            //crea el usuario
            String name = txtPlayerName.getText();
            if (name.equals("")) {
                name = "000";
            }
            playerCon = new PlayerController(name);

            //nivel al que pasa
            increaseLevel = 0;//elije el nivel
            callLvl();      //inicia el nivel

            //datos del usuario 
        
            showHighScore();
            showCurrentScore();
            showCurrentLevel();
        }
        game.setFocusable(true);//dale focus al jPanel
        buttonStart.setFocusable(false);

    }//GEN-LAST:event_buttonStartActionPerformed

    private void buttonShowLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowLeaderboardActionPerformed
        LeaderboardWindow lb = new LeaderboardWindow(this, true, this.lbCon);
        lb.setVisible(true);
        game.setFocusable(true);
        buttonShowLeaderboard.setFocusable(false);
    }//GEN-LAST:event_buttonShowLeaderboardActionPerformed
    /**
     * permite parar el juego y reiniciar los puntos del usuario(gameOver)
     */
    public void endCurrentGame() {
        dead = 1;//game over
        //resetea al usuario y lo hubica en el ranking
        if (game.getTanque().getTank().getY()!=game.getTanque().getTank().getShoot().getY()) {
            shipBullets.interrupt();
        }
        JOptionPane.showMessageDialog(null, "Game Over");
        this.lbCon.addNewScore(playerCon.getPlayer());
        playerCon.resetPoints();
        showHighScore();
        //para hilos
        stopThread();
    }
    /**
     * para los hilos de diparo, para que se activen cuando sea nescesario
     */
    public void stopThread() {
        for (Thread current : aliensBullets) {
            if (current.isAlive()==true) {
                current.interrupt();
            }
        }
    }
    
    /**
     *  Calls other methods necessary for memory persistence.
     */
    public void windowClosingEvent(){
        this.lbCon.saveScores();
    }
    
    /**
     * dependiendo la ronda activa un nivel del juego, y activa al jugador
     */
    public void callLvl() {
        //incremeta los niveles
        increaseLevel++;
          playerCon.addLevels(1);
          
          //si el usurio paso de nivel y mato todas las naves
        if (playerCon.getPlayer().getLvl() != 1 ||  dead == 0) {//apaga las acciones si paso de nivel
            playerCon.addPoints(20);
            JOptionPane.showMessageDialog(null, "¡siguiente nivel!");
            stopThread();
        }else{//activar primer nivel
            game.setRefreshRate(800);
            round=0;
        }
        //mostrar los datos 
          showCurrentLevel();
          showHighScore();
          
        dead = 0;//activa al jugador
           
        //dependiendo en el nivel que este, selecciona el proximo nivel 
        if (increaseLevel == 1) {
            game.lvl1();
        } else if (increaseLevel == 2) {
            game.lvl2();
        } else if (increaseLevel == 3) {
            game.lvl3();
          
        }
        
        round++;//suma la rondas para que el juego sea un bucle cada vez mas dificil
        if (round == 3) {// si la ronda es 3 regresa al nivel 1 pero mas rapido
            game.setRestarRefreshRate(100);
            round = 0;
        }
        game.repaint();

       //recreamos el gameBar
        gameBar1.setTanque(game.getTanque());
        gameBar1.repaint();
        game.setConsumiblesTanque(gameBar1);
        game.setViewGame(this);
        
        //dependiendo el nivel activa unos hilos diferentes
        if (increaseLevel != 3) {
            activateInvaders(1);
        } else {//este hilo es el jefe por tal dispara 3 veces
            activateInvaders(3);
              increaseLevel=0;
        }

     
    }
    /**
     * activa los hilos de movimiento de los invasores y sus disparos.Este metodo ademas tiene de entrada la cantidad de hilos de disparos que sse queiren activar
     * @param invadersShoots cnatidad de disparos de los invasores a la vez
     */
    public void activateInvaders(int invadersShoots) {
       invadersShoot(invadersShoots);
        try {Thread.sleep(200);} catch (Exception e) {}//tiempo de espera
        invadersrMove();

    }

    //juego hilos
    /**
     * Método encargado de generar un disparo desde el tanque
     */
    public void tankShoot(int type) { 
        shipBullets = new Thread(game);
        if (game.getTanque().getTank().getShoot().getY() == game.getTanque().getTank().getY()) {//solo dispara si el disparo ya esta en el tanque
            game.setOperation(2);
            game.setTypeShoot(type);
            shipBullets.start();
        }
    }
    /**
     * dependiendo los hilos que quieras este metodo permite activar los
     * disparos de los invasores
     *
     * @param size cantidad de disparos por ronda de los invasores
     */
    public void invadersShoot(int size) {
        game.setOperation(4);
        aliensBullets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            aliensBullets.add(new Thread(game));
            aliensBullets.get(i).start();
        }

    }
    
    /**
     * Método encargado de mover los invasores en grupo
     */
    public void invadersrMove() {
       
        game.setOperation(3);
        aliens = new Thread(game);
        if (moveAliens == false) {
            aliens.start();
            moveAliens = true;
        }
    }
    
    /**
     * Updates text label with the highest score recorded, obtained from LeaderboardController.
     * @see Controllers.LeaderboardController#getHighScore() 
     */
    public void showHighScore() {
        lblHighScore.setText(this.lbCon.getHighScore());
    }
    /**
     * Updates text label with the player current level, obtained from PlayerController.
     * @see Controllers.PlayerController#getPlayerLevel() 
     */
    public void showCurrentLevel() {
        lblCurrentLevel.setText(this.playerCon.getPlayerLevel());
    }
    /**
     * Updates text label with the player current score, obtained from PlayerController.
     * @see Controllers.PlayerController#getPlayerScore() 
     */
    public void showCurrentScore() {
        lblCurrentScore.setText(this.playerCon.getPlayerScore());
    }
    
//------------------GetSetters----------------------------------------
    public int getRound() {
        return round;
    }
    public PlayerController getUser() {
        return playerCon;
    }
    public void setUser(PlayerController user) {
        this.playerCon = user;
    }
    public int getDead() {
        return dead;
    }
    public int getIncrementLvl() {
        return increaseLevel;
    }
    public void setIncrementLvl(int incrementLvl) {
        this.increaseLevel += incrementLvl;
    }
    

//_________________________________main________________________________-

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WindowView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonShowLeaderboard;
    private javax.swing.JButton buttonStart;
    private Views.ActionScreenView game;
    private Views.PlayerStatusBarView gameBar1;
    private javax.swing.JLabel lblCurrentLevel;
    private javax.swing.JLabel lblCurrentLevelTitle;
    private javax.swing.JLabel lblCurrentScore;
    private javax.swing.JLabel lblCurrentScoreTitle;
    private javax.swing.JLabel lblHighScore;
    private javax.swing.JLabel lblHighScoreTitle;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JPanel panelPlayerStats;
    private javax.swing.JTextField txtPlayerName;
    // End of variables declaration//GEN-END:variables


}
//_____________________________________________________________________-
