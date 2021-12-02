/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class Bullet extends ObjectShapes {
        
    private long refreshRate; 
    
    final float[] colorSelect = Color.RGBtoHSB(0,255,7, null);
    final Color defaultColor = Color.getHSBColor(colorSelect[0], colorSelect[1], colorSelect[2]);
 //-----------------Constructor----------------------------------------
    public Bullet(){
        
    }
    
    /**
     * Bullet constructor for missile.
     * @param x initial x position
     * @param y initial y position
     * @param width
     * @param height 
     */
    public Bullet(int x, int y, int width, int height) {
        super(x, y, 0);
        this.width = width;
        this.height = height;
        setSkin();
    }
    
    /**
     * Bullet constructor for alien and ship ammo.
     * @param x initial x position
     * @param y initial y position
     * @param width
     * @param height
     * @param speed bullet speed.
     * @param refreshRate bullet refresh rate.
     */
    public Bullet(int x, int y, int width, int height, int speed, long refreshRate) {
        super(x, y,speed);
        this.width = width;
        this.height = height;
        this.refreshRate = refreshRate;
        setSkin();
    }
    
    /**
     * Moves bullet with a certain speed upwards.
     * 
     * @param speed bullet's speed
     * @return if was able to be moved upwards.
     */
    public boolean moveUpwards(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveUp();
        setSpeed(nomalSpeed);
        return result;
    }
    
    /**
     * Moves bullet with a certain speed downwards.
     * 
     * @param speed bullet's speed
     * @return if was able to be moved downwards.
     */
    public boolean moveDownwards(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveDown();
        setSpeed(nomalSpeed);
        return result;
        
    }
    
    /**
     * Moves bullet with a certain speed to the left.
     * 
     * @param speed bullet's speed
     * @return if was able to be moved to the left.
     */
    public boolean moveToTheLeft(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveLeft();
        setSpeed(nomalSpeed);
        return result;
        
    }
    
    /**
     * Moves bullet with a certain speed to the right.
     * 
     * @param speed bullet's speed
     * @return if was able to be moved to the right.
     */
    public boolean moveToTheRight(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveRight();
        setSpeed(nomalSpeed);
        return result;
        
    }

    /**
     * Moves the bullet with max speed upwards
     * @return if was able to be moved.
     */
    public boolean moveUpMaxSpeed() {
        for (Rectangle2D shape : getShapes()) {
            if (((shape.getY()-getSpeed())<=getLimitUp()) || getSpeed()<=0) {
                return false;
            }
        }
        try {Thread.sleep(refreshRate); } catch (Exception e) { System.out.println("cannot be moved to the right."+e);}   
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(), (shape.getY()-getSpeed()), shape.getWidth(), shape.getHeight());
        }
        setY(getY()-getSpeed());
        return true;
    }
     
    /**
     * Moves the bullet with medium speed upwards
     * @return if was able to be moved.
     */
    public boolean moveUpMediumSpeed() {
        for (Rectangle2D shape : getShapes()) {
            if (((shape.getY()-getSpeed())<=getLimitUp()) || getSpeed()<=0) {
                return false;
            }
        }
        try {Thread.sleep(refreshRate+(refreshRate)); } catch (Exception e) { System.out.println("cant be moved"+e);}   
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(), (shape.getY()-getSpeed()), shape.getWidth(), shape.getHeight());
        }
        setY(getY()-getSpeed());
        return true;
    }
    
     /**
     * Moves the bullet with max speed downwards
     * @return if was able to be moved.
     */
    public boolean moveDownFast(){
        for (Rectangle2D shape : getShapes()) {
            if (((shape.getMaxY()+getSpeed())>=getLimitDown()) || getSpeed()<=0) { 
                return false;
            }
        }
        try {Thread.sleep(refreshRate); } catch (Exception e) { System.out.println("cant be moved"+e);}    
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(), (shape.getY()+getSpeed()), shape.getWidth(), shape.getHeight());
        } 
        setY(getY()+getSpeed());
        return true;
    }
    
    public long getRefreshRate(){
        return refreshRate;
    }
    
    public void setRefreshRate(long refreshRate) {
        this.refreshRate = refreshRate;
    }

    @Override
    public void setSkin() {
        int x = getX();
        int y = getY();
        addShape(x, y, width, height);
    }
}
