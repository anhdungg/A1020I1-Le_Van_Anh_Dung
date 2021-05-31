package controller;

import common.Validate;
import model.bean.Customer;
import model.bean.Employee;
import service.FuramaService;
import service.impl.FuramaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "FuramaServlet", urlPatterns = {"/", "/home"})
public class FuramaServlet extends HttpServlet {
    public FuramaService service = new FuramaServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null){
            type = "";
        }

        switch (type){
            case "service":
                this.servicePost(request, response);
                break;
            case "contact":
                this.contactPost(request, response);
                break;
            case "customer":
                this.customerPost(request, response);
                break;
            case "employee":
                this.employeePost(request, response);
                break;
            case "login":
                this.checkLogin(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null){
            type = "";
        }

        switch (type){
            case "service":
                this.serviceGet(request, response);
                break;
            case "contact":
                this.contactGet(request, response);
                break;
            case "employee":
                this.employeeGet(request, response);
                break;
            case "customer":
                this.customerGet(request, response);
                break;
            default:
                this.viewLogin(request, response);
        }

    }

    private void viewLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String remember = request.getParameter("remember");

        if (remember.equals("on")){

        }
        if (user.equals("Anh Dung") && pass.equals("123")){
            this.viewHome(request, response);
        }else {
            request.setAttribute("user", user);
            request.setAttribute("pass", pass);
            request.setAttribute("error", "Sai ten dang nhap hoac mat khau");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

    private void viewHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
            request.setAttribute("customer", this.service.findByIdCustomer(id));
            request.setAttribute("action", "edit");
        } catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void saveEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String validateId = Validate.idCustomer(id);

        String idType = request.getParameter("idTypeCustomer");
        String validateIdTypeCustomer = Validate.idTypeCustomer(idType);

        String name = request.getParameter("name");
        String validateName = Validate.validateNull(name);

        String dayOfBirth = request.getParameter("dayOfBirth");
        String validateDateOfBirth = Validate.dateOfBirth(dayOfBirth);

        String CMND = request.getParameter("CMND");
        String validateCMND = Validate.CMND(CMND);

        String phoneNumber = request.getParameter("phoneNumber");
        String validatePhoneNumber = Validate.phoneNumber(phoneNumber);

        String email = request.getParameter("email");
        String validateEmail = Validate.email(email);

        String address = request.getParameter("address");
        String validateAddress = Validate.validateNull(address);

        String status = "";
        boolean check;
        if (validateId == null && validateIdTypeCustomer == null && validateDateOfBirth == null && validateCMND == null &&
                validatePhoneNumber == null && validateEmail == null && validateName == null && validateAddress == null){
            status = this.service.editCustomer(id, idType, name, dayOfBirth, CMND, phoneNumber, email, address);
            if (status.equals("Chinh sua thong tin khach hang thanh cong")){
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("status", status);
                request.setAttribute("statusSave", "success");
            }else{
                check = false;
            }
        }else {
            check = false;
        }
        if (!check){
            request.setAttribute("action", "edit");
            request.setAttribute("status", status);
            request.setAttribute("id", id);
            request.setAttribute("validateId", validateId);
            request.setAttribute("idType", idType);
            request.setAttribute("validateIdTypeCustomer", validateIdTypeCustomer);
            request.setAttribute("name", name);
            request.setAttribute("validateName", validateName);
            request.setAttribute("dayOfBirth", dayOfBirth);
            request.setAttribute("validateDateOfBirth", validateDateOfBirth);
            request.setAttribute("CMND", CMND);
            request.setAttribute("validateCMND", validateCMND);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("validatePhoneNumber", validatePhoneNumber);
            request.setAttribute("email", email);
            request.setAttribute("validateEmail", validateEmail);
            request.setAttribute("address", address);
            request.setAttribute("validateAddress", validateAddress);
        }
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idType", 0);
        request.setAttribute("action", "create");
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void saveCreateCustomer (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String validateId = Validate.idCustomer(id);

        String idType = request.getParameter("idTypeCustomer");
        String validateIdTypeCustomer = Validate.idTypeCustomer(idType);

        String name = request.getParameter("name");
        String validateName = Validate.validateNull(name);

        String dayOfBirth = request.getParameter("dayOfBirth");
        String validateDateOfBirth = Validate.dateOfBirth(dayOfBirth);

        String CMND = request.getParameter("CMND");
        String validateCMND = Validate.CMND(CMND);

        String phoneNumber = request.getParameter("phoneNumber");
        String validatePhoneNumber = Validate.phoneNumber(phoneNumber);

        String email = request.getParameter("email");
        String validateEmail = Validate.email(email);

        String address = request.getParameter("address");
        String validateAddress = Validate.validateNull(address);

        String status = "";
        boolean check;
        if (validateId == null && validateIdTypeCustomer == null && validateDateOfBirth == null && validateCMND == null &&
                validatePhoneNumber == null && validateEmail == null && validateName == null && validateAddress == null){
            status = this.service.createCustomer(id, idType, name, dayOfBirth, CMND, phoneNumber, email, address);
            if (status.equals("Tao moi khach hang thanh cong")){
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("status", status);
                request.setAttribute("statusSave", "success");
            }else {
                check = false;
            }
        }else {
            check = false;
        }
        if (!check){
            request.setAttribute("action", "create");
            request.setAttribute("status", status);
            request.setAttribute("id", id);
            request.setAttribute("validateId", validateId);
            request.setAttribute("idType", idType);
            request.setAttribute("validateIdTypeCustomer", validateIdTypeCustomer);
            request.setAttribute("name", name);
            request.setAttribute("validateName", validateName);
            request.setAttribute("dayOfBirth", dayOfBirth);
            request.setAttribute("validateDateOfBirth", validateDateOfBirth);
            request.setAttribute("CMND", CMND);
            request.setAttribute("validateCMND", validateCMND);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("validatePhoneNumber", validatePhoneNumber);
            request.setAttribute("email", email);
            request.setAttribute("validateEmail", validateEmail);
            request.setAttribute("address", address);
            request.setAttribute("validateAddress", validateAddress);
        }

        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void viewDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        Customer customer = this.service.findByIdCustomer(id);
        request.setAttribute("name", customer.getName());
        request.setAttribute("action", "delete");
        request.setAttribute("type", "customer");
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.getRequestDispatcher("customer.jsp").forward(request, response);
    }

    private void saveDeleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String id = request.getParameter("id");
            if (this.service.deleteCustomer(id)){
                request.setAttribute("statusSave", "success");
            }else {
                request.setAttribute("statusSave", "fail");
            }
        } catch (NumberFormatException ex){
            request.setAttribute("statusSave", "fail");
            ex.printStackTrace();
        }
        request.setAttribute("action", "statusSave");
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
            request.setAttribute("action", "edit");

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
        String validateName = Validate.validateNull(name);

        String idPosition = request.getParameter("idPosition");
        String idEducationDegree = request.getParameter("idEducationDegree");
        String idDivision = request.getParameter("idDivision");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String validateDateOfBirth = Validate.dateOfBirth(dayOfBirth);

        String CMND = request.getParameter("cmnd");
        String validateCMND = Validate.CMND(CMND);

        String salary = request.getParameter("salary");
        String validateSalary = Validate.validateDouble(salary);

        String phoneNumber = request.getParameter("phoneNumber");
        String validatePhoneNumber = Validate.phoneNumber(phoneNumber);

        String email = request.getParameter("email");
        String validateEmail = Validate.email(email);

        String address = request.getParameter("address");
        String validateAddress = Validate.validateNull(address);

        String status = "";
        boolean check;
        if (validateDateOfBirth == null && validateCMND == null && validateSalary == null && validatePhoneNumber == null &&
                validateEmail == null && validateName == null && validateAddress == null){
            status = this.service.editEmployee(id, name, idPosition, idEducationDegree, idDivision, dayOfBirth, CMND,
                    salary, phoneNumber, email, address);
            if (status.equals("Chinh sua thong tin nhan vien thanh cong")){
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("statusSave", "success");
                request.setAttribute("status", status);
            }else {
                check = false;
            }
        } else {
            check = false;
        }
        if (!check){
            request.setAttribute("action", "edit");
            request.setAttribute("status", status);
            request.setAttribute("id", id);
            request.setAttribute("name", name);
            request.setAttribute("validateName", validateName);
            request.setAttribute("idPosition", idPosition);
            request.setAttribute("idEducationDegree", idEducationDegree);
            request.setAttribute("idDivision", idDivision);
            request.setAttribute("dayOfBirth", dayOfBirth);
            request.setAttribute("validateDateOfBirth", validateDateOfBirth);
            request.setAttribute("CMND", CMND);
            request.setAttribute("validateCMND", validateCMND);
            request.setAttribute("salary", salary);
            request.setAttribute("validateSalary", validateSalary);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("validatePhoneNumber", validatePhoneNumber);
            request.setAttribute("email", email);
            request.setAttribute("validateEmail", validateEmail);
            request.setAttribute("address", address);
            request.setAttribute("validateAddress", validateAddress);
        }
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void viewCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("action", "create");
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void saveCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        String validateName = Validate.validateNull(name);

        String idPosition = request.getParameter("idPosition");
        String idEducationDegree = request.getParameter("idEducationDegree");
        String idDivision = request.getParameter("idDivision");
        String dayOfBirth = request.getParameter("dayOfBirth");
        String validateDateOfBirth = Validate.dateOfBirth(dayOfBirth);

        String CMND = request.getParameter("cmnd");
        String validateCMND = Validate.CMND(CMND);

        String salary = request.getParameter("salary");
        String validateSalary = Validate.validateDouble(salary);

        String phoneNumber = request.getParameter("phoneNumber");
        String validatePhoneNumber = Validate.phoneNumber(phoneNumber);

        String email = request.getParameter("email");
        String validateEmail = Validate.email(email);

        String address = request.getParameter("address");
        String validateAddress = Validate.validateNull(address);

        String status = "";
        boolean check;
        if (validateDateOfBirth == null && validateCMND == null && validateSalary == null && validatePhoneNumber == null &&
                validateEmail == null && validateName == null && validateAddress == null){
            status = this.service.createEmployee(name, idPosition, idEducationDegree, idDivision, dayOfBirth, CMND, salary,
                    phoneNumber, email, address);
            if (status.equals("Tao moi nhan vien thanh cong")){
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("statusSave", "success");
                request.setAttribute("status", status);
            }else {
                check = false;
            }
        }else {
            check = false;
        }
        if (!check){
            request.setAttribute("action", "create");
            request.setAttribute("status", status);
            request.setAttribute("name", name);
            request.setAttribute("validateName", validateName);
            request.setAttribute("idPosition", idPosition);
            request.setAttribute("idEducationDegree", idEducationDegree);
            request.setAttribute("idDivision", idDivision);
            request.setAttribute("dayOfBirth", dayOfBirth);
            request.setAttribute("validateDateOfBirth", validateDateOfBirth);
            request.setAttribute("CMND", CMND);
            request.setAttribute("validateCMND", validateCMND);
            request.setAttribute("salary", salary);
            request.setAttribute("validateSalary", validateSalary);
            request.setAttribute("phoneNumber", phoneNumber);
            request.setAttribute("validatePhoneNumber", validatePhoneNumber);
            request.setAttribute("email", email);
            request.setAttribute("validateEmail", validateEmail);
            request.setAttribute("address", address);
            request.setAttribute("validateAddress", validateAddress);
        }
        request.setAttribute("type", "employee");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.getRequestDispatcher("employee.jsp").forward(request, response);
    }

    private void viewDeleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        Employee employee = this.service.findByIdEmployee(Integer.parseInt(id));
        request.setAttribute("name", employee.getName());
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
        request.setAttribute("action", "statusSave");
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

    private void contactGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "create":
                this.viewCreateContact(request, response);
                break;
            case "createDetail":
                this.viewCreateContactDetail(request, response);
                break;
            default:
                this.viewListContact(request, response);
        }
    }

    private void contactPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "createDetail":
                this.saveCreateContactDetail(request, response);
                break;
            case "create":
                this.saveCreateContact(request, response);
                break;
        }
    }

    private void viewListContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("type", "contact");
        request.setAttribute("listContactView", this.service.findAllContactView());
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    private void viewCreateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("type", "contact");
        request.setAttribute("action", "create");
        request.setAttribute("listEmployee", this.service.findAllEmployee());
        request.setAttribute("listCustomer", this.service.findAllCustomer());
        request.setAttribute("listService", this.service.findAllService());
        request.setAttribute("listContactView", this.service.findAllContactView());
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    private void saveCreateContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idEmployee = request.getParameter("idEmployee");
        String idCustomer = request.getParameter("idCustomer");
        String idService = request.getParameter("idService");
        String contactDate = request.getParameter("contactDate");
        String validateContactDate = Validate.dayMonthYear(contactDate);

        String endDate = request.getParameter("endDate");
        String validateEndDate = Validate.dayMonthYear(endDate);
        if (validateContactDate == null && validateEndDate == null){
            LocalDate dateBefore = LocalDate.parse(contactDate);
            LocalDate dateAfter = LocalDate.parse(endDate);
            long dayBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
            if (dayBetween<0){
                validateEndDate = "Ngay ket thuc phai lon hon hoac bang ngay lam hop dong";
            }
        }

        String depositMoney = request.getParameter("depositMoney");
        String validateDepositMoney = Validate.validateDouble(depositMoney);

        String totalMoney = request.getParameter("totalMoney");
        if (totalMoney == null){
            totalMoney = "";
        }
        System.out.println(totalMoney);
        String validateTotalMoney = Validate.validateDouble(totalMoney);

        String status = "";
        boolean check;
        if (validateContactDate == null && validateEndDate == null && validateDepositMoney == null && validateTotalMoney == null){
            if (this.service.createContact(idEmployee, idCustomer, idService, contactDate, endDate, depositMoney, totalMoney)){
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("status", "Tao moi hop dong thanh cong");
            }else {
                check = false;
                status = "Loi co so du lieu";
            }
        }else{
            check = false;
        }

        if (!check){
            request.setAttribute("action", "create");
            request.setAttribute("status", status);
            request.setAttribute("idEmployee", idEmployee);
            request.setAttribute("idCustomer", idCustomer);
            request.setAttribute("idService", idService);
            request.setAttribute("contactDate", contactDate);
            request.setAttribute("validateContactDate", validateContactDate);
            request.setAttribute("endDate", endDate);
            request.setAttribute("validateEndDate", validateEndDate);
            request.setAttribute("depositMoney", depositMoney);
            request.setAttribute("validateDepositMoney", validateDepositMoney);
            request.setAttribute("totalMoney", totalMoney);
            request.setAttribute("validateTotalMoney", validateTotalMoney);
            request.setAttribute("listEmployee", this.service.findAllEmployee());
            request.setAttribute("listCustomer", this.service.findAllCustomer());
            request.setAttribute("listService", this.service.findAllService());
        }
        request.setAttribute("type", "contact");
        request.setAttribute("listContactView", this.service.findAllContactView());
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    private void viewCreateContactDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("type", "contact");
        request.setAttribute("action", "createDetail");
        request.setAttribute("listContact", this.service.findAllContact());
        request.setAttribute("listAccompaniedService", this.service.findAllAccompaniedService());
        request.setAttribute("listContactView", this.service.findAllContactView());
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    private void saveCreateContactDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idContact = request.getParameter("idContact");
        String idAccompaniedService = request.getParameter("idAccompaniedService");
        String amount = request.getParameter("amount");
        String validateAmount = Validate.validateInteger(amount);

        String status = "";
        boolean check;

        if (validateAmount == null) {
            if (this.service.createContactDetail(idContact, idAccompaniedService, amount)) {
                check = true;
                request.setAttribute("action", "statusSave");
                request.setAttribute("status", "Tao moi hop dong chi tiet thanh cong");
            } else {
                check = false;
                status = "Loi co so du lieu";
            }
        }else {
            check = false;
        }

        if (!check){
            request.setAttribute("action", "createDetail");
            request.setAttribute("status", status);
            request.setAttribute("idContact", idContact);
            request.setAttribute("idAccompaniedService", idAccompaniedService);
            request.setAttribute("idAccompaniedService", idAccompaniedService);
            request.setAttribute("amount", amount);
            request.setAttribute("validateAmount", validateAmount);
            request.setAttribute("listContact", this.service.findAllContact());
            request.setAttribute("listAccompaniedService", this.service.findAllAccompaniedService());
        }
        request.setAttribute("type", "contact");
        request.setAttribute("listContactView", this.service.findAllContactView());
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    private void serviceGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "create":
                this.viewCreateService(request, response);
                break;
            default:
                this.viewListService(request, response);
        }
    }

    private void servicePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }

        switch (action){
            case "create":
                this.saveCreateService(request, response);
                break;
        }
    }

    private void viewListService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("type", "service");
        request.getRequestDispatcher("service.jsp").forward(request, response);
    }

    private void viewCreateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("type", "service");
        request.setAttribute("action", "create");
        request.getRequestDispatcher("service.jsp").forward(request, response);
    }

    private void saveCreateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id==null){
            id = "";
        }
        String validateId = Validate.idService(id);

        String name = request.getParameter("name");
        String validateName = Validate.validateNull(name);

        String area = request.getParameter("area");
        String validateArea = Validate.validateDouble(area);

        String rentalCosts = request.getParameter("rentalCosts");
        String validateRentalCosts = Validate.validateDouble(rentalCosts);

        String maximumNumberOfPeople = request.getParameter("maximumNumberOfPeople");
        String validateMaximumPeople = Validate.validateInteger(maximumNumberOfPeople);

        String idRentalType = request.getParameter("idRentalType");
        String idServiceType = request.getParameter("idServiceType");

        String standard = request.getParameter("standard");
        if (standard == null){
            standard = "";
        }
        String validateStandard = null;

        String description = request.getParameter("description");

        String poolArea = request.getParameter("poolArea");
        if (poolArea == null){
            poolArea = "";
        }
        String validatePoolArea = null;

        String numberOfFloors = request.getParameter("numberOfFloors");
        if (numberOfFloors == null){
            numberOfFloors = "";
        }
        String validateNumberOfFloors = null;

        switch (idServiceType) {
            case "1":
                validateStandard = Validate.validateNull(standard);
                validatePoolArea = Validate.validateDouble(poolArea);
                validateNumberOfFloors = Validate.validateInteger(numberOfFloors);
                break;
            case "2":
                poolArea = "0";
                validateStandard = Validate.validateNull(standard);
                validateNumberOfFloors = Validate.validateInteger(numberOfFloors);
                break;
            case "3":
                poolArea = "0";
                numberOfFloors = "0";
                break;
        }
        String status = "";
        boolean check;
        if (validateId == null && validateName == null && validateArea == null && validateRentalCosts == null && validateMaximumPeople == null &&
                validatePoolArea == null && validateNumberOfFloors == null && validateStandard == null){
            status = this.service.createService(id, name, area, rentalCosts, maximumNumberOfPeople, idRentalType, idServiceType,
                    standard, description, poolArea, numberOfFloors);
            if (status.equals("Tao moi dich vu thanh cong")){
                check = true;
                request.setAttribute("action", "statusSave");
            }else {
                check = false;
            }
        }else {
            check = false;
        }
        if (!check){
            request.setAttribute("action", "create");
            request.setAttribute("status", status);
            request.setAttribute("id", id);
            request.setAttribute("validateId", validateId);
            request.setAttribute("name", name);
            request.setAttribute("validateName", validateName);
            request.setAttribute("area", area);
            request.setAttribute("validateArea", validateArea);
            request.setAttribute("rentalCosts", rentalCosts);
            request.setAttribute("validateRentalCosts", validateRentalCosts);
            request.setAttribute("maximumNumberOfPeople", maximumNumberOfPeople);
            request.setAttribute("validateMaximumPeople", validateMaximumPeople);
            request.setAttribute("idRentalType", idRentalType);
            request.setAttribute("idServiceType", idServiceType);
            request.setAttribute("standard", standard);
            request.setAttribute("validateStandard", validateStandard);
            request.setAttribute("description", description);
            request.setAttribute("poolArea", poolArea);
            request.setAttribute("validatePoolArea", validatePoolArea);
            request.setAttribute("numberOfFloors", numberOfFloors);
            request.setAttribute("validateNumberOfFloors", validateNumberOfFloors);
        }
        request.setAttribute("type", "service");
        request.getRequestDispatcher("service.jsp").forward(request, response);
    }
}
