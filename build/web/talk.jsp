 <%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html>
 <%
     HashMap userDetails=(HashMap)session.getAttribute("userDetails");
     if(userDetails != null){
         String temail = request.getParameter("temail");
         DataBase.DbConnect db = new  DataBase.DbConnect();
         HashMap tuser = db.getPeopleByEmail(temail);
         db.setstatus(1,temail, (String)userDetails.get("email"));
 %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PeopleTalk</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/talk.css" rel="stylesheet">

   
  </head>
  
  <body data-spy="scroll" data-target="#my-navbar">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="profile.jsp">PeopleTalk</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><div class="navbar-text">Welcome: <%= userDetails.get("name")%></div></li>
					<li><a href="profile.jsp">Home</a></li>
					<li><a href="Logout">Logout</a><li>
				</ul>			
			</div>
		</div>
	</nav><!-- end of navbar-->
	
	</br>
	</br>
		<div class="container">
			<div class="row">
				<div class="col-lg-4"><% session.setAttribute("photo",tuser);%>
                                    <img src="GetPhoto?email=<%=tuser.get("email")%>"    width="120" height="120">
				</div>
				<div class="col-lg-4">
					<div class="form-group">
					</br>
						<label for="email" class="control-label">Name: <font color="grey"><%= tuser.get("name")%></font></label><br>
						<label for="gender" class="control-label">Gender: <font color="grey"><%= tuser.get("gender")%></font></label><br>
						<label for="phone" class="control-label">Phone: <font color="grey"><%= tuser.get("phone")%></font></label><br>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
					</br>
						<label for="name" class="control-label">Email:<font color="grey"> <%= tuser.get("email")%></font></label><br>
						<label for="dob" class="control-label">Date of Birth: <font color="grey"><%= tuser.get("dob")%></font></label><br>
						<label for="address" class="control-label">Address: <font color="grey"><%= tuser.get("state")%>,<%= tuser.get("city")%>,<%= tuser.get("area")%></font></label><br>
					</div>
				</div>
			</div>
		</div>
		</br>
<%
            String msg=(String)session.getAttribute("msg");
            if(msg!=null)  
            {
%>
        <div class="panel panel-success">
            <div class="panel-heading text-center">
                <p><%=msg%></p>
            </div>
        </div>
 <%
            session.setAttribute("msg", null);
        }
%>
		<div class="container text-center">
			<div class="panel panel-default">
				<div class="panel-body text-center">
                                    <form action="SendMsg" method="post" data-toggle="validator" enctype='multipart/form-data' class="form-horizontal">
						<div class="form-group">
							<label for="message" class="col-lg-2 control-label">Message:</label>
								<div class="col-lg-4">
									<textarea id="message" name="message" class="form-control" rows="5" cols="50" required></textarea>
								</div>
						</div><!--end form group-->
							<div class="form-group">
							<label for="filetosend" class="col-lg-2 control-label">File to Send:</label>
								<div class="col-lg-4">
									<input type="file" name="ufile" class="form-control" id="filetosend"/>
                                                                        <input type="hidden" name="temail" value="<%=tuser.get("email")%>"/>
								</div>
								<div class="col-lg-2">
									<button type="submit" class="btn btn-primary">Send</button>
								</div>
						</div><!--end form group-->
					</form>
				</div>
			</div>
		</div>
		<div class="container text-center">
			<div class="panel panel-default">
				<div class="panel-body text-center">
					<div class="row">
						<div class="col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading text-center">
									<h5><%= userDetails.get("name") %>'s Messages</h5>
								</div>
                                                           <%
                                                                    java.util.ArrayList<java.util.HashMap> allMessage=db.getMessages((String)userDetails.get("email"), temail);
                                                                    for(java.util.HashMap message:allMessage){
                                                                %>
								<div class="panel-body text-left" class="text-left" >
									<p>Message: <%=message.get("message")%></p>
									<div class="row">
                                                                            <font size="3" >
										<div class="form-group">
											<div class="col-lg-2">
                                                                                     <%
                                                                                                    String fname=(String)message.get("filename");
                                                                                                if(fname!=null && !fname.equals("")){
                                                                                            %>
												<label for="message" class="control-label">File:  <a href="Downloadfile?filename=<%= message.get("filename")%>&pid=<%= message.get("pid")%>"><%= message.get("filename")%></a> </label>
                                                                                                
                                                                                     <%
                                                                                                    }
                                                                                            %>
                                                                                        </div>
										</div>
										</font>
                                                                                <font size="2">
                                                                                                <div class="col-lg-2" >
													<label for="message" class="control-label">Date:<%=message.get("datetime")%></label>
												</div>
											</div>
										</font>
									</div>
									<hr>
								</div>
                                                            <%
                                                                        }
                                                                   %>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="panel panel-default">
								<div class="panel-heading text-center">
									<h5><%= tuser.get("name") %>'s Messages</h5>
								</div>
                                                                    <%
                                                                     allMessage=db.getMessages( temail,(String)userDetails.get("email"));
                                                                    for(java.util.HashMap message:allMessage){
                                                                %>
								<div class="panel-body text-left">
									<p>Message: <%=message.get("message")%></p>
									<div class="row">
										<font size="3">
											<div class="form-group">
												<div class="col-lg-2">
													  <%
                                                                                                    String fname=(String)message.get("filename");
                                                                                                if(fname!=null && !fname.equals("")){
                                                                                            %>
                                                                                                    <label for="message" class="control-label">File:  <a href="Downloadfile?filename=<%= message.get("filename")%>&pid=<%= message.get("pid")%>"><%= message.get("filename")%></a> </label>
										    <%
                                                                                                    }
                                                                                            %>
												</div>
											</div>
										</font>
                                                                                <font size="2">
                                                                                                <div class="col-lg-2" >
													<label for="message" class="control-label">Date:<%=message.get("datetime")%></label>
												</div>
											</div>
										</font>
									</div>
									<hr>
                                                                        
                                                              <%
                                                                        }
                                                                   %>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	<hr>
	
	<!--footer-->
	
	<div class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container">
			<div class="navbar-text pull-left">
				<p>Design and Develop by Zhatab</p>
			</div>
		</div>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/jquery-2.2.2.min.js"></script>
    <script src="js/validator.js"></script>
  </body>
</html>
<%
    }else{
        session.setAttribute("msg","Please LogIn First!");
        response.sendRedirect("home.jsp");
    }
%>