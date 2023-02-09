///////////////////   ATM Class \\\\\\\\\\\\\\\\\\\\\\\\\
/*
 * GUI configuration for ATM panel
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        NdertoATM();
        pack();
        setSize(800,500);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /*
     * The method that configures the GUI
     * Configuring the panel layout
     */
    protected void NdertoATM()
    {

        /*
         * Instruction panel
         * The construction of the instruction panel has been done, the background color, borderline, text configurations, etc. have been set.
         */
        JLabel displayArea = new JLabel("<html> &emsp Instructions: <br> &emsp Please select one of the instructions below <br> &emsp Current balance:  $"+ balance+ "</html>");
        displayArea.setOpaque(true);
        displayArea.setBackground(Color.DARK_GRAY);
        displayArea.setBorder(BorderFactory.createLineBorder(Color.red));
        displayArea.setPreferredSize(new Dimension(100,150));
        displayArea.setFont(new Font("SansSerif", Font. BOLD, 15));
        displayArea.setForeground(Color.white);

        JPanel bottomArea = new JPanel();
        bottomArea.setLayout(new BorderLayout(0,0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout(0,0));

        //The input area that the user sets using the buttons.
        JLabel inputDisplay = new JLabel("...");
        inputDisplay.setBorder(BorderFactory.createLineBorder(Color.red));
        inputDisplay.setPreferredSize(new Dimension(50,35));
        inputDisplay.setFont(new Font("Serif", Font. BOLD, 15));
        bottomArea.add(inputDisplay, BorderLayout.NORTH);

        //Configuring the appearance of buttons in ATM
        GridBagLayout butonat = new GridBagLayout();
        buttonPanel.setLayout(butonat);
        buttonPanel.setBackground(Color.black);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        GridBagConstraints butonatK = new GridBagConstraints();



        /* Sequential configuration of buttons specifically
         * Determining the place of presentation, size, background color, text configurations
         * And finally adding them to the panel.
         */
        butonatK.weightx = 0.1;
        butonatK.weighty = 0.1;

        JButton terhiq1 = new JButton("Withdraw $10");
        butonatK.gridx = 0;
        butonatK.gridy = 0;
        butonatK.insets = new Insets(0,0,5,5);
        terhiq1.setSize(new Dimension(200,100));
        terhiq1.setBackground(Color.cyan);
        terhiq1.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(terhiq1, butonatK);

        JButton terhiq2 = new JButton("Withdraw $50");
        butonatK.gridx = 0;
        butonatK.gridy = 1;
        terhiq2.setSize(new Dimension(200,100));
        terhiq2.setBackground(Color.cyan);
        terhiq2.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(terhiq2, butonatK);

        JButton terhiq3 = new JButton("Withdraw $100");
        butonatK.gridx = 0;
        butonatK.gridy = 2;
        terhiq2.setSize(new Dimension(200,100));
        terhiq3.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(terhiq3, butonatK);
        terhiq3.setBackground(Color.cyan);

        JButton depozito = new JButton("Deposit");
        butonatK.gridx = 0;
        butonatK.gridy = 3;
        depozito.setSize(new Dimension(200,30));
        depozito.setBackground(Color.LIGHT_GRAY);
        depozito.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(depozito,butonatK);

        JButton dil = new JButton("Exit");
        butonatK.gridx = 0;
        butonatK.gridy = 4;
        butonatK.anchor = GridBagConstraints.PAGE_END;
        dil.setSize(new Dimension(200,30));
        dil.setBackground(Color.red);
        dil.setForeground(Color.white);
        dil.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(dil, butonatK);

        JButton numri1 = new JButton("1");
        butonatK.gridx = 1;
        butonatK.gridy = 0;
        numri1.setSize(new Dimension(200,30));
        numri1.setBackground(Color.YELLOW);
        numri1.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri1, butonatK);

        JButton numri2 = new JButton("2");
        butonatK.gridx = 2;
        butonatK.gridy = 0;
        numri2.setSize(new Dimension(200,30));
        numri2.setBackground(Color.YELLOW);
        numri2.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri2, butonatK);

        JButton numri3 = new JButton("3");
        butonatK.gridx = 3;
        butonatK.gridy = 0;
        numri3.setSize(new Dimension(200,30));
        numri3.setBackground(Color.YELLOW);
        numri3.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri3, butonatK);

        JButton numri4 = new JButton("4");
        butonatK.gridx = 1;
        butonatK.gridy = 1;
        numri4.setSize(new Dimension(200,30));
        numri4.setBackground(Color.YELLOW);
        numri4.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri4, butonatK);

        JButton numri5 = new JButton("5");
        butonatK.gridx = 2;
        butonatK.gridy = 1;
        numri5.setSize(new Dimension(200,30));
        numri5.setBackground(Color.YELLOW);
        numri5.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri5, butonatK);

        JButton numri6 = new JButton("6");
        butonatK.gridx = 3;
        butonatK.gridy = 1;
        numri6.setSize(new Dimension(200,30));
        numri6.setBackground(Color.YELLOW);
        numri6.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri6, butonatK);

        JButton numri7 = new JButton("7");
        butonatK.gridx = 1;
        butonatK.gridy = 2;
        numri7.setSize(new Dimension(200,30));
        numri7.setBackground(Color.YELLOW);
        numri7.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri7, butonatK);

        JButton numri8 = new JButton("8");
        butonatK.gridx = 2;
        butonatK.gridy = 2;
        numri8.setSize(new Dimension(200,30));
        numri8.setBackground(Color.YELLOW);
        numri8.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri8, butonatK);

        JButton numri9 = new JButton("9");
        butonatK.gridx = 3;
        butonatK.gridy = 2;
        numri9.setSize(new Dimension(200,30));
        numri9.setBackground(Color.YELLOW);
        numri9.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri9, butonatK);

        JButton numri0 = new JButton("0");
        butonatK.gridx = 1;
        butonatK.gridy = 3;
        numri0.setSize(new Dimension(200,30));
        numri0.setBackground(Color.YELLOW);
        numri0.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(numri0, butonatK);

        JButton fshi = new JButton("Delete");
        butonatK.gridx = 2;
        butonatK.gridy = 3;
        fshi.setSize(new Dimension(200,30));
        fshi.setBackground(Color.white);
        fshi.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(fshi, butonatK);

        JButton enter = new JButton("Enter");
        butonatK.gridx = 3;
        butonatK.gridy = 3;
        enter.setSize(new Dimension(200,30));
        enter.setBackground(Color.green);
        enter.setForeground(Color.white);
        enter.setFont(new Font("SansSerif", Font. BOLD, 15));
        buttonPanel.add(enter, butonatK);

        //We add all the buttons to the upper panel.

        buttonPanel.add(enter,butonatK);
        bottomArea.add(buttonPanel, BorderLayout.CENTER);
        bottomArea.setBackground(Color.LIGHT_GRAY);
        add(displayArea, BorderLayout.NORTH);
        add(bottomArea, BorderLayout.CENTER);

        /*
         * ActionListener configuration
         * With 3 balance pull buttons
         */
        terhiq1.addActionListener(new ActionListener()
        {
            // ActionEvent method for the Withdraw $10 button
            public void actionPerformed(ActionEvent event)
            {
                /*
                 * If the balance is greater than $10, the actions are carried out at the ATM
                 * Otherwise, an error message is displayed
                 */
                if(balance >= 10)
                {
                    balance = balance - 10;
                    displayArea.setText("<html> &emsp $10 Withdrawn! <br><br>"+TransaksionPerfunduar()+"</html>");
                    ShtypEnter = false;
                    System.out.println("You have withdrawn $10");
                    PerditesoHistoriaTransaksionit("User has withdrawn $10");
                } else
                {
                    displayArea.setText("<html> &emsp Your balance is under $10. Impossible to withdraw!! <br><br>"+TransaksionPerfunduar()+"</html>");
                }

            }
        });

        terhiq2.addActionListener(new ActionListener()
        {	//ActionEvent method for the Withdraw $50 button
            public void actionPerformed(ActionEvent event)
            {
                /*
                 * If the balance is greater than $50, the actions are carried out at the ATM
                 * Otherwise, an error message is displayed
                 */
                if(balance >= 50)
                {
                    balance = balance - 50;
                    displayArea.setText("<html> &emsp $50 Withdrawn! <br><br> " +TransaksionPerfunduar() + "</html>");
                    ShtypEnter = false;
                    System.out.println("You have withdrawn $50");
                    PerditesoHistoriaTransaksionit("User has withdrawn $50");
                } else
                {
                    displayArea.setText("<html> &emsp Your balance is under $50. Impossible to withdraw!! <br><br>"+TransaksionPerfunduar()+"</html>");
                }

            }
        });

        terhiq3.addActionListener(new ActionListener()
        {
            //ActionEvent method for the button Withdraw $100
            public void actionPerformed(ActionEvent event)
            {
                /*
                 * If the balance is greater than $100, the actions are carried out at the ATM
                 * Otherwise, an error message is displayed
                 */
                if(balance >= 100)
                {
                    balance = balance - 100;
                    displayArea.setText("<html> &emsp $100 Withdrawn! <br><br> "+TransaksionPerfunduar()+"</html>");
                    ShtypEnter = false;
                    System.out.println("You have withdrawn $100");
                    PerditesoHistoriaTransaksionit("User has withdrawn $100");
                } else
                {
                    displayArea.setText("<html> &emsp Your balance is under $100. Impossible to withdraw!! <br><br>"+TransaksionPerfunduar()+"</html>");
                }

            }
        });

        // "Exit" button
        // It makes it possible to exit the ATM and return to the login once again

        dil.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JOptionPane.showMessageDialog(null,"Your invoice: \n" +printoFaturen());
                JOptionPane.showMessageDialog(null, "Signing out of your account! Back to registration!");
                dispose();
                new ATM_Login();
            }

        });

        //Delete button
        //Deletes the input set by the user with the buttons

        fshi.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                inputDisplay.setText("ATM operations: ");
                displayArea.setText("<html> &emsp The input field was deleted! <br><br>"+TransaksionPerfunduar()+" </html>");
                fshiInputin();
                ShtypEnter = false;
            }
        });

        //Number buttons
        //Makes it possible to add the number of that button to the input area every time a button is clicked by the user
        //Each button contains ActionListener and Action event method
        numri1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("1"));
            }
        });
        numri2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("2"));
            }
        });
        numri3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("3"));
            }
        });
        numri4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("4"));
            }
        });
        numri5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("5"));
            }
        });
        numri6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("6"));
            }
        });
        numri7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("7"));
            }
        });
        numri8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("8"));
            }
        });
        numri9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("9"));
            }
        });
        numri0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                inputDisplay.setText("..." + perditesoInputin("0"));
            }
        });

        //Deposit button
        //Enables the input entered by the user to be deposited into the account when "Enter" is clicked
        depozito.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                displayArea.setText("<html> &emsp The deposit was selected! <br> &emsp Please enter an amount and click Enter! <br><br>"
                        + TransaksionPerfunduar() + "</html>" );
                ShtypEnter = true;
            }
        });

        //Enter button
        // After we have selected the deposit and the amount has been set by the user, press enter and the Balance is updated.
        enter.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                //Condition to perform the action on the enter button
                if(ShtypEnter == true)
                {
                    //If the input set by the user is 0, an error message is output
                    //On the contrary, the balance is updated with the set amount.
                    if(Integer.parseInt(getInputiVendosur())==0 || getInputiVendosur().equals("0000"))
                    {
                        displayArea.setText("\tYou have not set any value!");
                        fshiInputin();
                        inputDisplay.setText("...");
                        ShtypEnter = false;
                    }else
                    {
                        PerditesoBalancen(Integer.parseInt(getInputiVendosur()));
                        displayArea.setText("<html> &emsp You have deposited $" + getInputiVendosur()
                                + "! <br><br>" + TransaksionPerfunduar() + "</html>");
                        PerditesoHistoriaTransaksionit("The user has deposited $" + getInputiVendosur());
                    }
                    fshiInputin();
                    inputDisplay.setText("...");
                    ShtypEnter = false;
                }else
                {
                    displayArea.setText("<html> &emsp You have not selected any action! <br><br>" + TransaksionPerfunduar() + "</html>");
                    fshiInputin();
                    inputDisplay.setText("...");
                }
            }
        });

    }
    ////Methods for calculating actions with the balance\\\\

    /*
     * "Delete Input" method
     * Deletes the input placed in the panel
     */
    public void fshiInputin()
    {
        //Checks the input numbers from index 0 to 3
        for(int i = 0; i<=3; i++)
        {
            transaksioni[i] = "";
        }
        IndeksiInputit = 0;
    }

    /*
     * "PeerditesonInputin" method
     * Updates the input area with a number when the corresponding button is clicked
     */
    String perditesoInputin(String a)
    {
        if(IndeksiInputit <= 3)
        { transaksioni[IndeksiInputit] = a;
            IndeksiInputit ++;

            StringBuilder strBuilder = new StringBuilder();
            for(int i = 0; i <transaksioni.length; i++)
            {
                strBuilder.append(transaksioni[i]);
            }
            String newString = strBuilder.toString();
            return newString;
        }
        else
        {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                strBuilder.append(transaksioni[i]);
            }
            String newString = strBuilder.toString();
            return newString;
        }
    }

    /*
     * "getInputSet" method
     * Takes the input entered by the user and updates the balance
     */
    String getInputiVendosur()
    {
        StringBuilder strBuilder = new StringBuilder();
        //Inputi duhet te mos jete 0.
        if(transaksioni[0] == ""){
            return "0000";
        } else {
            for (int i = 0; i < transaksioni.length; i++) {
                strBuilder.append(transaksioni[i]);
            }
            String newString = strBuilder.toString();
            return newString;
        }

    }
    /*
     * Metoda "TransaksionPerfunduar"
     * Rivendosim programin në gjendjen e tij origjinale me bilancin e ri te perditesuar
     * E therrasim sa here te kryhet nje transaksion
     */
    String TransaksionPerfunduar()
    {
        return "&emsp Zona e Instruksionit <br> &emsp Ju lutem zgjidhni nje nga funksionet e meposhtme <br> &emsp Balanca momentit: $" + balance;
    }

    /*
     *  Metoda "PerditesoBalancen"
     *  Përditëson balancen pas depozitimit
     */
    void PerditesoBalancen(int l)
    {
        balance += l;
    }

    /*
     * Metoda "PerditesoHistoriaTransaksionit"
     * Perditeson histoine e transaksionit te bere ne ATM, qe do printohet ne fature.
     */
    void PerditesoHistoriaTransaksionit(String b)
    {
        Historiatransaksionit[IndeksiTransaksionit] = b;
        IndeksiTransaksionit++;
    }

    /*
     * Metoda "printoFaturen"
     * Printon faturen npasi mbyllet programi
     * Fatura e printuar bashke me te gjitha transaksionet e kryera
     */
    String printoFaturen()
    {
        if(transaksioni[0].equals(null)){
            return "&emsp Nuk eshte bere asnje transaksion!";
        } else{
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < IndeksiTransaksionit; i++) {
                strBuilder.append(Historiatransaksionit[i] + "\n");
            }
            String newString = strBuilder.toString();
            return newString;
        }
    }

}
