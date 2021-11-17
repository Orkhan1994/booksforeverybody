package com.developia.booksforeverbody.service;

import com.developia.booksforeverbody.dao.entity.RoleEntity;
import com.developia.booksforeverbody.dao.entity.UserEntity;
import com.developia.booksforeverbody.dao.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MyUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user=userRepo.findUserByUsername(username).
                orElseThrow(()->{
               throw new UsernameNotFoundException("Username or password incorrect");
        });

        List<SimpleGrantedAuthority> authorities=new ArrayList<>();

        for (RoleEntity role:user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        }

        User springUser=new User(user.getUsername(),user.getPassword(),authorities);

        return springUser;
    }
}
