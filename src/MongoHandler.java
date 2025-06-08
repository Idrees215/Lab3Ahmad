/**
 * Project:
 * Purpose Details:
 * Course:
 * Author: Idrees Ahmad
 * Date Developed:
 * Last Date Changed:
 * Revision:
 */

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoHandler {
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;

    public MongoHandler() {
        client = MongoClients.create("mongodb://localhost:27017");
        database = client.getDatabase("lab3");
        collection = database.getCollection("Customer");
    }

    public void createCustomer(Customer c) {
        Document doc = new Document("customerId", c.getCustomerId())
                .append("fullName", c.getFullName())
                .append("email", c.getEmail())
                .append("loyaltyPoints", c.getLoyaltyPoints());
        collection.insertOne(doc);
    }

    public List<Customer> readCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (Document doc : collection.find()) {
            customers.add(new Customer(
                    doc.getInteger("customerId", 0),
                    doc.getString("fullName"),
                    doc.getString("email"),
                    doc.getInteger("loyaltyPoints", 0)
            ));
        }
        return customers;
    }

    public void updateCustomer(Customer c) {
        collection.updateOne(
                Filters.eq("customerId", c.getCustomerId()),
                new Document("$set", new Document("fullName", c.getFullName())
                        .append("email", c.getEmail())
                        .append("loyaltyPoints", c.getLoyaltyPoints()))
        );
    }

    public void deleteCustomer(int customerId) {
        collection.deleteOne(Filters.eq("customerId", customerId));
    }
}
