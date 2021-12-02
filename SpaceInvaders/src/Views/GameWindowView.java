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

/**
 *
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class GameWindowView extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        game = new Views.ActionPanelView();
        gameStatusBar = new Views.ShipStatsPanelView();
        lblShields = new javax.swing.JLabel();
        lblMissiles = new javax.swing.JLabel();
        buttonNewGame = new javax.swing.JButton();
        buttonShowLeaderboard = new javax.swing.JButton();
        panelPlayerStats = new javax.swing.JPanel();
        lblCurrentLevelTitle = new javax.swing.JLabel();
        lblCurrentLevel = new javax.swing.JLabel();
        lblCurrentScoreTitle = new javax.swing.JLabel();
        lblCurrentScore = new javax.swing.JLabel();
        lblHighScore = new javax.swing.JLabel();
        lblHighScoreTitle1 = new javax.swing.JLabel();
        buttonCreatePlayer = new javax.swing.JButton();
        lblWindowTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        game.setBackground(new java.awt.Color(0, 0, 0));
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

        gameStatusBar.setBackground(new java.awt.Color(0, 0, 0));
        gameStatusBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 7)));

        lblShields.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblShields.setForeground(new java.awt.Color(255, 255, 255));
        lblShields.setText("SHIELDS");

        lblMissiles.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblMissiles.setForeground(new java.awt.Color(255, 255, 255));
        lblMissiles.setText("MISSILES");

        javax.swing.GroupLayout gameStatusBarLayout = new javax.swing.GroupLayout(gameStatusBar);
        gameStatusBar.setLayout(gameStatusBarLayout);
        gameStatusBarLayout.setHorizontalGroup(
            gameStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameStatusBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblShields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                .addComponent(lblMissiles)
                .addContainerGap())
        );
        gameStatusBarLayout.setVerticalGroup(
            gameStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameStatusBarLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(gameStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShields, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMissiles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonNewGame.setBackground(new java.awt.Color(0, 0, 0));
        buttonNewGame.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        buttonNewGame.setForeground(new java.awt.Color(255, 255, 255));
        buttonNewGame.setText("NEW GAME");
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGameActionPerformed(evt);
            }
        });

        buttonShowLeaderboard.setBackground(new java.awt.Color(0, 0, 0));
        buttonShowLeaderboard.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        buttonShowLeaderboard.setForeground(new java.awt.Color(255, 255, 255));
        buttonShowLeaderboard.setText("LEADERBOARD");
        buttonShowLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowLeaderboardActionPerformed(evt);
            }
        });

        panelPlayerStats.setBackground(new java.awt.Color(0, 0, 0));
        panelPlayerStats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        panelPlayerStats.setForeground(new java.awt.Color(255, 255, 255));

        lblCurrentLevelTitle.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentLevelTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentLevelTitle.setText("LEVEL");

        lblCurrentLevel.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentLevel.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentLevel.setText("0");

        lblCurrentScoreTitle.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentScoreTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentScoreTitle.setText("CURRENT SCORE:");

        lblCurrentScore.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblCurrentScore.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrentScore.setText("0");

        lblHighScore.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblHighScore.setForeground(new java.awt.Color(255, 255, 255));
        lblHighScore.setText("0");

        lblHighScoreTitle1.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblHighScoreTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblHighScoreTitle1.setText("HIGH SCORE: ");

        javax.swing.GroupLayout panelPlayerStatsLayout = new javax.swing.GroupLayout(panelPlayerStats);
        panelPlayerStats.setLayout(panelPlayerStatsLayout);
        panelPlayerStatsLayout.setHorizontalGroup(
            panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCurrentLevelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCurrentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentScoreTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCurrentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHighScoreTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHighScore, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPlayerStatsLayout.setVerticalGroup(
            panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                        .addComponent(lblHighScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(panelPlayerStatsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelPlayerStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCurrentLevelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrentLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrentScoreTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCurrentScore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHighScoreTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        buttonCreatePlayer.setBackground(new java.awt.Color(0, 0, 0));
        buttonCreatePlayer.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        buttonCreatePlayer.setForeground(new java.awt.Color(255, 255, 255));
        buttonCreatePlayer.setText("CREATE PLAYER");
        buttonCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreatePlayerActionPerformed(evt);
            }
        });

        lblWindowTitle.setBackground(new java.awt.Color(255, 255, 255));
        lblWindowTitle.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        lblWindowTitle.setForeground(new java.awt.Color(255, 204, 51));
        lblWindowTitle.setText("SPACE INVADERS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelPlayerStats, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gameStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(buttonCreatePlayer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonShowLeaderboard))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(lblWindowTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblWindowTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCreatePlayer)
                    .addComponent(buttonNewGame)
                    .addComponent(buttonShowLeaderboard))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPlayerStats, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gameStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Threads
     */
    private Thread aliens;
    private ArrayList<Thread> aliensBullets;
    private Thread shipBullets;
    private Thread moveShip;

    /**
     * Controllers
     */
    LeaderboardController lbCon;
    private PlayerController playerCon;
    
    /**
     * Game variables.
     */
    boolean moveAliens;
    private int deadStatus;
    private int difficulty = 0;
    private int currentLevel = 0;

    public GameWindowView() {
        initComponents();
        
        //Set JFrame properties.
        setEarlyWindowProperties();
        
        //Controllers init.
        this.lbCon = new LeaderboardController();
        
        
        //Fill window elements with info from controllers.
        fillWindowElements();
        
        //Set game properties.
        deadStatus = 1;
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
        this.panelPlayerStats.setVisible(false);
        this.buttonNewGame.setVisible(false);
        this.gameStatusBar.setVisible(false);
        this.game.setDoubleBuffered(true);
    }
    
    /**
     * Starts the game at level 1.
     */
    public void startGame(){
        //nivel al que pasa
        currentLevel = 0;//elije el nivel
        callLvl();      //inicia el nivel

        //datos del usuario 

        showHighScore();
        showCurrentScore();
        showCurrentLevel();   
    }
    
    /**
     * Methods called when the player presses a button on the keyboard.
     * Controls shooting and movement of the ship.
     *
     */
    private void gameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gameKeyPressed
        if (deadStatus == 0) {
            moveShip = new Thread(game);
            switch (evt.getKeyCode()) {
                case 32:
                    shipShootAction(1);
                    break;
                case 38:
                    shipShootAction(0);
                    break;
                case 37:
                    game.setThreadValue(0);
                    moveShip.start();
                    break;
                case 39:
                    game.setThreadValue(1);
                    moveShip.start();
                    break;
            }
        }
    }//GEN-LAST:event_gameKeyPressed

    //Starts or restarts a new game.
    private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
        game.setWon(false);
        game.setLost(false);
        if(!this.playerCon.getPlayerLevel().equals("0")){
            this.playerCon = new PlayerController(this.playerCon.getPlayerName());
        }
        if (deadStatus == 1){
            startGame();
            this.panelPlayerStats.setVisible(true);
        }
        this.gameStatusBar.setVisible(true);
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
    }//GEN-LAST:event_buttonNewGameActionPerformed

    private void buttonShowLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowLeaderboardActionPerformed
        LeaderboardWindowView lb = new LeaderboardWindowView(this, true, this.lbCon);
        lb.setVisible(true);
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
        
    }//GEN-LAST:event_buttonShowLeaderboardActionPerformed

    private void buttonCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreatePlayerActionPerformed
        if (deadStatus == 1){
            String name = "";
            if(playerCon != null){
                name = playerCon.getPlayerName();
            }
            setPlayerCon(new PlayerController());
            CreatePlayerWindowView w = new CreatePlayerWindowView(this, true, this, name);
            w.setVisible(true);
            this.buttonNewGame.setVisible(true);
        }
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
    }//GEN-LAST:event_buttonCreatePlayerActionPerformed
    
    /**
     * Ends current game and saves the player object to the Leaderboard.
     */
    public void endCurrentGame() {
        deadStatus = 1;
        game.setLost(true);
        if (game.getShipController().getShip().getY()!=game.getShipController().getShip().getBullet().getY()) {
            shipBullets.interrupt();
        }
        this.lbCon.addNewScore(playerCon.getPlayer());
        playerCon.resetPoints();
        showHighScore();
        stopThread();
    }
    
    /**
     * Stops active threads.
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
     * Starts a new level depending on the Player level.
     */
    public void callLvl() {
        currentLevel++;
        playerCon.addLevels(1);
          
        if (playerCon.getPlayerLevelInt() != 1 ||  deadStatus == 0) {
            playerCon.addPoints(20);
            game.setWon(true);
            stopThread();
        }else {
            game.setRefreshRate(800);
            difficulty = 0;
        }
        showCurrentLevel();
        showHighScore();
          
        deadStatus = 0;
           
        if (currentLevel == 1) {
            game.startLevel1();
        } else if (currentLevel == 2) {
            game.startLevel2();
        } else if (currentLevel == 3) {
            game.startsLevel3();
        }
        
        difficulty++;
        
        if (difficulty == 3) {// si la ronda es 3 regresa al nivel 1 pero mas rapido
            game.subtractRefreshRate(100);
            difficulty = 0;
        }
        game.repaint();

        gameStatusBar.setShipController(game.getShipController());
        gameStatusBar.repaint();
        game.setStatusBar(gameStatusBar);
        game.setGameWindow(this);
        
        if (currentLevel != 3) {
            createFleetThread(1);
        } else {
            createFleetThread(3);
            currentLevel = 0;
        }

     
    }
    
    /**
     * Creates the fleet thread with the fleet shooting rate.
     * @param invadersShoots fleet shooting rate.
     */
    public void createFleetThread(int invadersShoots) {
        fleetShootingRate(invadersShoots);
        try {Thread.sleep(200);
        } catch (InterruptedException e) {
        }
        invadersrMove();
    }

    /**
     * Triggers the shooting animation.
     * @param type type of ammo.
     */
    public void shipShootAction(int type) { 
        shipBullets = new Thread(game);
        if (game.getShipController().getShipBulletYCoord() == game.getShipController().getShipYCoord()) {
            game.setThreadValue(2);
            game.setTypeShoot(type);
            shipBullets.start();
        }
    }
    
    /**
     * Starts fleet shooting action with the number of threads desired.
     * @param size number of threads
     */
    public void fleetShootingRate(int size) {
        game.setThreadValue(4);
        aliensBullets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            aliensBullets.add(new Thread(game));
            aliensBullets.get(i).start();
        }

    }
    
    /**
     * Animate fleet motion.
     */
    public void invadersrMove() {
        game.setThreadValue(3);
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
    
    /**
     * Add points to Player.
     * @param points integer value with the number of new points.
     */
    public void addPointsToPlayer(int points){
        this.playerCon.addPoints(points);
    }
    
    public int getRound() {
        return difficulty;
    }
    public PlayerController getPlayer() {
        return playerCon;
    }
    public void setUser(PlayerController player) {
        this.setPlayerCon(player);
    }
    public int getDead() {
        return deadStatus;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }
    public void setIncrementLvl(int incrementLvl) {
        this.currentLevel += incrementLvl;
    }
    
    /**
     * @param playerCon the playerCon to set
     */
    public void setPlayerCon(PlayerController playerCon) {
        this.playerCon = playerCon;
    }

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
            java.util.logging.Logger.getLogger(GameWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameWindowView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameWindowView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreatePlayer;
    private javax.swing.JButton buttonNewGame;
    private javax.swing.JButton buttonShowLeaderboard;
    private Views.ActionPanelView game;
    private Views.ShipStatsPanelView gameStatusBar;
    private javax.swing.JLabel lblCurrentLevel;
    private javax.swing.JLabel lblCurrentLevelTitle;
    private javax.swing.JLabel lblCurrentScore;
    private javax.swing.JLabel lblCurrentScoreTitle;
    private javax.swing.JLabel lblHighScore;
    private javax.swing.JLabel lblHighScoreTitle1;
    private javax.swing.JLabel lblMissiles;
    private javax.swing.JLabel lblShields;
    private javax.swing.JLabel lblWindowTitle;
    private javax.swing.JPanel panelPlayerStats;
    // End of variables declaration//GEN-END:variables

}
//_____________________________________________________________________-
