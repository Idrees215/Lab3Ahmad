/**
 * Project:
 * Purpose Details:
 * Course:
 * Author: Idrees Ahmad
 * Date Developed:
 * Last Date Changed:
 * Revision:
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/lab3";
    private static final String USER = "root";
    private static final String PASSWORD = "IST888IST888";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void createCustomer(Customer c) {
        String sql = "INSERT INTO Customer (full_name, email, loyalty_points) VALUES (?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getFullName());
            stmt.setString(2, c.getEmail());
            stmt.setInt(3, c.getLoyaltyPoints());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT customer_id, full_name, email, loyalty_points FROM Customer";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getInt("loyalty_points")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public void updateCustomer(Customer c) {
        String sql = "UPDATE Customer SET full_name = ?, email = ?, loyalty_points = ? WHERE customer_id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getFullName());
            stmt.setString(2, c.getEmail());
            stmt.setInt(3, c.getLoyaltyPoints());
            stmt.setInt(4, c.getCustomerId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
