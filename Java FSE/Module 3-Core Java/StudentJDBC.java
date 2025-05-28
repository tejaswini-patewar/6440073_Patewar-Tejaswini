import java.sql.*;

public class StudentJDBC {

    // Student model (inner class)
    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

    // JDBC operations (DAO-style methods)
    public static void insertStudent(Connection conn, Student student) throws SQLException {
        String sql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, student.id);
        stmt.setString(2, student.name);
        stmt.setInt(3, student.age);
        int rows = stmt.executeUpdate();
        System.out.println(rows + " row(s) inserted.");
    }

    public static void updateStudent(Connection conn, Student student) throws SQLException {
        String sql = "UPDATE students SET name = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, student.name);
        stmt.setInt(2, student.age);
        stmt.setInt(3, student.id);
        int rows = stmt.executeUpdate();
        System.out.println(rows + " row(s) updated.");
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Insert a new student
            Student student1 = new Student(1, "Tejuu", 20);
            insertStudent(conn, student1);

            // Update student info
            Student updatedStudent = new Student(1, "Tejuu T", 21);
            updateStudent(conn, updatedStudent);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
