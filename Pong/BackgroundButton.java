import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BackgroundButton extends Actor
{
    private String imagem;

    public BackgroundButton(String imagem)
    {
        this.imagem = imagem;
        GreenfootImage image = new GreenfootImage(imagem);
        image.scale(16, 16);
        setImage(image);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            PongWorld world = (PongWorld) getWorld();
            world.setBackgroundImage(imagem);
        }
    }
}
