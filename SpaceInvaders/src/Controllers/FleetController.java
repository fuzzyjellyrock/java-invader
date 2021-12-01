/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Alien;
import Models.Ship;
import Models.Fleet;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Controlador para el grupo de invasores
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class FleetController {

    private Fleet fleet;

    //-----------------Constructor----------------------------------------
    /**
     * constructor de GroupInvaders null
     */
    public FleetController() {
        this.fleet = new Fleet();
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
     * @param refreshRateInvaders fps del grupo
     */
    public FleetController(int refreshRateInvaders) {
        this.fleet = new Fleet(refreshRateInvaders);
    }
    //------------------Methods------------------------------------------  

    public void setRowsAndColumns(int level){
        this.fleet.setRowsAndColumns(level);
    }
    
    public void addBoss(long refreshRate){
        this.fleet.addBoss(refreshRate);
    }
    
    /**
     * mueve las naves gunto con sus disparos a la izquierda dependiendo su
     * velocidad
     */
    public boolean moveGroupLeft() {
        return fleet.moveGroupLeft();

    }
    /**
     * mueve las naves gunto con sus disparos a la derecha dependiendo su
     * velocidad
     */
    public boolean moveGroupRight() {
        return fleet.moveGroupRight();

    }
    /**
     * mueve las naves gunto con sus disparos a para abajo de una manera unifome
     */
    public boolean moveGroupDown() {
        return fleet.moveGroupDown();

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
    public void addGroupInvader(int refreshBullet) {
        fleet.createAliens(refreshBullet);
    }
    
    //--------------------------------------
    
    /**
     * determina cuando quedan menos invasore que velocidad tendran los invasores, solo se activa si el tanque le dio a un invasor
     */
    public void controlOfRefreshRate(){
        fleet.refreshRateControl();
    }
    /**
     * dispara aleatoriamente una bala de los invasores
     *
     * @param enemy tanque enemigo al cual le puede afectar
     */
    public int randomShoot() {
        return fleet.randomShots();
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
    public int shootInvader(int invader, Ship tank) {
        return fleet.getInvaders().get(invader).shoot(tank);
    }

    //------------------GetSetters---------------------------------------
    /**
     * obtener el grupo de invasores que usa el objeto
     *
     * @return groupInvader(groupOfInvaders)
     */
    
    public int getAliensListSize(){
        return this.fleet.getAliensListSize();
    }
    
    public ArrayList<Rectangle2D> getAlienShapes(int index){
        return this.fleet.getAlienShapes(index);
    }
    
    public ArrayList<Rectangle2D> getAlienBulletShape(int index){
        return this.fleet.getAlienBulletShape(index);
    }
    
    public Color getFleetColor() {
        return fleet.getColor();
    }
    
    public Color getFleetSecondColor() {
        return fleet.getSecondColor();
    }
    
    public Fleet getFleet() {
        return fleet;
    }
    /**
     * determina el grupo de invasores que usa el objeto
     *
     * @param groupInvader destinado a la clase
     */
    public void setGroupInvader(Fleet groupInvader) {
        this.fleet = groupInvader;
    }
    /**
     * retorna un invasor dentro de groupOfInvaders dependiendo su index
     * @param alienIndex idex a buscar
     * @return Invader (model/Invader) invasor el cual se busca
     */
    public Alien getAlien(int alienIndex) {
        return fleet.getInvaders().get(alienIndex);
    }
    
    public int getAlienYCoord(int alienIndex) {
        return fleet.getInvaders().get(alienIndex).getY();
    }
    
    public int getAlienBulletYCoord(int alienIndex) {
        return fleet.getInvaders().get(alienIndex).getBullet().getY();
    }
    
    public int getAliensAlive() {
        return fleet.getAliensAlive();
    }
    
    //-------------------Override-----------------------------------------

    @Override
    public String toString() {
        return "" + fleet; //To change body of generated methods, choose Tools | Templates.
    }

}
