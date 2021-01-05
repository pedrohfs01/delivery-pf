package com.pedrofernandes.deliverypf.controllers;

import com.pedrofernandes.deliverypf.entities.dto.OrderDTO;
import com.pedrofernandes.deliverypf.entities.dto.ProductDTO;
import com.pedrofernandes.deliverypf.service.OrderService;
import com.pedrofernandes.deliverypf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
