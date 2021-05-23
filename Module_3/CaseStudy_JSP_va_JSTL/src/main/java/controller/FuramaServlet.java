package controller;

import service.FuramaService;
import service.impl.FuramaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FuramaServlet", urlPatterns = {"/", "/home"})
public class FuramaServlet extends HttpServlet {
    public FuramaService service = new FuramaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null){
            type = "";
        }

        switch (type){
            case "customer":
                this.customerPost(request, response);
                break;
            default:
                this.viewHome(request, response);
        }
        this.viewListCustomer(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null){
            type = "";
        }

        switch (type){
            case "customer":
                this.customerGet(request, response);
                break;
            default:
                this.viewHome(request, response);
        }

    }

    private void customerGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                this.viewDeleteCustomer(request, response);
                break;
            case "create":
                this.viewCreateCustomer(request, response);
                break;
            case "edit":
                this.viewEditCustomer(request, response);
                break;
            default:
                this.viewListCustomer(request, response);
        }
    }

    private void customerPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                this.saveDeleteCustomer(request, response);
                break;
            case "create":
                this.saveCreateCustomer(request, response);
                break;
            case "edit":
                this.saveEditCustomer(request, response);
                break;
            default:
                this.viewListCustomer(request, response);
        }
    }

    private void viewListCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listCustomer", this.service.findAll());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            request.setAttribute("customer", this.service.findById(Integer.parseInt(id)));
            request.setAttribute("action", "edit");

        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        request.getRequestDispatcher("edit_create_customer.jsp").forward(request, response);
    }

    private void saveEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String idType = request.getParameter("idTypeCustomer");
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String CMND = request.getParameter("CMND");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        boolean status = this.service.editCustomer(id, idType, name, dayOfBirth, CMND, phoneNumber, email, address);
        if (status){
            request.setAttribute("statusSave", "success");
        }else{
            request.setAttribute("statusSave", "fail");
        }
        request.setAttribute("action", "edit");
        request.setAttribute("customer", this.service.findById(Integer.parseInt(id)));
        request.getRequestDispatcher("edit_create_customer.jsp").forward(request, response);
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "create");
        request.getRequestDispatcher("edit_create_customer.jsp").forward(request, response);
    }
    private void saveCreateCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idType = request.getParameter("idTypeCustomer");
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String CMND = request.getParameter("CMND");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (this.service.createCustomer(idType, name, dayOfBirth, CMND, phoneNumber, email, address)){
            request.setAttribute("statusSave", "success");
        }else {
            request.setAttribute("statusSave", "fail");
        }
        request.setAttribute("action", "create");
        request.getRequestDispatcher("edit_create_customer.jsp").forward(request, response);
    }

    private void viewDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.setAttribute("action", "delete");
        request.setAttribute("listCustomer", this.service.findAll());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void saveDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
//            request.setAttribute("customer", this.service.deleteCustomer(Integer.parseInt(id)));
//            request.setAttribute("action", "delete");
            this.service.deleteCustomer(Integer.parseInt(id));
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        request.setAttribute("listCustomer", this.service.findAll());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }
    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}
