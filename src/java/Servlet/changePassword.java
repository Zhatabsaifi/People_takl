package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class changePassword extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session=request.getSession();
            try{
                String email=request.getParameter("email");
                String password=request.getParameter("password");
                 String newpassword=request.getParameter("newpassword");
                  String confirmpassword=request.getParameter("confirmpassword");
                  if(newpassword.equals(confirmpassword)){
                      
                      DataBase.DbConnect db=new DataBase.DbConnect();
                       String check = db.changePassword(newpassword, email, password);
                       if(check.equalsIgnoreCase("Done")){
                            session.setAttribute("msg", "Password Change Successfully");
                            response.sendRedirect("profile.jsp");
                       }else{
                            session.setAttribute("msg", "Wrong Current Password!");
                            response.sendRedirect("changepassword.jsp");
                       }
                  }else{
                       session.setAttribute("msg", "Please enter same password!");
                        response.sendRedirect("changepassword.jsp");
                  }
            }catch(Exception ex){
                session.setAttribute("msg", ex);
                response.sendRedirect("changepassword.jsp");
            }
    }
}
