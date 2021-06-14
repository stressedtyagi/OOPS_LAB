/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;

import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

/*
Write a java program to create an attractive registration form for students admission into our
institution which should contain Email id, password and confirm password, sex, Higher education
qualification (this is pop up menu contains B.Tech, M.tech etc.), username, and date of birth,
course (java, Data structures, Unix tool programming, Machine learning) choose one among them
(java, Data structures, Unix tool programming, Machine learning). And each component should
be specified with a label on top of it. For example, on top of email id component write label “enter
email id”. Now all components should be properly aligned. At the end add a submit button, upon
clicking this button, if password and confirm password are matched then save the total information
into a file otherwise show an error message in a label just below the button.
*/
class MyFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel email;
    private JTextField temail;
    private JLabel password;
    private JTextArea tpassword;
    private JLabel confirmPassword;
    private JTextArea tconfirmPassword;
    private JLabel quali;
    private JComboBox cquali;
    private JLabel course;
    private JComboBox ccourse;
    private JButton sub;
    private JButton reset;

    private String qualification[] = {
            "B.tech",
            "M.tech",
            "MCA",
            "MSC"
    };

    private String Course[] = {
            "Java",
            "Data Structure",
            "Unix tool programming",
            "Machine Learning"
    };

    public MyFrame() {
        setTitle("Registeration Form");
        setBounds(300, 90, 900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(100, 100);
        c.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(150, 20);
        temail.setLocation(350, 100);
        c.add(temail);

        password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 150);
        c.add(password);

        tpassword = new JTextArea();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(100, 20);
        tpassword.setLocation(350, 150);
        c.add(tpassword);

        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        confirmPassword.setSize(200, 20);
        confirmPassword.setLocation(100, 200);
        c.add(confirmPassword);

        tconfirmPassword= new JTextArea();
        tconfirmPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tconfirmPassword.setSize(200, 20);
        tconfirmPassword.setLocation(350, 200);
        c.add(tconfirmPassword);

        quali = new JLabel("Qualification");
        quali.setFont(new Font("Arial", Font.PLAIN, 20));
        quali.setSize(200, 20);
        quali.setLocation(100, 250);
        c.add(quali);

        cquali = new JComboBox(qualification);
        cquali.setFont(new Font("Arial", Font.PLAIN, 20));
        cquali.setSize(200, 25);
        cquali.setLocation(350, 250);
        c.add(cquali);

        course = new JLabel("Course");
        course.setFont(new Font("Arial", Font.PLAIN, 20));
        course.setSize(150, 20);
        course.setLocation(100, 300);
        c.add(course);

        ccourse = new JComboBox(Course);
        ccourse.setFont(new Font("Arial", Font.PLAIN, 20));
        ccourse.setSize(200, 25);
        ccourse.setLocation(350, 300);
        c.add(ccourse);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(100, 400);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(250, 400);
        reset.addActionListener(this);
        c.add(reset);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reset) {
            String def = "";
            temail.setText(def);
            tpassword.setText(def);
            tconfirmPassword.setText(def);
            cquali.setSelectedIndex(0);
            ccourse.setSelectedIndex(0);
        }
        else if (e.getSource() == sub) {
            if(tpassword.getText().equals(tconfirmPassword.getText())) {
                try {
                    FileWriter writer = new FileWriter("formInfo.txt");
                    writer.write(temail.getText() + "\n");
                    writer.write(tpassword.getText() + "\n");
                    writer.write(cquali.getSelectedItem() + "\n");
                    writer.write(ccourse.getSelectedItem() + "\n");
                    writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                showMessageDialog(null, "Data Successfully submitted to file");
            }else {
                showMessageDialog(null, "Password and confirm password are not same");
            }
        }
    }
}

public class sol1 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}
