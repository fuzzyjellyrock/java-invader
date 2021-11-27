/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */

public class Barrier {
    private ArrayList<GroupOfWalls> barrier;
    private int emptySpace;
    private int size;
    
 //-----------------Constructor---------------------------------------- 
    
    /**
     * crea un constructor null de muros (baarrir)
     */
    public Barrier() {
        barrier = new ArrayList<>();
    }
    /**
     *  constructor con parametros de la barrera(barrier)
     * @param emptySpace espacio entre las barreras
     * @param size cantidad de barreras
     */
    public Barrier(int emptySpace, int size) {
        barrier = new ArrayList<>(size);
        this.emptySpace = emptySpace;
        this.size = size;
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
        int x = xInicial;
        for(int i = 0; i < size;i++){//dependiendo la x inicial agrega los grupos de muros(GrouOfWall) una posicion sumando un espacio entre ellos(emptySpace)
            GroupOfWalls aux = new GroupOfWalls(x, yInicial, row, column, width, height);
            barrier.add(aux);
            x = x + (column*width) + emptySpace;
        }
    }
    
 //------------------GetSetters----------------------------------------
    
    /**
     * dependiendo que muro(groupOfWall.get(i)) y que bloque(wall,get(j)) se eliga se usara un metodo que determina si ese bloque esta vivo(shapes.size()>-1) o no
     * @param i index de grupo de muros(groupOfWall)
     * @param j idex de muro(wall)
    * @return <b>Rectangulo2D</b> en caso de encontrar que el muro que este vivo
      *     <br></b>null</b> en caso de que el bloque que busca esta muerto 
     */
    public Rectangle2D getWallAlive(int i, int j){
        return barrier.get(i).getWallAlive(j);
    }
    /**
     * retorna lo barrera de muros( ArrayList"GroupOfWalls")
     * @return barrera de muros( ArrayList"GroupOfWalls")
     */
    public ArrayList<GroupOfWalls> getBarrier() {
        return barrier;
    }
    /**
     * retorna el espacio vacio entre cada grupo de muros
     * @return (EmptySpace)
     */
    public int getEmptySpace() {
        return emptySpace;
    }
    /**
     * destian el espacio vacio entre los muros
     * @param emptySpace entre los muros(groupOfWall)
     */
    public void setEmptySpace(int emptySpace) {
        this.emptySpace = emptySpace;
    }
    /**
     * retorna la cantidad de grupos de muros que tiene la barrera
     * @return int con la cantidad de groupOfWall.size
     */
    public int getSize() {
        return size;
    }
    /***
     * destina la cantidad de muros que tendra la barrera
     * @param size tamaño de la barrera
     */
    public void setSize(int size) {
        this.size = size;
    }
 //-------------------Override-----------------------------------------   
}
