package edu.hillel.springdata.dao;

import edu.hillel.springdata.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
