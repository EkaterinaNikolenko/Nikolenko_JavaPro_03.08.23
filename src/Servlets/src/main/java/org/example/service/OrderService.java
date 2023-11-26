package org.example.service;

import org.example.models.Order;
import org.example.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {
    public Map<Integer, Order> getAccounts() {
        return OrderRepository.ORDERS;
    }

    public Order getOrderById(int id) {
        final Order account = OrderRepository.ORDERS.get(id);
        if (account==null){
            throw new RuntimeException("Account not found by id - "+id);
        }
        return account;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(OrderRepository.ORDERS.values());
    }

    public Order addOrder(Order account) {
        return OrderRepository.ORDERS.put(account.getId(), account);
    }
}
