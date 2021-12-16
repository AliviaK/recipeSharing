package edu.matc.controller;

import edu.matc.entity.Recipe;
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
import java.util.List;

/**
 * The type Display recipe details which retrieves a recipe and forwards the recipe to a jsp for viewing of its details
 */
@WebServlet(
        urlPatterns = {"/display-recipe-details"}
)
public class DisplayRecipeDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao recipeDao = DaoFactory.createDao(Recipe.class);

        List<Recipe> recipeList = recipeDao.getByPropertyLike("name", req.getParameter("submit"));
        logger.info("recipe list: " + recipeList);
        req.setAttribute("recipe", recipeList.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayRecipe.jsp");
        dispatcher.forward(req, resp);
    }
}
