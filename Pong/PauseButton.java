import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PauseButton extends Actor
{
    public PauseButton()
    {
        GreenfootImage image = new GreenfootImage("./images/pause-button.256x256.png");
        image.scale(20 ,20);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            world.pauseGame();
        }
    }
}