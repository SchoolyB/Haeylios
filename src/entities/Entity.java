package entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

  public int worldCoordX, worldCoordY; // world coordinates
  public int speed;

  public BufferedImage down1, down2, up1, up2, left, right;
  public String direction;
  public int spriteCounter = 0;
  public int spriteNum = 1;
  public Rectangle hitbox; // hitbox for collision detection
  public boolean collisionOn = false;

}