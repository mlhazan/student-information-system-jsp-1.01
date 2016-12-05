

package beans;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;


public class Registration {
    private String studentId;
    private String courseNumber;
    private int sectionId;

    public Registration() {
    }
    
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    

    public List<CoursesBean> getRegisteredCourses() {
         List<CoursesBean> courses = new ArrayList<CoursesBean>();


         String query = "select MYSISUSER.COURSES.* FROM MYSISUSER.COURSES,MYSISUSER.REGISTRATION WHERE"
         + " STUDENT_ID='"+studentId+"' AND "
                 + "MYSISUSER.COURSES.COURSE_NUMBER=MYSISUSER.REGISTRATION.COURSE_NUMBER";
         try{
             DBService dbs = new DBService();
             ResultSet rs = dbs.doExecuteSQL(query);
             while (rs.next()){
                courses.add(new CoursesBean(rs.getString(1),rs.getString(2),rs.getInt(3),
                     rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),
                     rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                     rs.getTime(12),rs.getTime(13),rs.getTimestamp(14)));
             }
         }catch (Exception e) {
                 e.printStackTrace();
         }
         return courses;
    }

    public String doDropCourse(String studentId,String courseId){
        StringBuilder buf = new StringBuilder();

        String sqlStatement = "DELETE FROM MYSISUSER.REGISTRATION WHERE STUDENT_ID='"+
                studentId+"' AND COURSE_NUMBER='"+courseId+"'";
        try{
            DBService dbs = new DBService();
            int count = dbs.updateSQL(sqlStatement);
            if (count > 0) {
                buf.append("Course Dropped Successfully");
            } else {
                buf.append("Course Drop failed");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return buf.toString();

    }

    public String doAddCourse(String studentId,String courseId,int sectionId){
        StringBuilder buf = new StringBuilder();

        try{
            DBService dbs = new DBService();
            String sqlStatement = "SELECT MYSISUSER.COURSES.* FROM MYSISUSER.COURSES "
                    + "WHERE COURSE_NUMBER='"+courseId+"' AND SECTION_ID="+sectionId;
            ResultSet rs = dbs.doExecuteSQL(sqlStatement);
            if(!rs.next()){
               buf.append("The Course Number or Section Id is not correct. Please"
                       + "try again.");
            }
            else{
                sqlStatement = "SELECT COURSE_NUMBER FROM MYSISUSER.REGISTRATION"
                        + " WHERE STUDENT_ID='"+studentId+"' AND COURSE_NUMBER='"+
                        courseId+"'";
                rs = dbs.doExecuteSQL(sqlStatement);
                if(rs.next()){
                   buf.append("You are already registered in this course!");
                }
                else{
                    sqlStatement = "SELECT COUNT(*) FROM MYSISUSER.REGISTRATION "
                            + "WHERE STUDENT_ID='"+studentId+"'";

                    int totalCourseCount = dbs.execSQLFunction(sqlStatement);

                    if (totalCourseCount == 5 ){
                        buf.append("You can not register more than 5 courses!");
                    }
                    else{

                        sqlStatement = "INSERT INTO MYSISUSER.REGISTRATION (STUDENT_ID,"
                                + " COURSE_NUMBER, SECTION_ID) VALUES (?,?,?)";

                        PreparedStatement pstmt = dbs.con.prepareStatement(sqlStatement);
                        pstmt.setString(1, studentId);
                        pstmt.setString(2, courseId);
                        pstmt.setInt(3, sectionId);

                        if (pstmt.executeUpdate() > 0) {
                            buf.append("Course Registered Successfully");
                        } else {
                            buf.append("Course Registration failed");
                        }

                    }
                }
                
            }
        }catch (Exception e){
            buf.append(e);
        }
        return buf.toString();
    }

    

}
