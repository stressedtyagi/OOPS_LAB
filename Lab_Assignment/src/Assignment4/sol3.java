/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sol3 extends Frame implements ActionListener {
    private Label label;
    private Button button;
    private TextArea textArea;
    private FileWriter writer;
    private BufferedWriter bufferWriter;

    sol3() {
        super("Sol 3");
        setSize(800, 600);

        textArea = new TextArea();
        textArea.setBounds(10, 80, 500, 100);
        add(textArea);

        label = new Label();
        label.setBounds(10, 200, 500, 30);
        add(label);

        button = new Button("Submit");
        button.setBounds(10, 240, 100, 30);
        button.addActionListener(this);
        add(button);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tex = textArea.getText();
        if (tex.split(" ").length < 30) {
            label.setForeground(Color.RED);
            label.setText("Minimum number of words should be 30.");
            return;
        }
        try {
            writer = new FileWriter("biodata.txt");
            bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(tex);
            bufferWriter.close();
            writer.close();
            label.setForeground(Color.GREEN);
            label.setText("Successfully copied to the file!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new sol3();
    }
}
