import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GridActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridActor extends Actor
{
    
    public GridActor() {
    }
    
    /**
     * Act - do whatever the GridActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public int getGridX() {
        return getX()/Wall.wallWidth;
    }
    
    public int getGridY() {
        return getY()/Wall.wallHeight;
    }
}
