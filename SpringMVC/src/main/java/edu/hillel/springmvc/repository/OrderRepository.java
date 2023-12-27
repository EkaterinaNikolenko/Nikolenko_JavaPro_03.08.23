package edu.hillel.springmvc.repository;

import edu.hillel.springmvc.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderRepository {
    public Map<Integer, Order> orders = new HashMap<>();

    public Order getOrderById(int id) {
        return orders.get(id);
    }

    public Map<Integer, Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
