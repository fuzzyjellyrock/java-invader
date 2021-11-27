/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barrier;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author User
 */
public class BarrierController {
    private Barrier barrier;
    //-----------------Constructor---------------------------------------- 
    /**
     * crea un constructor null de muros (baarrir)
     */
    public BarrierController() {
    }
    /**
     *  constructor con parametros de la barrera(barrier)
     * @param emptySpace espacio entre las barreras
     * @param size cantidad de barreras
     */
    public BarrierController(int size, int emptySpace) {
        barrier = new Barrier(emptySpace, size);
        
    }
    //------------------Methods-------------------------------------------
    
    /**
     * creador de muros dependiendo el espacio entre ellos y la cantidad que quiere el usuario
     * @param xInicial posición x donde comenzarán los muros(barrier)
     * @param yInicial posición y donde comenzarán los muros(barrier)
     * @param row cantidad de filas de bloques(wall) que tendra cada muro
     * @param column cantidad de columnas de bloques(wall) que tendra cada muro
     * @param width ancho de los blques(wall)
     * @param height alto de los bloques(wall)
     */
    public void addGroupOfWalls(int xInicial, int yInicial, int row, int column, int width, int height){
        barrier.addGroupOfWalls(xInicial, yInicial, row, column, width, height);
    }
    
    //------------------GetSetters----------------------------------------
    /**
     * retorna una la barrera usada en el objeto
     * @return (barrier)
     */
    public Barrier getBarrier() {
        return barrier;
    }
    /**
     * destiana la barrera usada en el objeto
     * @param barrier barrera destiana al objeto
     */
    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }
    /**
     * obtener filas de un determinado groupOfWall
     * @param i  index para buscar grupo de muros
     * @return int filas de el grupo de muros
     */
    public int getRow(int i){
        return barrier.getBarrier().get(i).getRow();
    }
    /**
     * obtener columnas de un determinado groupOfWall
     * @param i  index para buscar grupo de muros
     * @return int columnas -de el grupo de muros
     */
    public int getColumn(int i){
        return barrier.getBarrier().get(i).getColumn();
    }
    /**
     * buscar un muro(wall) en un determinado  grupo de muros(groupOfWall) y saber si esta mierto
       * @param i index de grupo de muros(groupOfWall)
     * @param j idex de muro(wall)
    * @return <b>Rectangulo2D</b> en caso de encontrar que el muro que este vivo
      *     <br></b>null</b> en caso de que el bloque que busca esta muerto 
     */
    public Rectangle2D getWallAlive(int i, int j){
        return barrier.getWallAlive(i, j);
    }
}
 //-------------------Override-----------------------------------------   
