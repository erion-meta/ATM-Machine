///////////////////   ATM Class \\\\\\\\\\\\\\\\\\\\\\\\\
/*
 * GUI configuration for ATM panel
 */

import javax.swing.*;

public class ATM_Class extends JFrame {

    //Variables to control balance, input from the user forr the deposit etc.
    // To control if "Deposit" is clicked before "Enter".

    int balanca = 100;   // Balanca fillestare e inicializojme me 100$.
    String[] transaksioni = new String[4];  // Inputi qe vendos perdoruesi per te depozituar
    String[] Historiatransaksionit = new String[100];  // Mban historine e trnsaksionit qe do printohet ne fature
    int IndeksiInputit = 0; //Indeksi i inputit te vendosur nga perdoruesi
    int IndeksiTransaksionit = 0;  //Indeksi i transaksionit qe eshte kryer
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

}
