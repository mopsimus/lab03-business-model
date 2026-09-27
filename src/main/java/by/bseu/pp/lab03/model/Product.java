package by.bseu.pp.lab03.model;

/**
 * Represents a product sold by the enterprise.
 */
public class Product {
    private final String code;
    private String name;
    private double price;

    public Product(String code, String name, double price) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }

        if (price < 0) {
            throw new IllegalArgumentException();
        }

        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void rename(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException();
        }

        this.name = newName;
    }

    public void changePrice(double newPrice) {
        if (newPrice < 0) {
            throw new IllegalArgumentException();
        }

        this.price = newPrice;
    }

    public double calculateAmount(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }

        return price * quantity;
    }
}
