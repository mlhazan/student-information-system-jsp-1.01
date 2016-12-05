

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<html>
    <head>
        <link href="css/style2.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Details</title>
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
                <div id="rightPanel">
			<div class ="greyBox">

			<jsp:include page="WEB-INF/jspf/rightpanel.jspf" flush="false"/>

                    </div>
		</div>
                <div id="content">
                    <p></p>
                    <div align="center">
                    <h3><b>Details of a Course Section</b></h3>
                    <jsp:useBean id="course" class="beans.CoursesBean" scope="session" />
                    <jsp:setProperty name="course" property="*" />
                    <table align="right" border="1px" width="90%">
                        <tr>
                            <td width="20%" id="td">Course Number</td>
                            <td width=70%>${course.courseNumber}</td>
                        </tr>
                        <tr>
                            <td width="20%" id="td">Section</td>
                            <td width=70%>${course.sectionId}</td>
                        </tr>
                        <tr>
                            <td width="20%" id="td">Title</td>
                            <td width=70%>${course.title}</td>
                        </tr>
                        <tr>
                            <td width="20%" id="td">Term</td>
                            <td width=70%>${course.term}</td>
                        </tr>
                        <tr>
                            <td width="20%" id="td">Description</td>
                            <td width=70%>${course.description}</td>
                        </tr>
                    </table>
                    <br/><br/><br/><br/>
                    <br/><br/><br/>
                    <br/><br/>
                    <b>Meeting Times</b>

                    <table align="right"border="1px" width="90%">
                        <tr id="tr">
                            <td width=20% >Days</td>
                            <td width=20% >Start Time</td>
                            <td width=20% >Stop Time</td>
                            <td width=20% >Building</td>
                            <td width=20% >Room</td>
                        </tr>
                        <tr>
                            <td width="20%">${course.days}</td>
                            <td width="20%">${course.startTime}</td>
                            <td width="20%">${course.endTime}</td>
                            <td width="20%">${course.building}</td>
                            <td width="20%">${course.room}</td>
                        </tr>
                    </table>

                    <p/><br/><br/><br/>
                    <b>Instructor(s)</b>
                    <table align="right"border="1px" width=90%>
                        <tr>
                            <td width=100%>${course.instructor}</td>
                        </tr>
                    </table>

                    <p/><br/><br/>
                    <b>Exam Details</b>
                    <table align="right"border="1px" width=90%>
                        <tr id="tr">
                            <td width=10%>Type</td>
                            <td width=10%>Day of Week</td>
                            <td width=8%>Date</td>
                            <td width=5%>Time</td>
                        </tr>
                        <tr>
                            <td width=10%>Final</td>
                            <td width=10%><fmt:formatDate value="${course.exam}" pattern="EEEEEEEEE" /></td>
                            <td width=10%><fmt:formatDate value="${course.exam}" pattern="MMMM dd" /></td>
                            <td width=10%><fmt:formatDate value="${course.exam}" pattern="HH:mm" /></td>
                        </tr>

                    </table>

                    <c:if test="${course.prerequisites != ''}">
                        <p/>
                        <br/><br/><br/><br/>
                        <b>Pre-Requisites</b>
                        <p id="p90">
                        You cannot register in this course unless you have taken the following pre-requisite courses.
                        </p>
                        <table align="right" border="1px" width=90%>
                            <tr>
                                <td width=100%>Course(s) needed from: ${course.prerequisites}</td>
                            </tr>
                        </table>
                    </c:if>
                    </div>
                </div>
            

       
		<div id="footer">
			<jsp:include page="WEB-INF/jspf/footer.jspf" flush="false"/>
		</div>
        </div>



    </body>
</html>
