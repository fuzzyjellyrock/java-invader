/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Player implements Serializable {
 
    
    
    private String name ;
    private int score ;
    private int level ;

//-----------------Constructor---------------------------------------- 
    /**
     * construcctor null de usuario
     */
    public Player() {
    }
    /**
     * constructor con parametros de usuario
     * @param name del usuario
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.level = 0;
    }
//------------------Methods-------------------------------------------
    
    /**
     * suma puntos al usuario 
     * @param score puntos a sumar
     * @return retorna los puntos actuales del usuario
     */
    public int scorePoints(int score){
       this.score += score;
       return this.score;
    }
    /**
     * suma niveles al usuario 
     * @param lvl puntos a sumar
     * @return retorna los niveles actuales del usuario
     */
    public int addLevels(int lvl){
       this.level += lvl;
       return this.level;
    }
    
    /**
     * resetea los puntos del usuario(se usa cuando el usuario muere)
     */
    public void resetPoints(){
        score=0;
        level=1;
        
    }
    
//------------------GetSetters----------------------------------------
    /**
     * retorna el nombre del usuario
     * @return String(name)
     */
    public String getName() {
        return name;
    }
    /**
     * destina el nombre del usuario dentro del objeto
     * @param name a destidar
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * retorna los puntos del usuario dentro de la partida
     * @return int(score)
     */
    public int getScore() {
        return score;
    }
    /**
     * destina los puntos del usuario 
     * @param score a destinar
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * retorna los niveles de el usuario dentro de la partidad
     * @return int (lvl)
     */
    public int getLvl() {
        return level;
    }
    /**
     * destina los niveles en los que se encuantra el usuario
     * @param lvl a destinasr
     */
    public void setLvl(int lvl) {
        this.level = lvl;
    }
//-------------------Override----------------------------------------
    
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
