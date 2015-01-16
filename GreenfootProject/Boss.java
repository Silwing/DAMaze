import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemy
{
    public Boss() {
        attack = 5;
        hitPercentage = 5;
        health = 10;
        damageSound = "BossHurt";
        zoneSound = "Boss";
    }
    
    @Override
    protected void removedFromWorld() {
        super.removedFromWorld();
        ((Level)getWorld()).gameWin();
    }
}
