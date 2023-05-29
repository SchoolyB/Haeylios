import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class GamePanel extends JPanel implements Runnable {

  JPanel panel = new JPanel();

  final int originalTileSize = 16; // 16 x 16 pixels
  final int scale = 2; // scale up by 2
  final int tileSize = originalTileSize * scale; // 32 x 32 pixels

  final int maxScreenVert = 16;
  final int maxScreenHoriz = 16;
  final int screenWidth = tileSize * maxScreenVert; // 512 pixels
  final int screenHeight = tileSize * maxScreenHoriz; // 512 pixels

  Thread gameThread; // thread for game loop (update, render, draw)

  public GamePanel() {
    this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // set size of panel
    this.setBackground(Color.BLACK);
    this.setDoubleBuffered(true); // for smoother animation
  }

  public void startGameThread() {
    gameThread = new Thread(this); // create thread for game loop
    gameThread.start(); // start thread
  }

  @Override // override JPanel's paintComponent method
  public void run() {

  }
}
