import java.sql.*;

public class DBlogic {

    public void addUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try ( Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User added successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getUsers() {
        String sql = "SELECT * FROM users";

        try ( Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql);
              ResultSet rs = pstmt.executeQuery()
        ) {

            while (rs.next()) {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("username:" + rs.getString("username"));
                System.out.println("password:" + rs.getString("password"));
                System.out.println("------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsers(int user_id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try ( Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, user_id);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User deleted successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUsers(String password, int user_id) {
            String sql = "UPDATE users SET password = ? WHERE id = ?";

        try ( Connection conn = DatabaseConnection.getConnection();
              PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, password);
            pstmt.setInt(2, user_id);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User change password successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
