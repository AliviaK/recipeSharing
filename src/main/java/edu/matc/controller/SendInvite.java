package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Routes back to viewParties with confirmation message that email was sent
 * @author Alivia Kleinfeldt
 */
@WebServlet(
        name = "send-invite",
        urlPatterns = { "/send-invite" }
)
public class SendInvite extends HttpServlet {

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
        String url = "/index.jsp";

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
