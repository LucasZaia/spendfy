package com.spendfy.api.enums.security.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spendfy.api.models.User;
import com.spendfy.api.repository.UserRepository;

@Service
public class UserSecService  implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        return new UserSec(user);
    }
    
}
