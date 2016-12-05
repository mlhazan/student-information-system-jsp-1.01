

<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
            <div id="content-container">
                <div id="section-navigation">
                        <jsp:include page="WEB-INF/jspf/leftpanel.jspf" flush="false"/>
                </div>
                <div id="content">
                    <h2>
                        Login info
                    </h2>
                    <form method="POST" action="LoginForm" onsubmit="return canLogin(this)">
                        <fieldset>
                            Student ID: <input type="text" name="id" size="15" /><br />
                            Password: <input type="password" name="password" size="15" />
                            <br /><br /><br />
                            <input type="submit" value="Login" />
                            <div class="greyBox"
                                <jsp:include page="WEB-INF/jspf/accessDenied.jspf" flush="false"/>
                            </div>
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
        </div>
    </body>
</html>