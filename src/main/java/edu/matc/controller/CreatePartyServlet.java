package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * The type Create party servlet that sends the selected recipe to the create party form
 */
@WebServlet(
        name = "create-party",
        urlPatterns = {"/create-party"}
)
public class CreatePartyServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/createParty.jsp";
        GenericDao recipeDao = DaoFactory.createDao(Recipe.class);

        /**
         * Get recipe by name searched
         */
        List<Recipe> recipeList = recipeDao.getByPropertyLike("name", request.getParameter("submit"));
        request.setAttribute("recipe", recipeList.get(0));

        RequestDispatcher dispatcher = getServletContext().
                getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
