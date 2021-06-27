/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class sol4 extends Frame implements MouseListener {
    private Label label_1;
    private JLabel log_label;

    sol4() {
        label_1 = new Label("All MOUSE actions will be logged here.");
        label_1.setBounds(30, 80, 400, 30);
        add(label_1);

        log_label = new JLabel("");
        log_label.setFont(new Font("Arial", Font.BOLD, 20));
        log_label.setBounds(50, 50, 100, 30);
        add(log_label);

        setSize(600, 600);
        setVisible(true);
        addMouseListener(this);
        setLayout(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void log(String msg) {
        this.log_label.setText(msg);
    }

    public void mouseClicked(MouseEvent e) {
        log("Mouse Clicked.");
    }

    public void mouseEntered(MouseEvent e) {
        log("Mouse Entered");
    }

    public void mousePressed(MouseEvent e) {
        log("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
        log("Mouse Released");
    }

    public void mouseExited(MouseEvent e) {
        log("Mouse Exit");
    }

    public static void main(String[] args) {
        new sol4();
    }
}
