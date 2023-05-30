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
      y -= speed; // move player up could also be playerY = playerY - playerSpeed
    } else if (KeyH.downArrowPressed == true) {
      direction = "down";
      y += speed; // move player down
    } else if (KeyH.leftArrowPressed == true) {
      direction = "left";
      x -= speed; // move player left
    } else if (KeyH.rightArrowPressed == true) {
      direction = "right";
      x += speed; // move player right
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

    g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null); // draw player sprite at playerX, playerY
                                                                             // with width and height of playerSize null
                                                                             // is for ImageObserver which we don't need
                                                                             // to worry about
  }

}
