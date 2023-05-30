package entities;

import java.awt.image.BufferedImage;

public class Entity {

  public int x, y;
  public int speed;

  public BufferedImage down1, down2, up1, up2, left, right;
  public String direction;
  public int spriteCounter = 0;
  public int spriteNum = 1;

}