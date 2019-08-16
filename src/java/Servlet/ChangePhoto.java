package Servlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@MultipartConfig
public class ChangePhoto extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
     {
        HttpSession session=request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        try{
            String email=request.getParameter("email");
            Part p=request.getPart("photo");
                InputStream in=null;
                if(p != null){
                    in=p.getInputStream();
                }
                DataBase.DbConnect db= new DataBase.DbConnect();
                String check=db.changePhoto(email, in);
                if(check.equalsIgnoreCase("Done")){
                    session.setAttribute("msg", "Photo Update Successfully.");
                    response.sendRedirect("profile.jsp");
                }
                else{
                    session.setAttribute("msg", "Update Failed.Please try Again!");
                    response.sendRedirect("profile.jsp");
                }
        }catch(Exception ex){
            session.setAttribute("msg","Update Failed."+ex);
            response.sendRedirect("profile.jsp");
        }
    }
}
