package com.aasim.SpringEcom.controller;

import com.aasim.SpringEcom.service.OrderService;
import com.aasim.SpringEcom.model.dto.OrderRequest;
import com.aasim.SpringEcom.model.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    ///api/orders/place`

    @PostMapping("/orders/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse orderResponse = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrders(){
     List<OrderResponse> responses = orderService.getAllOrder();
     return new ResponseEntity<>(responses,HttpStatus.OK);
    }

}
