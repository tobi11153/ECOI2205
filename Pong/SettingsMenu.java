import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SettingsMenu extends Actor
{
    private String[] targets = {"Ball", "PaddleLeft", "PaddleRight"};
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};

    public SettingsMenu()
    {
        // Constructor
    }

    protected void addedToWorld(World world)
    {
        for (int i = 0; i < targets.length; i++)
        {
            for (int j = 0; j < colors.length; j++)
            {
                ColorButton button = new ColorButton(colors[j], targets[i]);
                world.addObject(button, 100 + j * 60, 100 + i * 60);
            }
        }
    }
}
