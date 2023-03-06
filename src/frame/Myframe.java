package frame;

import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * Myframe
 */
public class Myframe extends JFrame{
  final static int WIDTH = 800;
  final static int HEIGHT = 500;

  public Myframe(){
    setTitle("Create Code Template");
    setSize(WIDTH,HEIGHT);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(new CreateTemplate(),BorderLayout.CENTER);
    setVisible(true);
  }
}