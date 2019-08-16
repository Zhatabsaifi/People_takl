package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@MultipartConfig
public class Downloadfile extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            String filename=request.getParameter("filename");
            System.out.println(filename);
            Integer pid = Integer.parseInt(request.getParameter("pid"));
            DataBase.DbConnect db = new DataBase.DbConnect();
            byte b[]=db.getfilebypid(pid);
            if(b != null){
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("content-Disposition", "attachment;filename"+filename);
                response.getOutputStream().write(b);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
