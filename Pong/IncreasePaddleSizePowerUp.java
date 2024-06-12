import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class IncreasePaddleSizePowerUp extends PowerUp
{
    public IncreasePaddleSizePowerUp()
    {
        super("./images/Supermushroom.png"); // Ensure you have this image in your images directory
    }

    @Override
    protected void applyEffect(Ball ball)
    {
        PongWorld world = (PongWorld) getWorld();
        Paddle paddle = ball.getLastHitPaddle();
        if (paddle != null) {
            paddle.increaseSize();
        }
    }
}