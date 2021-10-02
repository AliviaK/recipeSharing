package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDaoTest {
    RecipeDao dao;
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new RecipeDao();
        genericDao = new GenericDao(Recipe.class);
    }

    /**
     * Verifies a recipe is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Recipe retrievedRecipe = (Recipe) genericDao.getById(3);
        assertNotNull(retrievedRecipe);
        assertEquals("Flaky almond dessert croissant", retrievedRecipe.getNotes());
    }

    /**
     * Verifies all recipes are returned
     */
    @Test
    void getAllSuccess() {
        List<Recipe> recipes = dao.getAll();
        assertEquals(3, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Recipe> recipes = dao.getByPropertyLike("name", "br");
        assertEquals(1, recipes.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newName = "Cake";
        Recipe recipeToUpdate = dao.getById(2);
        recipeToUpdate.setName(newName);
        dao.saveOrUpdate(recipeToUpdate);
        Recipe retrievedRecipe = dao.getById(2);
        assertEquals(newName, retrievedRecipe.getName());
    }

    @Test
    void insertSuccess() {
        UserDao userDao = new UserDao();
        User user = userDao.getById(5);

        Recipe recipeToAdd = new Recipe("Brownies", "Delicious fudge brownies", true, user);
        user.addRecipe(recipeToAdd);

        int id = dao.insert(recipeToAdd);
        assertNotEquals(0, id);
        Recipe insertedRecipe = dao.getById(id);
        assertEquals("Brownies", insertedRecipe.getName());
        assertNotNull(insertedRecipe.getUser());
        assertEquals("Shirley", insertedRecipe.getUser().getFirstName());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}