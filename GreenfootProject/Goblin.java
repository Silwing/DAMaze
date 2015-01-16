import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goblin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goblin extends Enemy
{
    
    public Goblin() {
        attack = 1;
        health = 5;
        hitPercentage = 5;
        damageSound = "GoblinHurt";
        zoneSound = "Goblin";
    }
}
