

<%@page import="login.LoginForm"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Student Information System</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <jsp:include page="WEB-INF/jspf/header.jspf" flush="false"/>
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
                <p align="left">
                    <b>Welcome ${sessionScope.student.firstName}</b>
                </p>

                <jsp:include page="WEB-INF/jspf/schedule.jspf" flush="false"/>

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
    </body>
</html>