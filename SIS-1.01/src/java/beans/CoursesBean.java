

package beans;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adri
 */
@ManagedBean
@RequestScoped
public class CoursesBean {
    private String courseNumber;
    private String title;
    private int sectionId;
    private String term;
    private double credit;
    private String description;
    private String instructor;
    private String building;
    private String room;
    private String prerequisites;
    private String days;
    private Date startTime;
    private Date endTime;
    private Date exam;
    DBService dbs;
    /** Creates a new instance of CoursesBean */
    public CoursesBean() {
        //Initializing the Database Service Bean Class
        try{
            dbs = new DBService();
        }catch (SQLException ex){
            System.err.println("SQLException: " + ex.getMessage());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    public CoursesBean(String courseNumber,String title,int sectionId,String term,
            double credit,String description,String instructor,String building,
            String room,String prerequisites,String days,Date startTime,Date endTime,
            Date exam){

        this.courseNumber = courseNumber;
        this.title = title;
        this.sectionId = sectionId;
        this.term = term;
        this.credit = credit;
        this.description = description;
        this.instructor = instructor;
        this.building = building;
        this.room = room;
        this.prerequisites = prerequisites;
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
        this.exam = exam;

    }
    
    public List<CoursesBean> getAllCourses()throws SQLException{
        
         List<CoursesBean> courses = new ArrayList<CoursesBean>();
         String query = "select * from MYSISUSER.COURSES WHERE COURSE_NUMBER NOT "
                 + "IN (SELECT COURSE_NUMBER FROM MYSISUSER.REGISTRATION) ";
         
         ResultSet rs = dbs.doExecuteSQL(query);
         
         while (rs.next()){
             try{
                 courses.add(new CoursesBean(rs.getString(1),rs.getString(2),rs.getInt(3),
                         rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getString(7),
                         rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                         rs.getTime(12),rs.getTime(13),rs.getTimestamp(14)));
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
         return courses;
    }
    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    */
    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getExam() {
        return exam;
    }

    public void setExam(Date exam) {
        this.exam = exam;
    }

    public static void main(String[] args) throws Exception{
        CoursesBean c = new CoursesBean();
        List<CoursesBean> l = c.getAllCourses();
    }


}
