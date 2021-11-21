/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author fuzzyrock
 */
public class Player extends Character {
    int score;

    public Player() {
    }

    public Player(int x, int y) {
        super(3, 100, x, y, 50, null);
        this.score = 0;
    }
    
}
