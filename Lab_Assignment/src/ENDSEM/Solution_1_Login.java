/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package ENDSEM;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Solution_1_Login extends Frame implements ActionListener {
    TextField emailField, passwordField;
    Label emailLabel, passwordLabel, displayUserLabel;
    Button loginBtn;

    Solution_1_Login() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // add email field
        emailLabel = new Label("Email");
        emailField = new TextField();
        add(emailLabel);
        add(emailField);

        // add password field
        passwordLabel = new Label("Password");
        passwordField = new TextField();
        add(passwordLabel);
        add(passwordField);

        // add login button
        loginBtn = new Button("Login");
        loginBtn.addActionListener(this);
        add(loginBtn);

        // user display field
        displayUserLabel = new Label("");
        add(displayUserLabel);

        setSize(400, 200);
        setLayout(new GridLayout(3, 2));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Solution_1_Login();
    }

    public void actionPerformed(ActionEvent e) {
        String email = emailField.getText();
        String password = passwordField.getText();

        FileReader fr;
        BufferedReader brf;

        try {
            fr = new FileReader("userdata.txt");
            brf = new BufferedReader(fr);

            String line;
            while ((line = brf.readLine()) != null) {
                String output[] = line.split("\t");
                if (email.equals(output[2]) && password.equals(output[5])) {
                    displayUserLabel.setText(line);
                    break;
                }
            }
            brf.close();
            fr.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

