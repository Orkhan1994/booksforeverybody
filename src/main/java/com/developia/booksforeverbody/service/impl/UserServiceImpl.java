package com.developia.booksforeverbody.service.impl;

import com.developia.booksforeverbody.dao.entity.Role;
import com.developia.booksforeverbody.dao.entity.RoleEntity;
import com.developia.booksforeverbody.dao.entity.UserEntity;
import com.developia.booksforeverbody.dao.repository.RoleRepo;
import com.developia.booksforeverbody.dao.repository.UserRepo;
import com.developia.booksforeverbody.exception.UserAlreadyExistsException;
import com.developia.booksforeverbody.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder passwordEncoder;

    private final RoleRepo roleRepo;

    private final UserRepo userRepo;

    @Override
    public void register(UserEntity user) {
        userRepo.findUserByUsername(user.getUsername()).ifPresent(
                u -> {
                    throw new UserAlreadyExistsException("User already exists");
                }
        );

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        RoleEntity role= roleRepo.findByName(Role.USER);
        user.setRoles(List.of(role));

        userRepo.save(user);
    }
}
