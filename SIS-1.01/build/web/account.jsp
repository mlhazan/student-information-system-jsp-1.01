
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<%
int count=0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Details</title>
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
                <p id="p20blue"> Financial Information </p>
                <table border="1" cellpadding="2px" align="center" width="600px">
                    <thead>
                        <th id="th">Course ID</th>
                        <th id="th">Course Name</th>
                        <th id="th">Cost</th>
                    </thead>
                    <tbody>
                        <jsp:useBean id="registration" class="beans.Registration" scope="session" />
                        <jsp:setProperty name="registration" property="studentId" value="${sessionScope['username']}" />
                        <c:forEach var="course" items="${registration.registeredCourses}">
                            <tr>
                                <td align="center">${course.courseNumber}</td>
                                <td>${course.title}</td>
                                <td align="center">$500</td>
                                <% count++; %>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br/>
                <table border="1" cellpadding="2px" align="center" width="600px">
                    <tr>
                        <td align="right"> Total Cost: </td>
                        <td align="right"> <% out.print("$"+count*500); %> </td>
                    </tr>
                </table>
            </div>
            <div id="rightPanel">
                <div class ="greyBox">
                    <jsp:include page="WEB-INF/jspf/rightpanel.jspf" flush="false"/>
                </div>
            </div>
            <br><br>
            <div id="footer">
                <jsp:include page="WEB-INF/jspf/footer.jspf" />
            </div>
        </div>
    </body>
</html>
