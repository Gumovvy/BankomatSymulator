package com.gmv.bankomat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bankomat extends JFrame implements ActionListener {
    private ButtonGroup bgRadio;
    private JRadioButton rbWyplata, rbSaldo, rbWplata;
    private JLabel lOknoGlowne, lFirma, lWiadomoscOtransakcji, lWiadomoscOtransakcji2;
    private JButton bWyjscie, bOkZWyplaty, bOkZWplaty;
    private JTextField tWplata, tWyplata, tSaldo;
    private double konto = Math.round(Math.random() * 1000);

    public Bankomat() {
        /**************** OKNO GŁOWNE ****************/
        Toolkit zestaw = Toolkit.getDefaultToolkit();
        Dimension rozdzielczoscEkranu = zestaw.getScreenSize();
        int szerokoscEkranu = rozdzielczoscEkranu.width;
        int wysokoscEkranu = rozdzielczoscEkranu.height;
        setSize(szerokoscEkranu / 3, wysokoscEkranu / 2);
        setLocation(szerokoscEkranu / 4, wysokoscEkranu / 4);
        setTitle("Bankomat");
        setLayout(null);
        getContentPane().setBackground(Color.yellow);


        /**************** LABEL ****************/

        lOknoGlowne = new JLabel(
                "Witamy w bankomacie, wybierz w menu co chcesz zrobić:");
        lOknoGlowne.setBounds(10, 20, 480, 25);
        lOknoGlowne.setFont(new Font("Calibri", Font.BOLD, 14));
        lOknoGlowne.setForeground(new Color(180, 45, 67));
        lOknoGlowne.setBackground(Color.green);
        add(lOknoGlowne);

        lFirma = new JLabel("     E u r o n e t");
        lFirma.setBounds(20, wysokoscEkranu / 5, 400, 50);
        lFirma.setFont(new Font("Calibri", Font.ITALIC, 50));
        lFirma.setForeground(Color.blue);
        add(lFirma);

        lWiadomoscOtransakcji = new JLabel("Trasakcja przebiegła pomyślnie");
        lWiadomoscOtransakcji.setBounds(150, wysokoscEkranu / 3, 400, 50);
        lWiadomoscOtransakcji.setFont(new Font("Calibri", Font.ITALIC, 20));
        lWiadomoscOtransakcji.setForeground(Color.black);
        lWiadomoscOtransakcji.setVisible(false);
        add(lWiadomoscOtransakcji);


        lWiadomoscOtransakcji2 = new JLabel("Nie masz ");
        lWiadomoscOtransakcji2.setBounds(150, wysokoscEkranu / 3, 400, 50);
        lWiadomoscOtransakcji2.setFont(new Font("Calibri", Font.ITALIC, 20));
        lWiadomoscOtransakcji2.setForeground(Color.black);
        lWiadomoscOtransakcji2.setVisible(false);
        add(lWiadomoscOtransakcji2);


        /***************** RADIO BUTTONY *************/
        bgRadio = new ButtonGroup();

        rbWyplata = new JRadioButton("Wyplata gotowki", false);
        rbWyplata.setFont(new Font("Calibri", Font.BOLD, 18));
        rbWyplata.setBackground(Color.yellow);
        rbWyplata.setBounds(20, 60, 200, 25);
        bgRadio.add(rbWyplata);
        add(rbWyplata);
        rbWyplata.addActionListener(this);

        rbSaldo = new JRadioButton("Saldo konta", false);
        rbSaldo.setFont(new Font("Calibri", Font.BOLD, 18));
        rbSaldo.setBackground(Color.yellow);
        rbSaldo.setBounds(350, 60, 160, 25);
        bgRadio.add(rbSaldo);
        add(rbSaldo);
        rbSaldo.addActionListener(this);

        rbWplata = new JRadioButton("Wplata gotowki", false);
        rbWplata.setFont(new Font("Calibri", Font.BOLD, 18));
        rbWplata.setBackground(Color.yellow);
        rbWplata.setBounds(20, 350, 200, 25);
        bgRadio.add(rbWplata);
        add(rbWplata);
        rbWplata.addActionListener(this);
        /***************** Text fieldy *************/
        tWyplata = new JTextField("");
        tWyplata.setBounds(20, 100, 200, 25);
        tWyplata.setVisible(false);
        add(tWyplata);

        tSaldo = new JTextField("");
        tSaldo.setBounds(300, 100, 200, 25);
        tSaldo.setVisible(false);
        add(tSaldo);

        tWplata = new JTextField("");
        tWplata.setBounds(20, 250, 200, 25);
        tWplata.setVisible(false);
        add(tWplata);

        /**************** WYJSCIE i OK ****************/

        bWyjscie = new JButton("Wyjscie");
        bWyjscie.setBounds(350, 350, 100, 25);
        add(bWyjscie);
        bWyjscie.addActionListener(this);

        bOkZWyplaty = new JButton("OK");
        bOkZWyplaty.setVisible(false);
        add(bOkZWyplaty);
        bOkZWyplaty.addActionListener(this);

        bOkZWplaty = new JButton("OK");
        bOkZWplaty.setVisible(false);
        add(bOkZWplaty);
        bOkZWplaty.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        if (zrodlo == rbSaldo) {
            lWiadomoscOtransakcji.setVisible(false);
            tSaldo.setVisible(true);
            tWyplata.setVisible(false);
            bOkZWyplaty.setVisible(false);
            tWplata.setVisible(false);
            bOkZWplaty.setVisible(false);
            tSaldo.setText(String.valueOf(konto));
        } else if (zrodlo == rbWyplata) {
            lWiadomoscOtransakcji.setVisible(false);
            bOkZWplaty.setVisible(false);
            tSaldo.setVisible(false);
            tWyplata.setVisible(true);
            bOkZWyplaty.setVisible(true);
            tWplata.setVisible(false);
            tWyplata.setText("0");
            bOkZWyplaty.setBounds(20, 140, 60, 20);

        } else if (zrodlo == bOkZWyplaty) {
            String wyplataString = tWyplata.getText();
            double wyplataLiczbowo = Double.parseDouble(wyplataString);
            if(wyplataLiczbowo < konto) {
                konto = konto - wyplataLiczbowo;
                lWiadomoscOtransakcji.setText("Transakcja przebiegła pomyślnie.");
            }else{
                lWiadomoscOtransakcji.setText("Nie masz wystarczających środków.");
                lWiadomoscOtransakcji.setVisible(true);
            }


            tSaldo.setText(String.valueOf(konto));
            tWyplata.setText("0");
            lWiadomoscOtransakcji.setVisible(true);

        } else if (zrodlo == rbWplata) {
            tSaldo.setVisible(false);
            tWyplata.setVisible(false);
            bOkZWyplaty.setVisible(false);
            bOkZWplaty.setVisible(true);
            tWplata.setVisible(true);
            lWiadomoscOtransakcji.setVisible(false);
            tWplata.setText("0");
            bOkZWplaty.setBounds(20, 290, 60, 20);

        } else if (zrodlo == bOkZWplaty) {
            String wplataString = tWplata.getText();
            double wplataLiczbowo = Double.parseDouble(wplataString);
            konto = konto + wplataLiczbowo;
            tSaldo.setText(String.valueOf(konto));
            tWplata.setText("0");
            lWiadomoscOtransakcji.setVisible(true);

        } else if (zrodlo == bWyjscie) {
            dispose();

        }

    }

}
