import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor
{
    public StartButton()
    {        
        Font startFont = new Font("Arial", true, false, 24);
        
        GreenfootImage image = new GreenfootImage(140, 50);
        image.setColor(Color.GREEN);
        image.fill();
        image.setColor(Color.BLACK);
        image.setFont(startFont);
        image.drawString("Start", 25, 30);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            world.startGame();
        }
    }
}