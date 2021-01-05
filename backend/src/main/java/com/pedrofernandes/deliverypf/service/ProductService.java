package com.pedrofernandes.deliverypf.service;

import com.pedrofernandes.deliverypf.entities.Product;
import com.pedrofernandes.deliverypf.entities.dto.ProductDTO;
import com.pedrofernandes.deliverypf.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll(){
        List<Product> list = repo.findAllByOrderByName();
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
