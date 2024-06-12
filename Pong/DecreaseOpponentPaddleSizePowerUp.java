import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class DecreaseOpponentPaddleSizePowerUp extends PowerUp
{
    public DecreaseOpponentPaddleSizePowerUp()
    {
        super("decreasepng.png"); // Add your image file here
    }

    @Override
    protected void applyEffect(Ball ball)
    {
        PongWorld world = (PongWorld) getWorld();
        Paddle paddle = ball.getLastHitPaddle();
        if (paddle != null) {
            Paddle opponent = paddle.getSide() ? world.getRightPaddle() : world.getLeftPaddle();
            opponent.decreaseSize();
        }
    }
    }

