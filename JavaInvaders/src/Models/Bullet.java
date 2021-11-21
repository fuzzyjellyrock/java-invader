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
public class Bullet extends OnScreenObject {
    public Bullet() {
    }

    public Bullet(int x, int y, BufferedImage skin) {
        super(x, y, 1000, skin);
    }
    
    
}
