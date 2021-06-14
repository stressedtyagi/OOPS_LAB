/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class AlgerianFlag extends JComponent {
    public void paint(Graphics g) {
        Graphics2D g2 = ( Graphics2D ) g;

        // draw the orange space
        g2.setColor(Color.ORANGE);
        g2.fillRect(50, 50, 200, 50);

        // draw the white space
        g2.setColor(Color.WHITE);
        g2.fillRect(50, 101, 200, 50);

        // draw the green space
        g2.setColor(Color.GREEN);
        g2.fillRect(50, 152, 200, 50);

        // draw black pole
        g2.setColor(Color.BLACK);
        g2.fillRect(45, 52, 4, 400);

        // drawing inner blue chakra
        Shape circle=new Ellipse2D.Float(124.3f,103,50,46);
        Graphics2D ga=(Graphics2D)g;
        ga.draw(circle);
        ga.setPaint(Color.blue);
        ga.fill(circle);

        Graphics g1 = (Graphics) g;
        g1.setColor(Color.BLACK);
        g1.setFont(Font.getFont("Arial"));
        g1.drawString("Message should appear here : Random Text message",50,500);

        g1.setColor(Color.YELLOW);
        g1.fillOval(300,130,300,300);

//        g1.setColor(Color.ORANGE);
        g1.setColor(Color.BLACK);
        g1.fillOval(350, 165, 80, 80);
        g1.fillOval(460, 165, 80, 80);

        // Arc for the smile
        g1.setColor(Color.BLACK);
        g1.drawArc(360, 300, 170, 80, 180, 180);
    }
}

public class sol5 {
    public static void main(String[] args) {

        //create new frame object
        JFrame frame = new JFrame ("Algeria");

        // set the size of the frame
        frame.setSize(900 ,600);

        // set the location of the frame
        frame.setLocation(50,100);

        // create new object of type flag
        AlgerianFlag flag = new AlgerianFlag();

        // add the object flag to the frame
        frame.add(flag);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
