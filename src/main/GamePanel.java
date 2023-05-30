import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {

  JPanel panel = new JPanel();

  final int originalTileSize = 16; // 16 x 16 pixels
  final int scale = 2; // scale up by 2
  final int tileSize = originalTileSize * scale; // 32 x 32 pixels

  final int maxScreenVert = 16;
  final int maxScreenHoriz = 16;
  final int screenWidth = tileSize * maxScreenVert; // 512 pixels
  final int screenHeight = tileSize * maxScreenHoriz; // 512 pixels
  int FPS = 60; // frames per second
  Thread gameThread; // thread for game loop (update, render, draw)

  KeyHandler keyH = new KeyHandler(); // create key handler object

  int playerX = 100; // player x default position
  int playerY = 100; // player y default position
  int playerSpeed = 2; // player speed

  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // set size of panel
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true); // for smoother animation
    this.addKeyListener(keyH); // add key listener to panel
    this.setFocusable(true);
  }

  public void startGameThread() {
    gameThread = new Thread(this); // create thread for game loop
    gameThread.start(); // start thread
  }

  @Override
  public void run() {

    // game loop constantly updates, renders, and draws
    double nsPerFrame = 1000000000.0 / FPS; // 1 billion nanoseconds divided by FPS = nanoseconds per frame
    double delta = 0; // change in time
    long lastTime = System.nanoTime(); // get current time in nanoseconds
    long currentTime;

    long timer = 0;
    int showCount = 0;
    while (gameThread != null) {

      currentTime = System.nanoTime(); // get current time in nanoseconds
      delta += (currentTime - lastTime) / nsPerFrame;
      // add change in time
      timer += currentTime - lastTime; // add change in time to timer
      lastTime = currentTime; // set last time to current time
      if (delta >= 1) { // if change in time is greater than or equal to 1 (1 frame has passed) then
                        // update, repaint, and reset change in time
        Update();
        repaint(); // calls paintComponent(g) IDK WHY LOL
        delta--; // reset change in time
        showCount++;
      }
      if (timer >= 1000000000) {
        System.out.println("FPS: " + showCount);
        showCount = 0;
        timer = 0;
      }
    }
  }

  public void Update() { // constantly update game logic

    if (keyH.upArrowPressed == true) {
      playerY -= playerSpeed; // move player up could also be playerY = playerY - playerSpeed
    } else if (keyH.downArrowPressed == true) {
      playerY += playerSpeed; // move player down
    } else if (keyH.leftArrowPressed == true) {
      playerX -= playerSpeed; // move player left
    } else if (keyH.rightArrowPressed == true) {
      playerX += playerSpeed; // move player right
    }
  }

  public void paintComponent(Graphics g) { // draw graphics
    super.paintComponent(g); // clears screen

    Graphics2D g2 = (Graphics2D) g; // cast to Graphics2D object

    g2.setColor(Color.WHITE);
    g2.fillRect(playerX, playerY, tileSize, tileSize); // fill screen with white
    g2.dispose(); // dispose of graphics context and release resources
  }

}
