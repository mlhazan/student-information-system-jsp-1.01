

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Drop Courses</title>
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
                <jsp:include page="WEB-INF/jspf/menu.jspf" flush="false"/>
            </div>

            <div id="content">
                
                <p align="center">
                    <b>Currently Registered in Courses:</b>
                </p>
                    <table border="1px" cellpadding="2px" align="center" >
                        <thead>
                            <th bgcolor="#336699"><font color="White">Course#</font></th>
                            <th bgcolor="#336699"><font color="White">Section</font></th>
                            <th bgcolor="#336699"><font color="White">Course Name</font></th>
                            <th bgcolor="#336699"><font color="White">Session</font></th>
                        </thead>
                        <tbody>
                            <jsp:useBean id="registration" class="beans.Registration" scope="session" />
                            <jsp:setProperty name="registration" property="studentId" value="${sessionScope['username']}" />
                            <c:forEach var="course" items="${registration.registeredCourses}">
                                    <tr>
                                        <c:url value="CourseDetail" var="url">
                                            <c:param name="courseNumber" value="${course.courseNumber}" />
                                            <c:param name="sectionId" value="${course.sectionId}" />
                                        </c:url>
                                        <td><a href="${url}">${course.courseNumber}</a></td>
                                        <td>${course.sectionId}</td>
                                        <td>${course.title}</td>
                                        <td>${course.term}</td>
                                    </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br />
                    <p />
                    <form action="CourseDetail" method="post">
                        <table align="center">
                            <tr>
                                <td>Course ID</td>
                                <td>Section ID</td>
                                <td>Action</td>
                            </tr>
                            <tr>
                                <td><input size="15px" type="text" name="courseId"></td>
                                <td><input size="15px" type="text" name="sectionId"></td>
                                <td>
                                    <select name="action">
                                        <option value="add">Add</option>
                                        <option value="drop">Drop</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <br />
                        <div align="center">
                            <input type="submit" value="Process" />
                        </div>
                    </form>
                    <br/>
                    <c:if test="${sessionScope['AddDropMsg'] != null}">
                        <div class="greyBox">
                            <b>${sessionScope['AddDropMsg']}</b>
                        </div>
                        <c:remove var="AddDropMsg" scope="session" />
                    </c:if>
                <br/>
                <br/>
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
