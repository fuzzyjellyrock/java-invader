/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GroupOfWalls;
import Model.Aliens;
import Model.Tank;
import Model.Fleet;
import java.util.ArrayList;

/**
 * Controlador para el grupo de invasores
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ControllerGroupOfInvaders {

    private Fleet groupInvader;

    //-----------------Constructor----------------------------------------
    /**
     * constructor de GroupInvaders null
     */
    public ControllerGroupOfInvaders() {
        this.groupInvader = new Fleet();
    }
    /**
     * constructor GroupInvaders Con parametro
     *
     * @param xInicial posicion de inicial x del grupo (conde se pondra la
     * primera nave y todas partiran de hay)
     * @param yInicial posicion de inicial y del grupo (conde se pondra la
     * primera nave y todas partiran de hay)
     * @param row filas de invasores que se encontra en el grupo
     * @param column columnas de invasores que se encontra en el grupo
     * @param speed velocidad del grupo
     * @param refreshRateInvaders fps del grupo
     */
    public ControllerGroupOfInvaders(int xInicial, int yInicial, int row, int column, int speed, int refreshRateInvaders) {
        this.groupInvader = new Fleet(xInicial, yInicial, row, column, speed, refreshRateInvaders);
    }
    //------------------Methods------------------------------------------  

    /**
     * mueve las naves gunto con sus disparos a la izquierda dependiendo su
     * velocidad
     */
    public boolean moveGroupLeft() {
        return groupInvader.moveGroupLeft();

    }
    /**
     * mueve las naves gunto con sus disparos a la derecha dependiendo su
     * velocidad
     */
    public boolean moveGroupRight() {
        return groupInvader.moveGroupRight();

    }
    /**
     * mueve las naves gunto con sus disparos a para abajo de una manera unifome
     */
    public boolean moveGroupDown() {
        return groupInvader.moveGroupDown();

    }
    /**
   * Crea el grupo de invasores dado un tamaño parecido a una matriz, es decir
     * si se ingresa una fila y columna (ejem: 2*2 ) se crearan 4 invasores.
     * Otro ejemplo seria una fila y columna (ejem: 3*3) genera 9 invasores
 * @param widthInvader ancho de los invasores
 * @param heightInvader alto de los invasores
 * @param spaceBetweenInvaders espacio entre los invasores
 * @param speedBullet velocidad de la bala de los invasores
 * @param refreshBullet tasa de refresco de las balas
 */
    public void addGroupInvader(int widthInvader,int heightInvader,int spaceBetweenInvaders,int speedBullet,long refreshBullet) {
        groupInvader.addGroupInvader(widthInvader, heightInvader, spaceBetweenInvaders, speedBullet, refreshBullet);
    }
    /**
     * detecta si alguna nave tiene colision con algun muro
     * @param walls grupo de muros por los que las naves peden  pasar
     */
    public void detectionWall(ArrayList<GroupOfWalls> walls){
        groupInvader.detectionWall(walls);
    }
    //--------------------------------------
    
    /**
     * determina cuando quedan menos invasore que velocidad tendran los invasores, solo se activa si el tanque le dio a un invasor
     */
    public void controlOfRefreshRate(){
        groupInvader.controlOfRefreshRate();
    }
    /**
     * dispara aleatoriamente una bala de los invasores
     *
     * @param enemy tanque enemigo al cual le puede afectar
     */
    public int randomShoot() {
        return groupInvader.randomShoot();
    }
    /**
     * a partir de un index(invader) determina que invasor disparara
     * @param invader que va a disparar
     * @param tank tanque al cual la bala le puede hacer daño
     * @return <b>int 0</b> si el disparo puede seguir para adelante sin problema
     *     <br></b>int 1</b> si la bala regresa a su nave invasora
     *     <br></b>int 2</b> si la bala regresa a y le dio al tanque
     *     <br></b>int -1</b> si se elimino el invasor, por tal se elimino el invasor 
     * @see model.GroupOfInvaders/shoot()
     */
    public int shootInvader(int invader, Tank tank, ArrayList<GroupOfWalls> walls) {
        return groupInvader.getInvaders().get(invader).shoot(tank, walls);
    }

    //------------------GetSetters---------------------------------------
    /**
     * obtener el grupo de invasores que usa el objeto
     *
     * @return groupInvader(groupOfInvaders)
     */
    public Fleet getGroupInvader() {
        return groupInvader;
    }
    /**
     * determina el grupo de invasores que usa el objeto
     *
     * @param groupInvader destinado a la clase
     */
    public void setGroupInvader(Fleet groupInvader) {
        this.groupInvader = groupInvader;
    }
    /**
     * retorna un invasor dentro de groupOfInvaders dependiendo su index
     * @param invader idex a buscar
     * @return Invader (model/Invader) invasor el cual se busca
     */
    public Aliens getInvader(int invader) {
        return groupInvader.getInvaders().get(invader);
    }
    //-------------------Override-----------------------------------------

    @Override
    public String toString() {
        return "" + groupInvader; //To change body of generated methods, choose Tools | Templates.
    }

}
