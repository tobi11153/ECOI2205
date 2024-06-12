import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ReturnButton extends Actor
{
    public ReturnButton()
    {
        Font pauseFont = new Font("Arial", true, false, 24);
        GreenfootImage image = new GreenfootImage("./images/play-button.256x256.png");
        image.scale(20 ,20);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            world.resumeGame();
        }
    }
}