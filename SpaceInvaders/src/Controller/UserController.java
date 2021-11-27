/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Player;
/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class UserController {
    private  Player user;
      public UserController() {
        user= new Player();
    }
    public UserController(String name) {
        user = new Player(name);
    }
//------------------Methods-------------------------------------------
    
    /**
     * resetea los puntos del usuario(se usa cuando el usuario murio)
     */
    public void resetPoints(){
        user.resetPoints();
    }
    /**
     * registra en el txt un nuevo usuario, si el usuario supero un record ya registrado
     */
    public void positionInRecords(){
    user.positionInRecords();
    }
    /**
     * registra el record en el txt (records.txt) si el record supero alguno solo ingresa(int > -1) si ingresa -1 no se registra nada
     * @param addRecord posicion dentro del podio del usuario
     * @return retorna el nuevo texto que ira en el txt (hace uso del metodo checheckOtherRecords());
     */
    public String readRecordsWithNewRecord(){
      return user.readRecordsWithNewRecord(-1);
    }
    /**
     * suma puntos al usuario 
     * @param score puntos a sumar
     * @return retorna los puntos actuales del usuario
     */
    public int addPoints(int score){
       return user.scorePoints(score);
    }
    /**
     * suma niveles al usuario 
     * @param lvl puntos a sumar
     * @return retorna los niveles actuales del usuario
     */
    public int addLevels(int lvl){
       return user.addLevels(lvl);
    }
    

    public Player getUser() {
        return user;
    }

    
}
