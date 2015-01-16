import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level0 extends BoxedLevel
{

    /**
     * Constructor for objects of class Level0.
     * 
     */
    public static int lvlHeight = 14;
    public static int lvlWidth = 29;
    
    public Level0()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(lvlWidth, lvlHeight, 1); 
        
        // Horizontal level walls
        addHorizontalWall( 2, 2, 4);
        addHorizontalWall(11, 2, 4);
        addHorizontalWall(20, 2, 7);
        
        addHorizontalWall( 2, 5,10);
        addHorizontalWall(14, 5, 4);
        addHorizontalWall(26, 5, 3);
        
        addHorizontalWall( 0, 8, 3);
        addHorizontalWall( 8, 8, 4);
        addHorizontalWall(17, 8, 7);
        
        addHorizontalWall( 2,11, 7);
        addHorizontalWall(14,11, 7);
        addHorizontalWall(23,11, 7);
        
        // Vertical level walls
        addVerticalWall( 2, 2, 4);
        
        addVerticalWall( 5, 5, 4);
        
        addVerticalWall( 8, 0, 6);
        addVerticalWall( 8, 8, 4);
        
        addVerticalWall(11, 5, 4);
        addVerticalWall(11,11, 3);
        
        addVerticalWall(14, 2, 4);
        addVerticalWall(14, 8, 4);
        
        addVerticalWall(17, 0, 3);
        addVerticalWall(17, 5, 4);
        addVerticalWall(17,11, 3);
        
        addVerticalWall(20, 2, 4);
        addVerticalWall(20, 8, 4);
        
        addVerticalWall(23, 2, 7);
        
        addVerticalWall(26, 5, 4);
        
        addObjectToGrid(new Player(), 0, 0);
        addObjectToGrid(new Dagger(), 3, 3);
        addObjectToGrid(new Sword(), 10, 7);
        addObjectToGrid(new Goblin(), 4, 9);
        addObjectToGrid(new HealingPotion(), 10, 13);
        
    }
    
    @Override
    public void started() {
        super.started();
        
        pureData.send("affect Start");
    }
    
    @Override
    public void stopped() {
        pureData.send("affect Stop");
        
        super.stopped();
    }
}
