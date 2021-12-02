/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Controllers.FleetController;
import Controllers.ShipController;
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
 * This is where the game is displayed.
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class ActionPanelView extends javax.swing.JPanel implements Runnable {
    /**
     * Controllers.
     */
    //Alien fleet controller.
    private FleetController fleetCon;
    //Player Ship controller.
    private ShipController shipCon;
    
    /**
     * Thread method selector.
     */
    private int thread = 0;
    
    /**
     *  Game refresh rate.
     */
    private int refreshRate = 800;
    
    /**
     * Variables that control the Won or lost screen.
     */
    boolean won = false;
    boolean lost = false;
    
    /**
     * Array in which each position controls the objects are displayed in the ActionPanel.
     */
    private boolean[] visualElements = new boolean[4];
    
    /**
     * Ship initialization constants.
     */
    //Ship initial position.
    final int xInitShip = 300;
    final int yInitShip = 485;
    //Missile active variable trigger.
    int missile = 0;
    
    /**
     * References to Views.
     */
    //Reference to ship status view for lives and missiles.
    private ShipStatsPanelView shipStatsPanel;
    //JFrame reference.
    private GameWindowView gameWindow;
    
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
    /**
     * Sets the initial view when the game is oppened.
     */
    public ActionPanelView() {
        initComponents();
        startLevel1();
        //Show aliens.
        this.visualElements[0] = true;
        //Show aliens's bullets.
        this.visualElements[1] = true;
        //Show ship.
        this.visualElements[2] = true;
        //Show ship's bullets.
        this.visualElements[3] = true;
    }
    
    /**
     * Initialize the ShipController, and the Ship object for the selected level.
     * 
     * @param level level selected to play.
     */
    public void initializeShip(int level){
        this.shipCon = new ShipController(this.xInitShip, this.yInitShip, 0);
        this.shipCon.createLifes(level);
        this.shipCon.createMissiles(level);
    }
    
    /**
     * Initialize the FleetController, and the Fleet object for the selected level.
     * 
     * @param level level selected to play.
     */
    public void initializeFleet(int level){
        this.fleetCon = new FleetController(this.refreshRate);
        this.fleetCon.setRowsAndColumns(level);
        this.fleetCon.addGroupInvader(this.refreshRate/80);
    }
    
    public void initializeBossFleet(int level){
        this.fleetCon = new FleetController(this.refreshRate-100);
        this.fleetCon.setRowsAndColumns(level);
        this.fleetCon.addBoss(this.refreshRate/80);
    }
    
    /**
     * Sets the game variables ann initializes characters for Level 1.
     */
    public void startLevel1(){
        this.won = false;
        this.lost = false;
        initializeFleet(1);
        initializeShip(1);
    }
    
    /**
     * Sets the game variables ann initializes characters for Level 2.
     */
    public void startLevel2(){
        this.won = false;
        this.lost = false;
        initializeFleet(2);
        initializeShip(2);
    }
    
    public void startsLevel3(){
        this.won = false;
        this.lost = false;
        initializeBossFleet(3);
        initializeShip(3);
    }

    /**
     * Draws the ship's bullet and animates it.
     * The variable shot 
     */
    //retorna -2 ya no hay naves
        //retorna -1 si no paso nada 
        //retorna  0 si choco con una nave
        //retorna  1 si llego al limite
    public void shootBulletShip() {
        int hit = -1;
        while (hit == -1) {
            hit = this.shipCon.shoot(this.fleetCon.getFleet());
            //If the ship's bullet hits an alien.
            if (hit == 0) {
                this.gameWindow.addPointsToPlayer(10);
                this.gameWindow.showCurrentScore();
            }
            //If no more aliens are alive, call a new level.
            if (hit == -2) {
                this.gameWindow.callLvl();
                break;
            }
            repaint();
        }
    }
    
    /**
     * Ship launches a missile that stops when it reaches the ActionPanel height limit.
     */
    public void launchMissileShip() {
        int hit = -1;
        if (this.shipCon.removeMissile()) {
            this.shipStatsPanel.repaint();
            this.shipCon.createMissileForLaunch();
            while (hit != 2) {
                hit = this.shipCon.launchMissile(this.fleetCon.getFleet());
                if (hit == 0) {
                    this.gameWindow.addPointsToPlayer(10);
                    this.gameWindow.showCurrentScore();
                }
                if (hit == -2) {
                    this.gameWindow.callLvl();   
                    hit = 2;
                }
                repaint();
            }
            this.missile = 0;
            repaint();
            this.shipCon.removeMissileLaunched();
            this.shipCon.reload();
        }
    }
     
    /**
     * Initiates the fleet movement downwards.
     */
    public void startFleetManeuvers() {
        while (this.fleetCon.moveDownwards()) {
            repaint();
            while (this.fleetCon.moveToTheRight()) {
                repaint();    
            }          
            this.fleetCon.moveDownwards();
            repaint();
            while (this.fleetCon.moveToTheLeft()) {
                repaint();
            }
        }
    }
    
    /**
     * Controls events when the Fleet shoots and the Ship gets hit.
     */
    public void fleetShoot() {
        int possibility = this.fleetCon.randomizer();
        
        try {
            Thread.sleep(150); 
        } catch (InterruptedException e) {
        }
        
        if (possibility > -1 && (this.fleetCon.getAlienYCoord(possibility) == this.fleetCon.getAlienBulletYCoord(possibility))) {
            int playerGotHit = 0;
            int playerLevel = this.gameWindow.getCurrentLevel();
            while (playerGotHit == 0) {
                playerGotHit = this.fleetCon.alienShoot(possibility, this.shipCon.getShip());
                repaint(); 
                if (playerLevel != this.gameWindow.getCurrentLevel() && this.fleetCon.getAliensAlive() == 0) {
                    playerGotHit = 1;
                }
            }
          
            if (playerGotHit == 1) {
                this.shipStatsPanel.repaint();
                if (this.shipCon.getLivesListSize() == 0 && !this.lost) {
                    shipDestroyed();
                }
            }
        }
    }
    
    /**
     * Signals the gameWindow to end the current game.
     */
    public void shipDestroyed(){
        gameWindow.endCurrentGame();
    }
    
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
     * Subtract the current refresh rate by an specific value.
     * @param incrementRefreshRate the value that subtracts the refresh rate.
     */
    public void subtractRefreshRate(int incrementRefreshRate) {
        this.refreshRate -= incrementRefreshRate;
    }
    
    /**
     * Set a new value for the refresh rate.
     * @param refreshRate the new value for the refresh rate.
     */
    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }
    
    /**
     * Set a reference of the game window JFrame inside this panel.
     * @param gameWindow the GameWindowView JFrame to create the reference.
     */
    public void setGameWindow(GameWindowView gameWindow) {
        this.gameWindow = gameWindow;
    }
    
    /**
     * Set a reference of the status bar panel inside this panel.
     * @param statusBar the ShipStatsPanelView Panel to create the reference.
     */
    public void setStatusBar(ShipStatsPanelView statusBar) {
        this.shipStatsPanel = statusBar;
    }
    
    /**
     * Get the current ship ammo type.
     * @return if missile value. If 1, then it is a missile.
     */
    public int getAmmoType() {
        return this.missile;
    }
    
    /**
     * Set the current ship ammo type.
     * @param ammoType the type of ammo. 1 is a missile, 0 is normal bullets.
     */
    public void setTypeShoot(int ammoType) {
        this.missile = ammoType;
    }
    
    /**
     * Get the FleetController inside this panel.
     * @return FleetController
     */
    public FleetController getFleetController() {
        return fleetCon;
    }
    
    /**
     * Set the FleetController inside this panel.
     * @param fleetCon FleetController
     */
    public void setFleetController(FleetController fleetCon) {
        this.fleetCon = fleetCon;
    }
    
    /**
     * Get the ShipController inside this panel.
     * @return ShipController
     */
    public ShipController getShipController() {
        return shipCon;
    }
    
    /**
     * Set the ShipController inside this panel.
     * @param shipCon ShipController
     */
    public void setShipController(ShipController shipCon) {
        this.shipCon = shipCon;
    }
   
    /**
     * Sets the thread method to run.
     * 0 controls ship movement to the left.
     * 1 controls ship movement to the right.
     * 2 controls ship shooting action.
     * 3 controls fleet movement.
     * 4 controls fleet shooting action.
     
     * @param thread the integer value that sets the thread methods to run.
     */
    public void setThreadValue(int thread) {
        this.thread = thread;
    }
    
    /**
     * Sets the won value to trigger a screen message.
     * @param won boolean value.
     */
    public void setWon(boolean won){
        this.won = won;
    }
    
    /**
     * Sets the lost value to trigger a screen message.
     * @param lost boolean value.
     */
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
    
    /**
     * This methods renders the Rectangle2D ArrayList shapes inside an specific Graphics2D renderer.
     * @param renderer where the shapes will be rendered.
     * @param shapes an ArrayList of Rectangle2D objects.
     * @param where a String of what object are we rendering.
     */
    public void fillRenderer(Graphics2D renderer, ArrayList<Rectangle2D> shapes, String where){
        for(Rectangle2D current : shapes){
            renderer.fill(current);
        }
    }
    
    /**
     * Gets the Rectangle2D ArrayList of an alien and sends it to the fillRenderer() method.
     * Gets the Rectangle2D ArrayList of an bullet and sends it to the fillRenderer() method.
     * @param aliensRenderer a Graphics2D renderer.
     * @param aliensBulletsRenderer a Graphics2D renderer.
     */
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
    
    /**
     * Gets the Rectangle2D ArrayList of an player ship and sends it to the fillRenderer() method.
     * @param playerRenderer a Graphics2D renderer.
     */
    public void renderPlayerShip(Graphics2D playerRenderer){
        if (visualElements[2] == true && !lost) {
            playerRenderer.setColor(this.shipCon.getShipColor());
            fillRenderer(playerRenderer, this.shipCon.getPlayerShipShapes(), "Player");
        }
    }
    
    /**
     * Gets the Rectangle2D ArrayList of an player ship bullets and sends it to the fillRenderer() method.
     * @param bulletsRenderer a Graphics2D renderer.
     */
    public void renderPlayerBullets(Graphics2D bulletsRenderer){
        if (visualElements[3] == true) {
            bulletsRenderer.setColor(this.shipCon.getShipColor());
            if (missile == 1) {//si es el super disparo
                bulletsRenderer.setColor(Color.ORANGE);
            }
            fillRenderer(bulletsRenderer, this.shipCon.getBulletShapes(), "player bullets");
        }
    }
    
    /**
     * Renders a screen message of whether the player has won or lost.
     * @param renderer a Graphics2D renderer.
     * @throws InterruptedException for the thread that sleeps.
     */
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

    @Override
    public void run() {
        
        boolean stop = false;
        while (!Thread.interrupted() && !stop) {
            switch(this.thread) {
                case 0:
                    shipCon.moveLeftWithShoot();
                    repaint();
                    break;
                case 1:
                    shipCon.moveRightWithShoot();
                    repaint();
                    break;
                case 2:
                    if (missile == 0) {
                        shootBulletShip();
                    }else if (missile == 1) {
                        launchMissileShip();
                    }
                    break;
                case 3:
                    startFleetManeuvers();
                    break;
                case 4:
                    while (!Thread.interrupted()) {
                        fleetShoot();
                    }
                    break;
                default:
                    System.out.println("Thread stopped early. ActionScreenView run() method has no valid argument to run code.");
            }
            stop = true;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
