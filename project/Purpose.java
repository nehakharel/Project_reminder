import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Purpose extends JFrame implements ActionListener
{
    JLabel levent, ldatetime;
    //JComboBox jccategory;
    JTextField tfevent, tfdatetime;
    JButton submit;
    int id;
    String selected;
    
    public Purpose(int uid, String s)
    {
        levent=new JLabel("Enter event");
        ldatetime=new JLabel("Enter event's date(yyyy-MM-dd)");
        tfevent=new JTextField(70);
        tfdatetime=new JTextField(100);
        submit=new JButton("Click");

      //String[] arr = {"Birthday","Ocassions","Events"};
      //jccategory = new JComboBox(arr);

      add(levent);
      add(ldatetime);
      add(tfevent);
      add(tfdatetime);
      add(submit);
      setSize(700,700);
      setLayout(null);
      levent.setBounds(50,150,120,30);
      tfevent.setBounds(200,150,120,30);
      ldatetime.setBounds(50,200,220,30);
      tfdatetime.setBounds(240,200,150,30);
      submit.setBounds(130,270,120,30);
      
      this.id=uid;
      this.selected=s;
      //this.mail=smail;
      setVisible(true);
      submit.addActionListener(this);
      
    }

    public void actionPerformed(ActionEvent ae)
    {
        String event = tfevent.getText();
        String datetime = tfdatetime.getText();
        if(ae.getSource()==submit)
        {
           
         
            if(event.isEmpty())
            {
                JOptionPane.showMessageDialog(this,"Enter event");
            }
            else{
                new CurrentDateTime();
            
                try {
                    
                    Connection c =DriverManager.getConnection("jdbc:mysql://localhost/reminder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                            String q="insert into userdata(uid,Purpose,Event,Date) values(?,?,?,?)";
                            PreparedStatement p=c.prepareStatement(q);
                            p.setInt(1,id);
                            p.setString(2,selected);
                            p.setString(3,event);
                            p.setString(4,datetime);
                            int a = p.executeUpdate();
                            if(a > 0){
                                JOptionPane.showMessageDialog(this,"Event recorded successfully"); 
                            }
                            else 
                            {
                                JOptionPane.showMessageDialog(this,"not recorded"); 
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    //new Remind();
        }


    }
    
    
    
}