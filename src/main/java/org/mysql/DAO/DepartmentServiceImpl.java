package org.mysql.DAO;

import org.mysql.models.Department;
import org.mysql.mysqlconnection.Sqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DepartmentServiceImpl {
    public static List<Department> getListOfDepartment() {
        List<Department> departmentList = new ArrayList<>();
        Connection connection = Sqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
            while(resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, EmployeeD
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");

                departmentList.add(new Department(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departmentList;
    }

    public void createDepartment(Department department) throws SQLException {
        //TDOO
        Connection connection = Sqlconnection.getConnection();
        try {
            String sql = "INSERT INTO  department(id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new department was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void deleteDepartment(Department department) {
        try {
            String sql = "DELETE FROM department WHERE name=?";
            Connection connection = Sqlconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department.getName() );

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An department was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void UpdateDepartment(Department department) {
        Connection connection = Sqlconnection.getConnection();
        try {
            String sql = "UPDATE department SET id=?, name=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }
