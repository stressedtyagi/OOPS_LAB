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

public class Solution_1 extends Frame implements ActionListener {
    TextField firstNameField, lastNameField, emailField, passwordField, phoneField;
    Dialog stateDialog;
    Button signUpBtn, selectStateBtn;
    Choice stateField;
    Label warningLabel, firstNameLabel, lastNameLabel, emailLabel, passwordLabel, phoneLabel;
    String firstname, lastname, email, password, phone, state;

    Solution_1() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // add names fields
        firstNameLabel = new Label("First Name");
        lastNameLabel = new Label("Last Name");
        firstNameField = new TextField();
        lastNameField = new TextField();
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);

        // add email
        emailLabel = new Label("Email");
        emailField = new TextField();
        add(emailLabel);
        add(emailField);

        // add password
        passwordLabel = new Label("Password");
        passwordField = new TextField();
        add(passwordLabel);
        add(passwordField);

        // add phoneField
        phoneLabel = new Label("Phone");
        phoneField = new TextField();
        add(phoneLabel);
        add(phoneField);

        // add state popup
        stateDialog = new Dialog(this, "Choose State", true);
        stateDialog.setLayout(new FlowLayout());
        Button cnfStateBtn = new Button("Confirm");
        stateField = new Choice();
        stateField.add("Punjab");
        stateField.add("Tamil Nadu");
        stateField.add("Delhi");
        stateField.add("Haryana");
        stateField.add("Maharashtra");
        cnfStateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String res = stateField.getSelectedItem();
                state = res;
                stateDialog.dispose();
            }
        });
        stateDialog.add(stateField);
        stateDialog.add(cnfStateBtn);
        stateDialog.setSize(300, 100);
        stateDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                String res = stateField.getSelectedItem();
                state = res;
                stateDialog.dispose();
            }
        });

        selectStateBtn = new Button("Select State");
        selectStateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stateDialog.setVisible(true);
            }
        });

        add(selectStateBtn);

        // add signup button
        signUpBtn = new Button("Sign Up");
        add(signUpBtn);
        signUpBtn.addActionListener(this);

        // add warning label
        warningLabel = new Label("");
        add(warningLabel);

        setSize(600, 400);
        setVisible(true);
        setLayout(new GridLayout(5, 2));
    }

    public void actionPerformed(ActionEvent e) {
        firstname = firstNameField.getText();
        lastname = lastNameField.getText();
        email = emailField.getText();
        password = passwordField.getText();
        phone = phoneField.getText();

        String errors = "";

        if (validateName(firstname) && validateName(lastname)) {
            errors += "Name contains spaces in between\n";
        }

        if (!validateEmail(email)) {
            errors += "Email does not contain @";
        }

        if (!validatePassword(password)) {
            errors += "Password is 8 characters long or first character is not upper case.";
        }

        if (!validatePhone(phone)) {
            errors += "Phone number is invalid";
        }

        if (errors.equals("")) {
            String out = "";
            out += firstname + "\t";
            out += lastname + "\t";
            out += email + "\t";
            out += phone + "\t";
            out += firstname + "\t";
            out += password + "\t";
            out += state + "\t";

            try {
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File("userdata.txt"), true));
                pw.println(out);
                pw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            warningLabel.setText(errors);
        }

    }

    public boolean validateName(String str) {
        return str.contains(" ");
    }

    public boolean validateEmail(String str) {
        return str.contains("@");
    }

    public boolean validatePhone(String str) {
        if (str.length() < 10)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!(Character.isDigit(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public boolean validatePassword(String str) {
        if (str.length() < 8 || !Character.isUpperCase(str.charAt(0)))
            return false;
        return true;
    }

    public static void main(String[] args) {
        new Solution_1();
    }
}
