package progect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
public class wifi extends JFrame implements ActionListener{
    private JPanel p1;
    private JLabel l1;
    private JButton b1,b2,b3,b4,b5;
    wifi()
    {
        JPanel p1=new JPanel();
        p1.setBounds(0,0,700,600);
        p1.setLayout(null);
        setSize(700,600);
        b1=new JButton("Home Page");
        b1.setFont(new Font("Serif", Font.PLAIN, 18));
        b1.setForeground (Color.black);
        b1.setBounds(250,500,150,50); 
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\info\\2.png");
        l1=new JLabel(icon);
        p1.add(b1);
        b1.addActionListener(this);
        l1.setBounds(0,0,700,590);
        p1.add(l1);
        b1.setFocusable(false);
        b1.setBackground(Color.white);
        add(p1);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new home();
            dispose();
        }  
    }
}
