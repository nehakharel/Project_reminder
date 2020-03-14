import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class Select extends JFrame implements ActionListener
{
    JLabel lpurpose;
    JComboBox jccategory;
    int id;
    //String smail;
    public Select(int uid)
    {
        lpurpose=new JLabel("Select your purpose");
      String[] arr = {"Personal","Business"};
      jccategory = new JComboBox(arr);

      add(lpurpose);
      add(jccategory);
      setSize(800,800);
      setLayout(null);
      lpurpose.setBounds(50,150,180,30);
      jccategory.setBounds(250,150,80,30);
      setVisible(true);
      jccategory.addActionListener(this);
      this.id=uid;
      //this.smail=umail;
    }
    public void actionPerformed(ActionEvent fg)
    {
        String spurpose=(String)jccategory.getSelectedItem();
        if(jccategory.getSelectedIndex()!=-1)
        {
        new Purpose(id,spurpose);
        }
        
    }
    
}