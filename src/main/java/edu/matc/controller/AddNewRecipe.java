package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeIngredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewRecipe", urlPatterns = { "/addNewRecipe" } )
public class AddNewRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Recipe recipe = new Recipe();
        recipe.setName(req.getParameter("name"));
        recipe.setNotes(req.getParameter("notes"));

        /** Maybe make ingredient name and amount one long varchar instead of separate columns? */
        String ingredients[] = req.getParameterValues("recipeIngredient");
        for (String ing : ingredients) {
            RecipeIngredient ingredient = new RecipeIngredient();
            ingredient.setRecipe(recipe);
            ingredient.setIngredient(ing);
        }
        String amounts[] = req.getParameterValues("amount");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {}

}
