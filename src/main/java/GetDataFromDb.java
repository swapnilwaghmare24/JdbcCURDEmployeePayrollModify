import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromDb {
    private static List<EmployeeData> employeeDataList = new ArrayList<>();

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll_service? user=root & password=root");
            System.out.println("connected to sql server successfully");
            PreparedStatement stmt=connection.prepareStatement("select * from employee_payroll");
            ResultSet resultset=stmt.executeQuery();
            while(resultset.next()){
                int id=resultset.getInt("id");
                String name=resultset.getString("name");
                double salary=resultset.getDouble("salary");
                employeeDataList.add(new EmployeeData(id,name,salary));
            }
            System.out.println(employeeDataList);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
