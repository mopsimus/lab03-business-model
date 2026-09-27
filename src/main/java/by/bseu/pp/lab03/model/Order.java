package by.bseu.pp.lab03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order and protects the allowed order state transitions.
 */
public class Order {
    private final Customer customer;
    private final List<OrderItem> items;
    private OrderStatus status;
    private Payment payment;

    public Order(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException();
        }
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getItemsCount() {
        return items.size();
    }

    public Payment getPayment() {
        return payment;
    }

    public void addItem(Product product, int quantity) {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException();
        }

        items.add(new OrderItem(product, quantity));
    }

    public double total() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getAmount();
        }

        return total;
    }

    public void confirm() {
        if (status != OrderStatus.CREATED) {
            throw new IllegalStateException();
        }

        if (items.isEmpty()) {
            throw new IllegalStateException();
        }

        if (!customer.isActive()) {
            throw new IllegalStateException();
        }

        if (!customer.canPlaceOrder(total())) {
            throw new IllegalStateException();
        }

        status = OrderStatus.CONFIRMED;
    }

    public void cancel() {
        if (status != OrderStatus.CREATED
                && status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException();
        }

        status = OrderStatus.CANCELLED;
    }

    public void pay(Payment payment) {
        if (status != OrderStatus.CONFIRMED) {
            throw new IllegalStateException();
        }

        if (payment == null) {
            throw new IllegalArgumentException();
        }

        if (!payment.isSuccessful()) {
            throw new IllegalStateException();
        }

        if (Double.compare(payment.getAmount(), total()) != 0) {
            throw new IllegalArgumentException();
        }

        this.payment = payment;
        this.status = OrderStatus.PAID;
    }

    public boolean isPaid() {
        return status == OrderStatus.PAID;
    }
}
