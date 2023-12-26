package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.Order;
import com.spynu.newrestapi.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Api(tags = "Заказы")
public class OrderController {

    private final OrderService orderService;

    @ApiOperation(value = "Показать список заказов")
    @GetMapping("/showOrderList")
    public List<Order> showOrderList() {
        return orderService.getAllOrders();
    }

    @ApiOperation(value = "Показать форму создания заказа")
    @GetMapping("/showCreateForm")
    public Order showCreateForm() {
        return new Order();
    }

    @ApiOperation(value = "Создать заказ")
    @PostMapping("/createOrder")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        orderService.createNewOrder(order);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Показать форму редактирования заказа")
    @GetMapping("/{id}/showEditForm")
    public Order showEditForm(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @ApiOperation(value = "Редактировать заказ")
    @PostMapping("/{id}/update")
    public ResponseEntity<?> updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Удалить заказ")
    @PostMapping("/{id}/delete")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
