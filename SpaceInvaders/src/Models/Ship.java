/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Bloque con los atributos y métodos de la clase Tanque
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Ship extends GraphicsObject{
    
    final int speed = 15;
    
    private int livesCount;
    private ArrayList<Ship> lives;

    //disparo del tanque
    private Bullet bullet;
    private final int bulletSpeed = 7;
    private final int bulletRefreshRate = 7;
    
    private int missilesCapacity;
    private ArrayList<Bullet> missiles;
    
    //Ship size
    private final int width = 25;
    private final int height = 10;
    
    final float[] colorSelector = Color.RGBtoHSB(0,255,7, null);
    final Color defaultColor = Color.getHSBColor(colorSelector[0], colorSelector[1], colorSelector[2]);
    
 //-----------------Constructor---------------------------------------    
    /**
     * Status bar Ship Shape constructor.
     */
    public Ship(int xInitPosition, int yInitPosition) {
        super(xInitPosition, yInitPosition, 0);
        
        //agrega las formas del tanque
        addShape(xInitPosition, yInitPosition, width,  height);
        addShape(xInitPosition+(width/2)-(width/9), yInitPosition-4, (width/4), height);
        addShape(xInitPosition+(width/2)-(width/5), yInitPosition-2, (width/2), height);
        
        setColor(defaultColor);
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
    public Ship(int xInitPosition, int yInitPosition, int speed) {
        super(xInitPosition, yInitPosition, speed);
        setSpeed(this.speed);
        //agrega las formas del tanque
        addShape(xInitPosition, yInitPosition, width,  height);
        addShape(xInitPosition+(width/2)-(width/9), yInitPosition-4, (width/4), height);
        addShape(xInitPosition+(width/2)-(width/5), yInitPosition-2, (width/2), height);
        
        //creacion disparo 
        this.bullet = new Bullet( (int)((width/2)+xInitPosition-1),yInitPosition, 5 , 6, bulletSpeed , bulletRefreshRate);
        
        this.livesCount = 3;
        this.missilesCapacity = 4;
        
        this.lives = new ArrayList<>();
        this.missiles = new ArrayList<>();
        
        setColor(defaultColor);
    }
    
    //------------------Methods-------------------------------------------
    //-----consumibles
    /**
     * agrega consumibles a el tanque como sus vidas y sus superDisparos
     * @param x posicion inicial en x
     * @param y posicion inicial en y
     * @param separator  espacio entre los dos consumibles
     */
    public void setShipHealth(int level){
        switch (level) {
            case 1:
              this.livesCount = 3;
              break;
            case 2:
              this.livesCount = 4;
              break;
            case 3:
              this.livesCount = 5;
              break;
            default:
              this.livesCount = 1;
        }
    }
    
    public void setShipMissiles(int level){
        switch (level) {
            case 1:
              this.missilesCapacity = 4;
              break;
            case 2:
              this.missilesCapacity = 6;
              break;
            case 3:
              this.missilesCapacity = 8;
              break;
            default:
              this.missilesCapacity = 1;
        }
    }
    
    /**
     * Adds the lives (empty ships) to the ship lives list.
     */
    public void addLivesShapes(){
        for (int i = 0; i < this.livesCount; i++) {
            this.lives.add(new Ship(0, 0));
        }
    }
    
    public void addMissiles(){
        for (int i = 0; i < this.missilesCapacity; i++) {
            this.missiles.add(new Bullet());
        }
    }
    
    public boolean removeLive(){
        if (this.getLivesCount() > 0 ) {
            this.lives.remove(this.lives.size()-1);
            this.livesCount--;
            //System.out.println("lives inside ship: "+this.livesCount);
            return true;
        }else{
        return false;    
        }
    }

    public boolean removeMissile(){
        if (this.getMissilesCapacity() > 0 ) {
            this.missiles.remove(this.missiles.size()-1);
            this.missilesCapacity--;
            //System.out.println("missiles inside ship: "+this.missilesCapacity);
            return true;
        }else{
        return false;    
        }
        
    }
  
    //----movimiento del tanque
    /**
     * Mueve para la izquierda el tanque y el disparo, si es que el disparo no fue activado ya con anticipacion
     */
    public void moveLeftWithShoot(){
        if (moveLeft()) {
            if (getY() == bullet.getY()) {
            bullet.moveLeftWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala    
            }  
        }  
    }
    /**
     * Mueve para la derecha el tanque y el disparo, si es que el disparo no fue activado ya con anticipacion
     */
    public void moveRightWithShoot(){
        if (moveRight()) {
              if (getY() == bullet.getY()) {
            bullet.moveRightWithSpeed(getSpeed());//mueve el disparo del tanque sin modificar la velocidad real de la bala
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
  
      if(bullet.moveUpFast()==true){//si llega al fianl del borde (Position/limitUp)
             //deteccion de colisión con el grupo de alienigenas si es mayor a -1 muestra la posición de el invasor dado
             //lo detecta con la primera forma de el objeto (shoot) ya que shoot solo tendra una forma(rectangulo)
            int colision=enemy.collisionDetection(getBullet().getShapes().get(0));
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
    public int launchMissile(Fleet enemy){
        
        //retorna -2 ya no hay naves
        //retorna -1 si no paso nada
        //retorna  0 si choco con una nave
        // retorna 1 si le dio a un muro
        //retorna  2 si llego al limite
        
      if(bullet.moveUpMedium()==true){//si llega al fianl del borde (Position/limitUp)
             //deteccion de colisión con el grupo de alienigenas si es mayor a -1 muestra la posición de el invasor dado
             //lo detecta con la primera forma de el objeto (shoot) ya que shoot solo tendra una forma(rectangulo)
            int colision=enemy.collisionDetection(getBullet().getShapes().get(0));
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
    public void createDestroyMissile(int operation){
         
        if (operation == 1) {
         Rectangle2D aux =bullet.getShapes().get(0);
            bullet.addShape( (int)aux.getX(), //x
                             (int)aux.getY(), //y
                              5,             //ancho
                               12);          //alto
         bullet.addShape( (int)aux.getX()-2,   //x
                          (int)(aux.getY()+12),//y 
                           10,                //ancho
                            4);                //alto

        }
         if (bullet.getShapes().size()==3) {
            if (operation == 0) {
                     bullet.getShapes().remove(1);
                     bullet.getShapes().remove(1);
         }
        }
         
               
        
    }
    /**
     * Retorna el disparo a su tanque inicial
     * @return int 0 si el paso fue exitoso
     */
    public int returnShoot() {
             //si disparo retorna 
            bullet.setXComplete((int) ((getShapes().get(0).getWidth() / 2) + getShapes().get(0).getX() - 1));
            bullet.setYComplete((int) getShapes().get(0).getMinY());
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
                removeLive();//le quita vida
                return true;
            }
        return false;
    }
    
    //------------------GetSetters----------------------------------------
    
    /**
     * Obtener la clase de disparo del tanque
     * @return Shoot(shoot)
     */
    public Bullet getBullet() {
        return bullet;
    }
    
    public ArrayList<Rectangle2D> getBulletShapes() {
        return bullet.getShapes();
    }
    
    /**
      *Determina el disparo de la clase Shoot 
      * @param shoot destinado a el tanque
      */
    public void setShoot(Bullet shoot) {
        this.bullet = shoot;
    }
    
    //-------------------Override-----------------------------------------   

    @Override
    public String toString() {
        return  "---------Posicion-------------"+super.toString()
                +"shoot: "+bullet
                ; 
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the bulletSpeed
     */
    public int getBulletSpeed() {
        return bulletSpeed;
    }

    /**
     * @return the bulletRefreshRate
     */
    public int getBulletRefreshRate() {
        return bulletRefreshRate;
    }

    /**
     * @return the lives
     */
    public ArrayList<Ship> getLives() {
        return lives;
    }

    /**
     * @return the missiles
     */
    public ArrayList<Bullet> getMissiles() {
        return missiles;
    }

    /**
     * @return the livesCount
     */
    public int getLivesCount() {
        return livesCount;
    }

    /**
     * @return the missilesCapacity
     */
    public int getMissilesCapacity() {
        return missilesCapacity;
    }
}
