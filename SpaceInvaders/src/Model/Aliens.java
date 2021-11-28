/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
//Holaaa
//Holaaaaa
/**
 * Bloque con los atributos y métodos de la clase Invader
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Aliens extends Position {

    private Shoot shoot;
    private boolean dead  = false;

//-----------------Constructor-----------------------------------------
    /**
     * constructor null de invasor
     */
    public Aliens() {
    }

    /**
     * Crea el invasor con su posicion inicial, su forma inicial, su disparo con
     * la tasa de movimiento
     * @param x posicion en x del invader
     * @param y posicion en y del invader
     * @param width anchura del rectangulo conformado por el invader
     * @param height anchura del rectangulo conformado por el invader
     * @param speed velocidad del invader
     * @param speedBullet velocidad de la bala del invader
     * @param refreshShoot fps de el invasor
     */
    public Aliens(int x, int y, int width, int height, int speed, int speedBullet, long refreshShoot) {
        super(x, y, speed);
        

        //creacion de la bala 
        shoot = new Shoot((int) ((width / 2) + x - 1), y, 3, 5, speedBullet, refreshShoot);
    }
    //------------------Methods-------------------------------------------
    //movimiento de el invasor
    /**
     * Mueve la nave junto con la bala la izquierda. La bala solo se mueve con la nave, si la bala se encuentra dentro de la nave(nave.y == shoot.y)
      * @return <b>True</b> si el movimiento fue exitoso ( no importa si no se movio la bala)
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que speed es menor igual que 0
     */
    public boolean moveLeftWithShoot() {
        if (moveLeft()) {
            if (getY() == shoot.getY()) {
                shoot.moveLeftWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala    
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Mueve la nave junto con la bala a la derecha. La bala solo se mueve con la nave, si la bala se encuentra dentro de la nave(nave.y == shoot.y)
      * @return <b>True</b> si el movimiento fue exitoso ( no importa si no se movio la bala)
      *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que speed es menor igual que 0
     */
    public boolean moveRightWithShoot() {
        if (moveRight()) {
            if (getY() == shoot.getY()) {
                shoot.moveRightWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala
            }
            return true;
        } else {
            return false;
        }
    }    
    /**
     * Mueve la nave junto con la bala para abajo. La bala solo se mueve con la nave, si la bala se encuentra dentro de la nave(nave.y == shoot.y)
     * NOTA:si la bala se mueve con la nave hay que modificar la velcidad de la bala para abajo, ya que le velocidad de la bala para abajo es rapida
     * @return <b>True</b> si el movimiento fue exitoso ( no importa si no se movio la bala)
     *     <br></b>false</b> si el movimiento no se pudo por limites de movimiento o por que speed es menor igual que 0
     */
    public boolean moveDownWithShoot() {

        if (moveDown()) {
            if (getY() - getSpeed() == shoot.getY()) {
                shoot.moveDownWithSpeed(getSpeed());//debe mover la bala no a la velocidad de la bala, sino a la velocidad del invasor
            }
            return true;
        } else {
            return false;
        }
    }
    
    //detección con los muros
    /**
     * detecta si alguna de las formas del invasor choca con un los grupos de muros
     * @param walls grupo de muros a los que se puede chocar el invasor 
      * @return <b>true </b> si tiene colision la nave con algun muro
     *     <br></b>false</b> si la nave no tiene colisión
     */
    public boolean wallMoveDetection(ArrayList<GroupOfWalls> walls){
            for(int i = 0; i < getShape().size();i++){
                for (int j = 0; j <walls.size(); j++) {
                           if( walls.get(j).colisiones(getShape().get(i),true)>= 0 ){//detecta si un disparo le dio a un determinado grupo de muros(groupOfWall)
                return true;
            }
          }
        } 
        return false;
       
    }
    /**
     * detecta si el disparo le dio a una parte de un grupo de muros
     * @param walls grupo de muros a los que las balas les puede afectar
      * @return <b>True</b> si choco con algun muro
      *     <br></b>false</b> si no choca con ningun muro
     */
    public boolean wallShootDetection(ArrayList<GroupOfWalls> walls) {
        for(int i = 0; i < walls.size();i++){
            if( walls.get(i).colisiones(shoot.getShape().get(0),true)>= 0 ){//detecta si un disparo le dio a un determinado grupo de muros(groupOfWall)
                return true;
            }
        } 
        return false;
    }
    
    /**
     * Dispara al tanque enemigo moviendo la bala un paso para abajo dependiendo su velocidad y fps, una vez ya en el aire detecta si choco o con el límite, o con el tanque.
     * este metodo usa el metodo removeOrShoot para remover la bala o meverla a una determinda posicion
     * 
     * Nota: hay que tener en cuenta que si el tanque le dio a la nave que disparo, la bala desparece al contacto
     * 
     * @param enemy enemigo al cual le puede afectar la bala
     * @return <b>int 0</b> si el disparo puede seguir para adelante sin problema
     *     <br></b>int 1</b> si la bala regresa a su nave invasora
     *     <br></b>int 2</b> si la bala regresa a y le dio al tanque
     *     <br></b>int -1</b> si se elimino el invasor, por tal se elimino el invasor 
     * @see Invader/removeOrMoveShoot()
     */
    public int shoot(Tank enemy, ArrayList<GroupOfWalls> walls) {
        /*
        retorna 0 si el el diparo va normal}
        retorna 1 cuando regresa el disparo al invasor normal
        retora -1 elimina invasor
         */
        try {
           if (shoot.moveDownFast() == true) {//si la bala puede bajar
             //_________________
            if (enemy.collisionDetection(shoot.getShape().get(0)) ) {//si detecta colisión con el tanque o si detecta colisión con un muro
                // System.out.println("Hubo colision tanque");
                 removeOrMoveShoot();//elimina el invasor si la bala no sigue, pero si bala sigue eliminia al invader cuando la bala colisione
                return 1;//le dio a tanque
            }
            if (wallShootDetection(walls) == true) {//si detecta colisión con el tanque o si detecta colisión con un muro
                 //System.out.println("Hubo colision con muro");
                 removeOrMoveShoot();//elimina el invasor si la bala no sigue, pero si bala sigue eliminia al invader cuando la bala colisione
                return 2;//le dio a muro
            }
            //_________________
            return 0;//si el disparo sigue normal
            
        } else {//si no puede bajar, por tal llego al limite
               removeOrMoveShoot();
            return -1;//si llego al limite
        } 
        } catch (Exception e) {
             removeOrMoveShoot();
            return -1;
        }
          
    }
 
    //remover nave
    /**
     * Si el invasor tiene alguna forma retorna la bala a la posicion de su invasor, si no elimina la bala y termina eliminando todo el invasor
      * @return <b>int -1</b> si el disparo ya no tiene donde regresar por tal desaparece el disparo
     *     <br></b>int 1</b> si la bala regresa a su nave invasora
     */
    public int removeOrMoveShoot() {
        
        if (getShape().size() == 0) {//si no tiene forma el invasor, elimina todo de este invasor ya..
            removeAllShape();
            return -1;
        } else {//si el invasor tiene forma, retornalo a su forma inicial
            shoot.setXComplete((int) ((getShape().get(0).getWidth() / 2) + getShape().get(0).getX() - 1));
            shoot.setYComplete((int) getShape().get(0).getY());
            return 1;
        }

    }
    /**
     * Forma de eliminar el invasor del juego, eliminado sus formas y dandolo por muerto (dead =true)
     */
    public void removeAllShape(){
        removeShapes();
        shoot.removeShapes();
        dead = true;
    }
    /**
     * En caso de que se quiera dar por muerta la nave pero no se quiera eliminr el disparo usar este metodo
     */
    public void removeOnlyShip(){
        removeShapes();
        dead = true;
    }

    //------------------GetSetters----------------------------------------
    /**
     * Obtener la clase de disparo del invasor
     *
     * @return Shoot(shoot)
     */
    public Shoot getShoot() {
        return shoot;
    }
    /**
     * Determina el disparo de la clase Shoot
     *
     * @param shoot destinado a el invasor
     */
    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }
    /**
     * Retorna si un invasor esta muerto o no
     * @return <b>True</b> si la nave esta muerta
     *     <br></b>false</b> si la nave no esta muerta
     */
    public boolean isDead() {
        return dead;
    }
    /**
     * Destina si el invasor esta muerto o no 
     * @param dead boolean destinado al objeto
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    //-------------------Override-----------------------------------------    
    @Override
    public String toString() {
        return "\n---------Posicion-------------" + super.toString()
                + shoot;
    }

}
