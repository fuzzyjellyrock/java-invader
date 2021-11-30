/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Controllers.FleetController;
import Controllers.ShipController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * interfaz sobrepuesta en la interfaz ViewGame en la que se ejecuta el juego
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ActionScreenView extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Game
     */
    
    //ThreadController
    
    private FleetController invasores;//invasores
    private ShipController tanque; //tanque
    private PlayerStatusBarView consumiblesTanque; //barrera encargada de mostrar los consumibles
    private WindowView viewGame;  //forma de controlar el jframe
   
    private int typeShoot=0; //tipo de disparo del tanque
    private int operation = 0;//Operacion de los hilos
    
    private int incrementRefreshRate=800;//incremento de velocidad por ronda
    //Vista del jugador
    private boolean[] visualElements = new boolean[4];
//____________________________________________________________________
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 //-----------------Constructor---------------------------------------- 
    /**
     * constructor de personajes y la parte visual
     */
    public ActionScreenView() {
        initComponents();
        visible();
        lvl1();
    }
    /**
     * permite hacer visible todo el juego
     */
    public void visible(){
                //control de la partes visuales en la interfaz
        visualElements[0] = true;//mostrar las naves
        visualElements[1] = true;//mostrar balas de las naves
        visualElements[2] = true;//mostrar el tanque
        visualElements[3] = true;//mostrar la balas de tanque
    }
    
    //Creación de niveles
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl1(){
        
        //invasores
        invasores = new FleetController(/*x:*/70, /*y:*/ 30, /*filas:*/ 8, /*columnas:*/ 9, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate);
        invasores.addGroupInvader(/*ancho de invasor:*/15,/*alto de invasor*/ 8, /*espacio entre cada invasor*/22,/*velocidad de bala de invasores*/ 5, /*fps de bala de invasores*/(incrementRefreshRate/80));
        //tanque
        tanque = new ShipController(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 15,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
        tanque.getTank().addconsumable(3, 4, 18, 10, 600);
    }
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl2(){
              //Creacion de personajes
        
        //invasores
        invasores = new FleetController(/*x:*/70, /*y:*/ 30, /*filas:*/ 9, /*columnas:*/ 9, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate);
        invasores.addGroupInvader(/*ancho de invasor:*/15,/*alto de invasor*/ 8, /*espacio entre cada invasor*/22,/*velocidad de bala de invasores*/ 5, /*fps de bala de invasores*/(incrementRefreshRate/80));
        //tanque
        tanque = new ShipController(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 10,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
        tanque.getTank().addconsumable(/*Vidas del tanque*/4,/*super disparos del tanque*/ 4, /*posicion x dentro de gameBar*/18, /*posicion y dentro de gameBar*/10, /*espacio entre consumibles*/600);
    }
    /**
     * crea un nivel gefe (boss) a partir de los parametros de los personajes
     */
    public void lvl3(){
              //Creacion de personajes
        
        //invasores
        invasores = new FleetController(/*x:*/70, /*y:*/ 30, /*filas:*/ 10, /*columnas:*/ 10, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate-100);
        invasores.getGroupInvader().addBoss(15, 12, 5, incrementRefreshRate/80);
        //tanque
        tanque = new ShipController(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 10,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
        tanque.getTank().addconsumable(/*Vidas del tanque*/5,/*super disparos del tanque*/ 9, /*posicion x dentro de gameBar*/18, /*posicion y dentro de gameBar*/10, /*espacio entre consumibles*/600);
    }

//------------------Methods-------------------------------------------
    /**
     * Dispara la bala del tanque y lo repinta por movimiento
     */
    public void tankShoot() {
        int disparo = -1;
        while (disparo == -1) {//mientras el disparo pueda seguir sin problemas
            
            disparo = tanque.shoot(invasores.getGroupInvader());
           
             if (disparo == 1) {//esta parte le da un delay a la bala para que tarde en disparar cuando le de a un muro
                 visualElements[3]=false;//permite que si la bala se queda en quieta el usuario no la vea hasta que retorne
                 repaint();
                 try {Thread.sleep(500);} catch (Exception e) {}//demora de bala retornando
                tanque.getTank().returnShoot();//retorna la bala    
            }
                  if (disparo == 0) {
                viewGame.getUser().addPoints(10);
                viewGame.showCurrentScore();
                
            }
                   if (disparo == -2) {
                viewGame.callLvl();
                break;
            }
        repaint();
            visualElements[3]=true;
        }
       
        
    }
    /**
     * dispara desde el tanque una bala que destruye todo y solo retorna al llegar al limite del mapa
     */
    public void tankSuperShoot() {
        int disparo = -1;
         if (tanque.getTank().getConsumable().removeSuperShoot()) {//solo si tiene disparos de sobra
                consumiblesTanque.repaint();//eliminalo del la barra de consumibles
            tanque.getTank().createOrDestroySuperShoot(1);//genera la forma de la bala
             while (disparo != 2) {//mientras el disparo pueda seguir sin problemas
                 disparo = tanque.SuperShoot(invasores.getGroupInvader());//mueve el disparo
                
                     if (disparo == 0) {
                viewGame.getUser().addPoints(10);
                viewGame.showCurrentScore();
                
                 }
                if (disparo == -2) {
                viewGame.callLvl();   
                break;
            }
                 repaint();
             }
           typeShoot = 0;
           repaint();
          tanque.getTank().createOrDestroySuperShoot(0);//regresa a la bala normal
          tanque.getTank().returnShoot();//retorna la bala al tanque

         }
    }
     
    /**
     * Mueve los invasores de abajo, izquierda y derecha y por movimiento
     */
    public void moveInvaders() {
        while (invasores.moveGroupDown()) {
            repaint();
//--------------------------------------------------------
            while (invasores.moveGroupRight()) {
                repaint();    
            }
//--------------------------------------------------------            
            invasores.moveGroupDown();
            repaint();
//--------------------------------------------------------
            while (invasores.moveGroupLeft()) {
                repaint();
            }
        }
        
    }
    /**
     * permite que los invasores disparen aleatoriamente solo si estan vivos
     */
    public void invaderShoot() {
        //Posibilidad de disparo
        int possibility = invasores.randomShoot();
        //velocidad de disparo por segundo
        try {Thread.sleep(100); } catch (Exception e) {}
        if (possibility > -1 && (invasores.getInvader(possibility).getY()==invasores.getInvader(possibility).getShoot().getY())) {//si si existe la posibilidad y la bala se encuentra en el invasor
            int aux = 0;//determina el camino del disparo
            int auxLvl=viewGame.getIncrementLvl();//determina si el tanque si ya paso de nivel, si es asi detiene la bala del invasor
            while (aux == 0) {//mientras el disparo no colisione
                aux = invasores.shootInvader(possibility, tanque.getTank());//mueve la bala
                repaint(); 
                if (auxLvl!=viewGame.getIncrementLvl() && invasores.getGroupInvader().searchAlive()==0) {//para la bala de el invasor al terminar el nivel
                    break;
                }
            }
          
            if (aux == 1) {
                consumiblesTanque.repaint();
                if (tanque.getConsumable().getlives().size()==0) {//game over(si le da al tanque y no tiene vidas)
                   dead();
                }
            }
        }
    }
    /**
     * destina el game over de la partida usando el metodo / viewGame.stop()/dentro de ViewGame
     */
    public void dead(){
        viewGame.endCurrentGame();
    }
//------------------GetSetters----------------------------------------
    
    /**
     * Returns the value of whether an element is being displayed.
     * [0] show aliens
     * [1] show alien bullets
     * [2] show player's ship
     * [3] show player's ship bullets
     * 
     * @param index array position.
     * @return The boolean value at position index.
     */
    public boolean getVisualElementsValue(int index){
        boolean value = false;
        if(index < this.visualElements.length && index > -1){
            value = this.visualElements[index];
        } else {
            System.out.println("ActionScreenView class: setVisualElements(index) index is out of bounds. Array size: "+this.visualElements.length);
        }
        return value;
    }
    
    /**
     * resta la entrada de parametros a la tasa de refresco
     * @param incrementRefreshRate puntos a restar
     */
    public void setRestarRefreshRate(int incrementRefreshRate) {
        this.incrementRefreshRate -= incrementRefreshRate;
    }
    /**
     * destina la tasa de refresco en el objeto
     * @param incrementRefreshRate a destinar
     */
    public void setRefreshRate(int incrementRefreshRate) {
        this.incrementRefreshRate = incrementRefreshRate;
    }
    /**
     * detina el jFrame de el objeto
     * @param viewGame a destinar
     */
    public void setViewGame(WindowView viewGame) {
        this.viewGame = viewGame;
    }
    /**
     * destina los consumibles del tanque
     * @param consumiblesTanque consumibles del tanque
     */
    public void setConsumiblesTanque(PlayerStatusBarView consumiblesTanque) {
        this.consumiblesTanque = consumiblesTanque;
    }
    /**
     * detina en el momento que tipo de disparo se esta ejecutando
     * @return int (0) si es disparo normal int(1)si es super disparo
     */
    public int getTypeShoot() {
        return typeShoot;
    }
    /**
     * destian el tipo de disparo del tanque
     * @param typeShoot destinado al disparo del tanque
     */
    public void setTypeShoot(int typeShoot) {
        this.typeShoot = typeShoot;
    }
    /**
     * retorna los invasores del objeto
     * @return ControllerGroupOfInvaders( invasores)
     */
    public FleetController getInvasores() {
        return invasores;
    }
    /**
     * destian los invasores del objeto
     * @param invasores (ControllerGroupOfInvaders)
     */
    public void setInvasores(FleetController invasores) {
        this.invasores = invasores;
    }
    /**
     * retorna el tanque del objeto
     * @return ControllerTank(tanque)
     */
    public ShipController getTanque() {
        return tanque;
    }
    /**
     * destian el tanque del objeto
     * @param tanque (ControllerTank)
     */
    public void setTanque(ShipController tanque) {
        this.tanque = tanque;
    }
   
    /**
     * destina la operacion que ejecuta el hilo
     * @param operation operacion desceada
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    /**
     * Turns on or off elements from this panel.
     * [0] show aliens
     * [1] show alien bullets
     * [2] show player's ship
     * [3] show player's ship bullets
     * 
     * @param index array position.
     */
    public void setVisualElements(int index, boolean set){
        if(index < this.visualElements.length && index > -1){
            this.visualElements[index] = set;
        } else {
            System.out.println("ActionScreenView class: setVisualElements(index) index is out of bounds. Array size: "+this.visualElements.length);
        }
    }

    
//-------------------Override-----------------------------------------
    
    @Override
    protected void paintComponent(Graphics img) {
        super.paintComponent(img);
        
        //--------------ver naves---------------------------------
        
        if (visualElements[0] == true) {
            Graphics2D aliens = (Graphics2D) img.create();
            for (int i = 0; i < invasores.getGroupInvader().getInvaders().size(); i++) {
                for (int j = 0; j < invasores.getGroupInvader().getInvaders().get(i).getShape().size(); j++) {
                    aliens.setColor(Color.WHITE);
                    if (typeShoot == 1) {//si es el super disparo
                        aliens.setColor(Color.RED);
                    }
                    
                    Rectangle2D invasor = invasores.getGroupInvader().getInvaders().get(i).getShape().get(j);
                    aliens.fill(invasor);
                }
                //---------------ver disparos de naves----------------------------------
                Graphics2D aliensBullets = (Graphics2D) img.create();
                if (visualElements[1] == true) {
                    try {//solo si existe disparo
                        Rectangle2D invasorShoot = invasores.getGroupInvader().getInvaders().get(i).getShoot().getShape().get(0);
                        aliensBullets.setColor(Color.MAGENTA);
                        aliensBullets.fill(invasorShoot);
                    } catch (Exception e) {
                    }
                }
            }
            aliens.dispose();
        }
        
        Graphics2D player = (Graphics2D) img;
        float[] color = Color.RGBtoHSB(0,255,7, null);
        player.setColor(Color.getHSBColor(color[0], color[1], color[2]));
        
        //------------------ver tanque---------------------------
        if (visualElements[2] == true) {
            for (int i = 0; i < tanque.getTank().getShape().size(); i++) {
                Rectangle2D tank = tanque.getTank().getShape().get(i);
                player.fill(tank);
            }
        }
        
        Graphics2D playerBullets = (Graphics2D) img;
        //----------------ver disparo del tanque-------------------------------
        if (visualElements[3] == true) {
            for (int i = 0; i < tanque.getTank().getShoot().getShape().size(); i++) {
                Rectangle2D tankShoot = tanque.getTank().getShoot().getShape().get(i);
                playerBullets.setColor(Color.getHSBColor(color[0], color[1], color[2]));
                if (typeShoot == 1) {//si es el super disparo
                    playerBullets.setColor(Color.ORANGE);
                }
                playerBullets.fill(tankShoot);
            }

        }     
    }

     /**
     * tipo de hilo a ejecutar
     */
    @Override
    public void run() {
        
        boolean stop = false;
        while (!Thread.interrupted() && !stop) {
            switch(this.operation) {
                case 0:
                    //movimiento de tanque
                    tanque.moveLeftWithShoot();
                    repaint();
                    break;
                case 1:
                    //movimiento de tanque
                    tanque.moveRightWithShoot();
                    repaint();
                    break;
                case 2:
                    //disparo del tanque
                    if (typeShoot == 0) {
                        tankShoot();
                    }else if (typeShoot == 1) {
                        tankSuperShoot();
                    }
                    break;
                case 3:
                    //movimiento de los invasores
                    moveInvaders();
                    break;
                case 4:
                    //disparo invasores
                    while (!Thread.interrupted()) {
                        invaderShoot();
                    }
                    break;
                default:
                {
                    System.out.println("Thread stopped early. ActionScreenView run() method has no valid argument to run code.");
                }

            }
            stop = true;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
