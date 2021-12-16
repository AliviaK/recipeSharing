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

/**
 * The type Recipe dao test.
 */
class RecipeDaoTest {

    /**
     * The Recipe dao.
     */
    GenericDao recipeDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        recipeDao = DaoFactory.createDao(Recipe.class);
    }

    /**
     * Verifies a recipe is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Recipe retrievedRecipe = (Recipe) recipeDao.getById(3);
        assertNotNull(retrievedRecipe);
        assertEquals("Flaky almond dessert croissant", retrievedRecipe.getNotes());
    }

    /**
     * Verifies all recipes are returned
     */
    @Test
    void getAllSuccess() {
        List<Recipe> recipes = recipeDao.getAll();
        assertEquals(4, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Recipe> recipes = recipeDao.getByPropertyLike("name", "br", "Recipe");
        assertEquals(1, recipes.size());
    }

    /**
     * Save or update success.
     */
    @Test
    void saveOrUpdateSuccess() {
        String newName = "Cake";
        Recipe recipeToUpdate = (Recipe) recipeDao.getById(2);
        recipeToUpdate.setName(newName);
        recipeDao.saveOrUpdate(recipeToUpdate);
        Recipe retrievedRecipe = (Recipe) recipeDao.getById(2);
        assertEquals(newName, retrievedRecipe.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(5);

        Recipe recipeToAdd = new Recipe("Brownies", "Delicious fudge brownies", true, user);
        user.addRecipe(recipeToAdd);

        int id = recipeDao.insert(recipeToAdd);
        assertNotEquals(0, id);
        Recipe insertedRecipe = (Recipe) recipeDao.getById(id);
        assertEquals(recipeToAdd, insertedRecipe);
        assertNotNull(insertedRecipe.getUser());
        assertEquals("Shirley", insertedRecipe.getUser().getFirstName());
    }

    /**
     * Delete recipe if not in use for party
     */
    @Test
    void deleteSuccess() {
        Recipe recipe = (Recipe) recipeDao.getById(4);
        GenericDao<RecipeIngredient> ingDao = DaoFactory.createDao(RecipeIngredient.class);

        logger.info("Ingredients before recipe delete: " + recipe.getRecipeIngredients());

        recipeDao.delete(recipe);
        assertNull(recipeDao.getById(4));
        assertNull(ingDao.getById(6));
    }
}