package progect;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
public class home extends JFrame implements ActionListener{
    private JPanel p1;
    private JLabel l1;
    private JButton b1,b2,b3,b4,b5,b7;
    home()
    {
        setTitle("Home");
        JPanel p1=new JPanel();
        p1.setBounds(0,0,715,615);
        p1.setLayout(null);
        setSize(715,615);
        Icon icon7 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\log.png");
        b7=new JButton(icon7);
        b7.setBounds(0,0,50,50);
        p1.add(b7);
        Icon icon1 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\b1.png");
        b1=new JButton(icon1);
        b1.setBounds(80,172,161,159);
        Icon icon2 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\b2.png");
        b2=new JButton(icon2);
        b2.setBounds(80,350,161,159);
        Icon icon3 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\b3.png");
        b3=new JButton(icon3);
        b3.setBounds(460,172,161,159);
        Icon icon4 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\b4.png");
        b4=new JButton(icon4);
        b4.setBounds(460,350,161,159);
        Icon icon5 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\b5.png");
        b5=new JButton(icon5);
        b5.setBounds(270,250,161,159);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\home\\back.png");
        l1=new JLabel(icon);
        p1.add(b5);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
       b7.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b3.setFocusable(false);
        b4.setFocusable(false);
        b5.setFocusable(false);
        b7.setFocusable(false);
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        b3.setBackground(Color.white);
        b4.setBackground(Color.white);
        b5.setBackground(Color.white);
        l1.setBounds(0,0,700,590);
        p1.add(l1);
        add(p1);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new room();
            dispose();
        }
        else if(e.getSource()==b2)
        {
            new covidTest();
            dispose();
        }
        else if(e.getSource()==b3)
        {
            new info();
            dispose();
        }
        else if(e.getSource()==b4)
        {
            new resturent();
            dispose();
        }
        else if(e.getSource()==b5)
        {
            new emargency();
            dispose();
        }
        else if(e.getSource()==b7)
        {
            new Progect();
            dispose();
        }
    }
}
