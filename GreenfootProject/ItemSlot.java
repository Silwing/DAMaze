import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ItemSlot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemSlot extends Actor
{
    private static int slotCounter = 1;
    
    private Collectible item = null;
    private int slotNo;
    private boolean selected = false;
    private GreenfootImage unselectedImage, selectedImage;
    
    public ItemSlot(int no) {
        slotNo = no;
        unselectedImage = getImage();
        selectedImage = new GreenfootImage("selectedFrame.png");
    }
    
    public boolean hasItem() {
        return item != null;
    }
    
    public void setItem(Collectible newItem) {
        item = newItem;
        if(item != null) {
            getWorld().addObject(newItem, getX(), getY());
        }
    }
    
    public Collectible getItem() {
        return item;
    }
    
    public void selectSlot(Player selector) {
        if(!selected) {
            selected = true;
            setImage(selectedImage);
            if(hasItem()) {
                if(item.selectItem(selector)) {
                    setItem(null);
                }
            }
        }
    }
    
    public void deselectSlot(Player selector) {
        if(selected) {
            selected = false;
            setImage(unselectedImage);
        }
    }
    
    public int getSlotNo() {
        return slotNo;
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    /**
     * Act - do whatever the ItemSlot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
