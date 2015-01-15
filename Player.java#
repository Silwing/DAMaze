import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends GridActor
{
    private List<Collectible> items = new ArrayList<Collectible>();
    private Map<Integer, ItemSlot> itemSlots;
    private ItemSlot selectedSlot;
    private int health = 20;
    private List<Health> healthBar = new ArrayList<Health>();
    private Level level;
    
    @Override
    protected void addedToWorld(World world) {
        level = (Level)world;
        itemSlots = new HashMap<Integer,ItemSlot>();
        for(int i = 1; i <= 9; i++) {
            ItemSlot s = new ItemSlot();
            itemSlots.put(s.getSlotNo(), s);
            level.addObjectToHUD(s, i);
        }
        
        for(int i = 0; i < health/2; i++) {
            Health newHealth = new Health();
            healthBar.add(newHealth);
            level.addObjectToHUD(newHealth, i+11);
        }
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkCollectibles();
        checkSlotKeys();
        checkMoveKeys();
    }
    
    public void takeDamage(int dmg) {
        ListIterator<Health> iter = healthBar.listIterator(healthBar.size());
        while(dmg > 0) {
            Health cur = iter.previous();
            dmg = cur.takeDamage(dmg);
        }
    }
    
    private void checkSlotKeys() {
        String strKey = Greenfoot.getKey();
        if(strKey != null) {
            try {
                int key = Integer.parseInt(strKey);
           
                for(Map.Entry<Integer,ItemSlot> entry : itemSlots.entrySet()) {
                    if(key == entry.getKey()) {
                        entry.getValue().selectSlot();
                        selectedSlot = entry.getValue();
                    } else {
                        entry.getValue().deselectSlot();
                    }
                }
            } catch(NumberFormatException ex) {}
        }
    }
    
    private void checkCollectibles() {
        if(isTouching(Collectible.class)) {
            List<Collectible> touching = getIntersectingObjects(Collectible.class);
            items.addAll(touching);
            getWorld().removeObjects(touching);
            ListIterator<Collectible> itms = touching.listIterator();
            for(ItemSlot s : itemSlots.values()) {
                if(!s.hasItem()) {
                    s.setItem(itms.next());
                    if(!itms.hasNext()) break;
                }
            }
        }
    }
    
    private boolean isTouchingSouthWall() {
        for(Object o : getObjectsInRange(20, Wall.class)) {
            Wall w = (Wall)o;
            int yDiff = w.getY()-getY();
            int xDiff = w.getX()-getX();
            if(isTouchingVertical(xDiff, yDiff)) return true;
        }
        return false;
    }
    
    private boolean isTouchingNorthWall() {
        for(Object o : getObjectsInRange(20, Wall.class)) {
            Wall w = (Wall)o;
            int yDiff = getY()-w.getY();
            int xDiff = w.getX()-getX();
            if(isTouchingVertical(xDiff, yDiff)) return true;
        }
        return false;
    }
    
    private boolean isTouchingWestWall() {
        for(Object o : getObjectsInRange(20, Wall.class)) {
            Wall w = (Wall)o;
            int yDiff = w.getY()-getY();
            int xDiff = getX()-w.getX();
            if(isTouchingHorizontal(xDiff, yDiff)) return true;
        }
        return false;
    }
    
    private boolean isTouchingEastWall() {
        for(Object o : getObjectsInRange(20, Wall.class)) {
            Wall w = (Wall)o;
            int yDiff = w.getY()-getY();
            int xDiff = w.getX()-getX();
            if(isTouchingHorizontal(xDiff, yDiff)) return true;
        }
        return false;
    }
    
    private boolean isTouchingHorizontal(int xDiff, int yDiff) {
        return (xDiff <= Wall.wallWidth && xDiff >= 0)
                && (yDiff <= Wall.wallHeight/2 && yDiff >= -Wall.wallHeight/2);
    }
    
    private boolean isTouchingVertical(int xDiff, int yDiff) {
        return (yDiff <= Wall.wallHeight && yDiff >= 0)
                && (xDiff <= Wall.wallWidth/2 && xDiff >= -Wall.wallWidth/2);
    }
    
    private void checkMoveKeys() {
        boolean left = Greenfoot.isKeyDown("left");
        boolean right = Greenfoot.isKeyDown("right");
        boolean up = Greenfoot.isKeyDown("up");
        boolean down = Greenfoot.isKeyDown("down");
        // north-west
        if(left && up && !(right || down)) {
            if(isTouchingNorthWall())
                up = false;
            else if(isTouchingWestWall())
                left = false;
            else {
                setRotation(225);
                move(5);
            }
        }
        // north-east
        if(right && up && !(left || down)) {
            if(isTouchingNorthWall())
                up = false;
            else if(isTouchingEastWall())
                right = false;
            else {
                setRotation(315);
                move(5);
            }
        }
        // south-west
        if(left && down && !(right || up)) {
            if(isTouchingSouthWall())
                down = false;
            else if(isTouchingWestWall())
                left = false;
            else {
                setRotation(135);
                move(5);
            }
        }
        // south-east
        if(right && down && !(left || up)) {
            if(isTouchingSouthWall())
                down = false;
            else if(isTouchingEastWall())
                right = false;
            else {
                setRotation(45);
                move(5);
            }
        }
        // direct west
        if(left && !(right || up || down)) {
            if(!isTouchingWestWall()) {
                setRotation(180);
                move(5);
            }
        }
        // direct east
        if(right && !(left || up || down)) {
            if(!isTouchingEastWall()) {
                setRotation(0);
                move(5);
            }
        }
        // direct north
        if(up && !(left || right ||down)) {
            if(!isTouchingNorthWall()) {
                setRotation(270);
                move(5);
            }
        }
        // direct south
        if(down && !(left || right || up)) {
            if(!isTouchingSouthWall()) {
                setRotation(90);
                move(5);
            }
        }
    }
    
    
}
