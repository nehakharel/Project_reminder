
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
    

public class CurrentDateTime extends JFrame
{    
    String currentDt;
    public CurrentDateTime()
    {
       DateTimeFormatter dtff=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime noww=LocalDateTime.now();
        currentDt=dtff.format(noww);
        System.out.println(currentDt);
        setSize(600,606);
        setLayout(null);
    try {
        Connection conn =DriverManager.getConnection("jdbc:mysql://localhost/reminder?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
        Statement stmt = conn.createStatement();
        String sql="select register.Email from register inner join userdata on userdata.uid=register.uid where userdata.Date='"+currentDt+"'";
        ResultSet rs = stmt.executeQuery(sql); 
        while(rs.next())
        {   
            
            String dbmail= rs.getString("Email");
            SendEmail(dbmail);
              
           /* String dbDateTime= rs.getString("Date"); 
            if(dbDateTime.equals(currentDt))
                {
                    String q="select Email from register where 'dbDateTime'='currentDt'";
                    ResultSet rst = stmt.executeQuery(q); 
                    while(rst.next())
                    {   */   
                        
                        
        }
                    //System.out.println(dbmail);
    } catch (SQLException e)
    {
        e.printStackTrace();
    }
}
public void SendEmail(String mail)
{
    String to = mail;
    String from = "nehakcodes@gmail.com";
    String host = "smtp.gmail.com";
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("nehakcodes@gmail.com", "nkcodes@98");

        }

    });

    session.setDebug(true);
    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Reminder Alert!");
        message.setText("This is to remind you about your today's event.");
        System.out.println("sending...");
        Transport.send(message);
        System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }
   }
}   
    
    

/*class newthread implements Runnable
{
    

    {
        Thread t;
        newthread();
    {
        t=new Thread(this,"DT thread");
        t.start();
    }
    public void run()
    {
        try{
            for(int i=0;i<0;i++)
            {
                Thread.sleep(500);
                System.out.println(i);
                while(rs.next())
                    {       
                        
                            String dbDateTime= rs.getString("Date");  
                            
                    
                        if(dbDateTime.equals(currentDt))
                            {
                                new Remind();
                            }
                        
                    }
            
            }
        }catch(InterruptedException e)
    }
} 
public static void main(String args[])
{
        CurrentDateTime cdt=new CurrentDateTime();
        cdt.setVisible(true);
    }*/
    

