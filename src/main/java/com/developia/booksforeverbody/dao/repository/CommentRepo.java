package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<CommentEntity,Long> {
}
