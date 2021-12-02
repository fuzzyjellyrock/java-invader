/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 * 
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public abstract class Alien extends ObjectShapes {

    private int alienType;
    
    private Bullet bullet;
    private int bulletSpeed = 7;
    private int bulletRefreshRate;
    
    private boolean dead = false;

    public Alien() {
    }

    /**
     * 
     * @param x initial x position
     * @param y initial y position
     * @param width alien width
     * @param height alien height
     * @param speed alien speed
     * @param refreshShoot alien shooting rate
     */
    public Alien(int x, int y, int width, int height, int speed, long refreshShoot) {
        super(x, y, speed);
        this.width = width;
        this.height = height;
        this.alienType = 0;

        bullet = new Bullet((int) ((width / 2) + x - 1), y, 3, 5, bulletSpeed, refreshShoot);
    }
    
    /**
     * Moves alien while shooting to the right.
     * @return True if the bullet was able to be moved according to speed and barriers limits.
     */
    public boolean moveToTheLeftShooting() {
        if (moveLeft()) {
            if (getY() == bullet.getY()) {
                bullet.moveToTheLeft(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala    
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Moves alien while shooting to the left.
     * @return True if the bullet was able to be moved according to speed and barriers limits.
     */
    public boolean moveToTheRightShooting() {
        if (moveRight()) {
            if (getY() == bullet.getY()) {
                bullet.moveToTheRight(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala
            }
            return true;
        } else {
            return false;
        }
    }    
    
    /**
     * Moves alien while shooting downwards.
     * @return True if the bullet was able to be moved according to speed and barriers limits.
     */
    public boolean moveDownwardsShooting() {

        if (moveDown()) {
            if (getY() - getSpeed() == bullet.getY()) {
                bullet.moveDownwards(getSpeed());//debe mover la bala no a la velocidad de la bala, sino a la velocidad del invasor
            }
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Dispara al tanque enemigo moviendo la bala un paso para abajo dependiendo su velocidad y fps, una vez ya en el aire detecta si choco o con el límite, o con el tanque.
     * este metodo usa el metodo removeOrShoot para remover la bala o meverla a una determinda posicion
     * 
     * Nota: hay que tener en cuenta que si el tanque le dio a la nave que disparo, la bala desparece al contacto
     * 
     * @param enemy enemigo al cual le puede afectar la bala
     * @return <b>int 0</b> si el disparo puede seguir para adelante sin problema
     *     <br></b>int 1</b> si la bala regresa a su nave invasora
     *     <br></b>int 2</b> si la bala regresa a y le dio al tanque
     *     <br></b>int -1</b> si se elimino el invasor, por tal se elimino el invasor 
     * @see Invader/removeOrMoveShoot()
     */
    
    /**
     * Alien shooting action.
     * -1 bullet gets deleted because alien died.
     * 0 bullet goes upwards.
     * 1 bullet returns to alien.
     * 2 bullet hit player's ship.
     * @param enemy player ship that gets shot.
     * @return an integer that represents if the bullet hits something.
     */
    public int shoot(Ship enemy) {
        try {
           if (bullet.moveDownFast() == true) {
                if (enemy.collisionDetection(bullet.getShapes().get(0)) ) {
                    removeRestoreBullet();
                    return 1;
                }
                return 0;
            } else {
                removeRestoreBullet();
                return -1;
            } 
            } catch (Exception e) {
                removeRestoreBullet();
                return -1;
            }
          
    }
 
    /**
     * Deletes alien if it dies. Or returns bullet to its position.
     * 0 remove alien shapes, he died.
     * 1 return bullet to alien.
     * @return integer that represents which condition happened.
     */
    public int removeRestoreBullet() {
        
        if (getShapes().size() == 0) {
            removeShapes();
            return -1;
        } else {
            bullet.setAllShapesX((int) ((getShapes().get(0).getWidth() / 2) + getShapes().get(0).getX() - 1));
            bullet.setAllShapesY((int) getShapes().get(0).getY());
            return 1;
        }

    }
    
    /**
     * Remove all alien shapes and its bullet when it dies.
     */
    @Override
    public void removeShapes(){
        super.removeShapes();
        bullet.removeShapes();
        dead = true;
    }
    
    /**
     * Remove all alien shapes ONLY when it dies.
     */
    public void removeOnlyShip(){
        super.removeShapes();
        dead = true;
    }
    
    public ArrayList getBulletShape() {
        return bullet.getShapes();
    }
    
    public Bullet getBullet() {
        return bullet;
    }
    
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
    
    public boolean isDead() {
        return dead;
    }
    
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    /**
     * @return the bulletSpeed
     */
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    /**
     * @param bulletSpeed the bulletSpeed to set
     */
    public void setBulletSpeed(int bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }

    /**
     * @return the bulletRefreshRate
     */
    public int getBulletRefreshRate() {
        return bulletRefreshRate;
    }

    /**
     * @param bulletRefreshRate the bulletRefreshRate to set
     */
    public void setBulletRefreshRate(int bulletRefreshRate) {
        this.bulletRefreshRate = bulletRefreshRate;
    }

    /**
     * @return the alienType
     */
    public int getAlienType() {
        return alienType;
    }

    /**
     * @param alienType the alienType to set
     */
    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }
}
