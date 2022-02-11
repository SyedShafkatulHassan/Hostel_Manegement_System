
package progect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class report extends JFrame implements ActionListener{
    private JPanel p1;
    private JLabel l1p;
    private JTextField tex1,tex2;
    private JLabel l11,l1;
    private JButton b,pb,b3;
    String s;
    report()
    {
        setTitle("report");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1=new JPanel();
        s=String.valueOf(covidTest.covp);
        s=s+" percent";
        tex1=new JTextField(" Your covid affectence posibility is "+s);
        tex1.setForeground (Color.black);
        tex1.setBounds(160,120,390,30);
        tex1.setEditable(false);
        tex1.setFont(new Font("Serif", Font.PLAIN, 20));
        tex2=new JTextField();
        tex2.setForeground (Color.black);
        tex2.setBounds(160,160,390,30);
        tex2.setFont(new Font("Serif", Font.PLAIN, 20));
        l1=new JLabel("Your name:");
        l1.setForeground (Color.white);
        l1.setBounds(55,160,150,30);
        l1.setFont(new Font("Serif", Font.PLAIN, 22));
        p1.setBounds(0,0,700,600);
        p1.setLayout(null);
        p1.add(l1);
        p1.add(tex2);
        p1.add(tex1);
        add(p1);
        b =new JButton("Add to databace");
        b.setBounds(250,200,200,30);
        b3 =new JButton("Home");
        b3.setBounds(250,280,200,30);
        p1.add(b3);
        p1.add(b);
        pb =new JButton("ALL DATA");
        pb.setBounds(250,240,200,30);
        p1.add(pb);
        setSize(700,600);
        setLayout(null);
        Icon icon = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\regestration\\a.jpg");
        l11=new JLabel(icon);
        l11.setBounds(0,0,700,600);
        p1.add(l11);
        setLocationRelativeTo(null);
        setVisible(true);
        b.addActionListener(l->{
            new dbconect().addPatient(tex2.getText(),covidTest.covp);
        });
        b3.addActionListener(l->{
           covidTest.covp=0;
           new home(); 
           dispose();
        });
        pb.addActionListener(l->new patent());
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
