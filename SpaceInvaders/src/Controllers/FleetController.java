/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Alien;
import Models.Ship;
import Models.Fleet;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class FleetController {

    private Fleet fleet;
    
    public FleetController() {
        this.fleet = new Fleet();
    }
    
    public FleetController(int fleetRefreshRate) {
        this.fleet = new Fleet(fleetRefreshRate);
    }
    
    /**
     * Sets the size of the fleet according to the player level.
     * @param level player level.
     */
    public void setRowsAndColumns(int level){
        this.fleet.setRowsAndColumns(level);
    }
    
    /**
     * Add the boss and other enemies to the scene.
     * @param refreshRate 
     */
    public void addBoss(long refreshRate){
        this.fleet.addBoss(refreshRate);
    }
    
    /**
     * Move fleet to the left.
     * @return if fleet moved.
     */
    public boolean moveToTheLeft() {
        return fleet.moveGroupLeft();

    }
    
    /**
     * Move fleet to the right.
     * @return if fleet moved.
     */
    public boolean moveToTheRight() {
        return fleet.moveFleetRight();

    }
    
    /**
     * Move fleet downwards.
     * @return if fleet moved.
     */
    public boolean moveDownwards() {
        return fleet.moveFleetDown();

    }
    
    /**
     * Creates fleet aliens.
     * @param refreshBullet aliens refresh rate.
     */
    public void addGroupInvader(int refreshBullet) {
        fleet.createAliens(refreshBullet);
    }
    
    /**
     * Sets the velocity of the fleet as they die.
     */
    public void controlOfRefreshRate(){
        fleet.refreshRateControl();
    }
    
    /**
     * Gets a randomized value of the alien that could die.
     * @return enemy index that could die.
     */
    public int randomizer() {
        return fleet.randomizer();
    }
    
    /**
     * Gets the index of the alien that will shoot next.
     * @param alienIndex
     * @param ship
     * @return index of the alien that will shoot next
     */
    public int alienShoot(int alienIndex, Ship ship) {
        return fleet.getInvaders().get(alienIndex).shoot(ship);
    }
    
    public int getAliensListSize(){
        return this.fleet.getAliensListSize();
    }
    
    public ArrayList<Rectangle2D> getAlienShapes(int index){
        return this.fleet.getAlienShapes(index);
    }
    
    public ArrayList<Rectangle2D> getAlienBulletShape(int index){
        return this.fleet.getAlienBulletShape(index);
    }
    
    public Color getFleetColor() {
        return fleet.getColor();
    }
    
    public Color getFleetSecondColor() {
        return fleet.getSecondColor();
    }
    
    public Fleet getFleet() {
        return fleet;
    }
    
    public void setGroupInvader(Fleet groupInvader) {
        this.fleet = groupInvader;
    }
    
    public Alien getAlien(int alienIndex) {
        return fleet.getInvaders().get(alienIndex);
    }
    
    public int getAlienYCoord(int alienIndex) {
        return fleet.getInvaders().get(alienIndex).getY();
    }
    
    public int getAlienBulletYCoord(int alienIndex) {
        return fleet.getInvaders().get(alienIndex).getBullet().getY();
    }
    
    public int getAliensAlive() {
        return fleet.getAliensAlive();
    }
}
