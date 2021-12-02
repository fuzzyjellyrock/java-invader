/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class Fleet {
    Random rand;
    private int fleetSpeed = 10;
    private long refreshRate;
    
    private ArrayList<Alien> aliens;
    //Fleet initial postion
    private final int initialX = 160;
    private final int initialY = 30;
    //Aliens size
    final int width = 15;
    final int height = 8;
    
    //Boss aliens size
    final int bossWidth = 25;
    final int bossHeight = 22;
    //Social distancing
    final int socialDistancing = 24;
    
    //Fleet size
    private int rows;
    private int columns;
    
    //Fleet color
    //Normal color
    private Color color = Color.WHITE;
    //Color when attacked by missile.
    private Color secondColor = Color.RED;

    public Fleet() {
    }

    public Fleet(int refreshRate) {
        this.rand = new Random();
        this.refreshRate = refreshRate;
        aliens = new ArrayList<>();
    }
    
    /**
     * Sets the number of rows according to the player's level.
     * @param level player current level.
     */
    public void setRowsAndColumns(int level){
        switch (level) {
            case 1:
                this.rows = 8;
                this.columns = 9;
                break;
            case 2:
                this.rows = 9;
                this.columns = 9;
                break;
            case 3:
                this.rows = 10;
                this.columns = 10;
                break;
            default:
                System.out.println("Fleet class setRowsAndColumns() Invalid level. level: "+level);
                this.rows = 3;
                this.columns = 3;
        }
    }
    
    /**
     * Creates aliens and assigns a sprite according to the row they are in.
     * @param bulletsRefreshRate 
     */
    public void createAliens(long bulletsRefreshRate) {
        this.aliens.clear();
        int xTemp = initialX;
        int yTemp = initialY;
        for (int f = 0; f < rows; f++) {
            int mod = f%4;
            for (int c = 0; c < columns; c++) {
                addInvader(xTemp, yTemp, bulletsRefreshRate, mod+1);
                xTemp += width + socialDistancing;
            }
            xTemp = initialX;
            yTemp += height + socialDistancing;
        }
    }

    public void addBoss(long bulletsRefreshRate){
        throw new UnsupportedOperationException();
    }
    
    public void addInvader(int x, int y, long refreshShoot, int type) {
        aliens.add(createAlienType(x, y, refreshShoot,type));
    }
    
    /**
     * 
     * @param x initial x position
     * @param y initial y position
     * @param refreshShoot alien shooting rate
     * @param type alien type
     * @return Alien with shapes
     */
    public Alien createAlienType(int x, int y, long refreshShoot, int type){
        Alien alien;
        switch (type) {
            case 0:  
                    alien = new ChiefAlien(x, y, bossWidth, bossHeight, fleetSpeed, refreshShoot);
                    break;
            case 1:  
                    alien = new KnightAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 2:  
                    alien = new MinorRangerAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 3: 
                    alien = new ZealotAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 4:  
                    alien = new RangerAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            default:
                    alien = new KnightAlien(x, y, width, height, fleetSpeed, refreshShoot);
        }
        return alien;
    }
    
    public boolean moveGroupLeft() {
        if (aliens.size() >= 0  && getAliensAlive()!=0) {
            try {Thread.sleep(this.refreshRate);} catch (Exception e) {}
            for (Alien alien : aliens) {
                if (alien.verifyLimitLeft() == true) {
                    return false;
                }
            }
            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).moveToTheLeftShooting();
                
            }
            return true;
        }
        return false;
    }
    
    public boolean moveFleetRight() {
        if (aliens.size() >= 0 && getAliensAlive()!=0) {
            try {Thread.sleep(this.refreshRate);} catch (Exception e) {System.out.println("error move fleet right");}
            for (Alien alien : aliens) {
                if (alien.verifyLimitRight() == true) {
                    return false;
                }
            }
            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).moveToTheRightShooting();
            }
            return true;
        }
        return false;
    }
    
    public boolean moveFleetDown() {
        if (aliens.size() >= 0 && getAliensAlive()!=0) {
                for (Alien alien : aliens) {
                if (alien.verifyLimitDown() == true) {
                    return false;
                }
            }
            for (int i = 0; i < aliens.size(); i++) {
                aliens.get(i).setSpeed(20);
                aliens.get(i).moveDownwardsShooting();
                aliens.get(i).setSpeed(fleetSpeed);
            }
            return true;
        }
    return false;
    }
    
    public void refreshRateControl(){
        int size = getAliensAlive();
        if (size==50) {
            refreshRate=refreshRate-(refreshRate/4);
        }else if(20>size && 10<size){
           refreshRate=refreshRate-(refreshRate/12);   
        }else if(10>size && 3<size){
           refreshRate=refreshRate-(refreshRate/6);   
        }else if(3>=size ){
           refreshRate=refreshRate-(refreshRate/2);   
        }
    }
    
    public int getAliensAlive(){
        int size=0;
        for (Alien invader : aliens) {
             if (invader.isDead()==false) {
                size++;
            }
        }
        return size;
    }
    
    public void removeAlienShapes(int i){
        if (aliens.get(i).getY()==aliens.get(i).getBullet().getY()) {
            aliens.get(i).removeShapes();
        }else{
            aliens.get(i).removeOnlyShip();
        }
    }
    
    public int collisionDetection(Rectangle2D enemyShoot) {
        for (int i = 0; i < aliens.size(); i++) {
            if (aliens.get(i).collision(enemyShoot) == true) {
                removeAlienShapes(i);
                refreshRateControl();
                if(getAliensAlive()==0){
                    return -2;
                }
                return i;
            }
        }
        return -1;
    }
    
    public int randomizer(){
        int possibility = (int)(this.rand.nextDouble() * 3);
        if (possibility == 1) {//si se acepta el disparo escoje una nave aleatoria y lo pone a disparar 
            int invader = (int) (this.rand.nextDouble() * aliens.size() + 0);   
            while (aliens.get(invader).isDead()==true) {     //si el invasor no fue eliminado ya           
                invader = (int) (this.rand.nextDouble() * aliens.size() + 0);    
            }
            return  invader;
        } 
        return -1;
    }
    
    public int getRow() {
        return rows;
    }
    
    public void setRow(int row) {
        this.rows = row;
    }
    
    public int getColumn() {
        return columns;
    }
    
    public void setColumn(int column) {
        this.columns = column;
    }
    
    public int getGroupSpeed() {
        return fleetSpeed;
    }
    
    public void setGroupSpeed(int velocity) {
        this.fleetSpeed = velocity;
    }
    
    public ArrayList<Alien> getInvaders() {
        return aliens;
    }
    
    public void setInvaders(ArrayList<Alien> invaders) {
        this.aliens = invaders;
    }
    
    public long getRefreshRate() {
        return refreshRate;
    }
    
    public void setRefreshRate(long refreshRate) {
        this.refreshRate = refreshRate;
    }
   
    public Bullet getShootOfInvader(int index){
        return aliens.get(index).getBullet();
    }
    
    public int getAliensListSize(){
        return this.aliens.size();
    }
    
    public ArrayList<Rectangle2D> getAlienBulletShape(int index){
        return this.aliens.get(index).getBullet().getShapes();
    }
    
    public ArrayList<Rectangle2D> getAlienShapes(int index){
        ArrayList<Rectangle2D> shapes = null;
        if(index < this.aliens.size() && index > -1){
            shapes = this.aliens.get(index).getShapes();
        }
        return shapes;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the secondColor
     */
    public Color getSecondColor() {
        return secondColor;
    }

}
