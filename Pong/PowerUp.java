import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PowerUp extends Actor
{   

    public PowerUp(String imageFile)
    {
        GreenfootImage image = new GreenfootImage(imageFile);
        image.scale(20 ,20);
        setImage(image);    }

    public void act()
    {
        // A bola atingiu o power up
        if (isTouching(Ball.class)) {
            Ball ball = (Ball) getOneIntersectingObject(Ball.class);
            if (ball != null) {
                applyEffect(ball);
                PongWorld world = (PongWorld) getWorld();
                world.decreasepower();
                getWorld().removeObject(this); // remove aquele powerupyy
            }
        }
    }

    protected void applyEffect(Ball ball)
    {
      
    }

}