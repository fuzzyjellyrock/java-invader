/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import Controller.ControllerGroupOfInvaders;
import Controller.ControllerTank;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.xml.transform.Source;
/**
 * interfaz sobrepuesta en la interfaz ViewGame en la que se ejecuta el juego
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class ViewActionScreen extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form Game
     */
    private ControllerGroupOfInvaders invasores;//invasores
    private ControllerTank tanque; //tanque
    private PlayerStatusBar consumiblesTanque; //barrera encargada de mostrar los consumibles
    private ViewGame viewGame;  //forma de controlar el jframe
   
    private int typeShoot=0; //tipo de disparo del tanque
    private int operation = 0;//Operacion de los hilos
    
    private int incrementRefreshRate=800;//incremento de velocidad por ronda
    //Vista del jugador
    private boolean[] visual = new boolean[5];
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
    public ViewActionScreen() {
        initComponents();
        visible();
        lvl1();
    }
    /**
     * permite hacer visible todo el juego
     */
    public void visible(){
                //control de la partes visuales en la interfaz
        visual[0] = true;//mostrar las naves
        visual[1] = true;//mostrar balas de las naves
        visual[2] = true;//mostrar el tanque
        visual[3] = true;//mostrar la balas de tanque
        visual[4] = false;//mostrar las barreras de defensa 
    }
    
    //Creación de niveles
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl1(){
        
        //invasores
        invasores = new ControllerGroupOfInvaders(/*x:*/70, /*y:*/ 30, /*filas:*/ 8, /*columnas:*/ 9, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate);
        invasores.addGroupInvader(/*ancho de invasor:*/15,/*alto de invasor*/ 8, /*espacio entre cada invasor*/22,/*velocidad de bala de invasores*/ 5, /*fps de bala de invasores*/(incrementRefreshRate/80));
        //tanque
        tanque = new ControllerTank(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 15,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
        tanque.getTank().addconsumable(3, 4, 18, 10, 600);
    }
    /**
     * crea un nivel basico a partir de los parametros de los personajes
     */
    public void lvl2(){
              //Creacion de personajes
        
        //invasores
        invasores = new ControllerGroupOfInvaders(/*x:*/70, /*y:*/ 30, /*filas:*/ 9, /*columnas:*/ 9, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate);
        invasores.addGroupInvader(/*ancho de invasor:*/15,/*alto de invasor*/ 8, /*espacio entre cada invasor*/22,/*velocidad de bala de invasores*/ 5, /*fps de bala de invasores*/(incrementRefreshRate/80));
        //tanque
        tanque = new ControllerTank(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 10,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
        tanque.getTank().addconsumable(/*Vidas del tanque*/4,/*super disparos del tanque*/ 4, /*posicion x dentro de gameBar*/18, /*posicion y dentro de gameBar*/10, /*espacio entre consumibles*/600);
    }
    /**
     * crea un nivel gefe (boss) a partir de los parametros de los personajes
     */
    public void lvl3(){
              //Creacion de personajes
        
        //invasores
        invasores = new ControllerGroupOfInvaders(/*x:*/70, /*y:*/ 30, /*filas:*/ 10, /*columnas:*/ 10, /*y:velocidad de grupo:*/ 10,/*fps de grupo:*/ incrementRefreshRate-100);
        invasores.getGroupInvader().addBoss(15, 12, 5, incrementRefreshRate/80);
        //tanque
        tanque = new ControllerTank(/*x:*/20,/*y:*/ 485, /*ancho:*/ 25,/*alto:*/ 10,/*velocidad:*/ 10,/*velocidad bala:*/ 7,/*fps bala:*/ 7);
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
                 visual[3]=false;//permite que si la bala se queda en quieta el usuario no la vea hasta que retorne
                 repaint();
                 try {Thread.sleep(500);} catch (Exception e) {}//demora de bala retornando
                tanque.getTank().returnShoot();//retorna la bala    
            }
                  if (disparo == 0) {
                viewGame.getUser().addPoints(10);
                viewGame.showActualScore();
                
            }
                   if (disparo == -2) {
                viewGame.callLvl();
                break;
            }
        repaint();
            visual[3]=true;
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
                viewGame.showActualScore();
                
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
        viewGame.stop();
    }
//------------------GetSetters----------------------------------------
    
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
    public void setViewGame(ViewGame viewGame) {
        this.viewGame = viewGame;
    }
    /**
     * destina los consumibles del tanque
     * @param consumiblesTanque consumibles del tanque
     */
    public void setConsumiblesTanque(PlayerStatusBar consumiblesTanque) {
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
    public ControllerGroupOfInvaders getInvasores() {
        return invasores;
    }
    /**
     * destian los invasores del objeto
     * @param invasores (ControllerGroupOfInvaders)
     */
    public void setInvasores(ControllerGroupOfInvaders invasores) {
        this.invasores = invasores;
    }
    /**
     * retorna el tanque del objeto
     * @return ControllerTank(tanque)
     */
    public ControllerTank getTanque() {
        return tanque;
    }
    /**
     * destian el tanque del objeto
     * @param tanque (ControllerTank)
     */
    public void setTanque(ControllerTank tanque) {
        this.tanque = tanque;
    }
   
    /**
     * destina la operacion que ejecuta el hilo
     * @param operation operacion desceada
     */
    public void setOperation(int operation) {
        this.operation = operation;
    }

    
//-------------------Override-----------------------------------------
    
    @Override
    protected void paintComponent(Graphics img) {
        super.paintComponent(img);
        Graphics2D imgComplete = (Graphics2D) img;
        float[] color = Color.RGBtoHSB(0,255,7, null);
        imgComplete.setColor(Color.getHSBColor(color[0], color[1], color[2]));
        //--------------ver naves---------------------------------
        if (visual[0] == true) {
            for (int i = 0; i < invasores.getGroupInvader().getInvaders().size(); i++) {
                for (int j = 0; j < invasores.getGroupInvader().getInvaders().get(i).getShape().size(); j++) {
                    if (typeShoot == 1) {//si es el super disparo
                    imgComplete.setColor(Color.YELLOW);
                }
                    
                    Rectangle2D invasor = invasores.getGroupInvader().getInvaders().get(i).getShape().get(j);
                    imgComplete.fill(invasor);
                }
                //---------------ver disparos de naves----------------------------------
                if (visual[1] == true) {
                    try {//solo si existe disparo
                        Rectangle2D invasorShoot = invasores.getGroupInvader().getInvaders().get(i).getShoot().getShape().get(0);
                        imgComplete.fill(invasorShoot);
                    } catch (Exception e) {
                    }
                }
            }
        }
        //------------------ver tanque---------------------------
        if (visual[2] == true) {
            for (int i = 0; i < tanque.getTank().getShape().size(); i++) {
                Rectangle2D tank = tanque.getTank().getShape().get(i);
                imgComplete.fill(tank);
            }
        }
        //----------------ver disparo del tanque-------------------------------
        if (visual[3] == true) {
            for (int i = 0; i < tanque.getTank().getShoot().getShape().size(); i++) {
                 Rectangle2D tankShoot = tanque.getTank().getShoot().getShape().get(i);
                 if (typeShoot == 1) {//si es el super disparo
                    imgComplete.setColor(Color.YELLOW);
                }
            imgComplete.fill(tankShoot);
            }

        }     
    }

     /**
     * tipo de hilo a ejecutar
     */
    @Override
    public void run() {
        //movimiento de tanque
        // System.out.println("operacion "+operation);
        if (operation == 0) {
            tanque.moveLeftWithShoot();
            repaint();
        }
        if (operation == 1) {
            tanque.moveRightWithShoot();
            repaint();
        }
        //disparo del tanque
        if (operation == 3) {
            if (typeShoot ==0) {
                tankShoot();
            }if (typeShoot == 1) {
                tankSuperShoot();
            }
            
        }
        //movimiento de los invasores
        if (operation == 4) {
            moveInvaders();
        }
        //disparo invasores
        if (operation == 5) {
            while (true) {
                invaderShoot();
            }
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    }
}
