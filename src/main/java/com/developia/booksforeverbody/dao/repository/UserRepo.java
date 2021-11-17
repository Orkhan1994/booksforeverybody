package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findUserByUsername(String username);
}
