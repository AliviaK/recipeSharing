package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeStep;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeStepDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(RecipeStep.class);
    }

    /**
     * Verifies a recipe is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        RecipeStep retrievedRecipe = (RecipeStep) genericDao.getById(3);
        assertNotNull(retrievedRecipe);
        assertEquals("Add wet ingredients to dry", retrievedRecipe.getDirection());
    }

    /**
     * Verifies all recipes are returned
     */
    @Test
    void getAllSuccess() {
        List<RecipeStep> recipes = genericDao.getAll();
        assertEquals(5, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<RecipeStep> steps = genericDao.getByPropertyLike("direction", "mix", "RecipeStep");
        assertEquals(1, steps.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newDirection = "Butterscotch";
        RecipeStep recipeStepToUpdate = (RecipeStep) genericDao.getById(2);
        recipeStepToUpdate.setDirection(newDirection);
        genericDao.saveOrUpdate(recipeStepToUpdate);
        RecipeStep retrievedRecipeStep = (RecipeStep) genericDao.getById(2);
        assertEquals(newDirection, retrievedRecipeStep.getDirection());
    }

    @Test
    void insertSuccess() {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = (Recipe) recipeDao.getById(2);

        RecipeStep recipeStepToAdd = new RecipeStep(1, "Fold in chocolate chips", recipe);
        recipe.addRecipeStep(recipeStepToAdd);

        int id = genericDao.insert(recipeStepToAdd);
        assertNotEquals(0, id);
        RecipeStep insertedRecipeStep = (RecipeStep) genericDao.getById(id);
        assertNotNull(insertedRecipeStep.getRecipe());
        assertEquals("Mini Pie", insertedRecipeStep.getRecipe().getName());
    }

    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }
}