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

public class resturent extends JFrame implements ActionListener {

    private JPanel p1;
    public int po = 0;

    resturent() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS chart (ItemName VARCHAR(255),Price INTEGER,Quantity INTEGER)");
            JFrame frame = new JFrame();
            frame.setSize(700, 600);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel p1 = new JPanel();
            JLabel l1 = new JLabel("Item Name");
            JTextField t1 = new JTextField(15);
            JLabel l2 = new JLabel("price");
            JTextField t2 = new JTextField(10);
            JButton b1 = new JButton("Add Item");
            JTextField t3 = new JTextField(10);
            JLabel l100 = new JLabel("Qunatity");
            JButton b2 = new JButton("Buy Item");
            JLabel l11 = new JLabel("Item Name");
            JTextField t11 = new JTextField(15);
            JLabel l21 = new JLabel("price");
            JTextField t21 = new JTextField(10);
            JButton b11 = new JButton("Add Item");
            JTextField t31 = new JTextField(10);
            JLabel l1001 = new JLabel("Qunatity");
            JButton b21 = new JButton("Buy Item");
            JButton b22 = new JButton("Refresh Price");
            JButton b24 = new JButton("Back Page");
            p1.add(l1);
            p1.add(t1);
            p1.add(l2);
            p1.add(t2);
            p1.add(l100);
            p1.add(t3);
            p1.add(b1);
            p1.add(l11);
            p1.add(t11);
            p1.add(l21);
            p1.add(t21);
            p1.add(l1001);
            p1.add(t31);
            p1.add(b21);
            frame.add(p1);
            l1.setForeground (Color.white);
            l1.setFont(new Font("Serif", Font.PLAIN, 14));
            l2.setForeground (Color.white);
            l2.setFont(new Font("Serif", Font.PLAIN, 14));
            l11.setForeground (Color.white);
            l11.setFont(new Font("Serif", Font.PLAIN, 14));
            l100.setForeground (Color.white);
            l100.setFont(new Font("Serif", Font.PLAIN, 14));
            l21.setForeground (Color.white);
            l21.setFont(new Font("Serif", Font.PLAIN, 14));
            l1001.setForeground (Color.white);
            l1001.setFont(new Font("Serif", Font.PLAIN, 14));
            p1.setBackground(new Color(31,48,130));
            JPanel p2 = new JPanel();
            JTable table = new JTable();
            JScrollPane scrollPane = new JScrollPane(table);
            p2.add(scrollPane);
            p2.setBackground(new Color(31,48,130));
            frame.add(p2);
            JLabel l123 = new JLabel("Total cost");
            p2.add(l123);
            JTextField t4 = new JTextField(10);
            p2.add(t4);
            p2.add(b22);
            p2.add(b24);
            // manually add data to table
            String[] columnNames = {"ItemName", "Price", "Quantity"};
            l123.setForeground (Color.white);
            l123.setFont(new Font("Serif", Font.PLAIN, 14));
            ResultSet rs = stmt.executeQuery("SELECT * FROM chart");
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                String name = rs.getString("ItemName");
                int age = rs.getInt("Price");
                int Quantity = rs.getInt("Quantity");
                model.addRow(new Object[]{name, age, Quantity});
            }
            table.setModel(model);
             b24.addActionListener(e ->
             {
                 new home();
                 dispose();
             });
             b22.addActionListener(e ->
             {
                 po=0;
                 t4.setText(String.valueOf(po));
             });
            // add action listener
            b1.addActionListener(e -> {
                try {
                    Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
                    Statement stmt2 = con2.createStatement();
                    String name = t1.getText();
                    String age = t2.getText();
                    String Quantity = t3.getText();
                    int age22 = Integer.parseInt(age);
                    int Quantity22 = Integer.parseInt(Quantity);
                    if (name.equals("") || age.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    } else {
                        stmt2.executeUpdate("INSERT INTO chart (ItemName, Price, Quantity) VALUES ('" + name + "', " + age22 + ", " + Quantity22 + ")");
                        model.addRow(new Object[]{name, age, Quantity});
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        JOptionPane.showMessageDialog(null, "Item added");
                    }
                    con2.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            // add action listener to table
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        int row = table.getSelectedRow();
                        String name1 = table.getValueAt(row, 0).toString();
                        String age = table.getValueAt(row, 1).toString();
                        String Quantity = table.getValueAt(row, 2).toString();
                        int price1 = Integer.parseInt(age);
                        int Quantity1 = Integer.parseInt(Quantity);
                        String newName = JOptionPane.showInputDialog(null, "Name: " + name1);
                        int newPrice = Integer.parseInt(JOptionPane.showInputDialog(null, "Price: " + price1));
                        int newQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantity1 : " + Quantity1));
                        try {
                            Connection con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
                            Statement stmt3 = con3.createStatement();
                            String query = String.format("UPDATE chart SET ItemName = '%s', Price = %s ,Quantity =%s WHERE ItemName = '%s' AND Price = %s AND Quantity=%s", newName, newPrice, newQuantity, name1, price1, Quantity1);
                            stmt3.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Item updated");
                            con3.close();
                            table.setValueAt(newName, row, 0);
                            table.setValueAt(newPrice, row, 1);
                            table.setValueAt(newQuantity, row, 2);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            });
            b21.addActionListener(e -> {
                         try{
                            System.out.println("hi"); 
                        Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/res", "root", "");
                        String item = t11.getText();
                        String Quantity = t31.getText();
                        int Quantity22 = Integer.parseInt(Quantity);
                        Statement stmt3 = con2.createStatement();                        
                        ResultSet r = stmt3.executeQuery("select * from chart ");
                        while (r.next()) {
                            String ItemName = r.getString(1);
                            System.out.println("hi");
                            if (item.equals(ItemName)) {
                                String I = r.getString(2);
                                int p = Integer.parseInt(I);
                                po = (p * Quantity22)+po;
                                String quan = r.getString(3);
                                int q = Integer.parseInt(quan);
                                
                                q = q - Quantity22;
                                if(q<0){
                                    JOptionPane.showMessageDialog(null, "Stock KHALIIII!!!!");
                                    break;
                                }
                                quan = String.valueOf(q);
                                String query = String.format("UPDATE chart SET Quantity =%s WHERE ItemName = '%s'",q,ItemName);
                                stmt3.executeUpdate(query);
                                System.out.println(po);
                                t4.setText(String.valueOf(po));
                                break;
                            }
                        }
                        r=stmt3.executeQuery("SELECT * FROM chart");
                        int i=0;
                        while(r.next()){
                            table.setValueAt(r.getString(1), i, 0);
                            table.setValueAt(r.getString(2), i, 1);
                            table.setValueAt(r.getString(3), i, 2);
                            i++;
                        }
                        con2.close();
                        }
                    catch (Exception ex) {
                        ex.printStackTrace();
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
