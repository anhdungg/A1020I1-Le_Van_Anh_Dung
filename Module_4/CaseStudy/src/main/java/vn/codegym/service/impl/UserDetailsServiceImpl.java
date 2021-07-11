package vn.codegym.service.impl;


//import vn.codegym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.Role;
import vn.codegym.repository.RoleRepository;
import vn.codegym.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        vn.codegym.model.User user = this.userRepository.findByUserName(userName);

        if (user == null) {
//            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

//        System.out.println("Found User: " + userName);
        // [ROLE_USER, ROLE_ADMIN,..]
        List<Role> roles = this.roleRepository.findAllByUsers(user);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if (roles != null) {
            for (Role role1 : roles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role1.getRoleName());
                grantList.add(authority);
            }
        }

        return new User(user.getUserName(), user.getPassword(), grantList);
    }

}
