import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", urlPatterns = {"/","/list"})
public class ListCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "img/img-1.jpg"));
        list.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giag", "img/img-2.jpg"));
        list.add(new Customer("Nguyễn Thái Hoà", "1983-08-22", "Hà Nội", "img/img-3.jpg"));
        list.add(new Customer("Trần Đăng Khoa", "1983-08-17", "Hà Nội", "img/img-4.jpg"));
        list.add(new Customer("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "img/img-5.jpg"));
        request.setAttribute("customer", list);
        request.getRequestDispatcher("list_customer.jsp").forward(request, response);
    }
}
