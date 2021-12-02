/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Bullet;
import Models.Ship;
import Models.Fleet;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class ShipController {
        
    private Ship ship;
    
    /**
     * Creates Ship and its controller.
     * @param x ship initial x position.
     * @param y ship initial y position.
     * @param speed ship speed.
     */
    public ShipController(int x, int y, int speed) {
        this.ship = new Ship(x, y, speed);
    }
    
    /**
     * move ship to the left while shooting.
     */
    public void moveLeftWithShoot(){
        ship.moveLeftWithShoot();
    }
    
    /**
     * move ship to the right while shooting.
     */
    public void moveRightWithShoot(){
        ship.moveRightWithShoot();
    }
    
    /**
     * Ship shoot action and aliens removal.
     * @param fleet Fleet that's been shot.
     * @return a integer that indicates if they got shot.
     */
    public int shoot(Fleet fleet){
       return ship.shoot(fleet);
    }
    
    /**
     * dispara una bala con menos velocidad y solo retorna si llega al limite 
   * @param enemy el grupo de enmigos al cual le puede afectar la bala
    * @param walls muros a los cuales la bala le puede dar
     * @return <b>-1</b> si no pasa nada y puede seguir la bala adelante
     *         <br></b>0</b> si el disparo choco con una nave
     *         <br></b>1</b> si le dio a un muro
     *         <br></b>2</b> si llego al limite superiro(position/limitUp)
    */
    
    /**
     * Shoots a missile and returns if it hit something.
     * -1 nothing got hit.
     * 0 missile hit an alien.
     * 1 missile hit a barrier.
     * @param enemy Fleet that's been shot.
     * @return a integer that indicates if they got shot.
     */
    public int launchMissile(Fleet enemy){
     return ship.launchMissile(enemy);
    }
    
    /**
     * Creates ship lives according to the level.
     * @param level player current level.
     */
    public void createLifes(int level){
        this.ship.setShipHealth(level);
        this.ship.addLivesShapes();
    }
    
    /**
     * Creates ship missiles according to the level.
     * @param level player current level.
     */
    public void createMissiles(int level){
        this.ship.setShipMissiles(level);
        this.ship.addMissiles();
    }
    
    public boolean removeLive(){
        return this.ship.removeLive();
    }
    
    public boolean removeMissile(){
        return this.ship.removeMissile();
    }
    
    public void createMissileForLaunch(){
        this.ship.createMissileForLaunch();
    }
    
    public void removeMissileLaunched(){
        this.ship.removeMissileLaunched();
    }
    
    public void reload(){
        this.ship.returnBullet();
    }

    public Color getBulletsColor(){
        return this.ship.getColor();
    }
    
    public ArrayList<Rectangle2D> getBulletShapes(){
        return this.ship.getBulletShapes();
    }
    
    public Color getShipColor() {
        return ship.getColor();
    }
    
    public ArrayList<Rectangle2D> getPlayerShipShapes(){
        return this.ship.getShapes();
    }
    
    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public ArrayList<Ship> getLives(){
        return this.ship.getLives();
    }
    
    public int getLivesCount(){
        return this.ship.getLivesCount();
    }
    
    public int getMissileCapacity(){
        return this.ship.getMissilesCapacity();
    }
    
    public int getLivesListSize(){
        return this.ship.getLives().size();
    }
    
    public ArrayList<Bullet> getMissiles(){
        return this.ship.getMissiles();
    }
    
    public int getShipBulletYCoord(){
        return this.ship.getBullet().getY();
    }
    
    public int getShipYCoord(){
        return this.ship.getY();
    }
}
