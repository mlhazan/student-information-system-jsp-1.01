
package beans;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.sql.SQLException;
import java.util.Calendar;



public class DBService {
     //private static String driver = "com.mysql.jdbc.Driver";
     private static String user = "mysisuser";
     private static String pwd="mysis";
     //private static String url="jdbc:mysql://localhost:3306/mysis";
     private static String driver="org.apache.derby.jdbc.ClientDriver";
     private static String url="jdbc:derby://localhost:1527/mysis";
     Connection con;

     public DBService()throws SQLException, Exception{

        Class.forName(driver);
        this.con = DriverManager.getConnection(url, user, pwd);
     }

     public String doAddCourse (String COURSE_NUMBER ,String TITLE ,int SECTION_ID ,String TERM ,
             double CREDIT ,String DESCRIPTION,String INSTRUCTOR,String BUILDING,String ROOM,String PREREQUISITES,
             String DAYS,Date START_TIME,Date END_TIME,Date EXAM)throws SQLException{

        Integer pk;
        
        StringBuilder buf = new StringBuilder();

        try {
            String insertSql = "INSERT INTO MYSISUSER.COURSES (ID , COURSE_NUMBER , TITLE , SECTION_ID , TERM ,CREDIT,"
                    + "DESCRIPTION,INSTRUCTOR,BUILDING,ROOM,PREREQUISITES, DAYS, START_TIME,END_TIME,EXAM) VALUES (?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?,?,?)";

            String queryMaxKey = "select MAX(ID) from MYSISUSER.COURSES";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryMaxKey);
            int maxKey=0;

            while (rs.next()) {
                //MySQL Code
                // maxKey = rs.getInt("MAX(ID)");
                //Java DB
                maxKey = rs.getInt("1");
            }
            pk = ++maxKey;
            PreparedStatement pstmt = con.prepareStatement(insertSql);
            pstmt.setInt(1, pk);
            pstmt.setString(2,COURSE_NUMBER);
            pstmt.setString(3, TITLE);
            pstmt.setInt(4,SECTION_ID);
            pstmt.setString(5,TERM);
            pstmt.setDouble(6, CREDIT);
            pstmt.setString(7,DESCRIPTION);
            pstmt.setString(8,INSTRUCTOR);
            pstmt.setString(9,BUILDING);
            pstmt.setString(10,ROOM);
            pstmt.setString(11,PREREQUISITES);
            pstmt.setString(12,DAYS);
            //Convert String to a time object
            Time startTime = new Time(START_TIME.getTime());
            pstmt.setTime(13, startTime);
            //Convert String to a time object
            Time endTime = new Time(END_TIME.getTime());
            pstmt.setTime(14, endTime);
            //Convert String to DateTime object
            Timestamp examTimeStamp = new Timestamp(EXAM.getTime());

            pstmt.setTimestamp(15, examTimeStamp);
            
            if (pstmt.executeUpdate() > 0) {
                buf.append("Course added Successfully");
            } else {
                buf.append("Insertion of Course failed.");
            }
        } catch (Exception e) {
            buf.append(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
        }

        return buf.toString();

     }
     public ResultSet doExecuteSQL(String sqlStatement)throws SQLException{
         //Runs the query and returns a resultset
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sqlStatement);
         return rs;
     }

    public int updateSQL(String sql) throws SQLException {
        Statement s = con.createStatement();
        int r = s.executeUpdate(sql);
        return (r == 0) ? 0 : r;
    }

    public int execSQLFunction(String sql) throws SQLException {
        /*Used when executing sql functions like max() or count()*/
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery(sql);
        r.next();
        int value = r.getInt(1);

        return value;
    }

     
     public static void main(String[] args) throws ParseException,Exception,SQLException{
        DBService sb = new DBService();
        Date startTime,endTime,exam;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat tf = new SimpleDateFormat("HH:mm:ss");
        startTime = tf.parse("13:00:00");
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        cal.add(Calendar.MINUTE, 30);
        Date dateNewDate = cal.getTime();
        String newdate = tf.format(cal.getTime());

        endTime = tf.parse("14:20:00");
        exam = df.parse("2011/04/13 15:00:00");
        System.out.println(sb.doAddCourse("0360254","Data Structures & Algorithms",1,"2011 Winter",3.00,
                "An introduction to the programming and time-complexity analysis of internal (main store) and external data structures.",
                "Mukhopadhyay, A.","BB","113","0360100, 0360141","TR",startTime,endTime,exam));
    }
}
