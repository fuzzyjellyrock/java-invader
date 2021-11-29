/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Models.Player;
/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class PlayerController {
    private Player player;
    
    public PlayerController() {
        this.player = new Player();
    }
    
    public PlayerController(String name) {
        this.player = new Player(name);
    }
//------------------Methods-------------------------------------------
    
    /**
     * Converts the current player level into a String and returns it.
     * 
     * @return a String object with the player current level.
     */
    public String getPlayerLevel(){
        return String.valueOf(this.player.getLvl());
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
     * resetea los puntos del usuario(se usa cuando el usuario murio)
     */
    public void resetPoints(){
        player.resetPoints();
    }

    /**
     * suma puntos al usuario 
     * @param score puntos a sumar
     * @return retorna los puntos actuales del usuario
     */
    public int addPoints(int score){
       return player.scorePoints(score);
    }
    /**
     * suma niveles al usuario 
     * @param lvl puntos a sumar
     * @return retorna los niveles actuales del usuario
     */
    public int addLevels(int lvl){
       return player.addLevels(lvl);
    }
    
    /**
     * Returns the player contained inside this controller.
     * 
     * @return Player object inside the controller.
     */
    public Player getPlayer() {
        return player;
    }

    
}
