import greenfoot.*;

public class Menu extends Actor
{
    private StartButton startButton;
    private SettingsButton settingsButton;
    private ReturnButton returnButton;
    private boolean isPaused;

    public Menu(boolean isPaused)
    {
        this.isPaused = isPaused;
        if (isPaused) {
            returnButton = new ReturnButton();
        } else {
            startButton = new StartButton();
        }
        settingsButton = new SettingsButton();
    }

    protected void addedToWorld(World world)
    {
        if (!isPaused) {
            world.addObject(startButton, world.getWidth() / 2, world.getHeight() / 2 - 30);
        } else {
            world.addObject(returnButton, world.getWidth() / 2, 30 );
        }
        world.addObject(settingsButton, world.getWidth() / 2, world.getHeight() / 2 + 30);
    }
    
        public void removeButtons()
    {
        if (!isPaused) {
            getWorld().removeObject(startButton);
        } else {
            getWorld().removeObject(returnButton);
        }
        getWorld().removeObject(settingsButton);
    }
}