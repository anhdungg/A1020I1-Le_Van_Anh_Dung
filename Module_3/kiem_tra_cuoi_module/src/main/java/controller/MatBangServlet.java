package controller;

import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MatBangServlet", urlPatterns = "/")
public class MatBangServlet extends HttpServlet {
    private Service service = new ServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                this.deleteMB(request, response);
                break;
            case "create":
                this.createMB(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                this.viewCreateMB(request, response);
                break;
            default:
                this.viewList(request, response);
        }
    }

    private void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMB", this.service.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void deleteMB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null){
            id = "";
        }
        request.setAttribute("action", "delete");
        request.setAttribute("status", this.service.deleteMB(id));
        request.setAttribute("listMB", this.service.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }


    private void viewCreateMB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }
    private void createMB(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String dienTich = request.getParameter("dienTich");
        String trangThai = request.getParameter("trangThai");
        String tang = request.getParameter("tang");
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        String giaTien = request.getParameter("giaTien");
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        if (service.createMB(id, trangThai, dienTich, tang, loaiVanPhong, giaTien, ngayBatDau, ngayKetThuc)){
            request.setAttribute("listMB", this.service.findAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }
    }
}
