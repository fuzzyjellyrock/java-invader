/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.UserController;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Este bloque es la interfaz principal del videojuego basado SpaceInvaders
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ViewGame extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        game = new Views.ViewActionScreen();
        gameBar1 = new Views.PlayerStatusBar(game.getTanque());
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtArearecordScore = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jBegin = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbLvl = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        gameLayout.setVerticalGroup(
            gameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );

        gameBar1.setBackground(new java.awt.Color(0, 0, 0));
        gameBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 7), 2));
        gameBar1.setForeground(new java.awt.Color(0, 0, 0));

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

        TxtArearecordScore.setEditable(false);
        TxtArearecordScore.setBackground(new java.awt.Color(0, 0, 0));
        TxtArearecordScore.setColumns(20);
        TxtArearecordScore.setFont(new java.awt.Font("Showcard Gothic", 0, 12)); // NOI18N
        TxtArearecordScore.setForeground(new java.awt.Color(0, 255, 7));
        TxtArearecordScore.setLineWrap(true);
        TxtArearecordScore.setRows(5);
        TxtArearecordScore.setName(""); // NOI18N
        jScrollPane1.setViewportView(TxtArearecordScore);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 7));
        jLabel1.setText("score");

        jBegin.setBackground(new java.awt.Color(0, 0, 0));
        jBegin.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jBegin.setForeground(new java.awt.Color(0, 255, 7));
        jBegin.setText("COMENZAR");
        jBegin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeginActionPerformed(evt);
            }
        });

        txtnombre.setBackground(new java.awt.Color(0, 0, 0));
        txtnombre.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        txtnombre.setForeground(new java.awt.Color(0, 255, 7));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 7));
        jLabel2.setText("NOMBRE:");

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 7));
        jLabel3.setText("RECORDS:");

        jLabel4.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 7));
        jLabel4.setText("NIVEL");

        lbLvl.setFont(new java.awt.Font("hooge 05_53", 1, 18)); // NOI18N
        lbLvl.setForeground(new java.awt.Color(82, 255, 232));

        lblScore.setFont(new java.awt.Font("hooge 05_53", 1, 18)); // NOI18N
        lblScore.setForeground(new java.awt.Color(82, 255, 232));

        jLabel5.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 255, 7));
        jLabel5.setText("Invaders");

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 7));
        jLabel6.setText("Space");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblScore, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(lbLvl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel6)
                    .addContainerGap(832, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(game, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gameBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbLvl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblScore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBegin)
                        .addGap(30, 30, 30))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jLabel6)
                    .addContainerGap(565, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//-----------------Constructor---------------------------------------- 
    //hilos
    private Thread invasores;
    private ArrayList<Thread> invasoresShoot;
    private Thread disparoTanque;
    private Thread moveTank;

    //usuario
    private UserController user;
    //estado de game over
    private int dead;

    //nivel actaul al que pasa el usuario
    private int round=0;
    private int incrementLvl = 0;

    public ViewGame() {
        initComponents();
        //cambia los colores
        getContentPane().setBackground(Color.BLACK);
        jScrollPane1.setForeground(Color.yellow);
        ShowRecords();
        dead = 1;
    }

//------------------Methods-------------------------------------------
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
            moveTank = new Thread(game);
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
                    moveTank.start();
                    break;
                //mover tanque derecha
                case 39:
                    game.setOperation(1);
                    moveTank.start();
                    break;
            }
        }

//        System.out.println("" + tanque.getTank().getShape().get(0).getWidth());
//        System.out.println("" + tanque.getTank().getShape().get(0).getX() + " : " + tanque.getTank().getShape().get(0).getY());
    }//GEN-LAST:event_gameKeyPressed

    //reinicia el juego o lo activa
    /**
     * boton de inicio y reinicio del juego
     * @param evt evento del boton
     */
    private void jBeginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeginActionPerformed

        if (dead == 1) {
            //crea el usuario
            String name = txtnombre.getText();
            if (name.equals("")) {
                name = "anonimo";
            }
            user = new UserController(name);

            //nivel al que pasa
            incrementLvl = 0;//elije el nivel
            callLvl();      //inicia el nivel

            //datos del usuario 
        
            ShowRecords();
            showActualScore();
            showActualLvl();
        }
        game.setFocusable(true);//dale focus al jPanel
        jBegin.setFocusable(false);

    }//GEN-LAST:event_jBeginActionPerformed
    /**
     * permite parar el juego y reiniciar los puntos del usuario(gameOver)
     */
    public void stop() {
        dead = 1;//game over
        //resetea al usuario y lo hubica en el ranking
        if (game.getTanque().getTank().getY()!=game.getTanque().getTank().getShoot().getY()) {
            disparoTanque.stop();
        }
        JOptionPane.showMessageDialog(null, "game over");
        user.positionInRecords();
        user.resetPoints();
        ShowRecords();
        //para hilos
        stopThread();
    }
    /**
     * para los hilos de diparo, para que se activen cuando sea nescesario
     */
    public void stopThread() {
        for (Thread thread : invasoresShoot) {
            if (thread.isAlive()==true) {
            thread.stop();
            }
        }
        

    }
    
    /**
     * dependiendo la ronda activa un nivel del juego, y activa al jugador
     */
    public void callLvl() {
        //incremeta los niveles
        incrementLvl++;
          user.addLevels(1);
          
          //si el usurio paso de nivel y mato todas las naves
        if (user.getUser().getLvl() != 1 ||  dead == 0) {//apaga las acciones si paso de nivel
            user.addPoints(20);
            JOptionPane.showMessageDialog(null, "¡siguiente nivel!");
            stopThread();
        }else{//activar primer nivel
            game.setRefreshRate(800);
            round=0;
        }
        //mostrar los datos 
          showActualLvl();
          ShowRecords();
          
        dead = 0;//activa al jugador
           
        //dependiendo en el nivel que este, selecciona el proximo nivel 
        if (incrementLvl == 1) {
            game.lvl1();
        } else if (incrementLvl == 2) {
            game.lvl2();
        } else if (incrementLvl == 3) {
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
        if (incrementLvl != 3) {
            activateInvaders(1);
        } else {//este hilo es el jefe por tal dispara 3 veces
            activateInvaders(3);
              incrementLvl=0;
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
        disparoTanque = new Thread(game);
        if (game.getTanque().getTank().getShoot().getY() == game.getTanque().getTank().getY()) {//solo dispara si el disparo ya esta en el tanque
            game.setOperation(3);
            game.setTypeShoot(type);
            disparoTanque.start();
        }
    }
    /**
     * dependiendo los hilos que quieras este metodo permite activar los
     * disparos de los invasores
     *
     * @param size cantidad de disparos por ronda de los invasores
     */
    public void invadersShoot(int size) {
        game.setOperation(5);
        invasoresShoot = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            invasoresShoot.add(new Thread(game));
            invasoresShoot.get(i).start();
        }

    }
    
    boolean bugMove=false;
    /**
     * Método encargado de mover los invasores en grupo
     */
    public void invadersrMove() {
       
        game.setOperation(4);
        invasores = new Thread(game);
         if (bugMove == false) {
        invasores.start();
        bugMove = true;
        }
    }
    
    //informacion
    /**
     * muestra los records de otros jugadores en el juego
     */
    public void ShowRecords() {
        try {
            // leer la info del archivo de numeros
            BufferedReader reader = new BufferedReader(new FileReader("records.txt"));   //leer el txt
            String line = null;
            String text = "\n";

            while ((line = reader.readLine()) != null) {//recorre y guarda todos los jugadores en 
                String[] array = line.split(",");
                text += array[0] + "\tscore: " + array[1] + "\nlvl: " + array[2] + "\n";
            }

            TxtArearecordScore.setText("");
            TxtArearecordScore.setText(text);
            reader.close();

        } catch (IOException ex) {
            System.out.println("error con los archivos");
        }

    }
    /**
     * muestra los niveles del jugador 
     */
    public void showActualLvl() {
        lbLvl.setText("" + user.getUser().getLvl());
    }
    /**
     * muestra los puntos del usuario
     */
    public void showActualScore() {
        lblScore.removeAll();
        lblScore.setText("" + user.getUser().getScore());
    }
    
//------------------GetSetters----------------------------------------
    public int getRound() {
        return round;
    }
    public UserController getUser() {
        return user;
    }
    public void setUser(UserController user) {
        this.user = user;
    }
    public int getDead() {
        return dead;
    }
    public int getIncrementLvl() {
        return incrementLvl;
    }
    public void setIncrementLvl(int incrementLvl) {
        this.incrementLvl += incrementLvl;
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
            java.util.logging.Logger.getLogger(ViewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtArearecordScore;
    private Views.ViewActionScreen game;
    private Views.PlayerStatusBar gameBar1;
    private javax.swing.JButton jBegin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbLvl;
    private javax.swing.JLabel lblScore;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables


}
//_____________________________________________________________________-
