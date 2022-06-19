import java.sql.*;

public class InsertOperation {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
            System.out.println("connected to sql server successfully");
            PreparedStatement stmt=connection.prepareStatement("INSERT INTO employee_payroll (name,salary,start ) VALUES ('Rakesh',900000,'22-05-25')");
            stmt.executeUpdate();
            System.out.println("Data inserted in Database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
