package com.pedrofernandes.deliverypf.controllers;

import com.pedrofernandes.deliverypf.entities.dto.OrderDTO;
import com.pedrofernandes.deliverypf.entities.dto.ProductDTO;
import com.pedrofernandes.deliverypf.service.OrderService;
import com.pedrofernandes.deliverypf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        return new ResponseEntity(service.insert(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
        OrderDTO dto = service.setDelivered(id);
        return ResponseEntity.ok().body(dto);
    }
}
