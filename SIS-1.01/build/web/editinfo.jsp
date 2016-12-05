
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope['username']== null}" >
    <jsp:forward page="relogin.jsp" />
</c:if>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
  
<html>
    <head>
        <script type="text/javascript" src="validation.js"></script>
        <title>Personal Information</title>
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
                <br/>
                <div align="center">
                    Student Personal Info
                </div>

                <br/>

                <form name="form" method="POST" action="EditInfo" onSubmit="return isReady(this)">
                    <table width="70%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td>Email</td>
                        <td><input type="text" name="EMAIL"/></td>
                      </tr>
                      <tr>
                        <td>Street </td>
                        <td><input type="text" name="STREET_ADDRESS"/></td>
                      </tr>

                      <tr>
                        <td>City </td>
                        <td><input type="text" name="CITY" /></td>
                      </tr>

                      <tr>
                        <td>Province</td>
                        <td><input type="text" name="PROVINCE_STATE" /></td>
                      </tr>
                      <tr>
                        <td>Postal Code </td>
                        <td><input type="text" name="POSTAL_CODE" /></td>
                      </tr>

                      <tr>
                        <td>Country </td>
                        <td><input type="text" name="COUNTRY" /></td>
                      </tr>

                      <tr>
                        <td>Phone No </td>
                        <td><input type="text" name="PHONE_NUMBER" /></td>
                      </tr>

                      <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" name="edit" value="Submit">
                        </td>
                      </tr>

                      <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        </tr>
                    </table>
                </form>
            </div>

            <div id="footer">
                    <jsp:include page="WEB-INF/jspf/footer.jspf" flush="false"/>
            </div>
        </div>
    </body>
</html>