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
  public Tile[] tile; // array of tiles
  public int mapTileNum[][]; // array of tile numbers

  public TileManager(GamePanel gamePanel) {
    this.gamePanel = gamePanel; // set reference to gamePanel
    tile = new Tile[10]; // create array of tiles with 10 elements
    mapTileNum = new int[gamePanel.maxWorldMapVert][gamePanel.maxWorldMapHoriz];

    getTileImage();
    loadMap();

  }

  public void getTileImage() {
    try {
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/grass1.png"));

      tile[1] = new Tile();
      tile[1].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/tallGrass1.png"));

      tile[2] = new Tile();
      tile[2].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/wheat1.png"));

      tile[3] = new Tile();
      tile[3].image = ImageIO.read(getClass().getResourceAsStream("../resources/tiles/bush1.png"));
      tile[3].collision = true; // set collision to true to not allow player to walk through bushes

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void loadMap() {
    // load map from file
    try {
      InputStream is = getClass().getResourceAsStream("../resources/maps/world-map-calidos.txt"); // get map file from
                                                                                                  // resources
      BufferedReader br = new BufferedReader(new InputStreamReader(is)); // read map file line by line
      int col = 0;
      int row = 0;

      while (col < gamePanel.maxWorldMapVert && row < gamePanel.maxWorldMapHoriz) {
        String line = br.readLine(); // read single line from map file

        while (col < gamePanel.maxWorldMapVert) {
          String numbers[] = line.split(" "); // split line into array of strings
          int num = Integer.parseInt(numbers[col]); // convert string to integer
          mapTileNum[col][row] = num; // store tile number in mapTileNum array
          col++; // increment col by one
        }
        if (col == gamePanel.maxWorldMapVert) { // if col is equal to max screen vert reset col to 0 and increment row
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

    int worldVert = 0;
    int worldHoriz = 0;

    while (worldVert < gamePanel.maxWorldMapVert && worldHoriz < gamePanel.maxWorldMapHoriz) { // while worldVert and
                                                                                               // worldHoriz are less
                                                                                               // than max

      // screen size draw tiles

      int tileNum = mapTileNum[worldVert][worldHoriz]; // get tile number from mapTileNum array

      int worldCoordX = worldVert * gamePanel.tileSize; // calculate worldCoordX
      int worldCoordY = worldHoriz * gamePanel.tileSize; // calculate worldCoordY
      int screenX = worldCoordX - gamePanel.player.worldCoordX + gamePanel.player.screenX; // calculate screenX
      int screenY = worldCoordY - gamePanel.player.worldCoordY + gamePanel.player.screenY; // calculate screenY

      // if the player is a certain distance from the tile, draw it...
      // pretty wicked if statement
      if (worldCoordX + gamePanel.tileSize > gamePanel.player.worldCoordX - gamePanel.player.screenX &&
      // the plus and minus gamePanel.tileSize is to make sure the tile is drawn even
      // if the player is only half on the tile
          worldCoordX - gamePanel.tileSize < gamePanel.player.worldCoordX + gamePanel.player.screenX &&
          worldCoordY + gamePanel.tileSize > gamePanel.player.worldCoordY - gamePanel.player.screenY &&
          worldCoordY - gamePanel.tileSize < gamePanel.player.worldCoordY + gamePanel.player.screenY) {

        g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null); // passes the
      }
      // image, x, y,
      // width, height, observer
      worldVert++; // increment worldVert by one
      if (worldVert == gamePanel.maxWorldMapVert) { // if worldVert maxWorldMapHoriz equal to max screen vert reset
                                                    // worldVert to 0 and increment worldHoriz by
        // one
        worldVert = 0; // reset col to 0

        worldHoriz++; // increment worldHoriz by one

      }
    }

  }

}
