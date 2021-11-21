/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author fuzzyrock
 */
public abstract class Character extends OnScreenObject {
    int health;
    int fireRate;

    public Character() {
    }

    public Character(int health, int fireRate, int x, int y, double speed) {
        super(x, y, speed);
        this.health = health;
        this.fireRate = fireRate;
    }
    
    
    
    //Si health es 0, no puede disparar.
    public abstract void shoot();
}
