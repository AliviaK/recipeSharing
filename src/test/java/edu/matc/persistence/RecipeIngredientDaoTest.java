package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeIngredient;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeIngredientDaoTest {

    GenericDao ingredientDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        ingredientDao = DaoFactory.createDao(RecipeIngredient.class);
    }

    /**
     * Verifies a recipe is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        RecipeIngredient retrievedRecipe = (RecipeIngredient) ingredientDao.getById(3);
        assertNotNull(retrievedRecipe);
        assertEquals("Coconut Oil", retrievedRecipe.getIngredient());
    }

    /**
     * Verifies all recipes are returned
     */
    @Test
    void getAllSuccess() {
        List<RecipeIngredient> recipes = ingredientDao.getAll();
        assertEquals(6, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<RecipeIngredient> recipes = ingredientDao.getByPropertyLike("ingredient", "o", "RecipeIngredient");
        assertEquals(6, recipes.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newIngredient = "Butterscotch";
        RecipeIngredient recipeIngredientToUpdate = (RecipeIngredient) ingredientDao.getById(2);
        recipeIngredientToUpdate.setIngredient(newIngredient);
        ingredientDao.saveOrUpdate(recipeIngredientToUpdate);
        RecipeIngredient retrievedRecipeIngredient = (RecipeIngredient) ingredientDao.getById(2);
        assertEquals(newIngredient, retrievedRecipeIngredient.getIngredient());
    }

    @Test
    void insertSuccess() {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = (Recipe) recipeDao.getById(2);

        RecipeIngredient recipeIngredientToAdd = new RecipeIngredient(recipe, "Honey", "2 cups");
        recipe.addRecipeIngredient(recipeIngredientToAdd);

        int id = ingredientDao.insert(recipeIngredientToAdd);
        assertNotEquals(0, id);
        RecipeIngredient insertedRecipeIngredient = (RecipeIngredient) ingredientDao.getById(id);
        assertNotNull(insertedRecipeIngredient.getRecipe());
        assertEquals("Mini Pie", insertedRecipeIngredient.getRecipe().getName());
    }

    @Test
    void deleteSuccess() {
        RecipeIngredient ing = (RecipeIngredient) ingredientDao.getById(1);
        ingredientDao.delete(ing);
        assertNull(ingredientDao.getById(1));
        logger.info(ingredientDao.getById(1));
    }
}