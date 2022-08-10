package org.mysql.DAO;

import org.mysql.models.Address;
import org.mysql.models.Employee;
import org.mysql.mysqlconnection.Sqlconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddressServiceImpl {

    public static List<Address> getListOfAddress() {
        List<Address> addressList = new ArrayList<>();
        Connection connection = Sqlconnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM address");
            while(resultSet.next()) {// points to Row ON each iteration
                //ID, NAME, AGE, EmployeeD
                int id= resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("empaddress");
                addressList.add(new Address(id, name,address));
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
        return addressList;
    }

    public void createEmployee(Address address) throws SQLException {
        //TDOO
        Connection connection = Sqlconnection.getConnection();
        try {
            String sql = "INSERT INTO  address(id, name,empaddress) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, address.getId());
            statement.setString(2, address.getName());
            statement.setString(3, address.getAddress());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new Employee address was inserted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }

    public void deleteAddress(Address address ) {
        try {
            String sql = "DELETE FROM address WHERE id=?";
            Connection connection = Sqlconnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,address.getAddress());
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("An Employee was deleted successfully!");
            }
        } catch (SQLException e) {
            //TODO
            e.printStackTrace();
        }
    }
    public void UpdateEmployee(Employee employee) {
        Connection connection = Sqlconnection.getConnection();
        try {
            String sql = "UPDATE Employees SET id=?, name=?, dept_id=? WHERE id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, employee.getEmpId());
            statement.setString(2, employee.getEmpName());
            statement.setInt(3, employee.getAge());
            statement.setString(4, employee.getAddress());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing Employee was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
