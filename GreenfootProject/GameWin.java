import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWin extends GameEnd
{
    public GameWin() {
        TcpClient pureData = new TcpClient();
        pureData.connect();
        pureData.send("interface gameWin");
    }
}
