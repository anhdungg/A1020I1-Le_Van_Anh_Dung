package controller;

import model.bean.User;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/")
public class UserServlet extends HttpServlet {
    private UserRepository repository = new UserRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null) {
            if (action.equals("permision")) {
                this.addUserPermision(request, response);
            }else if (action.equals("test-without-tran")){
                this.testWithoutTran();
            }else if (action.equals("test-use-tran")){
                this.testUseTran();
            }
        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("kien", "kienhoang@gmail.com", "vn");

        int[] permision = {1, 2, 4};

        repository.addUserTransaction(user, permision);
    }

    private void testWithoutTran() {
        this.repository.insertUpdateWithoutTransaction();
    }

    private void testUseTran() {
        this.repository.insertUpdateUseTransaction();
    }
}
