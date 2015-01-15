import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends GridActor
{
    protected int attack, health, hitPercentage;
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!((Level)getWorld()).isGameOver()) {
            attackNearbyPlayer();
        }
    }
    
    protected void attackNearbyPlayer() {
        if(isTouching(Player.class)) {
            if(Greenfoot.getRandomNumber(100) < hitPercentage) {
                Player p = (Player)getOneIntersectingObject(Player.class);
                p.takeDamage(attack);
            }
        }
    }
    
    public void takeDamage(int dmg) {
        if(dmg >= health) {
            getWorld().removeObject(this);
        } else {
            health -= dmg;
        }
    }
    
    public int getAttack() {
        return attack;
    }
    
    public int getHealth() {
        return health;
    }
}
