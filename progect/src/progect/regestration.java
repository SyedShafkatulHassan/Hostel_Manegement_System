package progect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.*;

public class regestration extends JFrame implements ActionListener {

    private JPanel p2;
    private JTextField tex1, tex2, tex3, tex4, tex5;
    private JLabel l1, l2, l3, l4, l5, l6, l11, lr;
    private JPasswordField pas1, pas2;
    private JButton b1, b2;

    regestration() {
        setTitle("Hostel Management System");
        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 0, 700, 600);
        l1 = new JLabel("          Regestration");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Serif", Font.PLAIN, 25));
        l1.setBounds(220, 30, 200, 30);
        p2.add(l1);
        l2 = new JLabel("                  Username ");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Serif", Font.PLAIN, 18));
        l2.setBounds(40, 90, 210, 20);
        tex1 = new JTextField();
        tex1.setBounds(250, 90, 190, 20);
        p2.add(tex1);
        p2.add(l2);
        l3 = new JLabel("                  Email ");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Serif", Font.PLAIN, 18));
        l3.setBounds(40, 120, 210, 20);
        tex2 = new JTextField();
        tex2.setBounds(250, 120, 190, 20);
        p2.add(tex2);
        p2.add(l3);
        l4 = new JLabel("                  Password ");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Serif", Font.PLAIN, 18));
        l4.setBounds(40, 150, 210, 20);
        pas1 = new JPasswordField();
        pas1.setBounds(250, 150, 190, 20);
        p2.add(pas1);
        p2.add(l4);
        l5 = new JLabel("    Confirm  Password ");
        l5.setForeground(Color.white);
        l5.setFont(new Font("Serif", Font.PLAIN, 18));
        l5.setBounds(40, 180, 210, 20);
        pas2 = new JPasswordField();
        pas2.setBounds(250, 180, 190, 20);
        p2.add(pas2);
        p2.add(l5);
        l6 = new JLabel("        Mobile  Number ");
        l6.setForeground(Color.white);
        l6.setFont(new Font("Serif", Font.PLAIN, 18));
        l6.setBounds(40, 210, 210, 20);
        tex3 = new JTextField();
        tex3.setBounds(250, 210, 190, 20);
        p2.add(tex3);
        p2.add(l6);
        Icon icon1 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\b1.jpg");
        b1 = new JButton(icon1);
        b1.setBounds(150, 270, 150, 35);
        p2.add(b1);
        Icon icon2 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\b2.jpg");
        b2 = new JButton(icon2);
        b2.setBounds(360, 270, 150, 35);
        p2.add(b2);
        l6.setForeground(Color.white);
        b1.addActionListener(this);
        b2.addActionListener(this);
        l6.setFont(new Font("Serif", Font.PLAIN, 18));
        l6.setBounds(40, 210, 210, 20);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\a.jpg");
        l11 = new JLabel(icon);
        l11.setBounds(0, 0, 700, 600);
        p2.add(l11);
        setSize(700, 600);
        add(p2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            new Progect();
            dispose();
        } else if (e.getSource() == b1) {
            String user = "^[a-zA-Z0-9]+$";
            String pass ="^\\S*(?=\\S{6,})(?=\\S*\\d)(?=\\S*[A-Z])(?=\\S*[a-z])(?=\\S*[!@#$%^&*?])\\S*$";
            String email = "[a-z0-9_]+@(gmail|hotmail|yahoo)\\.com";
            String mobile = "(\\+88)?-?01[3-9]\\d{8}";
            String u;
            String em;
            String p;
            String p1;
            String m;
            u = tex1.getText();
            em = tex2.getText();
            p = new String(pas1.getPassword());
            p1 = new String(pas2.getPassword());
            m = tex3.getText();
            if (!Pattern.matches(user,u)) {
                JOptionPane.showMessageDialog(null, "Invalid User Name\n");
            } else if (!Pattern.matches(email, em)) {
                JOptionPane.showMessageDialog(null, "Invalid mail\n");
            } else if (!Pattern.matches(pass, p)) {
                JOptionPane.showMessageDialog(null, "Invalid Password\n");
            } else if (!Pattern.matches(mobile, m)) {
                JOptionPane.showMessageDialog(null, "Invalid Mobile number\n");
            }
            else if(!p.equals(p1))
            {
                 JOptionPane.showMessageDialog(null, "Confirm your password\n");
            }
            else {
                new dbconect().addUser(u,p,m,em);
            }
        }
    }

}
