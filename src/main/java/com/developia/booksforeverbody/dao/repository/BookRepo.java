package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,Long> {
}
