package Servlet;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "SearchProcess", urlPatterns = {"/SearchProcess"})
public class SearchProcess extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        try{
            HashMap userDetail = (HashMap)session.getAttribute("userDetails");
            String email = (String) userDetail.get("email");
            String state=request.getParameter("state");
            String city = request.getParameter("city");
            String area = request.getParameter("area");
            DataBase.DbConnect db = new DataBase.DbConnect();
            java.util.ArrayList<java.util.HashMap> alluserDetails=  db.SearchPeople(state,city,email,area);
            if(! alluserDetails.isEmpty()){
                java.util.HashMap address = new java.util.HashMap();
                address.put("state", state);
                address.put("city",city);
                address.put("area",area);
                session.setAttribute("alluserDetails", alluserDetails);
                session.setAttribute("address", address);
                response.sendRedirect("peoplesearch.jsp");
            }else{
                session.setAttribute("msg","No Date FOund!");
                response.sendRedirect("profile.jsp");
            }
        }catch(Exception ex){
            session.setAttribute("msg", "Failed"+ex);
            response.sendRedirect("profile.jsp");
        }
    }
}
