package com.pedrofernandes.deliverypf.entities.dto;

import com.pedrofernandes.deliverypf.entities.Order;
import com.pedrofernandes.deliverypf.entities.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderDTO {
    private Long id;

    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(Long id, String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.address = order.getAddress();
        this.latitude = order.getLatitude();
        this.longitude = order.getLongitude();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.products = order.getProducts().stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
