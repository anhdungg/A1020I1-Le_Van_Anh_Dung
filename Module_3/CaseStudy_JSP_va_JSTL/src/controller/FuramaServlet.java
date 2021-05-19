package controller;

import model.bean.Customer;
import service.FuramaService;
import service.impl.FuramaServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@WebServlet(name = "FaramaServlet", urlPatterns = {"/", "/home"})
public class FaramaServlet extends HttpServlet {
    public FuramaService service = new FuramaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "customer":
                this.customer(request, response);
                break;
            default:
                this.viewHome(request, response);
        }

    }

    private void customer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String method = request.getParameter("method");
        if (method == null){
            method = "";
        }
        switch (method){
            default:
                this.viewListCustomer(request, response);
        }
    }
    private void viewListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = this.service.findAll();
        List<List<Customer>> listPage = this.splitList(list);
        String page = request.getParameter("page");
        if (page != null){
            request.setAttribute("page", page);
            request.setAttribute("listCustomer", listPage.get(Integer.parseInt(page)-1));
        }else {
            request.setAttribute("page", 1);
            request.setAttribute("listCustomer", listPage.get(0));
        }
        request.setAttribute("numberOfPage", listPage.size());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private List<List<Customer>> splitList(List<Customer> list){
        List<List<Customer>> listPage = new ArrayList<>();
        if (list.size()<= 5){
            listPage.add(list);
            return listPage;
        }else {
            int indexSub = 5;
            while (true){
                listPage.add(list.subList(0, indexSub));
                for (int i=0; i<5; i++){
                    list.remove(0);
                }
                if (list.size()<=5){
                    listPage.add(list);
                    return listPage;
                }
            }
        }
    }
    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
