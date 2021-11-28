/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Juan Camilo Muños, Luis Miguel Sanchez Pinilla
 */
public class Player {
 
    
    
    private String name ;
    private int  score ;
    private int  lvl ;

//-----------------Constructor---------------------------------------- 
    /**
     * construcctor null de usuario
     */
    public Player() {
    }
    /**
     * constructor con parametros de usuario
     * @param name del usuario
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.lvl = 0;
    }
//------------------Methods-------------------------------------------
    
    /**
     * suma puntos al usuario 
     * @param score puntos a sumar
     * @return retorna los puntos actuales del usuario
     */
    public int scorePoints(int score){
       this.score += score;
       return this.score;
    }
    /**
     * suma niveles al usuario 
     * @param lvl puntos a sumar
     * @return retorna los niveles actuales del usuario
     */
    public int addLevels(int lvl){
       this.lvl += lvl;
       return this.lvl;
    }
    
    //---------archivar
    /**
     * busca si de todos los records registrados puede ser superado por el record de este usuario
     * @return 
   * @return <b>int(posicion del podio del ususario)</b> si su record supero otro
     *     <br></b>false</b> si su record no supera algun record registrado
     */
    public int checkOtherRecords(){
        try {
            // leer la info del archivo de numeros
            BufferedReader reader = new BufferedReader(new FileReader("records.txt"));   //texto a buscar
            String line = null; //linea de txt
            ArrayList<Integer> records = new ArrayList<>();//array donde se guardaran todos los records
            
               while ((line = reader.readLine()) != null) {//recorre y guarda todos los records
                String[] array = line.split(",");
                   if (array.length>2) {
                    records.add(Integer.parseInt(array[1]));       
                   }
                }
               
               if (records.size()>0) {//si hay records compara si el de este usuario puede ir al podio
                   for (int i = 0; i< records.size(); i++ ) {
                       if (score>=records.get(i)) {// si es mayor a alguno de los records
                           return i;
                       }
                   }
                    reader.close();
                   return -1;
            }else{//si no  hay records que este sea el primero
                   reader.close();
                   return 0;
               }
        } catch (IOException ex) {
          System.out.println("error con los archivos");
        }
        return -1;
    }
    /**
     * registra el record en el txt (records.txt) si el record supero alguno solo ingresa(int > -1) si ingresa -1 no se registra nada
     * @param addRecord posicion dentro del podio del usuario
     * @return retorna el nuevo texto que ira en el txt (hace uso del metodo checheckOtherRecords());
     */
    public String readRecordsWithNewRecord(int addRecord){
         try {
            // leer la info del archivo de numeros
            BufferedReader reader = new BufferedReader(new FileReader("records.txt"));   //leer el txt
            String line = null;
            int position=0;//dice en que posicion esta el primer usuario(es decir el podio de jugadores)
            String text= "" ;
           
               while ((line = reader.readLine()) != null) {//recorre y guarda todos los jugadores en 
                String[] array = line.split(",");
                
                   if (position==addRecord) {
                       text += name+","+score+","+lvl+"\n";
                   }
                   
                    text +=array[0]+","+array[1]+","+array[2]+"\n";    
                   
                
                position++;
            }
               if (position==0) {
                   text += name+","+score+","+lvl+"\n";
             }
            reader.close();
            return text;
        } catch (IOException ex) {
          System.out.println("error con los archivos");
        }
        return null;
    }
    /**
     * registra en el txt un nuevo usuario, si el usuario supero un record ya registrado
     */
    public void positionInRecords(){
    
        int positio = checkOtherRecords() ;//busca si su recor supera alguno
        if(positio!=-1) {//si encontro una posicion en el podio
            String records = readRecordsWithNewRecord(positio);//retorna el texto de los records con el recor del usuario agregado
            FileOutputStream fos = null; 
            try { 
            fos = new FileOutputStream("records.txt"); 
            fos.write(records.getBytes("UTF-8")); //tamaño del texto a agregar
            fos.close();
            } catch (IOException e) { 
               
            }


        }
    }
    /**
     * resetea los puntos del usuario(se usa cuando el usuario muere)
     */
    public void resetPoints(){
        score=0;
        lvl=1;
        
    }
    
//------------------GetSetters----------------------------------------
    /**
     * retorna el nombre del usuario
     * @return String(name)
     */
    public String getName() {
        return name;
    }
    /**
     * destina el nombre del usuario dentro del objeto
     * @param name a destidar
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * retorna los puntos del usuario dentro de la partida
     * @return int(score)
     */
    public int getScore() {
        return score;
    }
    /**
     * destina los puntos del usuario 
     * @param score a destinar
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * retorna los niveles de el usuario dentro de la partidad
     * @return int (lvl)
     */
    public int getLvl() {
        return lvl;
    }
    /**
     * destina los niveles en los que se encuantra el usuario
     * @param lvl a destinasr
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
//-------------------Override----------------------------------------
    
}
