package controller;

import model.bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/", "/manage"})
public class UserServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                this.saveCreate(request, response);
                break;
            case "edit":
                this.saveEdit(request, response);
                break;
            case "delete":
                this.saveDelete(request, response);
                break;
            case "search":
                this.viewSearch(request, response);
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
                this.viewCreate(request, response);
                break;
            case "view":
                this.viewUser(request, response);
                break;
            case "edit":
                this.viewEdit(request, response);
                break;
            case "delete":
                this.viewDelete(request, response);
                break;
            case "search":
                this.viewSearch(request, response);
                break;
            case "sort":
                this.sortName(request, response);
                break;
            default:
                this.viewList(request, response);
        }
    }

    private void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", this.service.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void saveCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        if (this.service.save(name, email, country)){
            request.setAttribute("message", "success");
        }else {
            request.setAttribute("message", "fail");
        }
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", this.service.findId(id));
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    private void viewEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", this.service.findId(id));
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        if (this.service.update(id, name, email, country)){
            request.setAttribute("message", "success");
        }else {
            request.setAttribute("message", "fail");
        }
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void viewDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("user", this.service.findId(id));
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    private void saveDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.service.remove(id);
        this.viewList(request, response);
    }

    private void viewSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        if (country != null){
            request.setAttribute("result", "true");
            List<User> list = this.service.findCountry(country);
            if (list.isEmpty()){
                request.setAttribute("status", "false");
                request.setAttribute("value", country);
            } else {
                request.setAttribute("status", "true");
                request.setAttribute("listUser", list);
            }
        }else {
            request.setAttribute("result", "false");
        }

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void sortName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = this.service.sortName();
        request.setAttribute("listUser", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
