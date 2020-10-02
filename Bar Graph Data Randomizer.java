import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.geom.*;
import java.util.Random;

public class programOneGUI extends JPanel {

@Override
  public void paintComponent(Graphics g) {
   super.paintComponent(g);
    //makes grid
    for ( int x = 30; x <= 300; x += 30 )
    for ( int y = 30; y <= 300; y += 30 )
    g.drawRect( x, y, 30, 30 );

    //makes the bar graphs and generates different colors
    //and sizes everytime the function is called
    double x = 45;
    //loop to make the bars on the grid
    for (int i = 0; i < 12; i++){
      Random rand = new Random();
       //interval for the random bar length
      double min = 35;
      double max = 325;
      //generate random length between the interval
      double random_length = min + (max - min) * rand.nextDouble();

      //make line
      Line2D.Double line = new Line2D.Double(x, 325, x, random_length);
      Graphics2D g2d = (Graphics2D) g;

      //creates width and random color of line
      g2d.setColor(new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
      g2d.setStroke(new BasicStroke(10f));

      g2d.draw(line);
      x += 25;
    }

  }
   public static void main(String[] args) {
     programOneGUI table = new programOneGUI();
     JFrame frame = new JFrame("Random Bar Chart");
     frame.add(table, BorderLayout.CENTER);

     frame.setSize(400, 450);//sets the window size of the frame
     //frame.setLocation(100, 100);//sets the location of window on screen
     frame.setVisible(true);//be able to see frame
//BUTTON
    JButton button = new JButton("Redraw"); //creates the redraw button
     button.setBounds(50,100,95,30);
     frame.add(button, BorderLayout.SOUTH); //places the button at the bottom of the GUI


     button.addActionListener(new ActionListener(){ //creates an action listener for the button function to work
     public void actionPerformed(ActionEvent e){ //creates the function of the button an event for when the user clicks the button
                 frame.add(new programOneGUI()); //adds what is in the program class
                 frame.setVisible(true);
                 //System.out.println("CLICKED!");
             }
         });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// it exits application (JFrame) and releases memory.

   }
}
//TASKS
//1. a user-defined JFrame object, a user-defined JPanel object, and a JButton. & • The JPanel should have a paintComponent(Graphics g) method GABY
//2.•	 The JPanel should have a paintComponent(Graphics g) method & draw background 10X10 Brandon
//3.and draw lines of random lengths and colors Rach
//4.•	Every time user clicks the Redraw button, the program should randomly redraw the lines again lauren

//NOTES
//https://docs.oracle.com/javase/7/docs/api/index.html?javax/swing/JFrame.html
//https://javatutorial.net/swing-jframe-basics-create-jframe
//https://docs.oracle.com/javase/tutorial/uiswing/components/button.html
/*
JFrame(): creates a frame which is invisible
JFrame(GraphicsConfiguration gc): creates a frame with a blank title and graphics configuration of screen device.
JFrame(String title): creates a JFrame with a title.
JFrame(String title, GraphicsConfiguration gc): creates a JFrame with specific Graphics configuration and specified title.
*/
