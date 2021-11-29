/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.geom.Rectangle2D;

/**
 * Bloque con los atributos y métodos de la clase Tanque
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Ship extends GameObject{
    //disparo del tanque
    private Bullet shoot;
    //vidas y superDisparos del tanque
    private PlayerShip consumable;
    //posicion inicial del tanque 
    private final int xInitial;
    private final int YInitial;
 
    
 //-----------------Constructor---------------------------------------
    /**
     * constructor null de tank
     */
    public Ship() {
       xInitial = 0;
       YInitial = 0;
    }
    /**
    * Crea un tanque con su forma principal (addShape) y crea el disparo con su tasa de movimiento
    * @param x ubicacion inicial en X
    * @param y ubicacion inicial en Y
    * @param width anchura de la forma 
    * @param height altura de la forma 
    * @param speed velocidad del tanque
    * @param speedBullet velocidad de la bala disparada por el tanque
    * @param refreshShoot fps de bala del tanque
    */
    public Ship(int x, int y, int width, int height, int speed,int speedBullet, long  refreshShoot) {
        super(x, y, speed);
        xInitial = x;
        YInitial = y;
        //agrega las formas del tanque
        addShape(x, y, width,  height);
        addShape(x+(width/2)-(width/9), y-4, (width/4), height);
        addShape(x+(width/2)-(width/5), y-2, (width/2), height);
        //creacion disparo 
        shoot = new Bullet( (int)((width/2)+x-1),y, 5 , 6, speedBullet , refreshShoot);
     
    }
    
    //------------------Methods-------------------------------------------
    //-----consumibles
    /**
     * agrega consumibles a el tanque como sus vidas y sus superDisparos
     * @param lives vidas del tanque
     * @param superShoots superDisparos
     * @param x posicion inicial en x
     * @param y posicion inicial en y
     * @param spaceBetweenThem  espacio entre los dos consumibles
     */
    public void addconsumable(int lives, int superShoots,int x, int y, int spaceBetweenThem ){
        consumable = new PlayerShip();
        consumable.shapeHealth( lives, 20, 10, y);
        consumable.shapeSuperShoot( superShoots, 20, x+spaceBetweenThem, y);
    
    }
  
    //----movimiento del tanque
    /**
     * Mueve para la izquierda el tanque y el disparo, si es que el disparo no fue activado ya con anticipacion
     */
    public void moveLeftWithShoot(){
        if (moveLeft()) {
            if (getY() == shoot.getY()) {
            shoot.moveLeftWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala    
            }  
        }  
    }
    /**
     * Mueve para la derecha el tanque y el disparo, si es que el disparo no fue activado ya con anticipacion
     */
    public void moveRightWithShoot(){
        if (moveRight()) {
              if (getY() == shoot.getY()) {
            shoot.moveRightWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala
        }
     }  
    }
   
    //--movimiento de disparo y control del disparo
    /**
    * Dispara hacia arriba la bala del tanque, tomando en cuenta que la bala retornara al tanque, en caso de que colisione con el limite o con un ivader
    * @param enemy el grupo de enmigos al cual le puede afectar la bala
    * @param walls muros a los cuales la bala le puede dar
     * @return <b>-1</b> si no pasa nada y puede seguir la bala adelante
     *         <br></b>0</b> si el disparo choco con una nave
     *         <br></b>1</b> si le dio a un muro
     *         <br></b>2</b> si llego al limite superiro(position/limitUp)
    */
    public int shoot(Fleet enemy){
        
        //retorna -2 ya no hay naves
        //retorna -1 si no paso nada 
        //retorna  0 si choco con una nave
        // retorna 1 si le dio a un muro
        //retorna  2 si llego al limite
  
      if(shoot.moveUpFast()==true){//si llega al fianl del borde (Position/limitUp)
             //deteccion de colisión con el grupo de alienigenas si es mayor a -1 muestra la posición de el invasor dado
             //lo detecta con la primera forma de el objeto (shoot) ya que shoot solo tendra una forma(rectangulo)
            int colision=enemy.collisionDetection(getShoot().getShape().get(0));
            if (colision == -2) {
              return -2;
            }
            if(colision >= 0 ){// si el enemigo en alguna zona detecta el disparo del tanque (colisión==true)
                //System.out.println("colision del tanque a invasor");
                 returnShoot();//retorna la bala
                 return 0;//choco con invasor
            }
            
            return -1;//el disparo sigue normal para delante
        }else{//si el disparo llego al limite retorna la bala a la posición del tanque
         returnShoot();
          return 2;//lego al limite
      }
    }
    /**
     * dispara una bala con menos velocidad y solo retorna si llega al limite 
   * @param enemy el grupo de enmigos al cual le puede afectar la bala
    * @param walls muros a los cuales la bala le puede dar
     * @return <b>-1</b> si no pasa nada y puede seguir la bala adelante
     *         <br></b>0</b> si el disparo choco con una nave
     *         <br></b>1</b> si le dio a un muro
     *         <br></b>2</b> si llego al limite superiro(position/limitUp)
    */
    public int SuperShoot(Fleet enemy){
        
        //retorna -2 ya no hay naves
        //retorna -1 si no paso nada
        //retorna  0 si choco con una nave
        // retorna 1 si le dio a un muro
        //retorna  2 si llego al limite
        
      if(shoot.moveUpMedium()==true){//si llega al fianl del borde (Position/limitUp)
             //deteccion de colisión con el grupo de alienigenas si es mayor a -1 muestra la posición de el invasor dado
             //lo detecta con la primera forma de el objeto (shoot) ya que shoot solo tendra una forma(rectangulo)
            int colision=enemy.collisionDetection(getShoot().getShape().get(0));
            if (colision == -2) {
              return -2;
            }
            if(colision >= 0 ){// si el enemigo en alguna zona detecta el disparo del tanque (colisión==true)
               // System.out.println("colision del tanque a invasor");
                 return 0;//choco con invasor
            }
             
            return -1;//el disparo sigue normal para delante
        }else{//si el disparo llego al limite retorna la bala a la posición del tanque
          return 2;//lego al limite
      }
    }
    /**
     * crea la bala especial para el super disparo(solo si operation es 1) si es 0 
     * @param operation operacion de borrar superDisparo(operatio == 0) o no crear el disparo( operatio ==1)
     */
    public void createOrDestroySuperShoot(int operation){
         
        if (operation == 1) {
         Rectangle2D aux =shoot.getShape().get(0);
            shoot.addShape( (int)aux.getX(), //x
                             (int)aux.getY(), //y
                              5,             //ancho
                               12);          //alto
         shoot.addShape( (int)aux.getX()-2,   //x
                          (int)(aux.getY()+12),//y 
                           10,                //ancho
                            4);                //alto

        }
         if (shoot.getShape().size()==3) {
            if (operation == 0) {
                     shoot.getShape().remove(1);
                     shoot.getShape().remove(1);
         }
        }
         
               
        
    }
    /**
     * Retorna el disparo a su tanque inicial
     * @return int 0 si el paso fue exitoso
     */
    public int returnShoot() {
             //si disparo retorna 
            shoot.setXComplete((int) ((getShape().get(0).getWidth() / 2) + getShape().get(0).getX() - 1));
            shoot.setYComplete((int) getShape().get(0).getMinY());
            return 0;
    }
    
    //-------colisión
   
    /**
    * Detecta si un disparo enemigo en este caso un rectangulo, tuvo colision con el tanque
    * @param enemyShoot disparo dado por el enemigo
    * @return <b>True</b> si tuvo colisión
     *     <br></b>false</b> si no tuvo colisión
    */ 
    public boolean collisionDetection (Rectangle2D enemyShoot){
            if (collision(enemyShoot)==true) {//si el disparo del enemigo le dio a alguna forma del tanque = true 
                //retorna el invasor con colision
                consumable.removeLive();//le quita vida
                return true;
            }
        return false;
    }
    
    //------------------GetSetters----------------------------------------
    
    /**
     * retorna los consumbles de el tanque
     * @return (Consumable)
     */
    public PlayerShip getConsumable() {
        return consumable;
    }
    /**
     * Obtener la clase de disparo del tanque
     * @return Shoot(shoot)
     */
    public Bullet getShoot() {
        return shoot;
    }
    /**
      *Determina el disparo de la clase Shoot 
      * @param shoot destinado a el tanque
      */
    public void setShoot(Bullet shoot) {
        this.shoot = shoot;
    }
    /** 
     * Muestra la ubicacion principal donde siempre comienza el tanque
     * @return int (YInitial)
     */
    public int getYInitial() {
        return YInitial;
    }
    /**
     * Muestra la ubicacion principal donde siempre comienza el tanque
     * @return int (xInitial)
     */
    public int getxInitial() {
        return xInitial;
    }
    
    //-------------------Override-----------------------------------------   

    @Override
    public String toString() {
        return  "---------Posicion-------------"+super.toString()
                +"shoot: "+shoot
                ; 
    }

}
