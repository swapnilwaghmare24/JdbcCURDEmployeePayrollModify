import java.sql.*;

public class UpdateData {
    public static void main(String[] args)  {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
            System.out.println("connected to sql server successfully");
            PreparedStatement stmt=connection.prepareStatement("update employee_payroll set salary=50000 where name='Rakesh'");
            stmt.executeUpdate();
            System.out.println("Data updated");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
