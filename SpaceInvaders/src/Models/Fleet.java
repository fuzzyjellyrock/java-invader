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
 * Clase que contiene los atributos y métodos de los invasores como una unidad
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Fleet {

    private int fleetSpeed = 10;
    private long refreshRate;
    
    private ArrayList<Alien> invaders;
    //inicio del grupo de invasores
    private final int initialX = 160;
    private final int initialY = 30;
    //Aliens size
    final int width = 15;
    final int height = 8;
    
    //Boss aliens size
    final int bossWidth = 25;
    final int bossHeight = 22;
    //Social distancing
    final int socialDistancing = 24;
    //filas
    private int rows;
    //columbas
    private int columns;
    
    //Fleet color
    //Normal color
    private Color color;
    //Color when attacked by missile.
    private Color secondColor;

//-----------------Constructor----------------------------------------
    /**
     * constructor de GroupInvaders null
     */
    public Fleet() {
        this.color = Color.WHITE;
        this.secondColor = Color.RED;
    }

   /**
    * Constructor completo de groupOfInvaders
    * @param xInicial posicion inicial x del grupo (Donde se pondra la primera nave y todas partiran de hay)
    * @param yInicial posicion inicial y del grupo (Donde se pondra la primera nave y todas partiran de hay)
    * @param rows filas de los invasores 
    * @param columns columnas de los invasores 
    * @param speed velocidad del grupo de invasores
    * @param refreshRate fps del grupo
    */
    public Fleet(int refreshRate) {
        this.refreshRate = refreshRate;
        invaders = new ArrayList<>();
        
        this.color = Color.WHITE;
        this.secondColor = Color.RED;
    }
    //------------------Methods------------------------------------------
    
    public void setRowsAndColumns(int level){
        switch (level) {
            case 1:
                this.rows = 8;
                this.columns = 9;
                break;
            case 2:
                this.rows = 9;
                this.columns = 9;
                break;
            case 3:
                this.rows = 10;
                this.columns = 10;
                break;
            default:
                System.out.println("Fleet class setRowsAndColumns() Invalid level. level: "+level);
                this.rows = 3;
                this.columns = 3;
        }
    }
    
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
    public void addGroupInvader(long refreshBullet) {
        invaders = new ArrayList<>();
        int xTemp = initialX;//el inicio donde estaran todas las naves y donde seran colocadas en el eje x
        int yTemp = initialY;//el inicio donde estaran todas las naves y donde seran colocadas en el eje y
        for (int f = 0; f < rows; f++) {//filas de la naves
            int mod = f%4;
            for (int c = 0; c < columns; c++) {//columnas de las naves
                addInvader(xTemp, yTemp, refreshBullet, mod+1);
                xTemp += width + socialDistancing;  //sumar espacio entre ellos - punto de inicio - y anchura de las naves
            }
            xTemp = initialX;//reinicia el x para la siguiente ilera de invasores
            yTemp += height + socialDistancing;// aumente el y
        }
    }
    
    /**
     * crea a partir de invasores un modelo de gefe dado un tamaño(su forma siempre sera igual)
     * @param width ancho de los invasores
     * @param height alto de los invasores
     * @param speedBullet valocidad de las balas 
     * @param refreshBullet tasa de refresco de las balas
     */
    public void addBoss(long refreshBullet){
        this.invaders.clear();
        int inicioX = initialX;//el inicio donde estaran todas las naves y donde seran colocadas en el eje x
        int inicioY = initialY;//el inicio donde estaran todas las naves y donde seran colocadas en el eje y
        //primera capa
        for (int f = 0; f < 20; f++) {
            int modulo = f%4;
            addInvader(inicioX, inicioY,refreshBullet, modulo);
            inicioX += width;
        }
       inicioX = initialX;
       inicioX -= width;
       inicioY+= height;
       //segunda y tercera capa
       
        for (int f = 0; f < 44; f++) {
            int modulo = f%4;
            if (f==22) {
                 inicioX = initialX;
                 inicioX -= width;
                inicioY+=height;
            }
             addInvader(inicioX, inicioY, refreshBullet, modulo);
             inicioX += width;
        }
        inicioX = initialX;
        inicioY+= height;
       //segunda y tercera capa
        for (int f = 0; f < 14; f++) {
            int modulo = f%4;
             addInvader(inicioX, inicioY, refreshBullet, modulo);
             inicioX += width;
               if (f==4) {
                inicioX += 3*width;
            }
                  if (f==8) {
                inicioX += 3*width;
            }
        }
        //Create final boss
        addShapeInvaders(-5, height, 20, 8);
        inicioY += height;
        inicioX = ((inicioX/2)-30)+initialX;
        addInvader(inicioX, inicioY, refreshBullet, 0);
        addInvader(inicioX, inicioY, refreshBullet, 0);

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
    
    public void addInvader(int x, int y, long refreshShoot, int type) {
        //creacion del invader junto con la bala y su velocidad
        Alien alien = createAlienType(x, y, refreshShoot,type);
        invaders.add(alien);
    }
    
    public Alien createAlienType(int x, int y, long refreshShoot, int type){
        Alien alien;
        switch (type) {
            case 0:  
                    alien = new ChiefAlien(x, y, bossWidth, bossHeight, fleetSpeed, refreshShoot);
                    break;
            case 1:  
                    alien = new KnightAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 2:  
                    alien = new MinorRangerAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 3: 
                    alien = new ZealotAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            case 4:  
                    alien = new RangerAlien(x, y, width, height, fleetSpeed, refreshShoot);
                    break;
            default:
                    alien = new KnightAlien(x, y, width, height, fleetSpeed, refreshShoot);
        }
        return alien;
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
                invaders.get(i).setSpeed(fleetSpeed);
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
        if ( invaders.get(i).getY()==invaders.get(i).getBullet().getY()) {
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
        return rows;
    }
    /**
     * Destina las filas del objeto
     * @param row a destinar en el objeto
     */
    public void setRow(int row) {
        this.rows = row;
    }
    /**
     * Retorna las columnas presentes de la variablee columna
     * @return int (column)
     */
    public int getColumn() {
        return columns;
    }
    /**
     * Determina la columna de el objeto groupOfInvaders
     * @param column destinada al objeto
     */
    public void setColumn(int column) {
        this.columns = column;
    }
    /**
     * Obtener la velocidad de groupOfInvaders
     * @return int(velocidad)
     */
    public int getGroupSpeed() {
        return fleetSpeed;
    }
    /**
     * Determina la velocidad del ojetos groupOfInvaders
     * @param velocity determinada a el objeto
     */
    public void setGroupSpeed(int velocity) {
        this.fleetSpeed = velocity;
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
        return invaders.get(index).getBullet();
    }
    
    public int getAliensListSize(){
        return this.invaders.size();
    }
    
    public ArrayList<Rectangle2D> getAlienBulletShape(int index){
        return this.invaders.get(index).getBullet().getShapes();
    }
    
    public ArrayList<Rectangle2D> getAlienShapes(int index){
        ArrayList<Rectangle2D> shapes = null;
        if(index < this.invaders.size() && index > -1){
            shapes = this.invaders.get(index).getShapes();
        }
        return shapes;
    }

//-------------------Override-----------------------------------------
    @Override
    public String toString() {
        return "\nVelocidad grupal: " + fleetSpeed
                + showInvasors();
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the secondColor
     */
    public Color getSecondColor() {
        return secondColor;
    }

}
