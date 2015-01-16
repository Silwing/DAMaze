import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Enemy
{
    private boolean playerInRangeLast = false;
    
    public Goblin() {
        attack = 1;
        health = 5;
        hitPercentage = 5;
        damageSound = "GoblinHurt";
    }
    
    @Override
    public void act() {
        super.act();
        
        if(!((Level)getWorld()).isGameOver()) {
            boolean playerInRange = getObjectsInRange(60, Player.class).size() > 0;
            if(!playerInRangeLast && playerInRange) {
                pureData.send("zone StartGoblin");
                playerInRangeLast = true;
            } else if (playerInRangeLast && !playerInRange) {
                pureData.send("zone StopGoblin");
                playerInRangeLast = false;
            }
        }
    }
    
    @Override
    protected void removedFromWorld() {
        if(playerInRangeLast) {
            pureData.send("zone StopGoblin");
        }
        
        super.removedFromWorld();
    }
}
