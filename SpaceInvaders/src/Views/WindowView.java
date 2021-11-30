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

        gameBar1.setBackground(new java.awt.Color(0, 0, 0));
        gameBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 7)));

        lblShields.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblShields.setForeground(new java.awt.Color(255, 255, 255));
        lblShields.setText("SHIELDS");

        lblMissiles.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblMissiles.setForeground(new java.awt.Color(255, 255, 255));
        lblMissiles.setText("MISSILES");

        javax.swing.GroupLayout gameBar1Layout = new javax.swing.GroupLayout(gameBar1);
        gameBar1.setLayout(gameBar1Layout);
        gameBar1Layout.setHorizontalGroup(
            gameBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblShields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 460, Short.MAX_VALUE)
                .addComponent(lblMissiles)
                .addContainerGap())
        );
        gameBar1Layout.setVerticalGroup(
            gameBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameBar1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(gameBar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblShields, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMissiles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonNewGame.setBackground(new java.awt.Color(0, 0, 0));
        buttonNewGame.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        buttonNewGame.setForeground(new java.awt.Color(255, 255, 255));
        buttonNewGame.setText("NEW GAME");
        buttonNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewGameActionPerformed(evt);
            }
        });

        buttonShowLeaderboard.setBackground(new java.awt.Color(0, 0, 0));
        buttonShowLeaderboard.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
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
        buttonCreatePlayer.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        buttonCreatePlayer.setForeground(new java.awt.Color(255, 255, 255));
        buttonCreatePlayer.setText("CREATE PLAYER");
        buttonCreatePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreatePlayerActionPerformed(evt);
            }
        });

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
                            .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
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
                .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private int currentLevel = 0;

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
        this.panelPlayerStats.setVisible(false);
        this.buttonNewGame.setVisible(false);
        this.game.setDoubleBuffered(true);
    }
    
    public void startGame(){
        //nivel al que pasa
        currentLevel = 0;//elije el nivel
        callLvl();      //inicia el nivel

        //datos del usuario 

        showHighScore();
        showCurrentScore();
        showCurrentLevel();   
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
    private void buttonNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewGameActionPerformed
        if(!this.playerCon.getPlayerLevel().equals("0")){
            this.playerCon = new PlayerController(this.playerCon.getPlayerName());
        }
        if (dead == 1){
            startGame();
            this.panelPlayerStats.setVisible(true);
        }
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
    }//GEN-LAST:event_buttonNewGameActionPerformed

    private void buttonShowLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowLeaderboardActionPerformed
        LeaderboardWindow lb = new LeaderboardWindow(this, true, this.lbCon);
        lb.setVisible(true);
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
    }//GEN-LAST:event_buttonShowLeaderboardActionPerformed

    private void buttonCreatePlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreatePlayerActionPerformed
        if (dead == 1){
            String name = "";
            if(playerCon != null){
                name = playerCon.getPlayerName();
            }
            setPlayerCon(new PlayerController());
            CreatePlayer w = new CreatePlayer(this, true, this, name);
            w.setVisible(true);
            this.buttonNewGame.setVisible(true);
        }
        buttonNewGame.setFocusable(false);
        buttonCreatePlayer.setFocusable(false);
        buttonShowLeaderboard.setFocusable(false);
        game.setFocusable(true);
    }//GEN-LAST:event_buttonCreatePlayerActionPerformed
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
        currentLevel++;
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
        if (currentLevel == 1) {
            game.lvl1();
        } else if (currentLevel == 2) {
            game.lvl2();
        } else if (currentLevel == 3) {
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
        if (currentLevel != 3) {
            activateInvaders(1);
        } else {//este hilo es el jefe por tal dispara 3 veces
            activateInvaders(3);
              currentLevel=0;
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
        System.out.println("moveAliens: "+moveAliens);
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
        this.setPlayerCon(user);
    }
    public int getDead() {
        return dead;
    }
    public int getIncrementLvl() {
        return currentLevel;
    }
    public void setIncrementLvl(int incrementLvl) {
        this.currentLevel += incrementLvl;
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
    private javax.swing.JButton buttonCreatePlayer;
    private javax.swing.JButton buttonNewGame;
    private javax.swing.JButton buttonShowLeaderboard;
    private Views.ActionScreenView game;
    private Views.PlayerStatusBarView gameBar1;
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

    /**
     * @param playerCon the playerCon to set
     */
    public void setPlayerCon(PlayerController playerCon) {
        this.playerCon = playerCon;
    }


}
//_____________________________________________________________________-
