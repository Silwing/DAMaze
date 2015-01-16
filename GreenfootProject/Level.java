import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    private int lvlWidth, lvlHeight;
    private boolean gameOver = false;
    protected TcpClient pureData;
    
    /**
     * Constructor for objects of class Level.
     * 
     */
    public Level(int lvlWidth, int lvlHeight, int cellSize)
    {    
        super(lvlWidth*Wall.wallWidth, lvlHeight*Wall.wallHeight+22, cellSize);
        this.lvlWidth = lvlWidth;
        this.lvlHeight = lvlHeight;
        this.pureData = new TcpClient();
    }
    
    // Grid size is based on wall size
    public void addObjectToGrid(Actor object, int x, int y) {
        addObject(object, x*Wall.wallWidth+Wall.wallWidth/2, y*Wall.wallHeight+Wall.wallHeight/2);
    }
    
    public void addObjectToHUD(Actor object, int slot) {
        addObject(object, slot*22+11, lvlHeight*Wall.wallHeight+11);
    }
    
    public void addHorizontalWall(int x, int y, int length) {
        for(int i = 0; i < length; i++) {
            addObjectToGrid(new Wall(), x+i, y);
        }
    }
    
    public void addVerticalWall(int x, int y, int length) {
        for(int j = 0; j < length; j++) {
            addObjectToGrid(new Wall(), x, y+j);
        }
    }
    
    public void gameOver() {
        gameOver = true;
        addObject(new GameOver(), lvlWidth*Wall.wallWidth/2, (lvlHeight*Wall.wallHeight+22)/2); 
    }
    
    public void gameWin() {
        gameOver = true;
        addObject(new GameWin(), lvlWidth*Wall.wallWidth/2, (lvlHeight*Wall.wallHeight+22)/2);
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    @Override
    public void started() {
        pureData.connect();
    }
    
    @Override
    public void stopped() {
        pureData.disconnect();
    }
}
