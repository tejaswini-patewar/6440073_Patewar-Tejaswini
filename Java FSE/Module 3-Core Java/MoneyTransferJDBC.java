import java.sql.*;

public class MoneyTransferJDBC {

    // Transfer method
    public static void transferMoney(Connection conn, int fromAcc, int toAcc, double amount) throws SQLException {
        try {
            conn.setAutoCommit(false); // Start transaction

            // Debit from source account
            PreparedStatement debitStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE acc_no = ? AND balance >= ?");
            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAcc);
            debitStmt.setDouble(3, amount);
            int debitRows = debitStmt.executeUpdate();

            // Credit to destination account
            PreparedStatement creditStmt = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE acc_no = ?");
            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAcc);
            int creditRows = creditStmt.executeUpdate();

            // Check if both operations succeeded
            if (debitRows == 1 && creditRows == 1) {
                conn.commit();
                System.out.println("✅ Transfer successful!");
            } else {
                conn.rollback();
                System.out.println("❌ Transfer failed. Rolled back.");
            }

        } catch (SQLException e) {
            conn.rollback();
            System.out.println("⚠️ Error occurred. Transaction rolled back.");
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true); // Reset
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/accounts";
        String user = "root";
        String password = ""; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Perform a sample transfer
            transferMoney(conn, 101, 102, 500.00);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
