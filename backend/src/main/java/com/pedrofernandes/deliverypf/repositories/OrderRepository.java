package com.pedrofernandes.deliverypf.repositories;

import com.pedrofernandes.deliverypf.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
