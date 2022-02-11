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
public class info extends JFrame implements ActionListener{
    private JPanel p1;
    private JLabel l1;
    private JButton b1,b2,b3,b4,b5;
    info()
    {
        setTitle("Info");
        JPanel p1=new JPanel();
        p1.setBounds(0,0,715,615);
        p1.setLayout(null);
        setSize(700,600);
        b1=new JButton("See Wifi Cost");
        b1.setBounds(250,172,150,50);
        b2=new JButton("See Room Cost");
        b2.setBounds(250,240,150,50);
        b1.setFont(new Font("Serif", Font.PLAIN, 18));
        b1.setForeground (Color.black);
        b2.setFont(new Font("Serif", Font.PLAIN, 18));
        b2.setForeground (Color.black);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\info\\1.png");
        l1=new JLabel(icon);
        p1.add(b1);
        p1.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        l1.setBounds(0,0,700,590);
        b1.setFocusable(false);
        b2.setFocusable(false);
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
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
            new wifi();
            dispose();
        }
        else if(e.getSource()==b2)
        {
            new sleep();
            dispose();
        }
        
    }
}
