/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.awt.image.BufferedImage;

/**
 *
 * @author fuzzyrock
 */
public abstract class OnScreenObject {
    int x;
    int y;
    double speed;
    BufferedImage skin;

    public OnScreenObject() {
    }

    public OnScreenObject(int x, int y, double speed, BufferedImage skin) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.skin = skin;
    }
    
}
