package progect;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Progect extends JFrame implements ActionListener{
    private JPanel p1,p2;
    
    private JTextField tex1,tex2,tex3,tex4,tex5;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JPasswordField pas1,pas2;
    private JButton b1,b2;
    private JProgressBar pro;
    
    Progect() 
    {
        setTitle("Hostel Management System");
        
        JPanel p1=new JPanel();
        p1.setBounds(0,0,700,600);
        p1.setLayout(null);
        l2=new JLabel("WELCOME TO OUR HOSTEL MANAGEMENT SYSTEM");
        l2.setBounds(100,80,500,30);
        l2.setForeground (Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 18));
        p1.add(l2);
        add(p1);
        Icon icon1 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\project\\b1.jpg");
        b1=new JButton(icon1);
        b1.setBounds(180,150,301,35);
        b1.setForeground (Color.black);
        b1.setFont(new Font("Serif", Font.PLAIN, 21));
        Icon icon2 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\project\\b2.jpg");
        b2=new JButton(icon2);
        b2.setBounds(300,191,100,25);
        b2.setForeground (Color.black);
        b2.setBackground(new java.awt.Color(248, 255, 247));
        b2.setFont(new Font("Serif", Font.PLAIN, 18));
        l2=new JLabel("Already a user?");
        l2.setFont(new Font("Serif", Font.PLAIN, 18));
        l2.setForeground (Color.white);
        l2.setBounds(180,185,130,35);
        p1.add(b2);
        p1.add(b1);
        p1.add(l2);
        b1.addActionListener(this); 
        b2.addActionListener(this); 
        setSize(700,600);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\project\\a.jpg");
        l1=new JLabel(icon);
        l1.setBounds(0,0,700,600);
        p1.add(l1);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }
    public static void main(String[] args) {
           new load();     
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            new regestration();
            dispose();
        }
        else if(e.getSource()==b2)
        {
            new login();
             dispose();
        }
    }
}
