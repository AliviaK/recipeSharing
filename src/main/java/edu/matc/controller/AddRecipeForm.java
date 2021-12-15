package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The AddRecipeForm is a servlet that forwards to the add recipe jsp displaying a message of successful recipe addition
 * @author Alivia Kleinfeldt
 */
@WebServlet(
        name = "add-form",
        urlPatterns = { "/add-form" }
)
public class AddRecipeForm extends HttpServlet {

    /**
     *  Handles HTTP GET requests.
     *
     * @param  request                   the HttpServletRequest object
     * @param  response                   the HttpServletResponse object
     * @exception  ServletException  if there is a Servlet failure
     * @exception  IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/addRecipe.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
