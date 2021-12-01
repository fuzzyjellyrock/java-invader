/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author fuzzyrock
 */
public class KnightAlien extends Alien {
    
    public KnightAlien(int x, int y, int width, int height, int speed, long refreshShoot) {
        super(x, y, width, height, speed, refreshShoot);
        setAlienType(1);
        setSkin();
    }
    
    @Override
    public void setSkin() {
        int x = getX();
        int y = getY();
        addShape(x, y, width, height); //forma primario del rectangulo
        addShape(x-((width/4)+1), y+(height), (width/4)+1, 7);
        addShape(x+(width/2)-((width/8)), y+(height), (width/4)+1 , 7);
        addShape(x+width, y+(height), (width/4)+1, 7);
    }
    
}
