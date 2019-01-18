// Java code to explain how to generate OTP

// Here we are using random() method of util
// class in Java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;




public class OTP_Generator
{

    // Generates OTP
    public static int generator()
    {

        // Using random method
        Random rand=new Random();
        return rand.nextInt(9999);

    }




    // checks OTP and user input
    private static void OTPchecker(int OTP, String email_id)
    {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter OTP received on email id:");
        int user_input=sc.nextInt();

        // check OTP
        if(OTP==user_input)
        {
            System.out.println("OTP authenticated");
            System.out.println("Grant access to  "+email_id);

        }
        else
        {
            System.out.println("OTP entered does not match");
        }

    }




    // used to send email using java mail API
    private static void sendEmail(int OTP,String email_id)
    {



        // Recipient's email ID is email_id


        // Sender's email ID needs to be mentioned
        String from = "xxxxx@gmail.com";

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_id));

            // Set Subject: header field
            message.setSubject("OTP for Authenication Purpose");

            // Now set the actual message
            message.setText("OTP is "+OTP);

            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }



    }






    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the email id to receive OTP");
        String email_id =sc.nextLine();
        int OTP=generator();
        System.out.println("Sending OTP to "+email_id);
        sendEmail(OTP,email_id);
        OTPchecker(OTP,email_id);
    }

}







