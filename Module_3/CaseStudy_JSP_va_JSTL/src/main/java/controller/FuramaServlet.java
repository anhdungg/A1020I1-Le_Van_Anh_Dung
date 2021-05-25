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
            case "employee":
                this.employeePost(request, response);
                break;
            default:
                this.viewHome(request, response);
        }
//        this.viewListCustomer(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null){
            type = "";
        }

        switch (type){
            case "employee":
                this.employeeGet(request, response);
                break;
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
            case "search":
                this.resultSearchCustomer(request, response);
                break;
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
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            request.setAttribute("customer", this.service.findByIdCustomer(Integer.parseInt(id)));
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
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
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "create");
        request.getRequestDispatcher("customer.jsp").forward(request, response);
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
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.setAttribute("action", "delete");
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void saveDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            if (this.service.deleteCustomer(Integer.parseInt(id))){
                request.setAttribute("statusSave", "success");
            }else {
                request.setAttribute("statusSave", "fail");
            }
        } catch (NumberFormatException ex){
            request.setAttribute("statusSave", "fail");
            ex.printStackTrace();
        }
        request.setAttribute("action", "delete");
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void resultSearchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("value");
        request.setAttribute("action", "search");
        request.setAttribute("type", "customer");
        request.setAttribute("value", name);
        request.setAttribute("listCustomer", this.service.findNameCustomer(name));
        request.getRequestDispatcher("customer.jsp").forward(request, response);

    }

    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    private void employeeGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "search":
                this.resultSearchEmployee(request, response);
                break;
            case "delete":
                this.viewDeleteEmployee(request, response);
                break;
            case "create":
                this.viewCreateEmployee(request, response);
                break;
            case "edit":
                this.viewEditEmployee(request, response);
                break;
            default:
                this.viewListEmployee(request, response);
        }
    }

    private void employeePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                this.saveDeleteEmployee(request, response);
                break;
            case "create":
                this.saveCreateEmployee(request, response);
                break;
            case "edit":
                this.saveEditEmployee(request, response);
                break;
            default:
                this.viewListEmployee(request, response);
        }
    }

    private void viewListEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void viewEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            String id = request.getParameter("id");
            request.setAttribute("employee", this.service.findByIdEmployee(Integer.parseInt(id)));
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void saveEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String idPosition = request.getParameter("idPosition");
        String idLevel = request.getParameter("idLevel");
        String idDepartment = request.getParameter("idDepartment");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String CMND = request.getParameter("cmnd");
        String salary = request.getParameter("salary");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (this.service.editEmployee(id, name, idPosition, idLevel, idDepartment, dayOfBirth, CMND, salary, phoneNumber, email, address)){
            request.setAttribute("statusSave", "success");
        }else {
            request.setAttribute("statusSave", "fail");
        }
        request.setAttribute("action", "create");
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void viewCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("action", "create");
        request.setAttribute("type", "employee");
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void saveCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String idPosition = request.getParameter("idPosition");
        String idLevel = request.getParameter("idLevel");
        String idDepartment = request.getParameter("idDepartment");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String CMND = request.getParameter("cmnd");
        String salary = request.getParameter("salary");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        if (this.service.createEmployee(name, idPosition, idLevel, idDepartment, dayOfBirth, CMND, salary, phoneNumber, email, address)){
            request.setAttribute("statusSave", "success");
        }else {
            request.setAttribute("statusSave", "fail");
        }
        request.setAttribute("action", "create");
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void viewDeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.setAttribute("action", "delete");
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void saveDeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            if (this.service.deleteEmployee(Integer.parseInt(id))){
                request.setAttribute("statusSave", "success");
            }else {
                request.setAttribute("statusSave", "fail");
            }
        } catch (NumberFormatException ex){
            request.setAttribute("statusSave", "fail");
            ex.printStackTrace();
        }
        request.setAttribute("action", "delete");
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void resultSearchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("value");
        request.setAttribute("action", "search");
        request.setAttribute("type", "employee");
        request.setAttribute("value", name);
        request.setAttribute("listEmployee", this.service.findNameEmployee(name));
        request.getRequestDispatcher("employee.jsp").forward(request, response);

    }
}
