package edu.hillel.springmvc.controller;

import edu.hillel.springmvc.model.Order;
import edu.hillel.springmvc.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getAllOrders")
    public Map<Integer, Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @GetMapping("/getOrderById")
    public Order getOrderById(@RequestParam int id) {
        return orderRepository.getOrderById(id);
    }

    @PostMapping("/addOrder")
    public void addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
    }

}
