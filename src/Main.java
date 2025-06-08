/**
 * Project:
 * Purpose Details:
 * Course:
 * Author: Idrees Ahmad
 * Date Developed:
 * Last Date Changed:
 * Revision:
 */

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MySQLHandler mysql = new MySQLHandler();
        MongoHandler mongo = new MongoHandler();

        Customer c1 = new Customer(1, "Alice Smith", "alice@example.com", 100);
        Customer c2 = new Customer(2, "Bob Johnson", "bob@example.com", 200);
        Customer c3 = new Customer(3, "Charlie Brown", "charlie@example.com", 300);

        // Create customers in both DBs
        mysql.createCustomer(c1);
        mysql.createCustomer(c2);
        mysql.createCustomer(c3);

        mongo.createCustomer(c1);
        mongo.createCustomer(c2);
        mongo.createCustomer(c3);

        // Read customers from MySQL
        System.out.println("MySQL Customers:");
        List<Customer> mysqlCustomers = mysql.readCustomers();
        mysqlCustomers.forEach(System.out::println);

        // Read customers from MongoDB
        System.out.println("\nMongoDB Customers:");
        List<Customer> mongoCustomers = mongo.readCustomers();
        mongoCustomers.forEach(System.out::println);

        // Update a customer and show updated list
        c1.setLoyaltyPoints(150);
        mysql.updateCustomer(c1);
        mongo.updateCustomer(c1);

        System.out.println("\nAfter update:");
        mysql.readCustomers().forEach(System.out::println);
        mongo.readCustomers().forEach(System.out::println);

        // Delete a customer
        mysql.deleteCustomer(c2.getCustomerId());
        mongo.deleteCustomer(c2.getCustomerId());

        System.out.println("\nAfter delete:");
        mysql.readCustomers().forEach(System.out::println);
        mongo.readCustomers().forEach(System.out::println);
    }
}
