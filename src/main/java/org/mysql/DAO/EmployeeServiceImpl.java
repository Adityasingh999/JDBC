package org.mysql.DAO;
import org.mysql.models.*;
import org.mysql.mysqlconnection.Sqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class EmployeeServiceImpl {

    public static List<Employee> getListOfEmployees() {
        List<Employee> EmployeeList = new ArrayList<>();
        Connection connection = Sqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while(resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, EmployeeD
                int empId= resultSet.getInt("empid");
                String empName = resultSet.getString("empname");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                EmployeeList.add(new Employee(empId, empName, age, address));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return EmployeeList;
    }

    public void createEmployee(Employee employee) throws SQLException {
        //TDOO
        Connection connection = Sqlconnection.getConnection();
        try {
            String sql = "INSERT INTO  employee(empid, empname,age,address) VALUES (?, ?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getEmpId());
            statement.setString(2, employee.getEmpName());
            statement.setInt(3, employee.getAge());
            statement.setString(4, employee.getAddress());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

        public void deleteEmployee(int empId) {
            try {
                String sql = "DELETE FROM employee WHERE empid=?";
                Connection connection = Sqlconnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, empId);

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("An Employee was deleted successfully!");
                }
            } catch (SQLException e) {
                //TODO
                e.printStackTrace();
            }
        }
        public void UpdateEmployee(int empId,String empName,int age,String address){
        Connection connection = Sqlconnection.getConnection();
        Employee employee=new Employee();
        try {
            String sql = "UPDATE employee SET empname=?,age=?,address=? WHERE empid=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,empId );
            statement.setString(2,empName);
            statement.setInt(3, age);
            statement.setString(4, address);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }




    }


}
