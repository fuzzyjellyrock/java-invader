/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.geom.Rectangle2D;
/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Wall extends Position{
    
    boolean dead  = false; 
//-----------------Constructor---------------------------------------- 
    /**
     * crea un muro vacio
     */
    public Wall() {
    }
    /**
     * crea un muro con una forma inicial
     * @param x posición x dentro de la imagen
     * @param y posición x dentro de la imagen
     * @param width ancho del bloque
     * @param height  alto del bloque
     */
    public Wall(int x, int y, int width, int height){
        super(x, y, 0);//destina la velocidad como 0 
        addShape(x, y, width, height);
    }
 //------------------Methods------------------------------------------
    /**
     * remueve las formas(shapes) del muro y destina e muro como muerto
     */
    public void removeBarrier(){
        removeShapes();
        dead = true;
    }
 //------------------GetSetters----------------------------------------
    /**
     * retorna si esta el muro ya esta muerto o no
    * @return <b>true</b> si el muro sigue vivo ( dead =false)
      *     <br><b>false</b> si el muro esta muerto ( dead=true)
     */
    public boolean isDead() {
        return dead;
    }
 //-------------------Override-----------------------------------------  
}
