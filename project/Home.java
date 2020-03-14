import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Home extends JFrame implements ActionListener
{
    JButton blogin, bsignup;
    JLabel text;
    public Home()
    {   
        text=new JLabel("Welcome!");
        blogin=new JButton("Login");
        bsignup=new JButton("Signup");
        setLayout(null);
        text.setBounds(300,150,150,50);
        blogin.setBounds(250,230,150,50);
        bsignup.setBounds(250,320,150,50);
        setSize(700,700);
        add(text);
        add(blogin);
        add(bsignup);
        setVisible(true);
        blogin.addActionListener(this);
        bsignup.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ac)
    {
      if(ac.getSource()==blogin)  
      {
          new Login();
      }
      else if(ac.getSource()==bsignup)  
      {
          new Register();
      }
    
    }
    public static void main(String args[])
    {
        new Home();
    }
}