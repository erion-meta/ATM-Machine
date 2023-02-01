/*
 //////////////////////     Klasa Login    \\\\\\\\\\\\\\\\\\
  * Ben te mundur logimin ne ATM duke vendosur numrin e kartes dhe pinin.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ATM_Login extends JFrame
{
    //Deklarojme pinin qe do perdorim per tu loguar ne ATM
    //Gjithashtu deklarojme dhe mundesite qe kemi per te shkruajtur pinin
    String pin = "ie202";
    int mundesia = 5;

    //Konstruktori "Klasa Login"
    //Vendosim opsionet e konfigurimit te panelit
    //Brenda konstruktorit therrasim dhe metoden  'Nderto ATM'
    public ATM_Login()
    {
        super("Logimi ne Atm");
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        NdertoLogin();
        pack();
        setSize(400,250);
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /*
     * Metoda "NdertoLogin"
     * Konfigurimi i paraqitjes se panelit
     */
    void NdertoLogin()
    {

        setLayout(null);

        //Paneli i vendosjes se numrit te kartes
        //Vendosim dhe specifikate perkatese te panelit
        JLabel karta= new JLabel("Numri kartes: ");
        karta.setBounds(10,10,80,25);
        add(karta);
        JTextField kartaTekst = new JTextField(12);
        kartaTekst.setBounds(100,10,160,25);
        kartaTekst.setBackground(Color.LIGHT_GRAY);
        add(kartaTekst);

        //Paneli i vendosjes se pinit nga perdoruesi
        JLabel Pini = new JLabel("Pin: ");
        Pini.setBounds(10,40,80,25);
        add(Pini);
        JPasswordField tekstPin = new JPasswordField(8);
        tekstPin.setBounds(100,40,160,25);
        tekstPin.setBackground(Color.LIGHT_GRAY);
        add(tekstPin);

        //Paneli i butonit "Enter"
        JButton enter = new JButton("Enter");
        enter.setBounds(10,80,80,25);
        enter.setBackground(Color.green);
        add(enter);

        //Paneli i butonit "Dil"
        JButton dil = new JButton("Dil");
        dil.setBounds(180,80,80,25);
        dil.setBackground(Color.red);
        add(dil);


        //Konfigurimi Action Listener

        dil.addActionListener(new ActionListener()
        {
            // Butoni "Dil" , nese klikohet ben te mundur daljen nga programi
            // Metoda actionPerformed per butonin perkates
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });


        tekstPin.addActionListener(new ActionListener()
        {
            //Nese pini eshte i vendosur sakte, hapet llogaria ne ATM
            //Ne te kundert te jepet edhe njehere mundesia per te vendosur pinin derisa mbarojne mundesite.
            public void actionPerformed(ActionEvent event) {
                char[] GjetjaPin = tekstPin.getPassword();
                String pinString = new String(GjetjaPin );
                if(pinString.equals(pin))
                {
                    JOptionPane.showMessageDialog(null, "Passwordi eshte i sakte! Llogaria po hapet...");  //Mesazhi qe shfaqet pasi eshte gjetur pini
                    dispose();
                    new ATM_Login();  //Hapet ATM
                } else
                {
                    if(mundesia != 1)
                    {
                        mundesia--;
                        JOptionPane.showMessageDialog(null, "Passwordi eshte i pa sakte! \n" + mundesia
                                + " mundesi te mbetura!");  //Mesazhi i shfaqur nese pini eshte i pa sakte
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Nuk keni mundesi te mbetura per te provuar passwordin! \n Programi u mbyll");
                        System.exit(0);  // Kur pini eshte vendosur 5 here gabim, mbyllet programi
                    }
                }
            }
        });

        enter.addActionListener(new ActionListener(){
            //Butoni enter, nese klikohet ben te mundur hapjen e llogarise ne ATM
            public void actionPerformed(ActionEvent event) {
                char[] pinGuess = tekstPin.getPassword();
                String pinString = new String(pinGuess);
                //Nese pini eshte i sakte, llogaria hapet
                if(pinString.equals(pin)){
                    JOptionPane.showMessageDialog(null, "Passwordi eshte i sakte! Llogaria po hapet...");
                    dispose();
                    new ATM_Login();
                }
                //Ne te kundert jepet mundesia per te vendosur pinin deri ne limit.
                else{
                    if(mundesia != 1){
                        mundesia--;
                        JOptionPane.showMessageDialog(null, "Passwordi eshte i pasakte! \n" + mundesia
                                + " mundesi te mbetura!"); //Mesazhi i shfaqur nese pini eshte i pa sakte
                    } else {
                        JOptionPane.showMessageDialog(null, "Nuk keni me mundesi te mbetura per te shkruajtur passwordin! \n Programi u mbyll");
                        System.exit(0);  // Kur pini eshte vendosur 5 here gabim, mbyllet programi
                    }
                }
            }
        });
    }

}
