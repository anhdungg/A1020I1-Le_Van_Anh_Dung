package vn.codegym.service;

import org.springframework.ui.Model;

public interface FuramaService {
    public void getSession(String nameUser, String role, Model model);
}
