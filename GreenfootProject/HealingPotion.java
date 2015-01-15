import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealingPotion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealingPotion extends Collectible
{
    private int heal = 4;
    
    @Override
    public boolean selectItem(Player selector) {
        selector.heal(heal);
        getWorld().removeObject(this);
        return true;
    }
    /**
     * Act - do whatever the HealingPotion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
