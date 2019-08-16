package Servlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class GetPhoto extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        try{
            String email = request.getParameter("email");
            DataBase.DbConnect db = new DataBase.DbConnect();
            byte[] b =db.getPhoto(email);
            if(b == null){
                ServletContext ctx=getServletContext();
                HashMap profilephoto = (HashMap) session.getAttribute("photo");
                session.setAttribute("photo",null);
                String gender = (String)profilephoto.get("gender");
                  InputStream fin=null;
                  if(gender.equals("female")){
                      fin=ctx.getResourceAsStream("/img/girl.jpg");
                  }else{
                      fin=ctx.getResourceAsStream("/img/xyz.jpg");
                  }
               b = new byte[35000];
                   fin.read(b);
            }
            response.getOutputStream().write(b);
        }catch(Exception ex){
            ex.printStackTrace();
            ServletContext ctx=getServletContext();
            HashMap userDetail = (HashMap) session.getAttribute("userDetails");
            String gender = (String)userDetail.get("gender");
            InputStream fin=null;
            if(gender.equalsIgnoreCase("female")){
                fin=ctx.getResourceAsStream("/img/girl.jpg");
            }else{
                 fin=ctx.getResourceAsStream("/img/xyz.jpg");
           }
           byte[] b = new byte[3500];
           fin.read(b);
           response.getOutputStream().write(b);
        }
    }
}
