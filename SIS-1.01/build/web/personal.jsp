

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<div id="container">
    <div id="header">

        <jsp:include page="WEB-INF/jspf/header.jspf" flush="false"/>


    </div>

    <div id="font1">
        <%
             String ID = (String) session.getAttribute("username");
             out.println("Student ID : " + "<a href='account.jsp'>" + ID + "</a>");
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
    <div align="center">
        Student Personal Info
    </div>

    <br/>
    <table width="30%" border="0"cellspacing="2"cellpadding="2">

        <tr> <b>Student ID:</b>${sessionScope.student.id}</tr><br/>
        <tr><b>First Name:</b> ${sessionScope.student.firstName}</tr><br/>
        <tr> <b>Last Name: </b>${sessionScope.student.lastName}</tr><br/>
    </table>
    <br/>

    <h2>Contact info</h2>
    <table width="30%" border="0"cellspacing="2"cellpadding="2">
        <tr><b>Email:</b>${sessionScope.studentAddress.email}<br/>
        <tr><b>Phone:</b> ${sessionScope.studentAddress.phoneNo}<br/>
        <tr><b>Address: </b>

        <tr><td>${sessionScope.studentAddress.street}</td></tr>
        <tr><td>${sessionScope.studentAddress.city}</td></tr>
        <tr><td>${sessionScope.studentAddress.province}
                ${sessionScope.studentAddress.postalCode}</td></tr>
        <tr><td>${sessionScope.studentAddress.country}</td></tr>
        <tr><td><form action="editinfo.jsp" method="POST">
                    <input type="submit" name="edit" value="Edit" />
                </form>
            </td></tr><br/><br/>
    </table>

    <c:if test="${sessionScope['editInfoMsg'] != null}">
        <div class="greyBox">
            <b>${sessionScope['editInfoMsg']}</b>
        </div>
        <c:remove var="editInfoMsg" scope="session" />
    </c:if>


    <div id="footer">
        <jsp:include page="WEB-INF/jspf/footer.jspf" flush="false"/>

    </div>
</div>




</body>
</html>