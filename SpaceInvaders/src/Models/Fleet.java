/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Clase que contiene los atributos y métodos de los invasores como una unidad
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Fleet {

    private int groupSpeed;
    private long refreshRate;

    private ArrayList<Alien> invaders;
    //inicio del grupo de invasores
    private final int xInicial;
    private final int yInicial;
    //tamaño en forma de matriz de la oleada de invasores
    //filas
    private int row;
    //columbas
    private int column;

//-----------------Constructor----------------------------------------
    /**
     * constructor de GroupInvaders null
     */
    public Fleet() {
        xInicial = 0;
        yInicial = 0;
    }

   /**
    * Constructor completo de groupOfInvaders
    * @param xInicial posicion inicial x del grupo (Donde se pondra la primera nave y todas partiran de hay)
    * @param yInicial posicion inicial y del grupo (Donde se pondra la primera nave y todas partiran de hay)
    * @param row filas de los invasores 
    * @param column columnas de los invasores 
    * @param speed velocidad del grupo de invasores
    * @param refreshRateInvaders fps del grupo
    */
    public Fleet(int xInicial, int yInicial, int row, int column, int speed,int refreshRateInvaders) {
        this.row = row;
        this.column = column;
        this.xInicial = xInicial;
        this.yInicial = yInicial;
        this.groupSpeed = speed;
        this.refreshRate = refreshRateInvaders;
        invaders = new ArrayList<>();
    }
    //------------------Methods------------------------------------------
    
    /**
   * Crea el grupo de invasores dado un tamaño parecido a una matriz, es decir
     * si se ingresa una fila y columna (ejem: 2*2 ) se crearan 4 invasores.
     * Otro ejemplo seria una fila y columna (ejem: 3*3) genera 9 invasores
 * @param widthInvader ancho de los invasores
 * @param heightInvader alto de los invasores
 * @param spaceBetweenInvaders espacio entre los invasores
 * @param speedBullet velocidad de la bala de los invasores
 * @param refreshBullet tasa de refresco de las balas
 */
    public void addGroupInvader(int widthInvader,int heightInvader,int spaceBetweenInvaders,int speedBullet,long refreshBullet) {
        invaders = new ArrayList<>();
        int inicioX = xInicial;//el inicio donde estaran todas las naves y donde seran colocadas en el eje x
        int inicioY = yInicial;//el inicio donde estaran todas las naves y donde seran colocadas en el eje y
        int width = widthInvader;//ancho de las naves
        int height = heightInvader;// alto de las naves
        int emptySpace = spaceBetweenInvaders;//espacio entre las naves
        for (int f = 0; f < row; f++) {//filas de la naves
            for (int c = 0; c < column; c++) {//columnas de las naves
                if(f%2==0){
                    addInvader(inicioX, inicioY, width, height, groupSpeed , speedBullet ,refreshBullet, 1);
                    inicioX += width + emptySpace;  //sumar espacio entre ellos - punto de inicio - y anchura de las naves 
                }else if(f%2!=0){
                    addInvader(inicioX, inicioY, width, height, groupSpeed , speedBullet ,refreshBullet, 2);
                    inicioX += width + emptySpace;  //sumar espacio entre ellos - punto de inicio - y anchura de las naves
                }

            }
            inicioX = xInicial;//reinicia el x para la siguiente ilera de invasores
            inicioY += height + emptySpace;// aumente el y
        }
    }
    /**
     * crea a partir de invasores un modelo de gefe dado un tamaño(su forma siempre sera igual)
     * @param widthInvader ancho de los invasores
     * @param heightInvader alto de los invasores
     * @param speedBullet valocidad de las balas 
     * @param refreshBullet tasa de refresco de las balas
     */
    public void addBoss(int widthInvader,int heightInvader,int speedBullet,long refreshBullet){
             invaders = new ArrayList<>();
        int inicioX = xInicial;//el inicio donde estaran todas las naves y donde seran colocadas en el eje x
        int inicioY = yInicial;//el inicio donde estaran todas las naves y donde seran colocadas en el eje y
        //primera capa
        for (int f = 0; f < 20; f++) {
             addInvader(inicioX, inicioY, widthInvader, heightInvader, groupSpeed , speedBullet ,refreshBullet,1);
             inicioX += widthInvader;
        }
       inicioX = xInicial;
       inicioX -= widthInvader;
       inicioY+= heightInvader;
       //segunda y tercera capa
       
        for (int f = 0; f < 44; f++) {
            if (f==22) {
                 inicioX = xInicial;
                 inicioX -= widthInvader;
                inicioY+=heightInvader;
            }
             addInvader(inicioX, inicioY, widthInvader, heightInvader, groupSpeed , speedBullet ,refreshBullet,1);
             inicioX += widthInvader;
        }
        inicioX = xInicial;
         inicioY+= heightInvader;
       //segunda y tercera capa
        for (int f = 0; f < 14; f++) {
             addInvader(inicioX, inicioY, widthInvader, heightInvader, groupSpeed , speedBullet ,refreshBullet,1);
             inicioX += widthInvader;
               if (f==4) {
                inicioX += 3*widthInvader;
            }
                  if (f==8) {
                inicioX += 3*widthInvader;
            }
        }
        //ultima capa
        addShapeInvaders(-5, heightInvader, 20, 8);
        inicioY += heightInvader;
        inicioX = ((inicioX/2)-30)+xInicial;
        addInvader(inicioX, inicioY, widthInvader+10, heightInvader+10, groupSpeed , speedBullet ,refreshBullet,1);
        addInvader(inicioX, inicioY, widthInvader+10, heightInvader+10, groupSpeed , speedBullet ,refreshBullet,1);

    }
    /**
     * agrega una forma a todos los invasores YA CREADOS 
     * @param x posición dentro de su x inicial donde estara la nueva forma
     * @param y posición dentro de su y inicial donde estara la nueva forma
     * @param width ancho de la forma a agregar
     * @param height  alto de la forma a agregar
     */
    public void addShapeInvaders(int x, int y, int width, int height){
        for (Alien invader : invaders) {
            invader.addShape(invader.getX()+x,//x
                            invader.getY()+y//y
                            , width,//ancho
                            height);//alto
        }
    }
    
    
    
    /**
     * Agrega un invasor a el arrayList(invaders),junto al respectivo disparo
     * del invader
     *
     * @param x posicion inicial x del invasor frente a su forma principal
     * @param y posicion inicial y del invasor frente a su forma principal
     * @param width anchura del invasor
     * @param height altura del invasor
     */
    public void addInvader(int x, int y, int width, int height, int speed, int speedBullet, long refreshShoot, int type) {
        //creacion del invader junto con la bala y su velocidad
        Alien aux = new Alien(x, y, width, height, speed, speedBullet, refreshShoot);
        //creacion de formas de los enemigos
        if (type == 1){
            aux.addShape(x, y, width, height); //forma primario del rectangulo
            aux.addShape(x-((width/4)+1), y+(height), (width/4)+1, 7);
            aux.addShape(x+(width/2)-((width/8)), y+(height), (width/4)+1 , 7);
            aux.addShape(x+width, y+(height), (width/4)+1, 7);
            invaders.add(aux);
        }else if (type == 2){
            aux.addShape(x, y, width, height/2); //forma primario del rectangulo
            aux.addShape(x-((width/4)+1), y, (width/4)+1, 14);
            aux.addShape(x+(width/2)-((width/8)), y+(height), (width/4)+1 , 7);
            aux.addShape(x+width, y, (width/4)+1, 14);
            invaders.add(aux);
        }
        
    }
    /**
     * Muestra todos los invasores del arrayList(invaders) con sus respectivas
     * formas y disparos
     *
     * @return String con la informacion de los invaders
     */
    public String showInvasors() {
        String aux = "";
        for (int i = 0; i < invaders.size(); i++) {
            aux += "\n______________________________________________________________"
                    + "\n\n ----------invader N°" + i + "----------\n"
                    + invaders.get(i);
        }

        return aux;
    }
    
    //--------mover el grupo completo con sus disparos------
    //como todo el grupo se tiene que mover, estos son controladores de todos eso movimientos
    /**
     * Mueve el grupo de invasores(invaders) para la izquierda con una demora de fps(refreshRate) buscando primero que no pase los limites
        * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento pasa los limites, o si el ya no hay mas invaders a que mover
     */
    public boolean moveGroupLeft() {
        if (invaders.size() >= 0  && searchAlive()!=0) {//solo se mueven si existe invasores
            
            try {Thread.sleep(getRefreshRate());} catch (Exception e) {}//---------fps 
            ////busca si es posible mover el grupo, verificando si alguna choca o no con el lado derecho (limitLeft)
            for (Alien invader : invaders) {
                if (invader.verifyLimitLeft() == true) {
                    return false;
                }
            }
            //si es posible mover el grupo mover las naves junto con sus dispar
            for (int i = 0; i < invaders.size(); i++) {
                invaders.get(i).moveLeftWithShoot();
                
            }
            return true;
        }
        return false;

    }
    /**
     * Mueve el grupo de invasores(invaders) para la derecha con una demora de fps(refreshRate) buscando primero que no pase los limites
     * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento pasa los limites, o si el ya no hay mas invaders a que mover
     */
    public boolean moveGroupRight() {
        
        if (invaders.size() >= 0 && searchAlive()!=0) {//solo se mueven si existe invasores
             try {Thread.sleep(getRefreshRate());} catch (Exception e) {System.out.println("error");}//---------fps
            //busca si es posible mover el grupo, verificando si alguna choca o no con el lado derecho(limitRight)
             for (Alien invader : invaders) {
                if (invader.verifyLimitRight() == true) {
                    return false;
                }
            }
            //si es posible mover el grupo mover las naves junto con sus disparos de pendiendo la velocidad del grupo (groupSpeed)
            for (int i = 0; i < invaders.size(); i++) {
                invaders.get(i).moveRightWithShoot();
            }
             return true;
        }
       return false;

    }
    /**
     * Mueve el grupo de invasores(invaders) para abajo con una demora de fps(refreshRate) buscando primero que no pase los limites
      * @return <b>True</b> si el movimiento fue exitoso
      *     <br></b>false</b> si el movimiento pasa los limites, o si el ya no hay mas invaders a que mover
     */
    public boolean moveGroupDown() {
         if (invaders.size() >= 0 && searchAlive()!=0) {//solo se mueven si existe invasores
            //ya que al bajar la nave el movimiento siepre sera uniforme hay que modificar la velocidad a una bajada de 10 cuadros ya que queremos que siempre al bajar sea un velocidad de 10
               for (Alien invader : invaders) {
                if (invader.verifyLimitDown() == true) {
                    return false;
                }
            }
            //si es posible mover el grupo mover las naves junto con sus disparos de pendiendo la velocidad del grupo (groupSpeed)
            for (int i = 0; i < invaders.size(); i++) {
                invaders.get(i).setSpeed(20);
                invaders.get(i).moveDownWithShoot();
                invaders.get(i).setSpeed(groupSpeed);
            }
            return true;
         }
    return false;
    }
    
    /**
     * determina cuando quedan menos invasore que velocidad tendran los invasores, solo se activa si el tanque le dio a un invasor
     */
    public void controlOfRefreshRate(){
       int size =searchAlive();
        if (size==50) {
            refreshRate=refreshRate-(refreshRate/4);
        }else if(20>size && 10<size){
           refreshRate=refreshRate-(refreshRate/12);   
        }else if(10>size && 3<size){
           refreshRate=refreshRate-(refreshRate/6);   
        }else if(3>=size ){
           refreshRate=refreshRate-(refreshRate/2);   
        }
        
        
        
    }
    /**
     * busca que invasores estan vivos
     * @return int con la cantidad de invasores vivos
     */
    public int searchAlive(){
        int size=0;
        for (Alien invader : invaders) {//busca quien esta vivo
             if (invader.isDead()==false) {
                size++;
            }
        }
        return size;
    }
    /**
     * Da por muerta la nave, pero si la bala esta activa solo elimina la forma del invader, mas no la bala.
     * En cambio si la bala se encunetra en el mismo invasor y elimina todo y lo da por muerto
     * @param i invader al cual se quiere eliminar
     */
    public void removeInvasorShape(int i){
        if ( invaders.get(i).getY()==invaders.get(i).getShoot().getY()) {
            invaders.get(i).removeAllShape();
        }else{
            invaders.get(i).removeOnlyShip();
        }
        
    }
    
    
    //------colision
    
    /**
     * Detecta si algun disparo del tanque colisiono con alguna de las naves, si
     * lo hace retorna la posición de la nave frente a el atributo
     * invaders(groupOfInvaders/invaders)
     *
     * @param enemyShoot disparo dado por el tanque
     * @return <b>int(posicion dentro de arrayList invaders dependiedo al
     * invasor que le dio)</b> si encuentra colision
     * <br></b>int (-1)</b> retorna -1 si no encontro colision con ninguna nave
     */
    public int collisionDetection(Rectangle2D enemyShoot) {
        for (int i = 0; i < invaders.size(); i++) {//buscar en cada una de los invasores si hay colision
          //  System.out.println(""+i);
            if (invaders.get(i).collision(enemyShoot) == true) {//si hay colision
                //si le dio a la nave destruyela ( dead =trure)
                 
                removeInvasorShape(i);
                controlOfRefreshRate();//revisa la cantidad de invaders y acomoda el refreshRate
                //retorna el invasor con colision
                if(searchAlive()==0){//busca si el invasor dado fue el ultimos
                    return -2;
                }
                return i;
            }
        }
        return -1;//retorna -1 si no hay colision
    }
    
    /**
     * Busca un invasor aleatorio EL CUAL NO ESTE MUERTO(dead==true).Este metodo sirve para cojer un invasor aleatorio el cual pueda disparar
     * @return <b>(int > 0) </b>el cual de la posicion de el invasor aleatorio <br> 
     *          <b>(int -1) </b> si no encuentra un invasor aleatorio
     */
    public int randomShoot(){
        //busca si por turno dispara
        int shotPossibility = (int) (Math.random() * 3 + 0);
        if (shotPossibility == 1) {//si se acepta el disparo escoje una nave aleatoria y lo pone a disparar 
            int invader = (int) (Math.random() * invaders.size() + 0);   
            while (invaders.get(invader).isDead()==true) {     //si el invasor no fue eliminado ya           
                invader = (int) (Math.random() * invaders.size() + 0);    
            }
            return  invader;
        } 
        return -1;
    }
    
    //------------------GetSetters---------------------------------------
    
    /**
     * Retorna las filas de el objeto
     * @return int (row)
     */
    public int getRow() {
        return row;
    }
    /**
     * Destina las filas del objeto
     * @param row a destinar en el objeto
     */
    public void setRow(int row) {
        this.row = row;
    }
    /**
     * Retorna las columnas presentes de la variablee columna
     * @return int (column)
     */
    public int getColumn() {
        return column;
    }
    /**
     * Determina la columna de el objeto groupOfInvaders
     * @param column destinada al objeto
     */
    public void setColumn(int column) {
        this.column = column;
    }
    /**
     * Obtener la velocidad de groupOfInvaders
     * @return int(velocidad)
     */
    public int getGroupSpeed() {
        return groupSpeed;
    }
    /**
     * Determina la velocidad del ojetos groupOfInvaders
     * @param velocity determinada a el objeto
     */
    public void setGroupSpeed(int velocity) {
        this.groupSpeed = velocity;
    }
    /**
     * Obtener array de invasores del groupOfInvaders
     * @return ArrayList(invader)
     */
    public ArrayList<Alien> getInvaders() {
        return invaders;
    }
    /**
     * Determina el arreglo de invasores del groupOfInvaders
     * @param invaders arreglo de invasores a destinar en el objeto
     */
    public void setInvaders(ArrayList<Alien> invaders) {
        this.invaders = invaders;
    }
    /**
     * Obtiene los fps de las naves grupales
     * @return long (RefreshRate)
     */
    public long getRefreshRate() {
        return refreshRate;
    }
    /**
     * Destina los fps de las naves grupales
     * @param refreshRate  destinado al objeto
     */
    public void setRefreshRate(long refreshRate) {
        this.refreshRate = refreshRate;
    }
    /**
     * Obtener el disparo de un invasor por su index
     * @param index (int) idex del invasor a buscar
     * @return Shoot(disparo del invasor)
     */
    public Bullet getShootOfInvader(int index){
        return invaders.get(index).getShoot();
    }


//-------------------Override-----------------------------------------
    @Override
    public String toString() {
        return "\nVelocidad grupal: " + groupSpeed
                + showInvasors();
    }

}
