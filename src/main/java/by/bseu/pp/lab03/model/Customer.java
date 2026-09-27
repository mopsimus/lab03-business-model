package by.bseu.pp.lab03.model;

/**
 * Represents a customer of the enterprise.
 *
 * <p>Complete all TODO parts without changing the public API of the class.</p>
 */
public class Customer {
    private final String code;
    private String name;
    private boolean active;
    private double creditLimit;

    public Customer(String code, String name, double creditLimit) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (creditLimit < 0) {
            throw new IllegalArgumentException();
        }
        this.code = code;
        this.name = name;
        this.creditLimit = creditLimit;
        this.active = true;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = newName;
    }

    public void changeCreditLimit(double newCreditLimit) {
        if (newCreditLimit < 0) {
            throw new IllegalArgumentException();
        }

        this.creditLimit = newCreditLimit;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean canPlaceOrder(double orderTotal) {
        if (orderTotal < 0) {
            throw new IllegalArgumentException();
        }

        return active && orderTotal <= creditLimit;
    }
}
