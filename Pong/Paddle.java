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
    private double velocity = 0; // Current velocity of the paddle
    private double acceleration = 0.5; // How fast the paddle accelerates
    private double maxSpeed = 4; // Maximum speed of the paddle

    public Paddle(boolean isLeft)
    {
        this.isLeft = isLeft;
        updateImage();
    }

    public void act()
    {
        // Desired speed based on input
        double desiredSpeed = 0;

        if (isLeft)
        {
            if (Greenfoot.isKeyDown("w")) desiredSpeed = -maxSpeed;
            if (Greenfoot.isKeyDown("s")) desiredSpeed = maxSpeed;
        }
        else
        {
            if (Greenfoot.isKeyDown("up")) desiredSpeed = -maxSpeed;
            if (Greenfoot.isKeyDown("down")) desiredSpeed = maxSpeed;
        }

        // Smoothly adjust the velocity towards the desired speed
        velocity += (desiredSpeed - velocity) * acceleration;

        // Move the paddle based on the current velocity
        if (getY() + velocity > 30 && getY() + velocity < getWorld().getHeight() - 30)
        {
            setLocation(getX(), (int)(getY() + velocity));
        }
    }

    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(10, height);
        image.setColor(Color.WHITE);
        image.fill();
        setImage(image);
    }

    public boolean getSide()
    {
        return this.isLeft;
    }

    public void increaseSize()
    {
        height *= 2 ;
        updateImage();
    }

    public void decreaseSize()
    {
        height = Math.max(20, height - 20);
        updateImage();
    }

    public void setColor(Color color)
    {
        GreenfootImage image = getImage();
        image.setColor(color);
        image.fill();
    }
}
