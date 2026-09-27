package by.bseu.pp.lab03.model;

/**
 * One line of an order: a product and its quantity.
 */
public class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException();
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return product.calculateAmount(quantity);
    }
}
