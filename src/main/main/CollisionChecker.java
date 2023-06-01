package main;

import entities.Entity;

public class CollisionChecker {

  GamePanel gamePanel;

  public CollisionChecker(GamePanel gamePanel) {

    this.gamePanel = gamePanel;

  }

  public void CheckTile(Entity entity) {

    int entityLeftWorldX = entity.worldCoordX + entity.hitbox.x; // x coord of left side of entity
    int entityRightWorldX = entity.worldCoordX + entity.hitbox.x + entity.hitbox.width; // x coord of right side of
                                                                                        // entity
    int entityTopWorldY = entity.worldCoordY + entity.hitbox.y; // y coord of top side of entity
    int entityBottomWorldY = entity.worldCoordY + entity.hitbox.y + entity.hitbox.height; // y coord of bottom side of
                                                                                          // entity

    int entityLeftVert = entityLeftWorldX / gamePanel.tileSize;
    int entityRightVert = entityRightWorldX / gamePanel.tileSize;
    int entityTopHoriz = entityTopWorldY / gamePanel.tileSize;
    int entityBottomHoriz = entityBottomWorldY / gamePanel.tileSize;

    int tileNum1, tileNum2;

    switch (entity.direction) {
      case "up":
        entityTopHoriz = (entityTopWorldY - entity.speed) / gamePanel.tileSize; //
        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftVert][entityTopHoriz];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityRightVert][entityTopHoriz];
        if (gamePanel.tileManager.tile[tileNum1].collision == true
            || gamePanel.tileManager.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "down":
        entityBottomHoriz = (entityBottomWorldY + entity.speed) / gamePanel.tileSize;
        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftVert][entityBottomHoriz];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityRightVert][entityBottomHoriz];
        if (gamePanel.tileManager.tile[tileNum1].collision == true
            || gamePanel.tileManager.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "left":
        entityLeftVert = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftVert][entityTopHoriz];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftVert][entityBottomHoriz];
        if (gamePanel.tileManager.tile[tileNum1].collision == true
            || gamePanel.tileManager.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "right":
        entityRightVert = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
        tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftVert][entityTopHoriz];
        tileNum2 = gamePanel.tileManager.mapTileNum[entityRightVert][entityBottomHoriz];
        if (gamePanel.tileManager.tile[tileNum1].collision == true
            || gamePanel.tileManager.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
    }
  }
}
