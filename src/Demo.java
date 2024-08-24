import javax.xml.transform.Result;
import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/students";
        String user = "postgres";
        String password = "user";
        String query = "SELECT * FROM student ";
        String inserQuery = "INSERT INTO student VALUES(4, 'Rahul')";
        String preparedInsertQuery = "INSERT INTO student VALUES(?, ?)";
        String updateQuery = "UPDATE student SET sname = 'Raj' WHERE sid = 4";
        String preparedUpdateQuery = "UPDATE student SET sname = ? WHERE sid = ?";
        String deleteQuery = "DELETE FROM student WHERE sid = 4";
        Connection conn = null;

        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connection established");

        // Manually inserting data
        Statement stmt = conn.createStatement();
        //stmt.executeUpdate(inserQuery);

        // Using prepared statement to insert Dynamic Data
        PreparedStatement pstmt = conn.prepareStatement(preparedInsertQuery);
        int id = 125;
        String name = "Paramita";
        pstmt.setInt(1, id);
        pstmt.setString(2, name);
        pstmt.executeUpdate();

        //Manually updating and deleting data
        stmt.executeUpdate(updateQuery);
        stmt.executeUpdate(deleteQuery);

        //Dynamic update and delete
        PreparedStatement updatePreparedQuery = conn.prepareStatement(preparedUpdateQuery);
        int updateId = 3;
        String updateName = "Anonymous";
        updatePreparedQuery.setString(1, updateName);
        updatePreparedQuery.setInt(2, updateId);
        updatePreparedQuery.executeUpdate();

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
