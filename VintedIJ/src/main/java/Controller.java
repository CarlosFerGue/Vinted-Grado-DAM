import action.ProductoAction;
import controller.action.LoginAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");

        switch (arrayAction[0]) {
            case "PRODUCTOS":
                out.print(new ProductoAction().execute(request, response));
                break;
            case "LOGIN":
                out.print(new LoginAction().execute(request, response));
                break;
//            case "CART":
//                out.print(new CartAction().execute(request, response));
//                break;
        }
    }


}