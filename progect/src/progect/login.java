/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progect;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*; 
import javax.swing.plaf.FontUIResource;
public class login extends JFrame implements ActionListener{
    private JPanel p2;
    private JTextField tex1,tex2,tex3,tex4,tex5;
    private JLabel l1,l2,l3,l4,l5,l6,l11,lr;
    private JPasswordField pas1,pas2;
    private JButton b1,b2;
    login()
    {
        setTitle("Hostel Management System");
        p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,0,700,600);
        l1 = new JLabel("                Login");
        l1.setForeground (Color.white);
        l1.setFont(new Font("Serif", Font.PLAIN, 25));
        l1.setBounds(220,30,200,30); 
        p2.add(l1);
        l2=new JLabel("                  Username ");
        l2.setForeground (Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 18));
        l2.setBounds(40,90,210,20);
        tex1=new JTextField();
        tex1.setBounds(250,90,190,20);
        p2.add(tex1);
        p2.add(l2);
        l3=new JLabel("                  Password ");
        l3.setForeground (Color.white);
        l3.setFont(new Font("Serif", Font.PLAIN, 18));
        l3.setBounds(40,120,210,20);
        pas1=new JPasswordField();
        pas1.setBounds(250,120,190,20);
        p2.add(pas1);
        p2.add(l3);
        Icon icon1 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\login\\b2.jpg");
        b1=new JButton(icon1);
        b1.setBounds(150,180,150,30);
        p2.add(b1);
        Icon icon2 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\b2.jpg");
        b2=new JButton(icon2);
        b2.setBounds(360,180,150,30);
        p2.add(b2);
        b1.addActionListener(this); 
        b2.addActionListener(this); 
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\a.jpg");
        l11=new JLabel(icon);
        l11.setBounds(0,0,700,600);
        p2.add(l11);
        setSize(700,600);
        add(p2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2)
        {
            new Progect();
            dispose();
        }
        else if(e.getSource()==b1)
        {
            new dbconect().checkuser(tex1.getText(),new String(pas1.getPassword()));
            dispose();
        }
    }
}
