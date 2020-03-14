import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener
{
  JLabel lusername,lpassword,lLogin;
  JTextField tfuname,tfpassword;
  JButton click;
  public Login()
  {     
        lusername=new JLabel("Username");
        lpassword=new JLabel("Password");
        lLogin=new JLabel("Login");
        tfuname=new JTextField(60);
        tfpassword=new JTextField(60);
        click=new JButton("login");
        add(lLogin);
        add(lusername);
        add(tfuname);
        add(lpassword);
        add(tfpassword);
        add(click);
        setSize(700,700);
        setLayout(null);
        lLogin.setBounds(350,210,150,40);
        lusername.setBounds(250,280,100,40);
        tfuname.setBounds(400,280,120,40);
        lpassword.setBounds(250,350,100,40);
        tfpassword.setBounds(400,350,120,40);
        click.setBounds(290,420,150,40);

        setVisible(true);
        click.addActionListener(this);
  }
  public void actionPerformed(ActionEvent fg)
    {
        String uname=tfuname.getText();
        String psw=tfpassword.getText();
        
            if (uname.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter your username");
            
            }else if(psw.isEmpty())
            {
            JOptionPane.showMessageDialog(this,"enter your password");
                
            }
            else
            {
                try {
                        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/reminder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                        Statement stmt = conn.createStatement();
                        String sql="select uid,UserName,Password,Email from register";
                        ResultSet rs = stmt.executeQuery(sql); 
                        while(rs.next())
                        {       
                                int dbuid=rs.getInt("uid");
                                String dbuname= rs.getString("UserName");  
                                String dbpwd= rs.getString("Password");
                                //String mail=rs.getString("Email");
                           
                            if(uname.equals(dbuname) && psw.equals(dbpwd))
                                {
                                    new Select(dbuid);
                                }
                            
                        }

                    
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                    
            }
        
    }
    public static void main(String args[])
    {
        new Login();
    }
}
