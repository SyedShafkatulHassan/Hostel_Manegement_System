package progect;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class room extends JFrame implements ActionListener {

    private JPanel p1;
    public int po = 0;

    room() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS rom (name VARCHAR(255),Roomnumber INTEGER)");
            JFrame frame = new JFrame();
            frame.setSize(700, 600);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel p1 = new JPanel();
            JLabel l1 = new JLabel("Name");
            JTextField t1 = new JTextField(15);
            JLabel l2 = new JLabel("Room number");
            JTextField t2 = new JTextField(10);
            JButton b1 = new JButton("Add");
            JButton b22 = new JButton("HomePage");
            p1.add(l1);
            p1.add(t1);
            p1.add(l2);
            p1.add(t2);
            p1.add(b1);
            frame.add(p1);
            l1.setForeground(Color.white);
            l1.setFont(new Font("Serif", Font.PLAIN, 14));
            l2.setForeground(Color.white);
            l2.setFont(new Font("Serif", Font.PLAIN, 14));
            p1.setBackground(new Color(31, 48, 130));
            JPanel p2 = new JPanel();
            JTable table = new JTable();
            JScrollPane scrollPane = new JScrollPane(table);
            p2.add(scrollPane);
            p2.add(b22);
            p2.setBackground(new Color(31, 48, 130));
            frame.add(p2);
           
               
            // manually add data to table
            String[] columnNames = {"Name", "Roomnumber",};
         
            ResultSet rs = stmt.executeQuery("SELECT * FROM rom");
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("Roomnumber");
                model.addRow(new Object[]{name, age});
            }
            table.setModel(model);

            b22.addActionListener(e
                    -> {
                new home();
                dispose();
            });
            // add action listener
            b1.addActionListener(e -> {
                try {
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
                    Statement stmt2 = con2.createStatement();
                    String name = t1.getText();
                    String age = t2.getText();
                    int age22 = Integer.parseInt(age);
                    stmt2.executeUpdate("INSERT INTO rom (name,Roomnumber) VALUES ('" + name + "', " + age22 + ")");
                    model.addRow(new Object[]{name, age});
                    t1.setText("");
                    t2.setText("");
                    JOptionPane.showMessageDialog(null, "Added");
                    con2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int row = table.getSelectedRow();
                        String name1 = table.getValueAt(row, 0).toString();
                        String age = table.getValueAt(row, 1).toString();
                        int price1 = Integer.parseInt(age);
                        String newName = JOptionPane.showInputDialog(null, "Name: " + name1);
                        int newPrice = Integer.parseInt(JOptionPane.showInputDialog(null, "Room Number: " + price1));
                        try {
                            Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
                            Statement stmt3 = con3.createStatement();
                            String query = String.format("UPDATE rom SET name = '%s', Roomnumber = %s  WHERE name = '%s' AND Roomnumber = %s ", newName, newPrice,name1, price1);
                            stmt3.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "updated");
                            con3.close();
                            table.setValueAt(newName, row, 0);
                            table.setValueAt(newPrice, row, 1);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
