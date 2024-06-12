import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SpeedPowerUp extends PowerUp
{

    public SpeedPowerUp()
    {
        super("./images/speed.png");
    }

    @Override
    protected void applyEffect(Ball ball)
    {
        ball.doublexSpeed();
    }
}