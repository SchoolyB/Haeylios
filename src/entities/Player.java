package entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

  GamePanel gamePanel;
  KeyHandler KeyH;

  public final int screenX; // returns half of screen width, thus
                            // placing player in center
  // of screen
  public final int screenY;

  public Player(GamePanel gamePanel, KeyHandler KeyH) {
    this.gamePanel = gamePanel;
    this.KeyH = KeyH; // why did I have to do this???
    screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2; // returns half of screen width, thus placing player
                                                                  // in center of screen
    screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2; // returns half of screen height, thus placing player
                                                                   // in center of screen
    setDefaultValues();
    getPlayerSprite();
  };

  public void setDefaultValues() {
    worldX = gamePanel.tileSize * 23; // sets player's world position to center of screen
    worldY = gamePanel.tileSize * 21; // sets player's world position to center of screen
    speed = 4;
    direction = "down";
  }

  public void getPlayerSprite() {
    try { // never forget how much I struggled with this and all the errors I
          // got...literally didnt change anything and it worked
      down1 = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/down1.png"));
      down2 = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/down2.png"));
      up1 = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/up1.png"));
      up2 = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/up2.png"));
      left = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/left.png"));
      right = ImageIO.read(getClass().getResourceAsStream("../resources/sprites/player/right.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update() {

    if (KeyH.upArrowPressed == true) {
      direction = "up";
      worldY -= speed; // move player up could also be playerY = playerY - playerSpeed
    } else if (KeyH.downArrowPressed == true) {
      direction = "down";
      worldY += speed; // move player down
    } else if (KeyH.leftArrowPressed == true) {
      direction = "left";
      worldX -= speed; // move player left
    } else if (KeyH.rightArrowPressed == true) {
      direction = "right";
      worldX += speed; // move player right
    }

    spriteCounter++;
    if (spriteCounter > 12) {
      if (spriteNum == 1) {
        spriteNum = 2;

      } else if (spriteNum == 2) {
        spriteNum = 1;
      }
      spriteCounter = 0;
    }
  }

  public void draw(Graphics2D g2) {

    BufferedImage image = null;

    switch (direction) {
      case "up":
        if (spriteNum == 1) {
          image = up1;
        }
        if (spriteNum == 2) {
          image = up2;
        }
        break;
      case "down":
        if (spriteNum == 1) {
          image = down1;
        }
        if (spriteNum == 2) {
          image = down2;
        }
        break;
      case "left":
        if (spriteNum == 1) {
          image = left;
        }
        if (spriteNum == 2) {
          image = left;
        }

        break;
      case "right":
        if (spriteNum == 1) {
          image = right;
        }
        if (spriteNum == 2) {
          image = right;
        }
        break;
    }

    g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null); // draw player sprite at
                                                                                         // playerX,
    // playerY
    // with width and height of playerSize null
    // is for ImageObserver which we don't need
    // to worry about
  }

}
