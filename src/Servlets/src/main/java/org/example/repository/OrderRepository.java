package org.example.repository;

import org.example.models.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    public static Map<Integer, Order> ORDERS = new HashMap<>();
}
