///////////////////   ATM Class \\\\\\\\\\\\\\\\\\\\\\\\\
/*
 * GUI configuration for ATM panel
 */

import javax.swing.*;

public class ATM_Class extends JFrame {

    //Variables to control balance, input from the user forr the deposit etc.
    // To control if "Deposit" is clicked before "Enter".

    int balance = 100;   // Initialize the initial balance with $100.
    String[] transaksioni = new String[4];  // The input that the user decides to deposit
    String[] Historiatransaksionit = new String[100];  // Keeps the transaction history that will be printed on the invoice
    int IndeksiInputit = 0; //The input index set by the user
    int IndeksiTransaksionit = 0;  //The index of the transaction that was performed
    boolean ShtypEnter = false;

    // ATM_Class constructor
    public ATM_Class()
    {
        super("ATM Account!!");

        for (int i=0; i <= 3; i++)
        {
            transaksioni[i] ="";
        }
        setResizable(false);
        setLocationRelativeTo(null);
        //NdertoATM();
        pack();
        setSize(800,500);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /*
     * Metoda qe ben konfigurimin e GUI
     * Konfigurimi i paraqitjes se panelit
     */

}
