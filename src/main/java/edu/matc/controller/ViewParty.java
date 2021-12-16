package edu.matc.controller;

import edu.matc.entity.Party;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type View party which sends a party to view its information in the jsp it is rerouting to
 */
@WebServlet(
        name = "view-party",
        urlPatterns = { "/view-party" }
)
public class ViewParty extends HttpServlet {
    /**
     *  Handles HTTP GET requests.
     *
     * @param  request                   the HttpServletRequest object
     * @param  response                   the HttpServletResponse object
     * @exception ServletException  if there is a Servlet failure
     * @exception IOException       if there is an IO failure
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/recipeParty.jsp";
        /**
         * Get party ID from form and retrieve from dao to send to jsp
         */
        int partyId = Integer.parseInt(request.getParameter("submit"));
        GenericDao partyDao = DaoFactory.createDao(Party.class);
        Party party = (Party) partyDao.getById(partyId);

        request.setAttribute("party", party);

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
