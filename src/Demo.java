import javax.xml.transform.Result;
import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/students";
        String user = "postgres";
        String password = "user";
        String query = "SELECT * FROM student";
        String inserQuery = "INSERT INTO student VALUES(4, 'Rahul')";
        String updateQuery = "UPDATE student SET sname = 'Raj' WHERE sid = 4";
        String deleteQuery = "DELETE FROM student WHERE sid = 4";
        Connection conn = null;

        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established");

        // Do something with the connection
        Statement stmt = conn.createStatement();
//        stmt.executeUpdate(inserQuery);
        stmt.executeUpdate(updateQuery);
        stmt.executeUpdate(deleteQuery);
        ResultSet rs = stmt.executeQuery(query);
//        System.out.println(rs.next());
//        System.out.println("Name is "+rs.getString("sname"));
        while(rs.next()){
            System.out.println("ID: "+rs.getInt("sid")+" Name: "+rs.getString("sname"));
        }
        conn.close();
        System.out.println("Connection closed");



    }
}
