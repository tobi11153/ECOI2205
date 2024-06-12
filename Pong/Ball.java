import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ball extends Actor
{
    private int xSpeed = 3;
    private int ySpeed = 3;
    private int batidas = 0;
    private boolean powered = false;
    private long powerUpStartTime;
    private static final int POWER_UP_DURATION = 3000; // 3 seconds in milliseconds
    private Paddle lastHitPaddle;

    /* 
     * Constructor
     */
    public Ball()
    {
        GreenfootImage image = new GreenfootImage(32, 32);
        image.setColor(Color.GREEN);
        image.fillOval(0, 0, 32, 32);
        setImage(image);
    }

    public void act()
    {
        PongWorld world = (PongWorld) getWorld();
        if (world.isGameStarted())
        {
            move();
            checkCollision();     
            if(powered){ 
                checkPowerUpDuration(); 
            }
        }
    }

    private void move()
    {
        PongWorld world = (PongWorld) getWorld();
        Score score = null;
        
        setLocation(getX() + xSpeed, getY() + ySpeed);
        
        if (getY() <= 0 || getY() >= world.getHeight() - 1)
        {
            ySpeed = -ySpeed;
        }
        
        if (getX() <= 0)
        {
            score = world.getRightScore();
        }
        
        if (getX() >= world.getWidth() - 1)
        {
            score = world.getLeftScore();
        }
        
        if (score != null)
        {
            score.add();
            score.update();
            
            resetPosition();
        }
    }

    private void checkCollision()
    {
        if (isTouching(Paddle.class))
        {
            lastHitPaddle = (Paddle) getOneIntersectingObject(Paddle.class);
            
            xSpeed = -xSpeed;
            
            //Aumenta a velocidade a cada x batidas
            batidas = batidas + 1;
            if(batidas >= 3){
              xSpeed =  xSpeed < 0 ? xSpeed - 1 : xSpeed + 1;
               batidas = 0;
            }
        }
    }

    private void resetPosition()
    {
        setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        xSpeed = Greenfoot.getRandomNumber(2) == 0 ? 3 : -3;
        ySpeed = Greenfoot.getRandomNumber(2) == 0 ? 3 : -3;
        powered = false;
    }
    
    public void doublexSpeed(){
        if (!powered) {
            xSpeed *= 2;
            powered = true;
            powerUpStartTime = System.currentTimeMillis();
        }
    }

    private void checkPowerUpDuration()
    {
        if (powered && (System.currentTimeMillis() - powerUpStartTime >= POWER_UP_DURATION)) {
            xSpeed /= 2;
            powered = false;
        }
    }
    
    public int getxSpeed(){
        return this.xSpeed;
    }
    
        public Paddle getLastHitPaddle()
    {
        return lastHitPaddle;
    }

  
}
