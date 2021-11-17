package com.developia.booksforeverbody.dao.repository;

import com.developia.booksforeverbody.dao.entity.Role;
import com.developia.booksforeverbody.dao.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<RoleEntity,Long> {

    RoleEntity findByName(Role name);
}
