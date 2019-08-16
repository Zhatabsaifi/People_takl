package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class EditProfile extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        try{    
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            String name=request.getParameter("name");
            String gender=request.getParameter("gender");
            String dt=request.getParameter("dob");
                java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.util.Date   date = null;
                  date = sdf.parse(dt);
                java.sql.Date d=new java.sql.Date(date.getTime());
            String state=request.getParameter("state");
            String city=request.getParameter("city");
            String area=request.getParameter("area");
            DataBase.DbConnect db=new DataBase.DbConnect();
            String check=db.update(name, phone, gender, d, state, city, area,email);
            if(check.equalsIgnoreCase("Done")){
                HashMap userDetail = (HashMap) session.getAttribute("userDetails");
                userDetail.put("name",name);
                userDetail.put("phone",phone);
                userDetail.put("gender",gender);
                userDetail.put("dob", dt);
                userDetail.put("state",state);
                userDetail.put("city",city);
                userDetail.put("area",area);
                session.setAttribute("userDetails", userDetail);
                session.setAttribute("msg","Change Details Successfully.");
                response.sendRedirect("profile.jsp");
            }else{
                session.setAttribute("msg","Update Failed.Please Try Again!");
                response.sendRedirect("profile.jsp");}
        }catch(Exception ex){
            session.setAttribute("msg","Update Failed!"+ex);
                response.sendRedirect("profile.jsp");
        }
    }
}
