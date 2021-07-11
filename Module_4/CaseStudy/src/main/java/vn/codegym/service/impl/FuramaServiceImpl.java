package vn.codegym.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import vn.codegym.service.FuramaService;

import java.util.Collection;

@Service
public class FuramaServiceImpl implements FuramaService {
    @Override
    public void getSession(String nameUser, String role, Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        if (authentication != null){
            Object session = authentication.getPrincipal();
            if (session instanceof User){
                User userDetail = (User)session;
                nameUser = userDetail.getUsername();
                Collection<GrantedAuthority> list = userDetail.getAuthorities();
                for (GrantedAuthority grantedAuthority : list){
                    switch (grantedAuthority.getAuthority()){
                        case "ROLE_MANAGER":
                            role = "ROLE_MANAGER";
                            break;
                        case "ROLE_MANAGE":
                            role = "ROLE_MANAGE";
                            break;
                        case "ROLE_STAFF":
                            role = "ROLE_STAFF";
                            break;
                        default:
                            role = "";
                    }
                }

            }
        }
        model.addAttribute("nameUser", nameUser);
        model.addAttribute("role", role);
    }
}
