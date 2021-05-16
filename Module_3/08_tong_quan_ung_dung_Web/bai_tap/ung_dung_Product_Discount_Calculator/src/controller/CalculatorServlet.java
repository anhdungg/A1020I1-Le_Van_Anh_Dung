package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bai_tap.ung_dung_Product_Discount_Calculator.CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double total=0;
        try {
            float price = Float.parseFloat(request.getParameter("price"));
            float discount = Float.parseFloat(request.getParameter("discount"));
            total = price * discount * 0.01;
        }
        finally {
            request.setAttribute("total",total+"%");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
