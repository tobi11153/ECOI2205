import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SettingsMenu extends Actor
{
    private String[] targets = {"Ball", "PaddleLeft", "PaddleRight"};
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};
    private String[] backgroundImages = {"space1.jpg", "beach.jpg", "table.png"}; 

    public SettingsMenu()
    {
        
    }

    protected void addedToWorld(World world)
    {
        // Add color buttons with labels
        for (int i = 0; i < targets.length; i++)
        {
            addLabel(targets[i], 50, 100 + i * 60);
            for (int j = 0; j < colors.length; j++)
            {
                ColorButton button = new ColorButton(colors[j], targets[i]);
                world.addObject(button, 200 + j * 60, 100 + i * 60);
            }
        }

        // Add background buttons with label
        addLabel("Background", 50, 100 + targets.length * 60);
        for (int i = 0; i < backgroundImages.length; i++)
        {
            BackgroundButton button = new BackgroundButton(backgroundImages[i]);
            world.addObject(button, 100 + i * 100, 100 + targets.length * 60);
        }
    }

    private void addLabel(String text, int x, int y)
    {
        GreenfootImage label = new GreenfootImage(text, 24, Color.WHITE, new Color(0, 0, 0, 0));
        getWorld().getBackground().drawImage(label, x, y);
    }
}
