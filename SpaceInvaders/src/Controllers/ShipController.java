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
 * Controlador para el tanque
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ShipController {
        
    private Ship ship;
    
 //-----------------Constructor---------------------------------------
    /**
    * 
    * Crea un tanque con su forma principal (addShape) y crea el disparo con su tasa de movimiento
    * @param x ubicacion del x inicial
    * @param y ubicacion del y inicial
    * @param width anchura de la forma principal
    * @param height altura de la forma inicial
    * @param speed velocidad de movimiento del tanque
    * @param speedBullet velocidad de  bala del tanqeu
    * @param refreshShoot fps de bala del tanque
    */
    public ShipController(int x, int y, int speed) {
        this.ship = new Ship(x, y, speed);
    }
    
    //------------------Methods-------------------------------------------

    //mover
    /**
     * mueve para la izquierda el tanque y el disparo
     * @param Steps pasos a dar a la izquierda
     */
    public void moveLeftWithShoot(){
        ship.moveLeftWithShoot();
    }
    /**
     * mueve para la derecha el tanque y el disparo
     * @param Steps pasos a dar a la derecha
     */
    public void moveRightWithShoot(){
        ship.moveRightWithShoot();
    }
    //disparar
    /**
     * dispara para arriba hasta detectar una colision
     * @param enemy grupo de enemigos a los cuales les afecta el disparo
     */
    public int shoot(Fleet enemy){
       return ship.shoot(enemy);
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
    public int launchMissile(Fleet enemy){
     return ship.launchMissile(enemy);
    }
    
    public void createLifes(int level){
        this.ship.setShipHealth(level);
        this.ship.addLivesShapes();
    }
    
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
    
    public void createDestroyMissile(int operation){
        this.ship.createDestroyMissile(operation);
    }
    
    //------------------GetSetters----------------------------------------
    
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
    
    /**
     * retorna el tanque(model.Tank/tank) utilizado en el controlador
     * @return Tank(tank)
     */
    public Ship getShip() {
        return ship;
    }
    /**
     * destina el tanque utilizado en el controlador
     * @param ship  destinado al objeto
     */
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
    
    //-------------------Override-----------------------------------------   

    @Override
    public String toString() {
        return  "";
                 
    }

  
}
