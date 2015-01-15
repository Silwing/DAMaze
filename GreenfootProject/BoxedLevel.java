import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoxedLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxedLevel extends Level
{
    private int lvlWidth, lvlHeight;
    /**
     * Constructor for objects of class BoxedLevel.
     * 
     */
    public BoxedLevel(int lvlWidth, int lvlHeight, int cellSize)
    {    
        super(lvlWidth+2, lvlHeight+2, cellSize); 
        
        this.lvlWidth = lvlWidth+2;
        this.lvlHeight = lvlHeight+2;
        // Create outer wall
        for(int i = 0; i < this.lvlWidth; i ++) { 
            super.addObjectToGrid(new Wall(), i, 0);
            super.addObjectToGrid(new Wall(), i, this.lvlHeight - 1);
        }
        for(int j = 0; j < this.lvlHeight; j ++) {
            super.addObjectToGrid(new Wall(), 0, j);
            super.addObjectToGrid(new Wall(), this.lvlWidth - 1, j);
        }
    }
    
    @Override
    public void addObjectToGrid(Actor object, int x, int y) {
        if(x > (lvlWidth-2)) {
            throw new IllegalArgumentException("Please provide an x-coordinate within the boxed level (got " + x + " with level width " + (lvlWidth-2) + ").");
        }
        if(y > (lvlHeight-2)) {
            throw new IllegalArgumentException("Please provide a y-coordinate within the boxed level (got " + y + " with level width " + (lvlHeight-2) + ").");
        }
        
        super.addObjectToGrid(object, x+1, y+1);
    }
}
