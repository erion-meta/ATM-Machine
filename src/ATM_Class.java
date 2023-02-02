///////////////////   ATM Class \\\\\\\\\\\\\\\\\\\\\\\\\
/*
 * GUI configuration for ATM panel
 *
 */

import javax.swing.*;

public class ATM_Class extends JFrame {

    /* Konstruktori i klases ATM
     * Vendosim opsionet e konfigurimit, madhesine, ndertimi i programit.
     */
    public ATM_Class()
    {
        super("ATM Account!!");

        for (int i=0; i <= 3; i++)
        {
            transaksioni[i] ="";
        }
        setResizable(false);
        setLocationRelativeTo(null);
        NdertoATM();
        pack();
        setSize(800,500);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
