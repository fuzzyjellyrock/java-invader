/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class Player implements Serializable {
    private String name ;
    private int score ;
    private int level ;

    public Player() {
    }
    /**
     * 
     * @param name player's name
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.level = 0;
    }

    public int addPoints(int points){
       this.score += points;
       return this.score;
    }
    
    public int addLevels(int level){
       this.level += level;
       return this.level;
    }
    
    public void resetPoints(){
        score = 0;
        level = 1;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getLvl() {
        return level;
    }
    
    public void setLvl(int lvl) {
        this.level = lvl;
    }
    
    /**
     * Debug method that returns a String containing the player info.
     * 
     * @return a String containing the player info.
     */
    @Override
    public String toString(){
        return "Name: "+this.name+", Score: "+this.score+", Level: "+this.level+"\n";
    }
}
