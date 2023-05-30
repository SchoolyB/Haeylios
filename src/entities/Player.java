package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

  GamePanel gamePanel;
  KeyHandler KeyH;

  public Player(GamePanel gamePanel, KeyHandler KeyH) {
    this.gamePanel = gamePanel;
    this.KeyH = KeyH; // why did I have to do this???
    setDefaultValues();
    getPlayerSprite();
  };

  public void setDefaultValues() {
    x = 100;
    y = 100;
    speed = 4;
    direction = "down";
  }

  public void getPlayerSprite() {
    try {
      down1 = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/down1.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update() {

    if (KeyH.upArrowPressed == true) {
      y -= speed; // move player up could also be playerY = playerY - playerSpeed
      direction = "up";
    } else if (KeyH.downArrowPressed == true) {
      y += speed; // move player down
      direction = "down";
    } else if (KeyH.leftArrowPressed == true) {
      x -= speed; // move player left
      direction = "left";
    } else if (KeyH.rightArrowPressed == true) {
      x += speed; // move player right
      direction = "right";
    }

  }

  public void draw(Graphics2D g2) {

    // g2.setColor(Color.WHITE);
    // g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize); // fill screen
    // with white

    BufferedImage image = null;

    switch (direction) {
      case "up":
        image = down1;
        break;
      case "down":
        image = down1;
        break;
      case "left":
        image = down1;
        break;
      case "right":
        image = down1;
        break;
    }

    g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null); // draw player sprite at playerX, playerY
                                                                             // with width and height of playerSize null
                                                                             // is for ImageObserver which we don't need
                                                                             // to worry about
  }

}
