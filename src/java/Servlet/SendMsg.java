package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@MultipartConfig
public class SendMsg extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap userDetails = (HashMap) session.getAttribute("userDetails");
        try{
            if(userDetails != null){
                  String temail=request.getParameter("temail");
                String semail=(String)userDetails.get("email");
                String message=request.getParameter("message");
                Part p=request.getPart("ufile");
                java.io.InputStream in=null;
                String fname="";
                if(p!=null){
                    fname=p.getSubmittedFileName();
                    in = p.getInputStream();
                }
                 DataBase.DbConnect db = new DataBase.DbConnect();
                 String ans=db.sendMessage(semail, temail, message, fname, in);
                 if(ans.equalsIgnoreCase("Done")){  
                     session.setAttribute("msg", "Message Sent Successfully.");  
                     response.sendRedirect("talk.jsp?temail="+temail);
                 }
                 else{ 
                     session.setAttribute("msg", "Message Sending Failed!");  
                     response.sendRedirect("talk.jsp?temail="+temail);
                 }
            }else{
                 String temail=request.getParameter("temail");
                    session.setAttribute("msg", "Message Sending Failed!");  
                     response.sendRedirect("talk.jsp?temail="+temail);
            }
        }catch(Exception ex){
            
                 String temail=request.getParameter("temail");
            session.setAttribute("msg","Failed "+ex+" ");
            response.sendRedirect("talk.jsp?temail="+temail);
        }
    }
}
