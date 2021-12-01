/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Controllers.FleetController;
import Controllers.ShipController;
import Models.Bullet;
import Models.Ship;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * interfaz sobrepuesta en la interfaz ViewGame en la que se ejecuta el juego
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ActionPanelView extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Game
     */
    
    //Controllers
    private FleetController fleetCon;//invasores
    private ShipController shipCon; //tanque
    
    //Views references
    private ShipStatsPanelView shipStatsPanel; //barrera encargada de mostrar los consumibles
    private GameWindowView gameWindow;  //forma de controlar el jframe
    
    //Ship initalization.
    final int xInitShip = 300;
    final int yInitShip = 485;
    int missile = 0;
    
    private int operation = 0;//Operacion de los hilos
    private int refreshRate=800;//incremento de velocidad por ronda
    
    //Won or lost screen
    boolean won = false;
    boolean lost = false;
    
    //ActionPanel objects visibility.
    private boolean[] visualElements = new boolean[4];
    
//____________________________________________________________________
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 //-----------------Constructor---------------------------------------- 
    /**
     * constructor de personajes y la parte visual
     */
    public ActionPanelView() {
        initComponents();
        lvl1();
        setObjectsVisible();
    }
    /**
     * permite hacer visible todo el juego
     */
    public void setObjectsVisible(){
        visualElements[0] = true;//Show aliens.
        visualElements[1] = true;//Show aliens's bullets.
        visualElements[2] = true;//Show ship.
        visualElements[3] = true;//Show ship's bullets.
    }
    
    public void initializeShip(int level){
        this.shipCon = new ShipController(this.xInitShip, this.yInitShip, 0);
        this.shipCon.createLifes(level);
        this.shipCon.createMissiles(level);
    }
    
    public void initializeFleet(int level){
        this.fleetCon = new FleetController(this.refreshRate);
        this.fleetCon.setRowsAndColumns(level);
        this.fleetCon.addGroupInvader(this.refreshRate/80);
    }
    
    public void initializeBossFleet(int level){
        this.fleetCon = new FleetController(this.refreshRate-100);
        this.fleetCon.setRowsAndColumns(level);
        this.fleetCon.addBoss(refreshRate/80);
    }
    
    //Creación de niveles
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl1(){
        this.won = false;
        this.lost = false;
        initializeFleet(1);
        initializeShip(1);
    }
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl2(){
              //Creacion de personajes
        this.won = false;
        this.lost = false;
        initializeFleet(2);
        initializeShip(2);
    }
    /**
     * crea un nivel gefe (boss) a partir de los parametros de los personajes
     */
    public void lvl3(){
              //Creacion de personajes
        this.won = false;
        this.lost = false;
        initializeBossFleet(3);
        initializeShip(3);
    }

//------------------Methods-------------------------------------------
    /**
     * Dispara la bala del tanque y lo repinta por movimiento
     */
    public void tankShoot() {
        int shot = -1;
        while (shot == -1) {//mientras el disparo pueda seguir sin problemas
            
            shot = shipCon.shoot(fleetCon.getFleet());
           
             if (shot == 1) {//esta parte le da un delay a la bala para que tarde en disparar cuando le de a un muro
                 visualElements[3]=false;//permite que si la bala se queda en quieta el usuario no la vea hasta que retorne
                 repaint();
                 try {Thread.sleep(500);} catch (Exception e) {}//demora de bala retornando
                shipCon.getShip().returnShoot();//retorna la bala    
            }
                  if (shot == 0) {
                gameWindow.getPlayer().addPoints(10);
                gameWindow.showCurrentScore();
                
            }
                   if (shot == -2) {
                gameWindow.callLvl();
                break;
            }
        repaint();
            visualElements[3]=true;
        }
       
        
    }
    /**
     * dispara desde el tanque una bala que destruye todo y solo retorna al llegar al limite del mapa
     */
    public void tankSuperShoot() {
        int disparo = -1;
         if (shipCon.removeMissile()) {//solo si tiene disparos de sobra
                shipStatsPanel.repaint();//eliminalo del la barra de consumibles
            shipCon.createDestroyMissile(1);//genera la forma de la bala
             while (disparo != 2) {//mientras el disparo pueda seguir sin problemas
                 disparo = shipCon.launchMissile(fleetCon.getFleet());//mueve el disparo
                
                     if (disparo == 0) {
                gameWindow.getPlayer().addPoints(10);
                gameWindow.showCurrentScore();
                
                 }
                if (disparo == -2) {
                gameWindow.callLvl();   
                break;
            }
                 repaint();
             }
           missile = 0;
           repaint();
          shipCon.getShip().createDestroyMissile(0);//regresa a la bala normal
          shipCon.getShip().returnShoot();//retorna la bala al tanque

         }
    }
     
    /**
     * Mueve los invasores de abajo, izquierda y derecha y por movimiento
     */
    public void moveInvaders() {
        while (fleetCon.moveGroupDown()) {
            repaint();
//--------------------------------------------------------
            while (fleetCon.moveGroupRight()) {
                repaint();    
            }
//--------------------------------------------------------            
            fleetCon.moveGroupDown();
            repaint();
//--------------------------------------------------------
            while (fleetCon.moveGroupLeft()) {
                repaint();
            }
        }
        
    }
    /**
     * permite que los invasores disparen aleatoriamente solo si estan vivos
     */
    public void alienShoots() {
        //Posibilidad de disparo
        int possibility = fleetCon.randomShoot();
        //velocidad de disparo por segundo
        try {Thread.sleep(100); } catch (Exception e) {}
        if (possibility > -1 && (fleetCon.getAlienYCoord(possibility) == fleetCon.getAlienBulletYCoord(possibility))) {//si si existe la posibilidad y la bala se encuentra en el invasor
            int aux = 0;//determina el camino del disparo
            int auxLvl=gameWindow.getIncrementLvl();//determina si el tanque si ya paso de nivel, si es asi detiene la bala del invasor
            while (aux == 0) {//mientras el disparo no colisione
                aux = fleetCon.shootInvader(possibility, shipCon.getShip());//mueve la bala
                repaint(); 
                if (auxLvl!=gameWindow.getIncrementLvl() && fleetCon.getAliensAlive() == 0) {//para la bala de el invasor al terminar el nivel
                    break;
                }
            }
          
            if (aux == 1) {
                shipStatsPanel.repaint();
                if (shipCon.getLivesListSize()==0 && !lost) {//game over(si le da al tanque y no tiene vidas)
                   dead();
                }
            }
        }
    }
    /**
     * destina el game over de la partida usando el metodo / viewGame.stop()/dentro de ViewGame
     */
    public void dead(){
        gameWindow.endCurrentGame();
    }
//------------------GetSetters----------------------------------------
    
    /**
     * Returns the value of whether an element is being displayed.
     * [0] show aliens
     * [1] show alien bullets
     * [2] show player's ship
     * [3] show player's ship bullets
     * 
     * @param index array position.
     * @return The boolean value at position index.
     */
    public boolean getVisualElementsValue(int index){
        boolean value = false;
        if(index < this.visualElements.length && index > -1){
            value = this.visualElements[index];
        } else {
            System.out.println("ActionScreenView class: setVisualElements(index) index is out of bounds. Array size: "+this.visualElements.length);
        }
        return value;
    }
    
    /**
     * resta la entrada de parametros a la tasa de refresco
     * @param incrementRefreshRate puntos a restar
     */
    public void setRestarRefreshRate(int incrementRefreshRate) {
        this.refreshRate -= incrementRefreshRate;
    }
    /**
     * destina la tasa de refresco en el objeto
     * @param incrementRefreshRate a destinar
     */
    public void setRefreshRate(int incrementRefreshRate) {
        this.refreshRate = incrementRefreshRate;
    }
    /**
     * detina el jFrame de el objeto
     * @param viewGame a destinar
     */
    public void setViewGame(GameWindowView viewGame) {
        this.gameWindow = viewGame;
    }
    /**
     * destina los consumibles del tanque
     * @param statusBar consumibles del tanque
     */
    public void setStatusBar(ShipStatsPanelView statusBar) {
        this.shipStatsPanel = statusBar;
    }
    /**
     * detina en el momento que tipo de disparo se esta ejecutando
     * @return int (0) si es disparo normal int(1)si es super disparo
     */
    public int getTypeShoot() {
        return missile;
    }
    /**
     * destian el tipo de disparo del tanque
     * @param typeShoot destinado al disparo del tanque
     */
    public void setTypeShoot(int typeShoot) {
        this.missile = typeShoot;
    }
    /**
     * retorna los invasores del objeto
     * @return ControllerGroupOfInvaders( invasores)
     */
    public FleetController getInvasores() {
        return fleetCon;
    }
    /**
     * destian los invasores del objeto
     * @param invasores (ControllerGroupOfInvaders)
     */
    public void setInvasores(FleetController invasores) {
        this.fleetCon = invasores;
    }
    /**
     * retorna el tanque del objeto
     * @return ControllerTank(tanque)
     */
    public ShipController getTanque() {
        return shipCon;
    }
    /**
     * destian el tanque del objeto
     * @param tanque (ControllerTank)
     */
    public void setTanque(ShipController tanque) {
        this.shipCon = tanque;
    }
   
    /**
     * destina la operacion que ejecuta el hilo
     * @param operation operacion desceada
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    public boolean isWon(){
        return this.won;
    }
    
    public boolean isLost(){
        return this.lost;
    }
    
    public void setWon(boolean won){
        this.won = won;
    }
    
    public void setLost(boolean lost){
        this.lost = lost;
    }
    
    /**
     * Turns on or off elements from this panel.
     * [0] show aliens
     * [1] show alien bullets
     * [2] show player's ship
     * [3] show player's ship bullets
     * 
     * @param index array position.
     */
    public void setVisualElements(int index, boolean set){
        if(index < this.visualElements.length && index > -1){
            this.visualElements[index] = set;
        } else {
            System.out.println("ActionScreenView class: setVisualElements(index) index is out of bounds. Array size: "+this.visualElements.length);
        }
    }
    
    public void fillRenderer(Graphics2D renderer, ArrayList<Rectangle2D> shapes, String where){
        for(Rectangle2D current : shapes){
            renderer.fill(current);
        }
    }
    
    public void renderAliens(Graphics2D aliensRenderer, Graphics2D aliensBulletsRenderer){
        if (visualElements[0] == true) {
            aliensRenderer.setColor(this.fleetCon.getFleetColor());
            aliensBulletsRenderer.setColor(Color.MAGENTA);
            for (int i = 0; i < fleetCon.getAliensListSize(); i++) {
                if (missile == 1) {
                    aliensRenderer.setColor(this.fleetCon.getFleetSecondColor());
                }
                
                fillRenderer(aliensRenderer, fleetCon.getAlienShapes(i), "aliens");

                if (visualElements[1] == true) {
                    fillRenderer(aliensBulletsRenderer, fleetCon.getAlienBulletShape(i), "aliens bullets");
                }
            }
        }
    }
    
    public void renderPlayerShip(Graphics2D playerRenderer){
        if (visualElements[2] == true && !lost) {
            playerRenderer.setColor(this.shipCon.getShipColor());
            fillRenderer(playerRenderer, this.shipCon.getPlayerShipShapes(), "Player");
        }
    }
    
    public void renderPlayerBullets(Graphics2D bulletsRenderer){
        if (visualElements[3] == true) {
            bulletsRenderer.setColor(this.shipCon.getShipColor());
            if (missile == 1) {//si es el super disparo
                bulletsRenderer.setColor(Color.ORANGE);
            }
            fillRenderer(bulletsRenderer, this.shipCon.getBulletShapes(), "player bullets");
        }
    }
    
    public void textOnScreen(Graphics2D renderer) throws InterruptedException{
        renderer.setColor(Color.cyan);
        renderer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderer.setFont(new Font("Rockwell",Font.BOLD, 82));
        String message = "";
        if(won){
            message = "YOU WON";
        } else if (lost){
            renderer.setColor(Color.RED);
            message = "YOU LOST";
        }
        renderer.drawString(message,90,251); 
        Thread.sleep(3000);
    }
    
//-------------------Override-----------------------------------------
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Won or lost message
        Graphics2D message = (Graphics2D) g.create();
        
        //Renderers for each group of objects.
        Graphics2D aliens = (Graphics2D) g.create();
        Graphics2D aliensBullets = (Graphics2D) g.create();
        Graphics2D player = (Graphics2D) g.create();
        Graphics2D playerBullets = (Graphics2D) g.create();
        
        renderAliens(aliens, aliensBullets);
        renderPlayerShip(player);
        renderPlayerBullets(playerBullets);
        try {
            textOnScreen(message);
        } catch (InterruptedException ex) {
            Logger.getLogger(ActionPanelView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     /**
     * tipo de hilo a ejecutar
     */
    @Override
    public void run() {
        
        boolean stop = false;
        while (!Thread.interrupted() && !stop) {
            switch(this.operation) {
                case 0:
                    //movimiento de tanque
                    shipCon.moveLeftWithShoot();
                    repaint();
                    break;
                case 1:
                    //movimiento de tanque
                    shipCon.moveRightWithShoot();
                    repaint();
                    break;
                case 2:
                    //disparo del tanque
                    if (missile == 0) {
                        tankShoot();
                    }else if (missile == 1) {
                        tankSuperShoot();
                    }
                    break;
                case 3:
                    //movimiento de los invasores
                    moveInvaders();
                    break;
                case 4:
                    //disparo invasores
                    while (!Thread.interrupted()) {
                        alienShoots();
                    }
                    break;
                default:
                {
                    System.out.println("Thread stopped early. ActionScreenView run() method has no valid argument to run code.");
                }

            }
            stop = true;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
