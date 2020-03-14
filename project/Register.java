import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Register extends JFrame implements ActionListener
{
  JLabel luname,lpassword,lname,lgender,lmail,lphone;
  JTextField tfuname,tfpassword,tfname,tfmail,tfphone;
  JButton click;
  JRadioButton r1,r2;
   String radio()
            {
                if(r1.isSelected())
                {
                    return "Male";
                }
                else 
                {
                    return "Female";
                }
            
            }
  public Register()
  {
      luname=new JLabel("Username");
      lpassword=new JLabel("Password");
      lname=new JLabel("Name");
      lgender=new JLabel("Gender");
      lmail=new JLabel("Email");
      lphone=new JLabel("Phone");
      r1=new JRadioButton("Male");
      r2=new JRadioButton("Female");
      ButtonGroup bg=new ButtonGroup();
      bg.add(r1);
      bg.add(r2);
      add(r1);
      add(r2);
      tfuname=new JTextField(60);
        tfpassword=new JTextField(60);
        tfname=new JTextField(60);
        tfmail=new JTextField(100);
        tfphone=new JTextField(60);
        click=new JButton("signup");
        add(luname);
        add(tfuname);
        add(lpassword);
        add(tfpassword);
        add(lname);
        add(tfname);
        add(lgender);
        add(lmail);
        add(tfmail);
        add(lphone);
        add(tfphone);
        add(click);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        luname.setBounds(80,30,80,30);
        tfuname.setBounds(180,30,120,30);
        lpassword.setBounds(80,70,80,30);
        tfpassword.setBounds(180,70,120,30);
        lname.setBounds(80,110,80,30);
        tfname.setBounds(180,110,120,30);
        lgender.setBounds(80,150,80,30);
        r1.setBounds(180,150,80,30);
        r2.setBounds(275,150,80,30);
        lmail.setBounds(80,190,80,30);
        tfmail.setBounds(180,190,120,30);
        lphone.setBounds(80,230,80,30);
        tfphone.setBounds(180,230,120,30);
        click.setBounds(120,290,80,30);
        click.addActionListener(this);
  }
  public void actionPerformed(ActionEvent fg)
    {
        String usname=tfuname.getText();
        String pwd=tfpassword.getText();
        String name=tfname.getText();
        String mail=tfmail.getText();
        String phone=tfphone.getText();
        if(fg.getSource()==click)
        {
           
        


            
             if (usname.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter Username");
            
            }else if(pwd.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter password");
                
            }
            else if(name.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"enter your name"); 
            }
            else
            {
                new Login();
                try {
                    Connection c =DriverManager.getConnection("jdbc:mysql://localhost/reminder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                    String q="insert into register(UserName,Password,Name,Gender,Email,Phone) values(?,?,?,?,?,?)";
                    PreparedStatement ps=c.prepareStatement(q);
                    ps.setString(1,usname);
                    ps.setString(2,pwd);
                    ps.setString(3,name);
                    ps.setString(4,radio());
                    ps.setString(5,mail);
                    ps.setString(6,phone);
                    int a = ps.executeUpdate();
                    if(a > 0){
                        JOptionPane.showMessageDialog(this,"new record created successfully"); 
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(this,"not recorded"); 
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
                    
            }
        }
        
    }
    public static void main(String args[])
    {
        new Register();
    }
}