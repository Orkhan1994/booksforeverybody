package com.developia.booksforeverbody.service.impl;

import com.developia.booksforeverbody.dao.entity.BookEntity;
import com.developia.booksforeverbody.dao.entity.BookStatus;
import com.developia.booksforeverbody.dao.repository.BookRepo;
import com.developia.booksforeverbody.exception.NotFoundException;
import com.developia.booksforeverbody.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAllByStatusIsNot(BookStatus.DELETED);
    }

    @Override
    public BookEntity getBookById(Long id) {
        return bookRepository.findByIdAndStatusIsNot(id,BookStatus.DELETED).orElseThrow(()->{
            throw new NotFoundException("Book not found");
                }
                );
    }
}
