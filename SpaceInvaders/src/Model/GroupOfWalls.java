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
public class GroupOfWalls {
    
    private ArrayList<Wall> wall;
    private final int xInicial;
    private final int yInicial;
    private int row;
    private int column;
 //-----------------Constructor----------------------------------------     
    /**
     * crea un grupo de muros vacio
     */
    public GroupOfWalls() {
        xInicial = 0;
        yInicial = 0;
    }
    /**
     * crea un grupo de muros con parametros
     * @param xInicial posición x donde comenzarán los muros(wall)
     * @param yInicial posición y donde comenzarán los muros(wall)
     * @param row cantidad de filas de bloques(wall) que tendra cada muro
     * @param column cantidad de columnas de bloques(wall) que tendra cada muro
     * @param width ancho de los blques(wall)
     * @param height alto de los bloques(wall)
     */
    public GroupOfWalls(int xInicial, int yInicial, int row, int column, int width, int height) {

        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.row = row;
        this.column = column;
        wall = new ArrayList<>();
        addGroupofWalls(width, height);//crea las formas de los bloques 
    }
    
 //------------------Methods-------------------------------------------  
    
    /**
     * Crea el grupo de muros(Wall) dado un tamaño parecido a una matriz, es decir
     * si se ingresa una fila y columna (ejem: 2*2 ) se crearan 4 muros.
     * Otro ejemplo seria una fila y columna (ejem: 3*3) genera 9 muros.
     * @param wallWidth tamaño(ancho) de los muros
     * @param wallHeight tamaño(largo) de los muros
     */
    public void addGroupofWalls(int wallWidth, int wallHeight){
        int inicioX = xInicial;
        int inicioY = yInicial;
        int width = wallWidth;
        int height = wallHeight;
        for (int f = 0; f < row; f++) {
            for(int c = 0; c < column; c++){
                addWall(inicioX, inicioY, width, height);
                inicioX += width;
            }
            inicioX = xInicial;
            inicioY += height;
        } 
    }
    /**
      * agrega un muro(wall) dependiendo los parametros
      * @param x posicion en x dentro de la imagen
      * @param y posicion en y dentro de la imagen
      * @param width ancho de los bloques(wall)
      * @param height alto de los bloques(wall)
      */
    public void addWall(int x, int y, int width, int height){
        Wall wall = new Wall(x, y, width, height);
        wall.addShape(x, y, width, height);
        this.wall.add(wall);
    }
    /**
     * detecta si algu bloque es dado por un disparo o forma Rectangle2D dentro de la imagen
     * @param disparo forma Rectangle2D con posible colision
     * @param delete determina si queremos eliminar o no la muro si tiene colsión
    * @return <b>-1</b> en caso de no encontrar colision con algun bloques de groupOfWall
      *     <br></b>int(con la posicion del bloque dado</b> en caso de si tenga colision
     */ 
    public int colisiones(Rectangle2D disparo,boolean delete) {
       
        for (int i = 0; i < wall.size(); i++) {
            if (wall.get(i).collision(disparo) == true) {
                 if(delete == true){
                   wall.get(i).removeBarrier();   
                }
                
                return i;
            }
        }
        return -1;
    }
    
 //------------------GetSetters----------------------------------------
    
    /**
     * retorna una forma(Rectangulo2D) en caso de que el muro(wall) no este destruido
     * @param i muro(wall) a buscar
        * @return <b>Rectangulo2D</b> en caso de encontrar que el muro que este vivo
      *     <br></b>null</b> en caso de que el bloque que busca esta muerto
     */
    public Rectangle2D getWallAlive(int i) {
         if (wall.get(i).isDead()==false) {//si no esta muerto
            return wall.get(i).getShape().get(0);
         }
         return null;
    }
    
    /**
     * retorna el grupo de muros
     * @return (ArrayList-Wall)
     */
    public ArrayList<Wall> getGroupOfWall() {
        return wall;
    }
    /**
     * retorna el tamaño de groupOfWall( es decir todos los muros(wall) que tiene)
     * @return int (grouOfWall)
     */
    public int getGroupWallSize(){
         return wall.size();    
     }
    /**
     * retorna la fila de bloques(wall) de el objeto
     * @return inr(row)
     */
    public int getRow() {
        return row;
    }
    /**
     * destina las filas de bloques(wall) de el grupo de muros
     * @param row filas del objeto
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * retorna las columnas del objeto
     * @return int(column)
     */
    public int getColumn() {
        return column;
    }
    /**
     * destina las columnas del objeto
     * @param column del objeto
     */
    public void setColumn(int column) {
        this.column = column;
    }
    
 //-------------------Override-----------------------------------------   

}
