package main;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener {

  public boolean upArrowPressed, downArrowPressed, leftArrowPressed, rightArrowPressed; // booleans for arrow keys

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode(); // get key code of the pressed key

    // ALLOWS FOR WASD TO BE USED INSTEAD OF ARROW KEYS
    if (code == KeyEvent.VK_W) { // if W key is pressed
      upArrowPressed = true;
    }
    if (code == KeyEvent.VK_A) { // if A key is pressed
      leftArrowPressed = true;
    }
    if (code == KeyEvent.VK_S) { // if S key is pressed
      downArrowPressed = true;
    }
    if (code == KeyEvent.VK_D) { // if D key is pressed
      rightArrowPressed = true;
    }

    // ALLOWS FOR ARROW KEYS TO BE USED INSTEAD OF WASD
    if (code == KeyEvent.VK_UP) { // if up key is pressed
      upArrowPressed = true;
    }
    if (code == KeyEvent.VK_LEFT) { // if left key is pressed
      leftArrowPressed = true;
    }
    if (code == KeyEvent.VK_DOWN) { // if down key is pressed
      downArrowPressed = true;
    }
    if (code == KeyEvent.VK_RIGHT) { // if right key is pressed
      rightArrowPressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

    int code = e.getKeyCode();
    // get key code of the released key

    if (code == KeyEvent.VK_W) { // if W key is pressed
      upArrowPressed = false;
    }
    if (code == KeyEvent.VK_A) { // if A key is pressed
      leftArrowPressed = false;
    }
    if (code == KeyEvent.VK_S) { // if S key is pressed
      downArrowPressed = false;
    }
    if (code == KeyEvent.VK_D) { // if D key is pressed
      rightArrowPressed = false;
    }

    if (code == KeyEvent.VK_UP) { // if up key is pressed
      upArrowPressed = false;
    }
    if (code == KeyEvent.VK_LEFT) { // if left key is pressed
      leftArrowPressed = false;
    }
    if (code == KeyEvent.VK_DOWN) { // if down key is pressed
      downArrowPressed = false;
    }
    if (code == KeyEvent.VK_RIGHT) { // if right key is pressed
      rightArrowPressed = false;
    }

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

}