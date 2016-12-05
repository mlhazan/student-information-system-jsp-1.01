package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBQuery {

    private static Connection con;
    private final static String dbURL = "jdbc:derby://localhost:1527/mysis";
    private final static String dbDriver = "org.apache.derby.jdbc.ClientDriver";
    private final static String user = "mysisuser";
    private final static String pwd = "mysis";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL, "mysisuser", "mysis");
        }
        return con;
    }

   public static Student getStudent(String id) throws ClassNotFoundException, SQLException {
        Student s = null;
        String qry = "SELECT * from STUDENT WHERE ID = '" + id + "'";
        Connection c = getConnection();
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(qry);
        if (rs.next()) {
            s = new Student();
            s.setId(id);
            s.setLastName(rs.getString(3));
            s.setFirstName(rs.getString(4));
        }
        return s;
    }

    public static PersonalInfo getAddress(String id) throws ClassNotFoundException,SQLException {
        PersonalInfo t = null;
        String qry = "SELECT * from STUDENT_Info WHERE STUDENT_ID = '" + id + "'";
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(qry);
        if (result.next()) {
            t = new PersonalInfo();
           // s.setId(id);
            t.setStreet(result.getString(2));
            t.setPhoneNo(result.getString(3));
            t.setPostalCode(result.getString(4));
            t.setCity(result.getString(5));
            t.setProvince(result.getString(6));
            t.setCountry(result.getString(7));
            t.setEmail(result.getString(8));
        }
        return t;
    }

    public String getEdit(String id,String address,String city,String province,String postalCode,String country,String phoneNo,String email) throws ClassNotFoundException,SQLException {

        StringBuilder buf = new StringBuilder();
        Connection con = getConnection();
        Statement st = con.createStatement();
        String qry = "UPDATE STUDENT_INFO SET STREET_ADDRESS='"+address+"', CITY='"+city+"', PROVINCE_STATE='"+province+"', POSTAL_CODE='"+postalCode+"',COUNTRY='"+country+"', PHONE_NUMBER='"+phoneNo+"',EMAIL='"+email+"' WHERE STUDENT_ID='" + id + "'";
  
        int count = st.executeUpdate(qry);

            if (count > 0) {
                buf.append("Info saved Successfully");
                }
            return buf.toString();

    }
    public String doCreateInfo(String id,String address,String city,String province,
            String postalCode,String country,String phoneNo,String email) throws ClassNotFoundException,SQLException {
        StringBuilder buf = new StringBuilder();
        Connection con = getConnection();
        String insertSql = "INSERT INTO MYSISUSER.STUDENT_INFO (STUDENT_ID,"
                + "STREET_ADDRESS,CITY,PROVINCE_STATE,POSTAL_CODE,COUNTRY,PHONE_NUMBER,"
                + "EMAIL) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(insertSql);
        pstmt.setString(1,id);
        pstmt.setString(2,address);
        pstmt.setString(3,city);
        pstmt.setString(4,province);
        pstmt.setString(5,postalCode);
        pstmt.setString(6,country);
        pstmt.setString(7,phoneNo);
        pstmt.setString(8,email);
        if (pstmt.executeUpdate() > 0) {
            buf.append("Student Info added Successfully");
        } else {
            buf.append("Insertion of Student Info failed.");
        }
        return buf.toString();
    }

    public boolean getStudentInfoExistence(String STUDENT_ID)throws ClassNotFoundException,SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        String query = "SELECT * FROM MYSISUSER.STUDENT_INFO WHERE STUDENT_ID='"+
                STUDENT_ID+"'";
        ResultSet result = st.executeQuery(query);
        if (result.next()){
            return true;
        }
        return false;
    }


    public boolean authUser (String id,String password) throws ClassNotFoundException, SQLException{
        String m=null;
        String n=null;

        Connection con =getConnection();
        Statement st = con.createStatement();
        String qry = "SELECT * from STUDENT WHERE ID = '" + id + "' AND PASSWORD='"+password+"'";
        ResultSet result = st.executeQuery(qry);
        while(result.next()){
            m=result.getString(1);
            n=result.getString(2);
        }
        if (m != null && n != null && m.equals(id) && n.equals(password)){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException{
        DBQuery bd=new DBQuery();
        //boolean flag = bd.authUser("593261719", "jur");
        String message = bd.doCreateInfo("593261719","test","test","test","test",
                "test","test","test");
        //  Student st=getStudent("102510251");
        /*
        DBQuery bd=new DBQuery();
        bd.getEdit("102510251", "12 Ghost St");
        PersonalInfo s = getAddress("102510251") ;
        System.out.println(s.getEmail());
        System.out.println(s.getPhoneNo());
        System.out.println(s.getStreet());
          System.out.println(s.getCity());
          System.out.println(s.getProvince());
        System.out.println(s.getPostalCode());
      
        System.out.println(s.getCountry());
        
        //System.out.println(st.getLastName());
       // System.out.println(s.getLastName());*/
    }

}
