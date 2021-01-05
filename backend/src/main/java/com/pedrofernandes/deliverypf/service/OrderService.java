package com.pedrofernandes.deliverypf.service;

import com.pedrofernandes.deliverypf.entities.Order;
import com.pedrofernandes.deliverypf.entities.Product;
import com.pedrofernandes.deliverypf.entities.dto.OrderDTO;
import com.pedrofernandes.deliverypf.entities.dto.ProductDTO;
import com.pedrofernandes.deliverypf.entities.enums.OrderStatus;
import com.pedrofernandes.deliverypf.repositories.OrderRepository;
import com.pedrofernandes.deliverypf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository repo;

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repo.findOrderWithProduct();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order(null, orderDTO.getAddress(), orderDTO.getLatitude(), orderDTO.getLongitude(),
                Instant.now(), OrderStatus.PENDING);
        for (ProductDTO p : orderDTO.getProducts()) {
            Product product = productRepository.getOne(p.getId());
            order.getProducts().add(product);
        }
        order = repo.save(order);
        return new OrderDTO(order);
    }
}
