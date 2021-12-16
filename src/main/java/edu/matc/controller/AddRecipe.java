package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeIngredient;
import edu.matc.entity.RecipeStep;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * The type Add recipe which adds inserted recipe into database and adds to user, then is sent back to homepage
 */
@WebServlet(
        name = "add-recipe",
        urlPatterns = {"/add-recipe"}
)
public class AddRecipe extends HttpServlet {
    /**
     * The Recipe dao.
     */
    GenericDao recipeDao;
    /**
     * The Recipe step dao.
     */
    GenericDao recipeStepDao;
    /**
     * The Recipe ingredient dao.
     */
    GenericDao recipeIngredientDao;
    /**
     * The User dao.
     */
    GenericDao userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Recipe recipe = setRecipeDetails(req, session);

        String message = "recipe " + recipe.getName() + " added";
        logger.info(message);

        String url = "add-form";
        resp.sendRedirect(url);
        return;
    }

    /**
     * Sets details and submits recipe with ingredients and steps to database
     * @param req
     * @param session
     * @return recipe
     */
    private Recipe setRecipeDetails(HttpServletRequest req, HttpSession session) {
        userDao = DaoFactory.createDao(User.class);
        recipeDao = DaoFactory.createDao(Recipe.class);
        recipeStepDao = DaoFactory.createDao(RecipeStep.class);
        recipeIngredientDao = DaoFactory.createDao(RecipeIngredient.class);

        /** Get info from form to insert recipe */
        String name = req.getParameter("name");
        String notes = req.getParameter("notes");
        String publicCheck = req.getParameter("isPublic");
        Boolean isPublic = publicCheck != null && publicCheck.equals("on");
        String[] ingredients = req.getParameterValues("ingredient[]");
        String[] ingredientQuantities = req.getParameterValues("quantity[]");
        String[] stepOrders = req.getParameterValues("order[]");
        String[] recipeSteps = req.getParameterValues("direction[]");

        /** Get user from session */
        List<User> user = userDao.getByPropertyEqual("userName", (String) session.getAttribute("userName"));
        User userToInsert = user.get(0);

        /** Insert recipe */
        Recipe recipe = new Recipe(name, notes, isPublic, userToInsert);
        int recipeId = recipeDao.insert(recipe);

        /** Loop through ingredients and quantities and insert into database */
        for (int ingIndex = 0; ingIndex < ingredients.length; ingIndex++) {
            if (ingredients[ingIndex] != "" && ingredientQuantities[ingIndex] != "") {
                RecipeIngredient ing = new RecipeIngredient(recipe, ingredients[ingIndex], ingredientQuantities[ingIndex]);

                recipe.addRecipeIngredient(ing);
                recipeIngredientDao.insert(ing);
            }
        }

        /** Loop through steps and order and insert into database */
        for (int stepIndex = 0; stepIndex < recipeSteps.length; stepIndex++) {
            if (stepOrders[stepIndex] != "" && recipeSteps[stepIndex] != "") {
                RecipeStep step = new RecipeStep(Integer.parseInt(stepOrders[stepIndex]), recipeSteps[stepIndex], recipe);

                recipe.addRecipeStep(step);
                int stepID = recipeStepDao.insert(step);
                logger.info("step added to database: " + recipeStepDao.getById(stepID));
            }
        }
        return recipe;
    }
}
