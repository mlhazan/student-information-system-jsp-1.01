/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.sql.ResultSet;
import beans.CoursesBean;
import beans.DBService;
import beans.Registration;

public class CourseDetail extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session=request.getSession();
            if (request.getMethod().equals("GET")) {
                String courseNumber = request.getParameter("courseNumber");
                int sectionId = Integer.parseInt(request.getParameter("sectionId"));

                DBService dbs = new DBService();

                String query = "select * from MYSISUSER.COURSES WHERE COURSE_NUMBER='"+
                courseNumber+"' AND SECTION_ID="+sectionId;

                ResultSet rs = dbs.doExecuteSQL(query);
                if(rs.next()){
                    CoursesBean cb = new CoursesBean(rs.getString(1),rs.getString(2),rs.getInt(3),
                     rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),
                     rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                     rs.getTime(12),rs.getTime(13),rs.getTimestamp(14));
                    
                    session.setAttribute("course", cb);
                    response.sendRedirect("courseDetail.jsp");
                }
                else{
                    out.println(request.getParameter("courseNumber"));
                    out.println(request.getParameter("sectionId"));
                    out.println("There is no course available in the database");
                }
            }
            if (request.getMethod().equals("POST")) {
                 String studentId = (String)session.getAttribute("username");
                 String courseId = request.getParameter("courseId");
                 int sectionId = Integer.parseInt(request.getParameter("sectionId"));

                 String action = request.getParameter("action");
                 String msg = null;

                 Registration r = new Registration();
                 if (action.equals("drop")){
                     msg = r.doDropCourse(studentId, courseId);
                 }
                 if (action.equals("add")){
                     msg = r.doAddCourse(studentId, courseId, sectionId);
                 }
                 session.setAttribute("AddDropMsg", msg);
                 //String nextJSP = "/registerDrop.jsp";
                 //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                 //dispatcher.forward(request,response);

                 response.sendRedirect("registerDrop.jsp");

            }
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
        finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
