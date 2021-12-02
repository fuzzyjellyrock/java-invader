/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Models.Player;
/**
 *
 * @author Juan Camilo Muñoz, Luis Miguel Sanchez Pinilla
 */
public class PlayerController {
    private Player player;
    
    public PlayerController() {
        this.player = new Player();
    }
    
    public PlayerController(String name) {
        this.player = new Player(name);
    }
    
    /**
     * Converts the current player level into a String and returns it.
     * 
     * @return a String object with the player current level.
     */
    public String getPlayerLevel(){
        return String.valueOf(this.player.getLvl());
    }
    
    /**
     * Get current player level.
     * 
     * @return a integer with the player current level.
     */
    public int getPlayerLevelInt(){
        return this.player.getLvl();
    }
    
    /**
     * Converts the current player score into a String and returns it.
     * 
     * @return a String object with the player current score.
     */
    public String getPlayerScore(){
        return String.valueOf(this.player.getScore());
    }
    
    /**
     * Resets player points.
     */
    public void resetPoints(){
        player.resetPoints();
    }

    /**
     * Add points to the player.
     * @param points to add.
     * @return player current score.
     */
    public int addPoints(int points){
       return player.addPoints(points);
    }
    
    /**
     * Add a new level to the player.
     * @param level
     * @return player current level.
     */
    public int addLevels(int level){
       return player.addLevels(level);
    }
    
    /**
     * Returns the player contained inside this controller.
     * 
     * @return Player object inside the controller.
     */
    
    public Player getPlayer() {
        return player;
    }
    
    /**
     * Returns a String with the current player's name.
     * 
     * @return a String with the player's name
     */
    public String getPlayerName(){
        return this.player.getName();
    }
}
