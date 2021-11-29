/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Bloque con los atributos y métodos de la clase Position
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class GameObject {
    private int speed;
    private int x;
    private int y;
    //forma o imagen del objeto
    private ArrayList<Rectangle2D> shapes;
    //limites del campo de juego
    private int limitLeft = 20;
    private int limitRight = 630;
    private int limitUp = 10;
    private int limitDown = 500;
    
//-----------------Constructor---------------------------------------
    /**
     * constructor position null
     */
    public GameObject() {
    }
    /**
     * Constructor position con parametros completos
     * @param x ubicacion principal en el eje c de la position
     * @param y ubicacion principal en el eje y de la position
     */
    public GameObject(int x, int y, int speed) {
        this.speed = speed;
        this.x = x;
        this.y = y;
        shapes = new ArrayList<>();
    }
//------------------Methods-------------------------------------------
    //--------------agregacion de formas
    /**
     * Agrega un forma que pertenecerá a el arrayList(shapes) l
     * @param x posicion de la forma en el eje x
     * @param y posicion de la forma en el eje y
     * @param width anchura de la forma 
     * @param height altura de la forma 
     */
    public void addShape(int x, int y, int width,int height){ 
        Rectangle2D aux = new Rectangle2D.Double(x, y, width, height); 
        shapes.add(aux);
    }
    /**
     * Muestra las formas presentes en el arrayList(shapes) cons sus atributos
     * @return  String con los atributos x,y,ancho,altura de las formas
     */
    public String showShape(){
        String aux = "";
        for (int i = 0; i < shapes.size(); i++) {
            aux += "\n     ----------forma N°"+i+"----------"+
                    "\nVelocidad: "+speed+
                    "\nx: "+shapes.get(i).getX()+
                    "\ny: "+shapes.get(i).getY()+
                    "\nAncho: "+shapes.get(i).getWidth()+
                    "\nAlto: "+shapes.get(i).getHeight();
        }
        return aux;
    }
    /**
     * Elimina todas la formas de atributo(shapes) reiniciado el arrayList
     */
    public void removeShapes(){
          shapes = new ArrayList<>();
    }
    
    //--------------detección de colición
    /**
     * Detecta si un disparo de forma rectangulo(Rectangle2D) colisiona con alguna de las forma del objeto
     * @param shoot (Rectangke2D) el cual puede colisionar con las formas
     * @return <b>True</b> si logro colisionar<br>
     *         </b>false</b> si no logro colisionar
     */
     public boolean collision(Rectangle2D shoot){
         for (Rectangle2D shape : shapes) {
             //System.out.println(shape.getCenterX()+" : "+shape.getCenterY()+"          "+shoot.getCenterX()+"  :   "+shoot.getCenterY());
             //System.out.println(""+shape.intersects(shoot));
             if (shape.intersects(shoot)) {//si alguna forma del objeto(shape) interactua con el disparo (shoot)
                 return true;
             }
         }
         return false;
     }
    
     //------------movimientos
     /**
      * Mueve las formas dadas del objeto dependiendo los pasos, ademas solo se mueve si no pasa el limite
      * @param speed int(Reales positivos) pasos a dar a la izquierda
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que speed es menor igual que 0
      */
     public boolean moveLeft(){ 
         if (verifyLimitLeft()==false) {
              for (Rectangle2D shape : shapes) {
            shape.setRect((shape.getX()-speed), 
                          shape.getY(),
                          shape.getWidth(),
                          shape.getHeight());
            }
             x -= speed;
              return true;
         }else{
               return false;
         }
     
    }
     /**
      * Mueve las formas dadas del objeto dependiendo los pasos, ademas solo se mueve si no pasa el limite
      * @param speed int(Reales positivos) pasos a dar a la derecha
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
      */
     public boolean moveRight(){     
         if (verifyLimitRight()==false) {
                for (Rectangle2D shape : shapes) {
                          shape.setRect((shape.getX()+speed), 
                          shape.getY(),
                          shape.getWidth(),
                          shape.getHeight());
                 }
         x += speed;
             return true;
         }else{
             return false;  
         }
    }
     /**
      * Mueve las formas dadas del objeto dependiendo los pasos, ademas solo se mueve si no pasa el limite
      * @param speed int(Reales positivos) pasos a dar para arriba
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
      */
     public boolean moveUp(){
         if (verifyLimitUp()==false) {
              for (Rectangle2D shape : shapes) {
            shape.setRect(shape.getX(), 
                          (shape.getY()-speed),
                          shape.getWidth(),
                          shape.getHeight());
        }
                y -= speed;
        return true;
         }else{
             return false;  
         }
     }
     /**
      * Mueve las formas dadas del objeto dependiendo los pasos, ademas solo se mueve si no pasa el limite
      * @param speed int(Reales positivos) pasos a dar para abajo
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
      */
     public boolean moveDown(){
         if (verifyLimitDown()==false) {
         
        for (Rectangle2D shape : shapes) {
            shape.setRect(shape.getX(), 
                          (shape.getY()+speed),
                          shape.getWidth(),
                          shape.getHeight());
        } 
        y += speed;
           return true;
         }else{
             return false;  
         }
     }
     
    /**
     * Mueve todos las formas a una posicion x de una forma equilibrada, permitiendo que la forma completa no se dañe
     * @param x destinado al objeto
     */
    public void setXComplete(int x) { 
      
        for (Rectangle2D shape : shapes) {
            shape.setRect(x+(shape.getX()-this.x), shape.getY() , shape.getWidth(), shape.getHeight());
        }
        this.x = x;
    }
    /**
     * Mueve todos las formas a una posicion y de una forma equilibrada, permitiendo que la forma completa no se dañe
     * @param y destinado al objeto
     */
    public void setYComplete(int y) {
      for (Rectangle2D shape : shapes) {
            shape.setRect(shape.getX(), y+(shape.getY()-this.y) , shape.getWidth(), shape.getHeight());
        }
      this.y = y;
    }
    
    //------------deteccion de limites
    /**
      * Verifica si al dar aun paso(xMax+speed) para la derecha dado por el limite derecho(limitRight) se pude avanzar
      * @return <b>True</b> si el movimiento no se pude hacer, por que pasa el limite
      *     <br></b>false</b> si el movimiento se puede hacer
     */
    public boolean verifyLimitRight(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getMaxX()+speed)>=limitRight) {
            return true;
            }
          
        }
        return false;
    }
    /**
     * Verifica si al dar aun paso(x-speed) para la izquierda dado por el limite izquierdo(limitLeft) se pude avanzar
      * @return <b>True</b> si el movimiento no se pude hacer, por que pasa el limite
      *     <br></b>false</b> si el movimiento se puede hacer
     */
    public boolean verifyLimitLeft(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getX()-speed)<=limitLeft) {
            return true;
            }
        }
        return false;
    }
    /**
     * Verifica si al dar aun paso(yMax+speed) para abajo dado por el limite superior(limitUp) se pude avanzar
      * @return <b>True</b> si el movimiento no se pude hacer, por que pasa el limite
      *     <br></b>false</b> si el movimiento se puede hacer
     */
    public boolean verifyLimitDown(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getMaxY()+speed)>=limitDown) {
            return true;
            }
        }
        return false;
    }
    /**
     * Verifica si al dar aun paso(y-speed) para arriba dado por el limite inferior(limitDown) se pude avanzar
      * @return <b>True</b> si el movimiento no se pude hacer, por que pasa el limite
      *     <br></b>false</b> si el movimiento se puede hacer
     */
    public boolean verifyLimitUp(){
        for (Rectangle2D shape : shapes) {
            if ((shape.getY()-speed)>=limitUp) {
            return true;
            }
        }
        return false;
    }
    
 
    
    
//------------------GetSetters----------------------------------------
     
    /**
     * Obtener x del la posicion principal
     * @return int(x)
     */
    public int getX() {
        return x;
    }
    /**
     * Obtener y del la posicion principal
     * @return int (y)
     */
    public int getY() {
        return y;
    }
    /**
     * Destina la x principal del  juego
     * @param x a destianr del objeto
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Destina la y principal del  juego
     * @param y a destianr del objeto
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Obtener el limite del margen izquierdo
     * @return int (limitLeft)
     */
    public int getLimitLeft() {
        return limitLeft;
    }
    /**
     * Determina el limite izquierdo del objero
     * @param limitLeft margen de limite izquierdo
     */
    public void setLimitLeft(int limitLeft) {
        this.limitLeft = limitLeft;
    }
    /**
     * Retorna el limite derecho del juego 
     * @return  int (limitRight)
     */
    public int getLimitRight() {
        return limitRight;
    }
    /**
     * Destina el limite derecho del juego deo objeto
     * @param limitRight 
     */
    public void setLimitRight(int limitRight) {
        this.limitRight = limitRight;
    }
    /**
     * Retorna el limite superior de el juego
     * @return  int(limitUp)
     */
    public int getLimitUp() {
        return limitUp;
    }
    /**
     * Destina el limite superior del juego
     * @param limitUp 
     */
    public void setLimitUp(int limitUp) {
        this.limitUp = limitUp;
    }
    /**
     * Retorna el limite inferior del juego
     * @return  int(limitDown)
     */
    public int getLimitDown() {
        return limitDown;
    }
    /**
     * Destina el limite inferior del juego
     * @param limitDown 
     */
    public void setLimitDown(int limitDown) {
        this.limitDown = limitDown;
    }
    /**
     * Retorna la velocidad de movimiento de el objeto
     * @return int(speed)
     */
    public int getSpeed() {    
        return speed;
    }
    /**
     * Destina la velocidad de el obejto
     * @param speed 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * Retorna las formas del objeto
     * @return ArrayList(Rectangulo)
     */
    public ArrayList<Rectangle2D> getShape() {
        return shapes;
    }
    /**
     * Determina  el arreglo de formas del objeto
     * @param shape arreglo destinado a su modificar en el objeto
     */
    public void setShape(ArrayList<Rectangle2D> shape) {
        this.shapes = shape;
    }
  //-------------------Override-----------------------------------------
    @Override
    public String toString() {
        return  "\nx General: "+getX()
                +"\ny General: "+getY()
                +"\n----------imagen del objeto-----------"+showShape()+"\n\n"
                ;
                
    }
    
    
    
}
