
package progect;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class patent extends JFrame implements ActionListener{
    JTable table;
    DefaultTableModel model;
    JPanel p1,p2;
    JButton b1;
    JLabel l1;
    patent()
    {
        setTitle("patent");
        setSize(700,600);
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(0,0,700,100);
        add(p1);
        l1=new JLabel("Record of all students");
        l1.setForeground (Color.white);
        l1.setFont(new Font("Serif", Font.PLAIN, 20));
        l1.setBounds(250,50,300,40);
        p1.add(l1);
        p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(0,100,700,600);
        add(p2);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        p1.setBackground( new Color(31,48,130) );
        p2.setBackground( new Color(31,48,130) );
        table = new JTable();
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50,0,600,300);
        p2.add(sp);
        String[] columnNames = {"Name", "Percentages"};
        try{
        ResultSet rs = new dbconect().getList();
        model = new DefaultTableModel(columnNames, 0);
        while (rs.next()) {
            String name = rs.getString("name");
            int pct = rs.getInt("pct");
            model.addRow(new Object[] {name, pct});
        }
        if(rs.isClosed()) {
            System.out.println("ResultSet is closed");
        }
        }catch(SQLException e){
            
        }
        table.setModel(model);
        b1=new JButton("Home page");
        b1.setBounds(250,400,150,30);
        b1.setFont(new Font("Serif", Font.PLAIN, 20));
        p2.add(b1);
        b1.addActionListener(l->{
        covidTest.covp=0;
        new home(); 
       dispose();
        });
        setBackground( new Color(31,48,130) );
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
      
}
