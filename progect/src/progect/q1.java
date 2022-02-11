package progect;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class q1 extends JFrame implements ActionListener{
    private JLabel l1p,l0;
    private JPanel p1;
    private JCheckBox jb1,jb2,jb3;
    private JButton b1;
    q1()
    {
        setTitle("Qusetion 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        p1.setBounds(0,0,700,600);
        p1.setLayout(null);
        l1p=new JLabel("What is your age?");
        l1p.setForeground (Color.white);
        l1p.setBounds(240,50,200,30);
        l1p.setFont(new Font("Serif", Font.PLAIN, 24));
        jb1=new JCheckBox("0-20");  
        jb1.setBounds(250,109,150,20);
        jb2=new JCheckBox("20-40");  
        jb2.setBounds(250,150,150,20);
        jb3=new JCheckBox("40-60");  
        jb3.setBounds(250,191,150,20);
        p1.add(jb1);
        p1.add(jb2);
        p1.add(jb3);
        b1 = new JButton("Next page");
        b1.setBounds(250,245,150,30);
        b1.setFont(new Font("Serif", Font.PLAIN, 20));
        p1.add(b1);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        b1.addActionListener(e ->
             {
                 new q2();
                 dispose();
             });
        p1.setBackground( new Color(31,48,130) );
        p1.add(l1p);
        add(p1); 
        l0 = new JLabel();
        setSize(700,600);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
         if(jb1.isSelected()){
             covidTest.covp=covidTest.covp+20;
         } 
         else if(jb2.isSelected()){
             covidTest.covp=covidTest.covp+5;
         } 
         else if(jb3.isSelected()){
             covidTest.covp=covidTest.covp+20;
         } 
         System.out.println(covidTest.covp);
    }
    
}
