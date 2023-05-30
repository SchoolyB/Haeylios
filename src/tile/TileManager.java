package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import main.GamePanel;
import java.awt.Graphics2D;

public class TileManager {

  GamePanel gamePanel; // reference to gamePanel
  Tile[] tile; // array of tiles
  int mapTileNum[][]; // array of tile numbers

  public TileManager(GamePanel gamePanel) {
    this.gamePanel = gamePanel; // set reference to gamePanel
    tile = new Tile[10]; // create array of tiles with 10 elements
    mapTileNum = new int[gamePanel.maxScreenVert][gamePanel.maxScreenHoriz];

    getTileImage();
    loadMap();

  }

  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass1.png"));

      tile[1] = new Tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/tallGrass1.png"));

      // todo copy and paste the above line for each tile image like water, sand etc.
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadMap() {
    // load map from file
    try {
      InputStream is = getClass().getResourceAsStream("../resources/maps/map1.txt"); // get map file from resources
      BufferedReader br = new BufferedReader(new InputStreamReader(is)); // read map file line by line
      int col = 0;
      int row = 0;

      while (col < gamePanel.maxScreenVert && row < gamePanel.maxScreenHoriz) {
        String line = br.readLine(); // read single line from map file

        while (col < gamePanel.maxScreenVert) {
          String numbers[] = line.split(" "); // split line into array of strings
          int num = Integer.parseInt(numbers[col]); // convert string to integer
          mapTileNum[col][row] = num; // store tile number in mapTileNum array
          col++; // increment col by one
        }
        if (col == gamePanel.maxScreenVert) { // if col is equal to max screen vert reset col to 0 and increment row
                                              // by one
          col = 0;
          row++;
        }

      }
      br.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void draw(Graphics2D g2) {

    int col = 0;
    int row = 0;

    int x = 0;
    int y = 0;

    while (col < gamePanel.maxScreenVert && row < gamePanel.maxScreenHoriz) { // while col and row are less than max

      // screen size draw tiles

      int tileNum = mapTileNum[col][row]; // get tile number from mapTileNum array

      g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null); // passes the image, x, y,
                                                                                             // width, height, observer
      col++; // increment col by one
      x += gamePanel.tileSize; // increment x by tile size
      if (col == gamePanel.maxScreenVert) { // if col is equal to max screen vert reset col to 0 and increment row by
                                            // one
        col = 0; // reset col to 0
        x = 0; // reset x to 0
        row++; // increment row by one
        y += gamePanel.tileSize; // increment y by tile size
      }
    }

  }

}
