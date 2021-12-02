/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class Ship extends ObjectShapes{
    
    final int shipSpeed = 15;
    
    private int livesCount;
    private ArrayList<Ship> lives;

    private Bullet bullet;
    private final int bulletSpeed = 7;
    private final int bulletRefreshRate = 7;
    
    private int missilesCapacity;
    private ArrayList<Bullet> missiles;
    
    //Ship size
    private final int shipWidth = 25;
    private final int shipHeight = 10;
    
    final float[] colorSelector = Color.RGBtoHSB(0,255,7, null);
    final Color defaultColor = Color.getHSBColor(colorSelector[0], colorSelector[1], colorSelector[2]);
    
 //-----------------Constructor---------------------------------------    
    /**
     * Status bar Ship Shape constructor.
     */
    public Ship(int xInitPosition, int yInitPosition) {
        super(xInitPosition, yInitPosition, 0);
        this.width = shipWidth;
        this.height = shipHeight;
        setSkin();
        
        setColor(defaultColor);
    }

    public Ship(int xInitPosition, int yInitPosition, int speed) {
        super(xInitPosition, yInitPosition, speed);
        setSpeed(this.shipSpeed);
        this.width = shipWidth;
        this.height = shipHeight;
        setColor(defaultColor);
        setSkin();
        
        this.bullet = new Bullet((int)((width/2)+xInitPosition-1),yInitPosition, 5 , 6, bulletSpeed , bulletRefreshRate);
        
        this.livesCount = 3;
        this.missilesCapacity = 4;
        
        this.lives = new ArrayList<>();
        this.missiles = new ArrayList<>();
    }
    
    public void setShipHealth(int level){
        switch (level) {
            case 1:
              this.livesCount = 3;
              break;
            case 2:
              this.livesCount = 4;
              break;
            case 3:
              this.livesCount = 5;
              break;
            default:
              this.livesCount = 1;
        }
    }
    
    public void setShipMissiles(int level){
        switch (level) {
            case 1:
              this.missilesCapacity = 4;
              break;
            case 2:
              this.missilesCapacity = 6;
              break;
            case 3:
              this.missilesCapacity = 8;
              break;
            default:
              this.missilesCapacity = 1;
        }
    }
    
    /**
     * Adds the lives (empty ships) to the ship lives list.
     */
    public void addLivesShapes(){
        for (int i = 0; i < this.livesCount; i++) {
            this.lives.add(new Ship(0, 0));
        }
    }
    
    public void addMissiles(){
        Rectangle2D aux =bullet.getShapes().get(0);
        for (int i = 0; i < this.missilesCapacity; i++) {
            this.missiles.add(new Bullet());
        }
    }
    
    public void createMissileForLaunch(){
        Rectangle2D model =bullet.getShapes().get(0);
        bullet.addShape((int)model.getX(), (int)model.getY(), 5, 12);
        bullet.addShape((int)model.getX()-2, (int)(model.getY()+12), 10, 4);
    }
    
    public void removeMissileLaunched(){
        if (bullet.getShapes().size() == 3) {
            bullet.getShapes().remove(1);
            bullet.getShapes().remove(1);
        }
    }
    
    public boolean removeLive(){
        if (this.getLivesCount() > 0 ) {
            this.lives.remove(this.lives.size()-1);
            this.livesCount--;
            //System.out.println("lives inside ship: "+this.livesCount);
            return true;
        }else{
            return false;    
        }
    }

    public boolean removeMissile(){
        if (this.getMissilesCapacity() > 0 ) {
            this.missiles.remove(this.missiles.size()-1);
            this.missilesCapacity--;
            //System.out.println("missiles inside ship: "+this.missilesCapacity);
            return true;
        }else{
        return false;    
        }
        
    }

    public void moveLeftWithShoot(){
        if (moveLeft()) {
            if (getY() == bullet.getY()) {
                bullet.moveToTheLeft(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala    
            }  
        }  
    }
    
    public void moveRightWithShoot(){
        if (moveRight()) {
            if (getY() == bullet.getY()) {
                bullet.moveToTheRight(getSpeed());
            }
        }  
    }

    public int shoot(Fleet enemy){
        if(bullet.moveUpMaxSpeed()==true){
            int colision=enemy.collisionDetection(getBullet().getShapes().get(0));
            if (colision == -2) {
                return -2;
            }
            if(colision >= 0 ){
                returnBullet();
                return 0;
            }
            return -1;
        }else{
            returnBullet();
            return 1;
        }
    }

    public int launchMissile(Fleet enemy){
        if(bullet.moveUpMediumSpeed() == true){
            int colision=enemy.collisionDetection(getBullet().getShapes().get(0));
            if (colision == -2) {
                return -2;
            }
            if(colision >= 0 ){
                return 0;
            }
            return -1;
        }else{
            return 2;
        }
    }
    
    public int returnBullet() {
        bullet.setAllShapesX((int) ((getShapes().get(0).getWidth() / 2) + getShapes().get(0).getX() - 1));
        bullet.setAllShapesY((int) getShapes().get(0).getMinY());
        return 0;
    }

    public boolean collisionDetection (Rectangle2D enemyShoot){
            if (collision(enemyShoot)==true) {
                removeLive();
                return true;
            }
        return false;
    }
    
    public Bullet getBullet() {
        return bullet;
    }
    
    public ArrayList<Rectangle2D> getBulletShapes() {
        return bullet.getShapes();
    }
    
    public void setShoot(Bullet shoot) {
        this.bullet = shoot;
    }
    
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the bulletSpeed
     */
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    /**
     * @return the bulletRefreshRate
     */
    public int getBulletRefreshRate() {
        return bulletRefreshRate;
    }

    /**
     * @return the lives
     */
    public ArrayList<Ship> getLives() {
        return lives;
    }

    /**
     * @return the missiles
     */
    public ArrayList<Bullet> getMissiles() {
        return missiles;
    }

    /**
     * @return the livesCount
     */
    public int getLivesCount() {
        return livesCount;
    }

    /**
     * @return the missilesCapacity
     */
    public int getMissilesCapacity() {
        return missilesCapacity;
    }

    @Override
    public void setSkin() {
        int x = getX();
        int y = getY();
        addShape(x, y, width,  height);
        addShape(x+(width/2)-(width/9), y-4, (width/4), height);
        addShape(x+(width/2)-(width/5), y-2, (width/2), height);
    }
}
