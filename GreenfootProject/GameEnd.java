import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameEnd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEnd extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            getWorld().stopped(); // appearantly this is not run when a new world is set
            Level newWorld = new Level0();
            Greenfoot.setWorld(newWorld);
            newWorld.started();
        }
    }    
}
