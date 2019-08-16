package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;

public final class editprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <title>PeopleTalk</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/forgetpassword.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"datetimepicker/css/datetimepicker.min.css\" rel=\"stylesheet\"  />\r\n");
      out.write("  </head>\r\n");
      out.write("  ");

      HashMap userDetail=(HashMap)session.getAttribute("userDetails");
  
      out.write("\r\n");
      out.write("  <body data-spy=\"scroll\" data-target=\"#my-navbar\">\r\n");
      out.write("<nav class=\"navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\r\n");
      out.write("\t\t\t\t<span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t<span class=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t\t<a class=\"navbar-brand\" href=\"profile.jsp\">PeopleTalk</a>\r\n");
      out.write("\t\t\t<div class=\"navbar-collapse collapse\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t<li><div class=\"navbar-text\"><p>Welcome: ");
      out.print( userDetail.get("name") );
      out.write("</p></div></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"profile.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"Logout\">Logout</a><li>\r\n");
      out.write("\t\t\t\t</ul>\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</nav><!-- end of navbar-->\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<section>\r\n");
      out.write("\t\t\t\t<div class=\"panel panel-default\">\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-heading text-center\">\r\n");
      out.write("\t\t\t\t\t\t<h3>Edit Profile</h3>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<form action=\"\"  method='post' enctype=\"multipart/form-data\"  data-toggle=\"validator\" class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-2 col-lg-offset-1\">");
 session.setAttribute("photo",userDetail);
      out.write("\r\n");
      out.write("                                                                        <img src=\"GetPhoto?email=");
      out.print( userDetail.get("email") );
      out.write("\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</br></br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label for=\"changephoto\" class=\"control-label\">Change Photo:</label><br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</br></br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"file\" name=\"photo\" class=\"form-control\" id=\"changephoto\" required/>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"col-lg-3 \" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</br></br>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<hr>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("                                                    <form action=\"EditProfile?email=");
      out.print( userDetail.get("email") );
      out.write("\" method='post' data-toggle=\"validator\" class=\"form-horizontal\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"email\" class=\"col-lg-2 control-label\">Email:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("                                                                            <label class=\"form-control\" id=\"email\" >");
      out.print( userDetail.get("email") );
      out.write("</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"phone\" class=\"col-lg-2 control-label\">Phone:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name='phone' class=\"form-control\" pattern=\"^[_0-9]{1,}$\" maxlength=\"10\" minlength=\"10\" id=\"phone\" placeholder=\"");
      out.print( userDetail.get("phone") );
      out.write("\"  required/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"name\" class=\"col-lg-2 control-label\">Name:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" pattern=\"^[_A-Z a-z]{1,}$\"  placeholder=\"");
      out.print( userDetail.get("name") );
      out.write("\" required/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"gender\" class=\"col-lg-2 control-label\">Gender:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\"> \r\n");
      out.write("                                                                      ");

                                                                                    String gender=(String) userDetail.get("gender") ;
                                                                            
      out.write("\r\n");
      out.write("                                                                            <input type=\"radio\" id=\"gender\"name=\"gender\" value=\"male\" ");
  if(gender.equalsIgnoreCase("male")){
      out.write("checked");
    }   
      out.write("/>Male\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"radio\" id=\"gender\"name=\"gender\" value=\"female\" ");
 else{
      out.write("checked");
    }   
      out.write("/>Female\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"dob\" class=\"col-lg-2 control-label\">Date of Birth:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("                                                                            <input type=\"text\" name=\"dob\" class=\"form-control\" id=\"dob\" placeholder=\"");
      out.print( userDetail.get("dob") );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"state\" class=\"col-lg-2 control-label\">State:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" name=\"state\" class=\"form-control\" id=\"listBox\" onchange='selct_district(this.value)'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"city\" class=\"col-lg-2 control-label\">City:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"form-control\" id='secondlist'>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"area\" class=\"col-lg-2 control-label\">Area:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-5\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"area\" name=\"area\" placeholder=\"");
      out.print( userDetail.get("state") );
      out.write(',');
      out.print( userDetail.get("city") );
      out.write(',');
      out.print( userDetail.get("area") );
      out.write("\"  required/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!--end form group-->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"col-lg-10 col-lg-offset-2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">Update Profile</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</form>\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!--footer-->\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"navbar navbar-inverse navbar-fixed-bottom\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"navbar-text pull-left\">\r\n");
      out.write("\t\t\t\t<p>Design and Develop by Zhatab</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("   \t<script type=\"text/javascript\" src=\"js/jquery-2.2.2.min.js\" ></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"js/script.js\" ></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/validator.js\" ></script>\r\n");
      out.write("<script type=\"text/javaScript\" src='js/state.js' ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"datetimepicker/js/moment.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"datetimepicker/js/datetimepicker.min.js\" ></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("    $(function () {\r\n");
      out.write("        $('#dob').datetimepicker({\r\n");
      out.write("        \tformat: 'DD/MM/YYYY',\r\n");
      out.write("                maxDate: new Date()\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\t</script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
