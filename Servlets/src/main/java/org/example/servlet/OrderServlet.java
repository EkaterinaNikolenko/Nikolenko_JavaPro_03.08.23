package org.example.servlet;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.Order;
import org.example.service.OrderService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet")
public class OrderServlet extends HttpServlet {
    private final OrderService orderService = new OrderService();
    private final Gson gson = new Gson();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET");
        try(PrintWriter writer = resp.getWriter()) {
            final String id = req.getParameter("id");
            if (id == null) {
                System.out.println(orderService.getAllOrders());
                writer.println(gson.toJson(orderService.getAllOrders()));
            } else {
                try {
                    System.out.println(orderService.getOrderById(Integer.parseInt(id)));
                    writer.println(gson.toJson(orderService.getOrderById(Integer.parseInt(id))));
                    writer.println(orderService.getOrderById(Integer.parseInt(id)));
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    resp.setStatus(404);
                    writer.println("Account not found!");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST");
        final Order order = gson.fromJson(req.getReader(), Order.class);
        orderService.addOrder(order);
        System.out.println(order);
    }
}
