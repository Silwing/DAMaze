import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends GameEnd
{
    @Override
    protected void addedToWorld(World world) {
        TcpClient pureData = new TcpClient();
        pureData.connect();
        pureData.send("interface gameOver");
    }  
}
