package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entities.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

  JPanel panel = new JPanel();

  final int originalTileSize = 16; // 16 x 16 pixels
  final int scale = 4;
  public final int tileSize = originalTileSize * scale; // 32 x 32 pixels. made public so player class can access

  public final int maxScreenVert = 16;
  public final int maxScreenHoriz = 12;
  public final int screenWidth = tileSize * maxScreenVert; // 512 pixels
  public final int screenHeight = tileSize * maxScreenHoriz; // 512 pixels
  int FPS = 60; // frames per second

  // WORLD MAP VARIABLES
  public final int maxWorldMapVert = 50; // 50 tiles vertically in world map
  public final int maxWorldMapHoriz = 50; // 50 tiles horizontally in world map
  public final int worldMapWidth = tileSize * maxWorldMapVert; // 800 pixels
  public final int worldMapHeight = tileSize * maxWorldMapHoriz; // 800 pixels

  Thread gameThread; // thread for game loop (update, render, draw)
  KeyHandler keyH = new KeyHandler(); // create key handler object
  public Player player = new Player(this, keyH);
  public CollisionChecker collisionChecker = new CollisionChecker(this); // create collision checker object for
                                                                         // collision
  // detection between player and tiles
  TileManager tileManager = new TileManager(this);

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
    double nanosPerFrame = 1000000000.0 / FPS; // 1 billion nanoseconds divided by FPS = nanoseconds per frame
    double delta = 0; // change in time
    long lastTime = System.nanoTime(); // get current time in nanoseconds
    long currentTime;

    long timer = 0;
    int frameCount = 0;
    while (gameThread != null) {

      currentTime = System.nanoTime(); // get current time in nanoseconds
      delta += (currentTime - lastTime) / nanosPerFrame;
      // add change in time
      timer += currentTime - lastTime; // add change in time to timer
      lastTime = currentTime; // set last time to current time
      if (delta >= 1) { // if change in time is greater than or equal to 1 (1 frame has passed) then
                        // update, repaint, and reset change in time
        Update();
        repaint(); // calls paintComponent(g) IDK WHY LOL
        delta--; // reset change in time
        frameCount++;
      }
      if (timer >= 1000000000) {
        System.out.println("Current FPS: " + frameCount);
        frameCount = 0;
        timer = 0;
      }
    }
  }

  public void Update() { // constantly update game logic
    player.update();
  }

  public void paintComponent(Graphics g) { // draw graphics
    super.paintComponent(g); // clears screen

    Graphics2D g2 = (Graphics2D) g; // cast to Graphics2D object
    tileManager.draw(g2); // call this method before player.draw() so that the player is drawn on top of
                          // the tiles
    player.draw(g2);
    g2.dispose(); // dispose of graphics context and release resources
  }

}
