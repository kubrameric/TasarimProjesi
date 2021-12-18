package com.tasarim.tasarimprojesi.service.impl;

import com.tasarim.tasarimprojesi.model.User;
import com.tasarim.tasarimprojesi.security.MyUserDetails;
import com.tasarim.tasarimprojesi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userService.findByUsername(username);
        return MyUserDetails.build(user);
    }

}
