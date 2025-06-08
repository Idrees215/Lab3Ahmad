/**
 * Project:
 * Purpose Details:
 * Course:
 * Author: Idrees Ahmad
 * Date Developed:
 * Last Date Changed:
 * Revision:
 */

public class Customer {
    private int customerId;
    private String fullName;
    private String email;
    private int loyaltyPoints;

    public Customer() {}

    public Customer(int customerId, String fullName, String email, int loyaltyPoints) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}


