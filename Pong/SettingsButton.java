import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//menu para mecher nas configurações
public class SettingsButton extends Actor
{
    public SettingsButton()
    {
        Font settingsFont = new Font("Arial", true, false, 24);
        GreenfootImage image = new GreenfootImage(140, 50);
        image.setColor(Color.YELLOW);
        image.fill();
        image.setColor(Color.BLACK);
        image.setFont(settingsFont);
        image.drawString("Settings", 20, 30);
        setImage(image);
    }
        public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            // Open settings menu or perform settings-related actions
            System.out.println("Settings clicked");
        }
    }
}