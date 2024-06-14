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
    private int sets = 0;
    private boolean left;
    
    public Score(int size , boolean left)
    {
        this.score = 0;
        this.size = size;
        this.left = left;
        this.sets = 0;
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
         this.score++;
        if (score >= 3) {
            addSet();
            this.score = 0; // Reset points after earning a set
        }

        update();
    }

    private void addSet()
    {
        sets++;
    }
    
    public void update()
    {
        if(left){
        setImage(new GreenfootImage("" + sets + " : " + score, size, Color.WHITE, Color.BLACK));
    }else{
            setImage(new GreenfootImage("" + score + " : " + sets, size, Color.WHITE, Color.BLACK));

    }
    }
    
    public int getSets(){
        return this.sets;
    }
}
