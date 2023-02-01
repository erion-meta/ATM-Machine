/*
 //////////////////////     Login Class    \\\\\\\\\\\\\\\\\\
  * Panel to put name and pin to log in ATM.
 */

import javax.swing.*;
import java.awt.*;

class ATM_Login extends JFrame
{
    //Declare a static PIN
    //A variable that holds the value of how many times we can retry the pin
    String pin = "987654321";
    int pinRetry = 5;

    //"ATM_Login Constructor
    //Panel configuration options
    public ATM_Login()
    {
        super("Log in ATM");
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        BuildLogin();
        pack();
        setSize(400,250);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /*
     * BuildLogin method
     * Panel view configuration
     */
    void BuildLogin()
    {

        setLayout(null);

        // Card number from the user
        JLabel karta= new JLabel("Card Number: ");
        karta.setBounds(10,10,80,25);
        add(karta);
        JTextField kartaTekst = new JTextField(12);
        kartaTekst.setBounds(100,10,160,25);
        kartaTekst.setBackground(Color.LIGHT_GRAY);
        add(kartaTekst);

        //Pin from the user
        JLabel Pini = new JLabel("PIN: ");
        Pini.setBounds(10,40,80,25);
        add(Pini);
        JPasswordField pinText = new JPasswordField(8);
        pinText.setBounds(100,40,160,25);
        pinText.setBackground(Color.LIGHT_GRAY);
        add(pinText);

        //Enter button
        JButton enter = new JButton("Enter");
        enter.setBounds(10,80,80,25);
        enter.setBackground(Color.green);
        add(enter);

        //Exit button
        JButton exit = new JButton("Exit");
        exit.setBounds(180,80,80,25);
        exit.setBackground(Color.red);
        add(exit);


        // Action Listener configuration for each button

        exit.addActionListener(event -> System.exit(0));

        //If pin is correct ATM will be open
        // Else, you can retry as many times as you have left
        pinText.addActionListener(event -> {
            char[] pinFind = pinText.getPassword();
            String pinString = new String(pinFind );
            if(pinString.equals(pin))
            {
                JOptionPane.showMessageDialog(null, "PIN is correct! Account is being opened...");
                dispose();
                new ATM_Login();  //ATM opens
            } else
            {
                if(pinRetry != 1)
                {
                    pinRetry--;
                    JOptionPane.showMessageDialog(null, "PIN is incorrect! \n" + pinRetry
                            + " remaining possibilities!");
                } else
                {
                    JOptionPane.showMessageDialog(null, "You have no chance left to try the password! \n The program was closed");
                    System.exit(0);
                }
            }
        });

        //Action Listener for Enter button
        enter.addActionListener(event -> {
            char[] pinGuess = pinText.getPassword();
            String pinString = new String(pinGuess);
            // if Pin is correct...
            if(pinString.equals(pin)){
                JOptionPane.showMessageDialog(null, "The password is correct! Account is being opened...");
                dispose();
                new ATM_Login();
            }
            //if pin is incorrect...
            else{
                if(pinRetry != 1){
                    pinRetry--;
                    JOptionPane.showMessageDialog(null, "The password is incorrect! \n" + pinRetry
                            + " remaining possibilities!");
                } else {
                    JOptionPane.showMessageDialog(null, "You have no remaining options to write the PIN! \n The program was closed");
                    System.exit(0);
                }
            }
        });
    }

}
