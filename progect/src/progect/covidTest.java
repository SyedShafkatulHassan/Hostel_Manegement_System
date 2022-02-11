package progect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class covidTest extends JFrame implements ActionListener{
    public static int covp=0;

    private JPanel p1;
    private JLabel l1,l1p;
    private JButton b1,b2,b3,b4,b5;
    covidTest()
    {
        setTitle("Covid Test");
        JPanel p1=new JPanel();
        p1.setBounds(0,0,700,600);
        p1.setLayout(null);
        setSize(700,600);
        l1p=new JLabel(" Welcome to covid 19 test ");
        l1p.setBounds(200,50,400,100);
        l1p.setFont(new Font("Serif", Font.PLAIN, 24));
        p1.add(l1p);
        b1=new JButton("Start the test");
        b1.setFont(new Font("Serif", Font.PLAIN, 24));
        b1.setBackground(Color.white);
        b1.setBounds(240,150,161,40);
        b2=new JButton("Back Page");
        b2.setFont(new Font("Serif", Font.PLAIN, 24));
        b2.setBackground(Color.white);
        b2.setBounds(240,200,161,40);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\covid19\\start\\back1.png");
        l1=new JLabel(icon);
        add(p1);
        l1.setBounds(0,0,700,600);
        p1.add(b1);
        p1.add(b2);
        p1.add(l1);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setFocusable(false);
        b1.setBackground(Color.white);
        b2.setFocusable(false);
        b2.setBackground(Color.white);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2)
        {
            new home();
            dispose();
        }
        else if(e.getSource()==b1)
        {
            new q1();
            dispose();
        }
    }
    
}
