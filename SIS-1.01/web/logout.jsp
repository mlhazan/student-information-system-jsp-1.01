
<% session.invalidate(); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Student Information System</title>


    </head>
    <body>


<div id="container">
	<div id="header">

			<jsp:include page="WEB-INF/jspf/header.jspf" flush="false"/>


	</div>
	<div id="navigation">
		<ul>
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Contact us</a></li>
		</ul>
	</div>
	<div id="content-container">
		<div id="section-navigation">
                    <jsp:include page="WEB-INF/jspf/leftpanel.jspf" flush="false"/>

		</div>
		<div id="content">

        <div class="greyBox"
             <h5> Session Deleted.Please make a new session.<a href="./index.jsp">Click here</a>
        </h5>
        </div>
      
      		</div>
		<div id="rightPanel">
			<div class ="greyBox">

			<jsp:include page="WEB-INF/jspf/rightpanel.jspf" flush="false"/>

                    </div>
		</div>
		<div id="footer">
			<jsp:include page="WEB-INF/jspf/footer.jspf" flush="false"/>
		</div>
	</div>
</div>



    </body>
</html>