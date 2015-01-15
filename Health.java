import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    private int health = 2;
    private GreenfootImage fullHealthImg, halfHealthImg, noHealthImg;
    
    public Health() {
        fullHealthImg = new GreenfootImage("heart.png");
        halfHealthImg = new GreenfootImage("halfHeart.png");
        noHealthImg = new GreenfootImage(16,16);
    }
    
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    public int takeDamage(int dmg) {
        if(dmg <= 0) throw new IllegalArgumentException("Damage should be larger than 0");
        
        if(health <= dmg) {
            int remainingDmg = dmg - health;
            health = 0;
            setImage(noHealthImg);
            return remainingDmg;
        }
        
        setImage(halfHealthImg);
        health -= dmg;
        return 0;
    }
}
