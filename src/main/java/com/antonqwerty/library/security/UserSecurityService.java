package com.antonqwerty.library.security;

import com.antonqwerty.library.model.SecurityUser;
import com.antonqwerty.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityUser user = userRepository.findByName(username);
        if (user != null) {
            return new User(user.getName(),user.getPassword(), List.of());
        }
        throw new UsernameNotFoundException("User not found");
    }
}
