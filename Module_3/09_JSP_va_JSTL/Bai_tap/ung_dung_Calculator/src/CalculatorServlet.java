import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.calculator(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void calculator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double first=0.0;
        double second=0.0;
        double result=0.0;
        String resultString = "";
        try {
            first = Double.parseDouble(request.getParameter("first"));
            second = Double.parseDouble(request.getParameter("second"));
        }catch (NumberFormatException e){
            resultString = "Error: Number format";
        }
        String operator = request.getParameter("operator");
        switch (operator) {
            case "+":
                result = first + second;
                break;
            case "-":
                result = first - second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                if (second == 0.0 && resultString.equals("")){
                    resultString = "Error: Arithmetic";
                    break;
                }
                result = first / second;
                break;
        }
        if (resultString.equals("")){
            request.setAttribute("result", first + operator + second + " = " + result);
        }else {
            request.setAttribute("result", resultString);
        }
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
