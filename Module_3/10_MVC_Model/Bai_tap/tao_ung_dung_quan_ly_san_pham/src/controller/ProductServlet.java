package controller;

import model.bean.Product;
import model.service.ProductService;
import model.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product", "/"})
public class ProductServlet extends HttpServlet {
    ProductService service = new ProductServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
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
                this.confirmDelete(request, response);
                break;
            case "search":
                this.resultSearch(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }

        switch (action){
            case "create":
                this.viewCreate(request, response);
                break;
            case "edit":
                this.viewEdit(request, response);
                break;
            case "delete":
                this.viewDelete(request, response);
                break;
            case "view":
                this.viewProduct(request, response);
                break;
            case "search":
                this.viewSearch(request, response);
                break;
            default:
                this.viewList(request, response);
        }

    }

    private void viewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("products", this.service.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void viewCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void saveCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        if(this.service.save(name, unit, price, description, producer)){
            request.setAttribute("message", "success");
        }else {
            request.setAttribute("message", "fail");
        }
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void viewEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        Product product = service.findId(Integer.parseInt(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        Product product = service.findId(Integer.parseInt(id));
        if(service.update(id, name, unit, price, description, producer)){
            request.setAttribute("message", "success");
        }else {
            request.setAttribute("message", "fail");
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    private void viewDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        Product product = service.findId(Integer.parseInt(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("delete.jsp").forward(request, response);
    }

    private void confirmDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        service.remove(Integer.parseInt(id));
        this.viewList(request, response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        Product product = service.findId(Integer.parseInt(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("view.jsp").forward(request, response);
    }

    private void viewSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("result", "false");
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    private void resultSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String value = request.getParameter("value");
        List<Product> list = service.search(value);
        request.setAttribute("result", "true");
        if (list.isEmpty()){
            request.setAttribute("status", "false");
            request.setAttribute("value", value);
        }else {
            request.setAttribute("status", "true");
            request.setAttribute("products", list);
        }
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
