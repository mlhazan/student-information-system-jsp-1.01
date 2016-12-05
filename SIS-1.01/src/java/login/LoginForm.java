/**
 *
 * @author m.hasan
 * ID:102551565
 */
package login;


import beans.DBQuery;
import beans.Student;
import beans.PersonalInfo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginForm extends HttpServlet{
    String user,userName;
    String pass,password;

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
    }

    @Override
    public  void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException  {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        userName=request.getParameter("id");
        password=request.getParameter("password");
        DBQuery db = new DBQuery() ;

       
       
            try{
                boolean verify= db.authUser (userName,password);
                if(verify==true){

                HttpSession session=request.getSession();
                session.setAttribute("username",userName);


                Student student =  DBQuery.getStudent(userName) ;
                PersonalInfo studentAddress = DBQuery.getAddress(userName);
                session.setAttribute("studentAddress", studentAddress);
                session.setAttribute("student", student);
                response.sendRedirect("usermain.jsp");
                }

                else
                {
            
                    response.sendRedirect("relogin.jsp");
                }

            }
             
            catch (Exception e){
                e.printStackTrace();
            }
   
        }
      
}