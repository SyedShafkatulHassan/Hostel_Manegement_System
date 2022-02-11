
package progect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import javax.swing.*;

public class emargency extends JFrame implements ActionListener{
  private JButton shafkat,bach;
  private JLabel l;
  private JPanel p1;
  emargency()
  {
       setTitle("About Me");
       p1=new JPanel();
       p1.setLayout(null);
       p1.setBounds(0,0,720,600);
       Icon icon1 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\about\\back1.png");
       l=new JLabel(icon1);
       Icon icon2 = new ImageIcon("C:\\Users\\Shafkat\\Desktop\\progectimage\\about\\shafkatul.png");
       l.setBounds(0,0,715,600);
       p1.add(l);
       
      shafkat=new JButton(icon2);
      shafkat.setBounds(100,170,100,100);
       shafkat.addActionListener(this);
       bach =   new JButton("Home");
       bach.setBounds(250,530,100,30);
       bach.addActionListener(this);
       l.add(bach);
      l.add(shafkat);
      add(p1);
      setSize(720,600);
      setLayout(null);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
      setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shafkat)
        {
            try{
                java.awt.Desktop.getDesktop().browse(URI.create("https://github.com/SyedShafkatulHassan"));
            }
            catch(IOException ex)
            {
                System.out.print("hi");
            }
        }
        if(e.getSource()==bach)
        {
           new home();
           dispose();
        }
    }

}
