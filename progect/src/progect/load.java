package progect;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class load extends JFrame {
    private JPanel p1;
    private JProgressBar pro;
    private JLabel l1,l2;
//    public static void main(String[] args) {
//        new load();
//    }

    public load() {
        setTitle("Hostel Management System");
        setSize(700, 600);
        setLayout(null);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\project\\a.jpg");
        l1=new JLabel(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,700,600);
        l1.setBounds(0,0,700,600);
        p1.add(l1);
        p1.setOpaque(false);
        pro = new JProgressBar();
        pro.setValue(0);
        pro.setStringPainted(true);
        pro.setBounds(250,225,150, 32);
        l2=new JLabel("         Loading");
        l2.setFont(new Font("Serif", Font.PLAIN, 18));
        l2.setForeground (Color.white);
        l2.setBounds(250,190,130,35);
        p1.add(l2);
        p1.add(pro);
        p1.add(l1);
        add(p1);
        loading();
    }

    public final void loading() {
        int i = 0;
        try {
            while (i <= 100) {
                pro.setValue(i + 10);
                Thread.sleep(1000);
                if (i == 100) {
                    dispose();
                     new Progect();
                }
                i =i+ 20;
            }
            // new Progect();
        } catch (Exception e) {

        }
    }
}
