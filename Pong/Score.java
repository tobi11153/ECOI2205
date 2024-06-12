import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    private int score = 0;
    private int size;
    
    public Score(int size)
    {
        this.score = 0;
        this.size = size;
    }
    
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        update();
    }
    
    public void add()
    {
        this.score = this.score + 1;
    }
    
    public void update()
    {
        setImage(new GreenfootImage(""+this.score, this.size, Color.WHITE, Color.BLACK));
    }
}
