package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

  public boolean upArrowPressed, downArrowPressed, leftArrowPressed, rightArrowPressed; // booleans for arrow keys

  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode(); // get key key of the pressed key

    // ALLOWS FOR WASD TO BE USED INSTEAD OF ARROW KEYS
    if (key == KeyEvent.VK_W) { // if W key is pressed
      upArrowPressed = true;
    }
    if (key == KeyEvent.VK_A) { // if A key is pressed
      leftArrowPressed = true;
    }
    if (key == KeyEvent.VK_S) { // if S key is pressed
      downArrowPressed = true;
    }
    if (key == KeyEvent.VK_D) { // if D key is pressed
      rightArrowPressed = true;
    }

    // ALLOWS FOR ARROW KEYS TO BE USED INSTEAD OF WASD
    if (key == KeyEvent.VK_UP) { // if up key is pressed
      upArrowPressed = true;
    }
    if (key == KeyEvent.VK_LEFT) { // if left key is pressed
      leftArrowPressed = true;
    }
    if (key == KeyEvent.VK_DOWN) { // if down key is pressed
      downArrowPressed = true;
    }
    if (key == KeyEvent.VK_RIGHT) { // if right key is pressed
      rightArrowPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

    int key = e.getKeyCode();
    // get key key of the released key

    if (key == KeyEvent.VK_W) { // if W key is pressed
      upArrowPressed = false;
    }
    if (key == KeyEvent.VK_A) { // if A key is pressed
      leftArrowPressed = false;
    }
    if (key == KeyEvent.VK_S) { // if S key is pressed
      downArrowPressed = false;
    }
    if (key == KeyEvent.VK_D) { // if D key is pressed
      rightArrowPressed = false;
    }

    if (key == KeyEvent.VK_UP) { // if up key is pressed
      upArrowPressed = false;
    }
    if (key == KeyEvent.VK_LEFT) { // if left key is pressed
      leftArrowPressed = false;
    }
    if (key == KeyEvent.VK_DOWN) { // if down key is pressed
      downArrowPressed = false;
    }
    if (key == KeyEvent.VK_RIGHT) { // if right key is pressed
      rightArrowPressed = false;
    }

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

}