import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PongWorld extends World
{
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private LeftScore leftScore;
    private RightScore rightScore;
    private boolean isGameStarted;
    private Menu menu;
    private PauseButton pauseButton;
    private int powerupcount = 0;
    private SettingsMenu settingsMenu;



    public PongWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        isGameStarted = false;
        
        // Add menu (which contains the start button) to the world
        menu = new Menu(false);
        addObject(menu, getWidth() / 2, getHeight() / 2);
    }
    
    public void startGame()
    {
        isGameStarted = true;
        
        
        // Add paddles to the world
        leftPaddle = new Paddle(true);
        rightPaddle = new Paddle(false);
        addObject(leftPaddle, 50, getHeight() / 2);
        addObject(rightPaddle, getWidth() - 50, getHeight() / 2);
        
        // Add ball to the world
        ball = new Ball();            
        addObject(ball, getWidth() / 2, getHeight() / 2);
        
        // Left and right scores
        leftScore = new LeftScore();
        addObject(leftScore, getWidth()/2 - 120, 48);
        rightScore = new RightScore();
        addObject(rightScore, getWidth()/2 + 120, 48);
        
        //criar botao de pausa
        pauseButton = new PauseButton();
        addObject(pauseButton, getWidth()/2, 30);
        
        //remover menu
        menu.removeButtons();
        removeObject(menu);
    
    }
    
    public Ball getBall()
    {
        return this.ball;
    }
    
    public LeftScore getLeftScore()
    {
        return this.leftScore;
    }
    
    public RightScore getRightScore()
    {
        return this.rightScore;
    }
    
        public Paddle getLeftPaddle() {
        return this.leftPaddle;
    }

    public Paddle getRightPaddle() {
        return rightPaddle;
    }
    
    public boolean isGameStarted()
    {
        return isGameStarted;
    }
    
        public void pauseGame()
    {
        isGameStarted = false;
        menu = new Menu(true);
        addObject(menu, getWidth() / 2, getHeight() / 2);
        removeObject(pauseButton); // Remove pause button
    }
    
        public void resumeGame()
    {
        isGameStarted = true;
        menu.removeButtons();
        removeObject(menu);
        addObject(pauseButton, getWidth()/2, 30);
        
    }
    
        private void addPowerUp()
    {
        if (Greenfoot.getRandomNumber(100) < 10) // Adjust the probability as needed
        {
            int margem = 60;
            int x = margem + Greenfoot.getRandomNumber(getWidth() - 2 * margem);
            int y = margem + Greenfoot.getRandomNumber(getHeight() - 2 * margem);
            int powerUpType = Greenfoot.getRandomNumber(3);

            switch (powerUpType) {
                case 0:
                    addObject(new SpeedPowerUp(), x, y); // Speed increase
                    break;
                case 1:
                    addObject(new IncreasePaddleSizePowerUp(), x, y); // Increase paddle size
                    break;
                case 2:
                    addObject(new DecreaseOpponentPaddleSizePowerUp(), x , y ); //decrease paddle size
                    break;
                }
    
}
}

    public void act()
    {
        if (isGameStarted) {
            if (Greenfoot.getRandomNumber(1000) < 5) //probabilidade de aparecer powerup
            {
                addPowerUp();
            }
        }
    }
    
    public void decreasepower(){
        powerupcount = powerupcount - 1;
    }
        public void setBallColor(Color color)
    {
        ball.setColor(color);
    }

    public void setLeftPaddleColor(Color color)
    {
        leftPaddle.setColor(color);
    }

    public void setRightPaddleColor(Color color)
    {
        rightPaddle.setColor(color);
    }
    
        public void openSettings()
    {
        settingsMenu = new SettingsMenu();
        addObject(settingsMenu, getWidth() / 2, getHeight() / 2);
        menu.removeButtons();
        removeObject(menu);
    }
    
        public void closeSettings()
    {
        removeObject(settingsMenu);
        menu = new Menu(isGameStarted);
        addObject(menu, getWidth() / 2, getHeight() / 2);
    }
    
        public void setBackgroundImage(String imageFile)
    {
        GreenfootImage bg = new GreenfootImage(imageFile);
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
    }
}

