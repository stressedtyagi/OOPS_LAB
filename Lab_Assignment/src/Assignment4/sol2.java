/*
 * Copyright (c) 2021.
 * Divyanshu Tyagi
 * NIT Warangal
 * 207919
 */

package Assignment4;
/*
Write a java program to implement a simple calculator having buttons for individual operations
+,-,*, /, % and one clear button and along with them two textFields one for first input, one for
second input and one label for result. Arrange these buttons in a grid layout. Handle the possible
exceptions like divisible by zero. Output Frame should be like below.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigInteger;

import static javax.swing.JOptionPane.showMessageDialog;

class EmptyInputException extends Exception {
    public EmptyInputException(String str) {
        super(str);

    }
}

class DivByZero extends Exception {
    public DivByZero(String str) {
        super(str);

    }
}

class IntegerOverflowException extends  Exception {
    public IntegerOverflowException(String str) {
        super(str);

    }
}

class MyCalculatorFrame extends JFrame implements ActionListener {
    private Container c;
    private JLabel firstNum;
    private JTextArea tfirstNum;
    private JLabel secondNum;
    private JTextArea tsecondNum;
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton mod;
    private JButton clear;
    private JLabel result;
    private JTextArea tresult;



    public MyCalculatorFrame() {
        setTitle("Calculator");
        setBounds(300, 90, 400, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        firstNum = new JLabel("First Number");
        firstNum.setFont(new Font("Arial", Font.PLAIN, 20));
        firstNum.setSize(200, 20);
        firstNum.setLocation(1, 1);
        c.add(firstNum);

        tfirstNum = new JTextArea();
        tfirstNum.setFont(new Font("Arial", Font.PLAIN, 15));
        tfirstNum.setSize(200, 20);
        tfirstNum.setLocation(202, 1);
        c.add(tfirstNum);


        secondNum = new JLabel("Second Number");
        secondNum.setFont(new Font("Arial", Font.PLAIN, 20));
        secondNum.setSize(200, 20);
        secondNum.setLocation(1, 25);
        c.add(secondNum);


        tsecondNum = new JTextArea();
        tsecondNum.setFont(new Font("Arial", Font.PLAIN, 15));
        tsecondNum.setSize(200, 20);
        tsecondNum.setLocation(202, 25);
        c.add(tsecondNum);

        result = new JLabel("Result");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        result.setSize(200,20);
        result.setLocation(1,50);
        c.add(result);

        tresult = new JTextArea();
        tresult.setFont(new Font("Arial", Font.PLAIN, 17));
        tresult.setSize(200,20);
        tresult.setLocation(202,50);
        tresult.setEditable(false);
        c.add(tresult);

        add = new JButton("+");
        add.setFont(new Font("Arial", Font.PLAIN, 15));
        add.setSize(185,40);
        add.setLocation(1,90);
        add.addActionListener(this);
        c.add(add);

        sub = new JButton("-");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(185,40);
        sub.setLocation(190,90);
        sub.addActionListener(this);
        c.add(sub);

        mul = new JButton("*");
        mul.setFont(new Font("Arial", Font.PLAIN, 15));
        mul.setSize(185,40);
        mul.setLocation(1,140);
        mul.addActionListener(this);
        c.add(mul);

        div = new JButton("/");
        div.setFont(new Font("Arial", Font.PLAIN, 15));
        div.setSize(185,40);
        div.setLocation(190,140);
        div.addActionListener(this);
        c.add(div);


        mod = new JButton("%");
        mod.setFont(new Font("Arial", Font.PLAIN, 15));
        mod.setSize(185,40);
        mod.setLocation(1,190);
        mod.addActionListener(this);
        c.add(mod);

        clear = new JButton("Clear");
        clear.setFont(new Font("Arial", Font.PLAIN, 15));
        clear.setSize(185,40);
        clear.setLocation(190,190);
        clear.addActionListener(this);
        c.add(clear);

        // making event listener to not let user enter anything other than number in txt area
        // associated for numbers
        tfirstNum.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = firstNum.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' ) ||  ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    tfirstNum.setEditable(true);
                } else {
                    tfirstNum.setEditable(false);
                }
            }
        });

        tsecondNum.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = tsecondNum.getText();
                int l = value.length();
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    tsecondNum.setEditable(true);
                } else {
                    tsecondNum.setEditable(false);
                }
            }
        });
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        try {

            if (tfirstNum.getText().length() == 0 || tsecondNum.getText().length() == 0) {
                throw new EmptyInputException("Either of the two numbers is not entered");
            }
            if (source == clear) {
                System.out.println("in clear");
                String def = "";
                tfirstNum.setText(def);
                tsecondNum.setText(def);
                tresult.setEditable(true);
                tresult.setText(def);
                tresult.setEditable(false);
            }else {
                Integer number_1 = Integer.parseInt(tfirstNum.getText());
                Integer number_2 = Integer.parseInt(tsecondNum.getText());
                long res = 0;
                if(number_1 > Integer.MAX_VALUE || number_2 > Integer.MAX_VALUE) {
                    throw new IntegerOverflowException("Integer Overflow");
                }
                if (add.equals(source)) {
                    res = (number_1 + number_2);
                }else if (sub.equals(source)) {
                    res = number_1 - number_2;
                }else if (mul.equals(source)) {
                    res = number_1 * number_2;
                }else if (div.equals(source)) {
                    if(number_2 == 0) {
                        throw new DivByZero("Divided by zero");
                    }
                    res = number_1 / number_2;
                }else if (mod.equals(source)) {
                    res = number_1 % number_2;
                }
                if(res > Long.MAX_VALUE) {
                    throw new IntegerOverflowException("Integer Overflow");
                }
                tresult.setEditable(true);
                tresult.setText(res + "");
                tresult.setEditable(false);
            }
        }catch (Exception exp) {
            showMessageDialog(null, "!! ERROR : " + exp.getMessage() + " !!");
            exp.printStackTrace();
        }
    }
}

public class sol2 {
    public static void main(String[] args) {
        MyCalculatorFrame frame = new MyCalculatorFrame();
    }
}
