/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Write a java program to implement the following
In a frame left side add several buttons in one by one, on clicking each button one image should
appear on right side of the frame, initially no image should be there, have totally 5 buttons, once
you click on a button, an image will be appear there and after that if you click another button
another image should appear at same place where previous image is appeared. Which images to
show is up to you
*/

public class sol6 implements ActionListener {
    static JFrame frame;
    static private JButton bt1, bt2, bt3, bt4, bt5;
    static private ImageIcon icon1, icon2, icon3, icon4, icon5;
    static JLabel label = null;

    public static void main(String[] args) {

        sol6 obj = new sol6();

        frame = new JFrame("Random Image Generator");
        frame.setLayout(new FlowLayout());
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        bt1 = new JButton("Image 1");
        bt1.setFont(new Font("Arial", Font.PLAIN, 15));
        bt1.setSize(100, 20);
        bt1.addActionListener(obj);
        frame.add(bt1);

        bt2 = new JButton("Image 2");
        bt2.setFont(new Font("Arial", Font.PLAIN, 15));
        bt2.setSize(100, 20);
        bt2.addActionListener(obj);
        frame.add(bt2);

        bt3 = new JButton("Image 3");
        bt3.setFont(new Font("Arial", Font.PLAIN, 15));
        bt3.setSize(100, 20);
        bt3.addActionListener(obj);
        frame.add(bt3);

        bt4 = new JButton("Image 4");
        bt4.setFont(new Font("Arial", Font.PLAIN, 15));
        bt4.setSize(100, 20);
        bt4.addActionListener(obj);
        frame.add(bt4);

        bt5 = new JButton("Image 5");
        bt5.setFont(new Font("Arial", Font.PLAIN, 15));
        bt5.setSize(100, 20);
        bt5.addActionListener(obj);
        frame.add(bt5);

        icon1 = new ImageIcon("img1.jpg");
        icon2 = new ImageIcon("img2.jpg");
        icon3 = new ImageIcon("img3.jpg");
        icon4 = new ImageIcon("img4.jpg");
        icon5 = new ImageIcon("img5.jpg");

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(label != null)
            frame.remove(label);
        if (source == bt1) {
            label = new JLabel(icon1);
        } else if (source == bt2) {
            label = new JLabel(icon2);
        } else if (source == bt3) {
            label = new JLabel(icon3);
        } else if (source == bt4) {
            label = new JLabel(icon4);
        } else if (source == bt5) {
            label = new JLabel(icon5);
        }

        frame.add(label);
        frame.pack();
        frame.setSize(900, 600);
    }
}
