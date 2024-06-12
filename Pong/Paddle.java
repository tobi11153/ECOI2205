import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private boolean isLeft;
    private int height = 100;

    public Paddle(boolean isLeft)
    {
        this.isLeft = isLeft;
        updateImage();
    }

    public void act()
    {
        // Movement for left paddle
        if (isLeft)
        {
            if (Greenfoot.isKeyDown("w")) moveUp();
            if (Greenfoot.isKeyDown("s")) moveDown();
        }
        // Movement for right paddle
        else
        {
            if (Greenfoot.isKeyDown("up")) moveUp();
            if (Greenfoot.isKeyDown("down")) moveDown();
        }
    }
    
    private void moveUp()
    {
        if (getY() > 30) setLocation(getX(), getY() - 4);
    }

    private void moveDown()
    {
        if (getY() < getWorld().getHeight() - 30) setLocation(getX(), getY() + 4);
    }
    
       public void increaseSize()
    {
        height += 20;
        updateImage();
    }

    public void decreaseSize()
    {
        height = Math.max(20, height - 20);
        updateImage();
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(10, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
    }
    public boolean getSide(){
        return this.isLeft;
    }
}
