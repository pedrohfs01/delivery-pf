package com.pedrofernandes.deliverypf.service;

import com.pedrofernandes.deliverypf.entities.Order;
import com.pedrofernandes.deliverypf.entities.Product;
import com.pedrofernandes.deliverypf.entities.dto.OrderDTO;
import com.pedrofernandes.deliverypf.entities.dto.ProductDTO;
import com.pedrofernandes.deliverypf.repositories.OrderRepository;
import com.pedrofernandes.deliverypf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = repo.findOrderWithProduct();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }
}
