<%@page import="java.util.HashMap"%>
<%
    HashMap userDetail = (HashMap)session.getAttribute("userDetails");
    if(userDetail != null){
        session.setAttribute("allUserDetail", null);
        session.setAttribute("address", null);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PeopleTalk</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/custom.css" rel="stylesheet">
	
	<script language="Javascript" src="js/jquery.js"></script>
	<script type="text/JavaScript" src='js/state.js'></script>
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
                                    <li><form action="Find?email=<%=userDetail.get("email")%>" method="post" class="form-horizontal">
                                            <input type="text" name="name" placeholder="Enter Name" required/>
                                            <input type="submit" value="Search" class="btn btn-primary"/>
                                        </form>
                                    </li>
                                    <li><div class="navbar-text"><p>Welcome: <%= userDetail.get("name")  %>    </p></div></li>
					<li><a href="profile.jsp">Home</a></li>
					<li><a href="Logout">Logout</a><li>
				</ul>			
			</div>
		</div>
	</nav>
	</br>
	</br>
		<div class="container">
			<section>
			<div class="row">
				<div class="col-lg-6">
					<div class="col-lg-4"><% session.setAttribute("photo",userDetail);%>
                                            <img src="GetPhoto?email=<%= userDetail.get("email") %>" width="150" height="150">
					</div>
					<div class="col-lg-6">
						<div class="form-group">
							<label for="email" class="control-label">Name: <font color="grey"><%= userDetail.get("name")  %></font></label>
						</div><!--end form group-->
						<div class="form-group">
							<label for="name" class="control-label">Email:<font color="grey"> <%= userDetail.get("email")  %></font></label>
						</div><!--end form group-->
						<div class="form-group">
							<label for="gender" class="control-label">Gender: <font color="grey"><%= userDetail.get("gender")  %></font></label>
						</div><!--end form group-->
						<div class="form-group">
							<label for="dob" class="control-label">Date of Birth: <font color="grey"><%= userDetail.get("dob")  %></font></label>
						</div>
						</div><!--end form group-->
						<div class="col-lg-10 form-group">
							<label for="state" class="control-label">Address: <font color="grey"><%= userDetail.get("area")  %>,<%= userDetail.get("city")  %>, <%= userDetail.get("state")  %></font></label>
						</div><!--end form group-->
						<div class="form-group">
							<div class="col-lg-10 form-group">
								<a href="editprofile.jsp" class="btn btn-primary">Edit Profile</a>
                                <a href="changepassword.jsp" class="btn btn-primary">Change Password</a>
															
							</div>		
						</div>
					</div>
                                                <br><br>
				<div class="col-lg-6"> 
<%
        String msg=(String)session.getAttribute("msg");
        if(msg != null){
%>
        <div class="panel panel-danger">
            <div class="panel-heading text-center">
                <h4><%=  msg %></h4>
            </div>
        </div>
<%
        session.setAttribute("msg", null);
    }
%>
					<div class="panel panel-default">
						<div class="panel-heading text-center">
							<h3>Search People</h3>
						</div>
						<div class="panel-body">
							<form action="SearchProcess" method="post" class="form-horizontal">
								<div class="form-group">
									<label for="state" class="col-lg-3 control-label">State:</label>
									<div class="col-lg-9">
										<select name="state" class="form-control" id="listBox" onchange='selct_district(this.value)'>
											
										</select>
									</div>
								</div><!--end form group-->
								<div class="form-group">
									<label for="city" class="col-lg-3 control-label">City:</label>
										<div class="col-lg-9">
											<select name="city" class="form-control" id='secondlist'>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label for="area" class="col-lg-3 control-label">Area:</label>
									<div class="col-lg-9">
										
										<input type="text" name="area" class="form-control" id="area" placeholder="Enter your Area" />
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-10 col-lg-offset-3">
										<button type="search" class="btn btn-primary" >Search</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!--footer--><br><br><br>
        <div class="panel panel-default">
             <div class="panel-heading text-center">
                    <h3>Unread message</h3>
                </div>
<%
                DataBase.DbConnect db=new DataBase.DbConnect();
                java.util.ArrayList<java.util.HashMap> newmsg = db.unreadmsg((String)userDetail.get("email"));
               for(java.util.HashMap peopleDetail : newmsg){
 %>
               
                <div class="panel-body">
                                <div class="panel-body text-left" class="text-left" >

                                       <section>
                <div class="row">
                        <div class="col-lg-3"><% session.setAttribute("photo",peopleDetail);%>
                            <img src="GetPhoto?email=<%=peopleDetail.get("email")%>"    width="75" height="75">
                        </div>
                        <div class="col-lg-7">
                                        <div class="form-group">
                                                <label for="email" class="control-label">Name: <font color="grey"><%=   peopleDetail.get("name")    %></font></label><br>
                                                <label for="name" class="control-label">Email:<font color="grey"><%=   peopleDetail.get("email")    %></font></label><br>
                                                <label for="phone" class="control-label">Phone: <font color="grey"><%=   peopleDetail.get("phone")    %></font></label><br>										

                                        </div>
                        </div>
                                                <form action="talk.jsp?temail=<%=peopleDetail.get("email")%>" method="post" class="form-horizontal">
                                <div class="col-lg-2">
                                        <div class="form-group">
                                        </br>
                                        </br>
                                <button type="search" class="btn btn-primary">New Message</button>
                                        </div>
                                </div>
                        </form>
                         <font size="2" >
                              <label >Date: <%=   peopleDetail.get("udate")    %></label>
                        </font>
                </div>
        </section>
                        
                    </div>
                    <hr>
            </div>
<%
    }
%>

        </div>
	<div class="navbar navbar-inverse navbar-fixed-bottom">
		<div class="container">
			<div class="navbar-text pull-left">
				<p>Design and Develop by Zhatab</p>
			</div>
	
		</div>
	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
<%
    }
    else{
        session.setAttribute("msg", "Please LogIn First!");
        response.sendRedirect("home.jsp");
    }
%>