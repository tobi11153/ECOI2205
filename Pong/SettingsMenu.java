import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

public class SettingsMenu extends Actor
{
    private String[] targets = {"Ball", "PaddleLeft", "PaddleRight"};
    private Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA};
    private String[] backgroundImages = {"space1.jpg", "beach.jpg", "table.png"}; 
    private List<Actor> buttonsAndLabels = new ArrayList<>();

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
                buttonsAndLabels.add(button);

                world.addObject(button, 200 + j * 60, 80 + i * 60);
            }
        }

        // Add background buttons with label
        addLabel("Background", 50, 100 + targets.length * 60);
        for (int i = 0; i < backgroundImages.length; i++)
        {
            BackgroundButton button = new BackgroundButton(backgroundImages[i]);
            buttonsAndLabels.add(button);

            world.addObject(button, 200 + i * 100, 80 + targets.length * 60);
        }
        
        backButton backButton = new backButton();
        buttonsAndLabels.add(backButton);

        world.addObject(backButton, world.getWidth() / 2, world.getHeight() - 50);
    }

    private void addLabel(String text, int x, int y)
    {
        Label label = new Label(text, 24);
        buttonsAndLabels.add(label);
        getWorld().addObject(label, x + 50, y - 15); // Adjusted position to center the label
    }
    
        public void removeButtonsAndLabels()
    {
        World world = getWorld();
        if (world != null) {
            for (Actor actor : buttonsAndLabels) {
                world.removeObject(actor);
            }
            buttonsAndLabels.clear();
        }
    }
}


class Label extends Actor
{
    public Label(String text, int size)
    {
        GreenfootImage label = new GreenfootImage(text, size, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(label);
    }
    
}
