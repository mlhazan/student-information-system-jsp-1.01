
package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="LogoutServlet", urlPatterns={"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      HttpSession session=request.getSession(true);
      remonveSessionUser(session);
      String url="/logout.jsp";
       doRedirect(request,response,url);
    }

    private void remonveSessionUser(HttpSession session) {
        session.removeAttribute("username");

    }

    private void doRedirect(HttpServletRequest request, HttpServletResponse response,String url)
            throws IOException{
        String redirect=response.encodeRedirectURL(request.getContextPath()+url);
        response.sendRedirect(redirect);

    }



}
