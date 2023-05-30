package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.text.SimpleDateFormat;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

  GamePanel gamePanel;
  KeyHandler KeyH;

  public Player(GamePanel gamePanel, KeyHandler KeyH) {
    this.gamePanel = gamePanel;
    this.KeyH = KeyH; // why did I have to do this???
    setDefaultValues();

  };

  public void setDefaultValues() {
    x = 100;
    y = 100;
    speed = 4;
  }

  public void update() {

    if (KeyH.upArrowPressed == true) {
      y -= speed; // move player up could also be playerY = playerY - playerSpeed
    } else if (KeyH.downArrowPressed == true) {
      y += speed; // move player down
    } else if (KeyH.leftArrowPressed == true) {
      x -= speed; // move player left
    } else if (KeyH.rightArrowPressed == true) {
      x += speed; // move player right
    }

  }

  public void draw(Graphics2D g2) {

    g2.setColor(Color.WHITE);
    g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize); // fill screen with white

  }

}
