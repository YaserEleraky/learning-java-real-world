package ch02.solutions;

import javax.swing.*;

public class GoodbyeJava {
  public static void main( String[] args ) {
    JFrame frame = new JFrame( "Exercise: Goodbye, Java" );
    JLabel label = new JLabel("Goodbye, Java!", JLabel.CENTER );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.add(label);
    frame.setSize( 300, 200 );
    frame.setVisible( true );
  }
}
