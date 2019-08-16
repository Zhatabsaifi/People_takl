package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Find extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
       try{
           String email = request.getParameter("email");
           String name = request.getParameter("name");
           DataBase.DbConnect db = new DataBase.DbConnect();
           java.util.ArrayList<java.util.HashMap> alluserDetails=db.find(email,name);
           if(! alluserDetails.isEmpty()){
                session.setAttribute("alluserDetails", alluserDetails);
                response.sendRedirect("find_entry.jsp");
            }else{
                session.setAttribute("msg","No Date FOund!");
                response.sendRedirect("profile.jsp");
            }
       }catch(Exception ex){
           session.setAttribute("msg", "Failed! "+ex);
           response.sendRedirect("profile.jsp");
       }
    }
}
