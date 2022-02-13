package br.com.letscode.desafio.service;

import br.com.letscode.desafio.domain.model.User;
import br.com.letscode.desafio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service(value = "userService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> opt = userRepository.findByUsername(username);
        User userModel = null;
        if (opt.isPresent()) {
            userModel = opt.get();
        }
        if (userModel == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(userModel);
    }

    public String getContextUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    class MyUserDetails implements UserDetails {

        private static final long serialVersionUID = -8489053074208206273L;

        private final User userModel;

        public MyUserDetails(User userModel) {
            this.userModel = userModel;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return userModel.getPassword();
        }

        @Override
        public String getUsername() {
            return userModel.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}