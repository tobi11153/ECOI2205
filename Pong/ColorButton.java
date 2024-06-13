import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ColorButton extends Actor
{
    private Color color;
    private String target;

    public ColorButton(Color color, String target)
    {
        this.color = color;
        this.target = target;
        GreenfootImage image = new GreenfootImage(50, 50);
        image.setColor(color);
        image.fill();
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            if (target.equals("Ball"))
            {
                world.setBallColor(color);
            }
            else if (target.equals("PaddleLeft"))
            {
                world.setLeftPaddleColor(color);
            }
            else if (target.equals("PaddleRight"))
            {
                world.setRightPaddleColor(color);
            }
        }
    }
}
