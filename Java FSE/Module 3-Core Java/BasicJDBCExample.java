import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCExample {

    public static void main(String[] args) {
        // Database credentials and URL
        String url = "jdbc:mysql://localhost:3306/school";  // MySQL URL format
        String user = "root";  // replace with your MySQL username
        String password = "your_password";  // replace with your MySQL password

        // JDBC variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load the JDBC driver (optional for newer Java versions but good tradition)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Create a connection to the DB
            conn = DriverManager.getConnection(url, user, password);

            // 3. Create a statement object to execute query
            stmt = conn.createStatement();

            // 4. Write the SQL query
            String sql = "SELECT id, name, age FROM students";

            // 5. Execute query and get result set
            rs = stmt.executeQuery(sql);

            // 6. Process the results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7. Close resources in reverse order (best practice)
            try { if (rs != null) rs.close(); } catch (Exception e) { /* ignore */ }
            try { if (stmt != null) stmt.close(); } catch (Exception e) { /* ignore */ }
            try { if (conn != null) conn.close(); } catch (Exception e) { /* ignore */ }
        }
    }
}
