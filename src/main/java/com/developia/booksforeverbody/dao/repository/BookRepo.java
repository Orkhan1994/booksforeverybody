package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.BookEntity;
import com.developia.booksforeverbody.dao.entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<BookEntity,Long> {


    List<BookEntity> findAllByStatusIsNot(BookStatus status);

    Optional< BookEntity> findByIdStatusIsNot(Long id, BookStatus status);
}
