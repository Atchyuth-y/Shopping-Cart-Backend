package com.scart.ProfileService.security.services;

import com.scart.ProfileService.Model.Profile;
import com.scart.ProfileService.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
//        List<SimpleGrantedAuthority> roles=null;
        Optional<Profile> userProfile = profileRepository.findByEmail(emailId);
        if (userProfile == null) {
            throw new UsernameNotFoundException(emailId);
        } else {
            // roles= Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
            String username = userProfile.get().getEmailId();
            String password = userProfile.get().getPassword();
            return new User(username, password, new ArrayList<>());
        }
    }
}

