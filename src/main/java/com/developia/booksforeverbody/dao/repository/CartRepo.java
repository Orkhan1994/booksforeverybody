package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<CartEntity,Long> {
}
