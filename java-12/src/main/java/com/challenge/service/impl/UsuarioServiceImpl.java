package com.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.challenge.repository.UserRepository;



@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
    	return usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
    }
}
