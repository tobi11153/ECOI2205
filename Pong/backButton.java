import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class backButton extends Actor
{

    public backButton()
    {
        Font returnFont = new Font("Arial", true, false, 24);
        GreenfootImage image = new GreenfootImage(140, 50);
        image.setColor(Color.LIGHT_GRAY);
        image.fill();
        image.setColor(Color.BLACK);
        image.setFont(returnFont);
        image.drawString("Return", 30, 30);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            world.closeSettings();
        }
    }
}
