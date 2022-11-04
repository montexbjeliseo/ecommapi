package com.mtx.ecommerce.security.service.impl;

import com.mtx.ecommerce.security.model.User;
import com.mtx.ecommerce.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userRepository.existsByEmail(username)) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return userRepository.findByEmail(username).get();

    }

}
