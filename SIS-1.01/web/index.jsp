<%-- 
    Document   : index
    Created on : 17-Feb-2015, 2:37:29 PM
    Author     : M.Hasan
    
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <script type="text/javascript" src="validation.js"></script>
       <title>Student Information System</title>
   </head>
   <body>
        <div id="container">
            <div id="header">
                <jsp:include page="WEB-INF/jspf/header.jspf" flush="false"/>
            </div>
            <div id="navigation">
                <jsp:include page="WEB-INF/jspf/topmenu.jspf" flush="false"/>
            </div>
            <div id="section-navigation">
                <jsp:include page="WEB-INF/jspf/leftpanel.jspf" flush="false"/>
            </div>

            <div id="content">

                <h2>
                    Login info
                </h2>

                <form name="form" method="POST" action="LoginForm" onSubmit="return canLogin(this)">
                    <fieldset>
                        Student ID: <input type="text" name="id" size="15" /><br />
                        Password: <input type="password" name="password" size="15" />
                        <br/>
                        <br/>
                        <br/>
                        <input type="submit" value="Login" />
                    </fieldset>
                </form>
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