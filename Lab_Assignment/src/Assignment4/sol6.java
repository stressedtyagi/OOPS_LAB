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

class MyFramePicture extends JFrame implements ActionListener {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private JPanel imagePanel;
    private JLabel label;
    private ImageIcon im;

    MyFramePicture() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 800);

        b1 = new Button("Image 1");
        b1.addActionListener(this);

        b2 = new Button("Image 2");
        b2.addActionListener(this);
        b3 = new Button("Image 3");
        b3.addActionListener(this);
        b4 = new Button("Image 4");
        b4.addActionListener(this);
        b5 = new Button("Image 5");
        b5.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(b1);
        buttonPanel.add(b2);
        buttonPanel.add(b3);
        buttonPanel.add(b4);
        buttonPanel.add(b5);
        label = new JLabel();
        imagePanel = new JPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, imagePanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(50);
        add(splitPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {
            if (source == b1) {
                imagePanel.removeAll();
                imagePanel.repaint();
                imagePanel.revalidate();
                im = new ImageIcon("img1.jpg");
                label.setIcon(im);
                imagePanel.add(label);
            } else if (source == b2) {
                imagePanel.removeAll();
                imagePanel.repaint();
                imagePanel.revalidate();
                im = new ImageIcon("img2.jpg");
                label.setIcon(im);
                imagePanel.add(label);
            } else if (source == b3) {
                imagePanel.removeAll();
                imagePanel.repaint();
                imagePanel.revalidate();
                im = new ImageIcon("img3.jpg");
                label.setIcon(im);
                imagePanel.add(label);
            } else if (source == b4) {
                imagePanel.removeAll();
                imagePanel.repaint();
                imagePanel.revalidate();
                im = new ImageIcon("img4.jpg");
                label.setIcon(im);
                imagePanel.add(label);
            } else if (source == b5) {
                imagePanel.removeAll();
                imagePanel.repaint();
                imagePanel.revalidate();
                im = new ImageIcon("img5.jpg");
                label.setIcon(im);
                imagePanel.add(label);
            }
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

public class sol6 {

    public static void main(String[] args) {
        MyFramePicture c = new MyFramePicture();
    }

}
