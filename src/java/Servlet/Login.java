package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Login extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         HttpSession session = request.getSession();
             try{
                     String email = request.getParameter("email");
                     String pass = request.getParameter("password");
                    DataBase.DbConnect db = new DataBase.DbConnect();
                    HashMap userDetails = db.checkLogin(email, pass);
                    if(userDetails != null){
                        session.setAttribute("userDetails", userDetails);
                        response.sendRedirect("profile.jsp");
                    }
                    else{
                        session.setAttribute("msg","Wrong Entry!");
                        response.sendRedirect("home.jsp");
                    }
             }catch(Exception ex){
                    session.setAttribute("msg", "Login Failed: "+ex);
                    response.sendRedirect("home.jsp");
             }
    }
}
