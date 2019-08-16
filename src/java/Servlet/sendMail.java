package Servlet;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class sendMail extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
              String email = request.getParameter("email");
              DataBase.DbConnect db = new DataBase.DbConnect();
             String pass =  db.passbyemail(email);
             if(pass != null){
                 final String SEmail="sendmailincapp@gmail.com";
                 final String SPass="Zhatab1757#"; 
                 final String REmail=email;
                 final String Sub="Your Password is Here from PeopleTalk!";
                 final String Body="Your Email Id: "+email+" and Password: "+pass;
                 Properties props=new Properties();
                 props.put("mail.smtp.host","smtp.gmail.com");
                 props.put("mail.smtp.socketFactory.port","465");
                 props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                 props.put("mail.smtp.auth","true");
                 props.put("mail.smtp.port","465");
                 Session sess=Session.getInstance(props, new javax.mail.Authenticator(){
                                                                protected PasswordAuthentication getPasswordAuthentication(){
                                                                        return new PasswordAuthentication(SEmail,SPass);
                                                                  }
                                                             }
                 );
                 Message message=new MimeMessage(sess);
                 message.setFrom(new InternetAddress(SEmail));
                 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(REmail));
                 message.setSubject(Sub);
                 message.setContent(Body,"text/html");
                 Transport.send(message);
                 session.setAttribute("msg","Mail Sent successfully.");
                 response.sendRedirect("home.jsp");
             }else{
                 session.setAttribute("msg","You doesn't have any account.Please Register First!");
                 response.sendRedirect("forgetpassword.jsp");
             }
        }catch(Exception ex){
            session.setAttribute("msg", "Failed !"+ex);
            response.sendRedirect("home.jsp");
        }
    }
}
