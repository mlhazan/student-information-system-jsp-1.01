package servlets;

import beans.DBQuery;
import beans.PersonalInfo;
import beans.Student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditInfo extends HttpServlet {

     DBQuery db = new DBQuery();
     String message = null;

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          HttpSession session = request.getSession();
          String userID = (String) session.getAttribute("username");
          String form = request.getParameter("edit");
          String street = request.getParameter("STREET_ADDRESS");
          String city = request.getParameter("CITY");
          String province = request.getParameter("PROVINCE_STATE");
          String postalCode = request.getParameter("POSTAL_CODE");
          String country = request.getParameter("COUNTRY");
          String phoneNo = request.getParameter("PHONE_NUMBER");
          String email = request.getParameter("EMAIL");
          try {
               out.println("<html>");
               out.println("<head>");
               out.println("<title>MySIS WEB</title>");
               out.println("</head>");
               out.println("<body>");

               if (request.getMethod().equals("POST")) {
                    if (form != null) {
                         //Check if Student info is not inserted into the DB yet
                         if (!db.getStudentInfoExistence(userID)) {
                              //Create the student info in the STUDENT_INFO table
                              message = db.doCreateInfo(userID, street, city, province,
                                      postalCode, country, phoneNo, email);
                         } else {
                              message = db.getEdit(userID, street, city, province, postalCode, country, phoneNo, email);
                         }
                         Student student = db.getStudent(userID);
                         PersonalInfo studentAddress = db.getAddress(userID);
                         session.setAttribute("studentAddress", studentAddress);
                         session.setAttribute("student", student);
                         session.setAttribute("editInfoMsg", message);
                         RequestDispatcher rd = getServletContext().getRequestDispatcher("/personal.jsp");
                         rd.include(request, response);
                    }

                    /* out.println("<table style=\"height: 50px;width:500px;border:0px;background:#bdaf80\">");
                out.println("");
                out.println("<textarea rows=\"10\" cols=\"500\" style=\"width:500px;height:50px;background-color:#DBE6E0\"/>");
                out.println(message);
                out.println("</textarea>");
                out.println("</table>");
        }
             out.println("</body>");
             out.println("</html>");
                     */
               }
          } catch (Exception e) {
               e.printStackTrace();
          }
     }

     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     /**
      * Handles the HTTP <code>GET</code> method.
      *
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
      *
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
      *
      * @return a String containing servlet description
      */
     @Override
     public String getServletInfo() {
          return "Short description";
     }// </editor-fold>

}
