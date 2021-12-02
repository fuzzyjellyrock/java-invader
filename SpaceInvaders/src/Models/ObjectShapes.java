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
public abstract class ObjectShapes {
    private int x;
    private int y;
    int width;
    int height;
    
    //Object shapes
    private ArrayList<Rectangle2D> shapes;
    private Color color;
    
    //Game panel limit
    private int limitLeft = 20;
    private int limitRight = 630;
    private int limitUp = 10;
    private int limitDown = 500;
    
    private int speed;
    
    public ObjectShapes() {
    }

    public ObjectShapes(int x, int y, int speed) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        shapes = new ArrayList<>();
    }
    
    public abstract void setSkin();
    
    
    public void addShape(int x, int y, int width, int height){ 
        Rectangle2D aux = new Rectangle2D.Double(x, y, width, height); 
        shapes.add(aux);
    }
    
    public void removeShapes(){
          shapes = new ArrayList<>();
    }
    
    /**
     * Returns True if any of the shapes of the bullet hit another object.
     * @param bulletShape a bullet shape
     * @return True if any of the shapes of the bullet hits another object.
     */
    public boolean collision(Rectangle2D bulletShape){
        for (Rectangle2D shape : shapes) {
            //System.out.println(shape.getCenterX()+" : "+shape.getCenterY()+"          "+shoot.getCenterX()+"  :   "+shoot.getCenterY());
            //System.out.println(""+shape.intersects(shoot));
            if (shape.intersects(bulletShape)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean moveLeft(){ 
        if (verifyLimitLeft()==false) {
            for (Rectangle2D shape : shapes) {
                shape.setRect((shape.getX()-speed), shape.getY(), shape.getWidth(), shape.getHeight());
            }
            x -= speed;
            return true;
        }else{
            return false;
        }
    }
    public boolean moveRight(){     
        if (verifyLimitRight()==false) {
            for (Rectangle2D shape : shapes) {
                shape.setRect((shape.getX()+speed), shape.getY(), shape.getWidth(), shape.getHeight());
            }
            x += speed;
            return true;
        }else{
            return false;  
        }
    }
    
    public boolean moveUp(){
        if (verifyLimitUp()==false) {
            for (Rectangle2D shape : shapes) {
                shape.setRect(shape.getX(), (shape.getY()-speed), shape.getWidth(), shape.getHeight());
            }
            y -= speed;
            return true;
        }else{
            return false;  
        }
    }
    
    public boolean moveDown(){
        if (verifyLimitDown()==false) {

        for (Rectangle2D shape : shapes) {
            shape.setRect(shape.getX(), (shape.getY()+speed), shape.getWidth(), shape.getHeight());
        } 
        y += speed;
        return true;
        }else{
            return false;  
        }
    }
     
    /**
     * Moves the shapes of this object concurrently.
     * @param x position.
     */
    public void setAllShapesX(int x) { 
        for (Rectangle2D shape : shapes) {
            shape.setRect(x+(shape.getX()-this.x), shape.getY() , shape.getWidth(), shape.getHeight());
        }
        this.x = x;
    }
    
    /**
     * Moves the shapes of this object concurrently.
     * @param y position.
     */
    public void setAllShapesY(int y) {
        for (Rectangle2D shape : shapes) {
            shape.setRect(shape.getX(), y+(shape.getY()-this.y) , shape.getWidth(), shape.getHeight());
        }
        this.y = y;
    }
    
    public boolean verifyLimitRight(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getMaxX()+speed)>=limitRight) {
                return true;
            }
          
        }
        return false;
    }
    
    public boolean verifyLimitLeft(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getX()-speed)<=limitLeft) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verifyLimitDown(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getMaxY()+speed)>=limitDown) {
                return true;
            }
        }
        return false;
    }
    
    public boolean verifyLimitUp(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getY()-speed)>=limitUp) {
                return true;
            }
        }
        return false;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getLimitLeft() {
        return limitLeft;
    }
    
    public void setLimitLeft(int limitLeft) {
        this.limitLeft = limitLeft;
    }
   
    public int getLimitRight() {
        return limitRight;
    }
    
    public void setLimitRight(int limitRight) {
        this.limitRight = limitRight;
    }
    
    public int getLimitUp() {
        return limitUp;
    }
    
    public void setLimitUp(int limitUp) {
        this.limitUp = limitUp;
    }
    
    public int getLimitDown() {
        return limitDown;
    }
    
    public void setLimitDown(int limitDown) {
        this.limitDown = limitDown;
    }
    
    public int getSpeed() {    
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public ArrayList<Rectangle2D> getShapes() {
        return shapes;
    }
    
    public void setShape(ArrayList<Rectangle2D> shape) {
        this.shapes = shape;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
