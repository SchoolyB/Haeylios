package main;

import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false); // prevents resizing
    window.setTitle("Project Haeylios");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel); // add gamePanel to window
    window.pack(); // set window size to preferred size of gamePanel
    window.setLocationRelativeTo(null); // centers window
    window.setVisible(true);
    gamePanel.startGameThread();
  }
}
