package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        urlPatterns = {"/searchRecipe"}
)

public class SearchRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = DaoFactory.createDao(Recipe.class);
        if (req.getParameter("submit").equals("searchRecipe")) {
            req.setAttribute("recipes", recipeDao.getByPropertyLike("name", req.getParameter("searchTermRecipe"), "Recipe"));
            logger.debug(req.getParameter("name"));
        } else {
            req.setAttribute("recipes", recipeDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}
