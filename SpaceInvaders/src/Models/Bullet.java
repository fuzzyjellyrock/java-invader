/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * Bloque con los atributos y métodos de la clase Shoot (Disparo)
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Bullet extends ObjectShapes {
        
    private long refreshRate; 
    
    final float[] colorSelect = Color.RGBtoHSB(0,255,7, null);
    final Color defaultColor = Color.getHSBColor(colorSelect[0], colorSelect[1], colorSelect[2]);
 //-----------------Constructor----------------------------------------
    public Bullet(){
        
    }
    
    /**
     * constructor null de shoot
     */
    public Bullet(int x, int y, int width, int height) {
        super(x, y, 0);
        addShape(x, y, width, height);
    }
   /**
   * Crea un disparo agregando su posición y tamaño de una vez
   * @param velocity la cual tendra el shoot
   * @param x posicion de el shoot en el eje x
   * @param y posicion de el shoot en el eje y
   * @param high altura de el rectangulo el cual formara el shoot
   * @param width anchura de el rectangulo el cual formara el shoot
   */  
    public Bullet( int x, int y, int width, int height, int speed, long refreshRate) {
        super(x, y,speed);
        this.refreshRate = refreshRate;
        addShape(x, y, width, height);
    }
 //------------------Methods-------------------------------------------
    
    //ya que la bala no simpre se va a mover rapido, aplicamos una velocidad temporal a las balas, las movemos y dejamos su velocidad como era antes
    /**
     * Mueve el disparo para arriba modificando su velocidad temporalmente, al terminar su velocidad se repone a su anterior
     * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento 
     */
    public boolean moveUpWithSpeed(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveUp();
        setSpeed(nomalSpeed);
        return result;
    }
    /**
     * Mueve el disparo para abajo modificando su velocidad temporalmente, al terminar su velocidad se repone a su anterior
     * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento 
     */
    public boolean moveDownWithSpeed(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveDown();
        setSpeed(nomalSpeed);
        return result;
        
    }
    /**
     * Mueve el disparo para la izquierda modificando su velocidad temporalmente, al terminar su velocidad se repone a su anterior
     * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento 
     */
    public boolean moveLeftWithSpeed(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveLeft();
        setSpeed(nomalSpeed);
        return result;
        
    }
    /**
     * Mueve el disparo para la derecha modificando su velocidad temporalmente, al terminar su velocidad se repone a su anterior
     * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento 
     */
    public boolean moveRightWithSpeed(int speed){
        int nomalSpeed = getSpeed();
        setSpeed(speed);
        boolean result = moveRight();
        setSpeed(nomalSpeed);
        return result;
        
    }

    //si un tanque,o un invasor dispara su disparo(shoot) la velocidad y RefreshRate sera diferente a un movimiento comun, como(Position/moveDown)
    /**
     * Se usa cuando se dispara la bala, el cual saldra para arriba con una demora dependiedo su velocidad(spped) y dependiendo su tasa de movimiento(refreshRate)
     * @param speed int(Reales positivos) pasos a dar para arriba
     * @return <b>True</b> si el movimiento fue exitoso
     *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
     */
     public boolean moveUpFast() {
        for (Rectangle2D shape : getShapes()) {//buscar en cada forma de el disparo
            if (((shape.getY()-getSpeed())<=getLimitUp()) || getSpeed()<=0) {//si no se pasa del limite
                return false;//si pasa ya no se puede mover para arriba
            }
        }
        //si puede ir arriba mover todas las formas faltantes
        try {Thread.sleep(refreshRate); } catch (Exception e) { System.out.println("error mover derecha"+e);}   
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(),
                    (shape.getY()-getSpeed()),
                    shape.getWidth(),
                    shape.getHeight());
        }
        setY(getY()-getSpeed());
        return true;
    }
    /**
     * permite que la bala se mueva con una tasa de frefresco un medio mas rapido que las otras balas(por tal se mueve mas lento la bala)
     * @return <b>True</b> si el movimiento fue exitoso
     *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
     */
     public boolean moveUpMedium() {
        for (Rectangle2D shape : getShapes()) {//buscar en cada forma de el disparo
            if (((shape.getY()-getSpeed())<=getLimitUp()) || getSpeed()<=0) {//si no se pasa del limite
                return false;//si pasa ya no se puede mover para arriba
            }
        }
        //si puede ir arriba mover todas las formas faltantes
        try {Thread.sleep(refreshRate+(refreshRate)); } catch (Exception e) { System.out.println("error mover derecha"+e);}   
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(),
                    (shape.getY()-getSpeed()),
                    shape.getWidth(),
                    shape.getHeight());
        }
        setY(getY()-getSpeed());
        return true;
    }
    /**
      * Se usa cuando se dispara la bala, el cual saldra para abajo con una demora dependiedo su velocidad(spped) y dependiendo su tasa de movimiento(refreshRate)
      * @param speed int(Reales positivos) pasos a dar para abajo
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que steps es menor igual que 0
      */
     public boolean moveDownFast(){
         for (Rectangle2D shape : getShapes()) {
             if (((shape.getMaxY()+getSpeed())>=getLimitDown()) || getSpeed()<=0) {//si el paso a dar no se puede 
             return false;
            }
         }
         try {Thread.sleep(refreshRate); } catch (Exception e) { System.out.println("error mover derecha"+e);}    
        for (Rectangle2D shape : getShapes()) {
            shape.setRect(shape.getX(), 
                          (shape.getY()+getSpeed()),
                          shape.getWidth(),
                          shape.getHeight());
        } 
        setY(getY()+getSpeed());
        return true;
     }
     
     
    //------------------GetSetters----------------------------------------
    /**
     * Retorna tasa de movimiento durante segundos de la bala al dispararse
     * @return long (refreshRate)
     */
    public long getRefreshRate(){
        return refreshRate;
     }
    /**
     * Destinar la tasa de fps 
     * @param refreshRate (Long) destiando a el objeto
     */
    public void setRefreshRate(long refreshRate) {
        this.refreshRate = refreshRate;
    }

    //-------------------Override-----------------------------------------

    @Override
    public String toString() {
        return "\n---------Posicion Disparo-------------"+super.toString()
                ; 
    }

  
}
