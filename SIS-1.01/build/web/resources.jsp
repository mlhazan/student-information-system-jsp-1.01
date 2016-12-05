
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resources Page</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <jsp:include page="WEB-INF/jspf/header.jspf" />
            </div>
            <div id="font1">
                <%
                String ID=(String)session.getAttribute("username");
                out.println("Student ID : "+"<a href='account.jsp'>"+ID+"</a>");
                %>
            </div>
            <div id="navigation">
                <jsp:include page="WEB-INF/jspf/topmenu.jspf" flush="false"/>
            </div>
            <div id="section-navigation">
                <ul>
                    <jsp:include page="WEB-INF/jspf/menu.jspf" flush="false"/>
                </ul>
            </div>
            <div id="content">
                <p id="p20blue"> Resources </p>
                <br> <br>
                <p style="font-size:16pt"> We got most of our ideas for features and styling from the University of Windsor's <a href="https://uowweb1.uwindsor.ca/uowsis/fortecgi/frte_cs0?serviceName=wwwST&templateName=SISWebST/html/StudentLogin.htm">SIS page</a>. Our left banner page was obtained from <a href="http://t1.gstatic.com/images?q=tbn:ANd9GcTLDeYZp7snVrgDud3WN4YOqwIaOmLNBA0dyTn3pyJw1aqZOmHN4g">here</a> and our top banner was obtained from <a href="data:image/jpg;base64,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">here</a></p>
            </div>
            <div id="rightPanel">
                <div class ="greyBox">
                    <jsp:include page="WEB-INF/jspf/rightpanel.jspf" flush="false"/>
                </div>
            </div>
            <br /><br />
            <div id="footer">
                 <jsp:include page="WEB-INF/jspf/footer.jspf" />
            </div>
        </div>
    </body>
</html>
