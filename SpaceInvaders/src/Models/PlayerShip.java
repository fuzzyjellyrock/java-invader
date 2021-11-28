/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class PlayerShip {
    
    //vidas del lives
    private ArrayList< Ship > lives;
    private int livesSize ;
    private int emptySpaceLives ;
    //super disparos
    private ArrayList< Bullet > superShoot;
    private int superShootsSize;
    private int emptySpaceSuperShoot ;
    
    //-----------------Constructor---------------------------------------- 
     /**
     * constructor de lives null
     */
     public PlayerShip() {
        this.lives = new ArrayList<>();
        this.superShoot = new ArrayList<>();
    }
     /**
      * cosntructor creador de vidas de lives
      * @param livesSize cantidad de vidas
      * @param emptySpace espacio entre las vidas
      * @param x posicion inicial x de las vidas
      * @param y  posicion inicial y de las vidas 
      */
     public void shapeHealth( int livesSize, int emptySpace,int x, int y) {
        this.livesSize = livesSize;
        this.emptySpaceLives = emptySpace;
         
        addShapeLive(x, y);
    }
     /**
      * constructor creador de superDisparos (superShoot)
      * @param superShootSize cantidad de super diparos
      * @param emptySpaceSuperShoot espacio entre los super disparos
         * @param x posicion inicial x de los super disparos
      * @param y  posicion inicial y de los super disparos
      */
     public void shapeSuperShoot( int superShootSize, int emptySpaceSuperShoot,int x, int y) {
        
        this.superShootsSize = superShootSize;
        this.emptySpaceSuperShoot= emptySpaceSuperShoot;

         addShapeSuperShoot(x, y);
    }
    //------------------Methods-------------------------------------------
     
     //agrega forma a lo consumbles 
    /**
     * agrega una forma a las vidas a partir del modelo de tanque ,partiendo de una posición "x" y "y"
      * @param x posicion inicial x de la forma
      * @param y  posicion inicial y de la forma
     */
    public void addShapeLive(int x, int y){
        int xAux = x;
        for (int i = 0; i < livesSize; i++) {//cantidad de vidas en forma de tanque
        
             Ship aux = new Ship(/*x:*/xAux,/*y:*/ y, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 0,/*velocidad bala:*/ 0,/*fps bala:*/ 0);
             xAux += emptySpaceLives + aux.getShape().get(0).getWidth();
             lives.add(aux);
        }
    }
    /**
     * agrega una forma a los super disparos a partir del modelo shoot,partiendo de una posición "x" y "y"
      * @param x posicion inicial x de la forma
      * @param y  posicion inicial y de la forma
     */
    public void addShapeSuperShoot(int x, int y){
        int xAux = x;
        for (int i = 0; i < superShootsSize; i++) {
             Bullet aux = new Bullet(xAux, y, 8 , 15, 0, 0);
             aux.addShape(xAux-7, y+16, 20, 3);
             xAux -= emptySpaceSuperShoot + aux.getShape().get(0).getWidth();
             superShoot.add(aux);
        }
    }
    
    //elimina las formas
    /**
     * elimina una vida incluyendo su forma dentro de la imagen
     * @return <b>True</b> si lo elimino con exito
     *     <br></b>false</b> si no hay mas vidas para 
     */
    public boolean removeLive(){
        
        if (livesSize > 0 ) {
            lives.remove(lives.size()-1);
            livesSize--;
            return true;
        }else{
        return false;    
        }
    }
    /**
     * elimina los superDisparos incluyendo sus formas
 * @return <b>True</b> si lo elimino con exito
     *     <br></b>false</b> si no hay mas super disparos para eliminar
     */
    public boolean removeSuperShoot(){
        if (superShootsSize > 0 ) {
            superShoot.remove(superShoot.size()-1);
            superShootsSize--;
            return true;
        }else{
        return false;    
        }
        
    }

    //------------------GetSetters----------------------------------------
    /**
     * retorna las vidas en forma de tanque
     * @return lives(ArrayList"Tank")
     */
    public ArrayList<Ship> getlives() {
        return lives;
    }
    /**
     * retorna las vidas actuales del tanque
     * @return int(livesSize)
     */
    public int getLivesSize() {
        return livesSize;
    }
    /**
     * destian las vidas del tanque
     * @param livesSize vidas del tanque
     */
    public void setLivesSize(int livesSize) {
        this.livesSize = livesSize;
    }
    /**
     * retorna los super disparos de el tanque
     * @return superShoot(ArrayList"Shoot")
     */
    public ArrayList<Bullet> getSuperShoot() {
        return superShoot;
    }
    /**
     * retorna cantidad de super disparos que tiene el tanque
     * @return int(superShoot)
     */
    public int getSuperShootsSize() {
        return superShootsSize;
    }
    /**
     * destina la cantidad de super disparos que tiene el tanque
     * @param superShootsSize super disparos del tanque
     */
    public void setSuperShootsSize(int superShootsSize) {
        this.superShootsSize = superShootsSize;
    }

    //-------------------Override-----------------------------------------    
    
    
}
