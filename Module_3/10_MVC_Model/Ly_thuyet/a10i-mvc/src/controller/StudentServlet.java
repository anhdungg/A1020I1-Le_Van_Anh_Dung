package controller;

import model.bean.Student;
import model.service.StudentService;
import model.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student"})
public class StudentServlet extends HttpServlet {

    // DI
    StudentService studentService = new StudentServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("studentName");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student studentObj = new Student(name, dateOfBirth);

        String msg = null;
        if (this.studentService.save(studentObj)) {
            msg = "OK";
            // load list
            loadList(request, response);
        } else {
            msg = "Invalid data";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("create.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            this.loadList(request, response);
        } else if ("create".equals(actionUser)) {
            response.sendRedirect("create.jsp");
        }
    }

    private void loadList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentListServlet", this.studentService.findAll());
        request.getRequestDispatcher("list_jstl.jsp").forward(request, response);
    }
}
