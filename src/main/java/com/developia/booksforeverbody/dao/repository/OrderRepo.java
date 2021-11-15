package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderEntity,Long> {
}
