package com.example.materia_seca.service;

import com.example.materia_seca.entity.User;
import com.example.materia_seca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if(user == null)
            return null;
        return new org.springframework.security.core.userdetails.User(
                user.getCorreo(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

}
