package com.developia.booksforeverbody.service;

import com.developia.booksforeverbody.dao.entity.BookEntity;

import java.util.List;

public interface BookService {

    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);
}
