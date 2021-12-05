package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

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
        List<Recipe> recipes = genericDao.getAll();
        assertEquals(3, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Recipe> recipes = genericDao.getByPropertyLike("name", "br", "Recipe");
        assertEquals(1, recipes.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newName = "Cake";
        Recipe recipeToUpdate = (Recipe) genericDao.getById(2);
        recipeToUpdate.setName(newName);
        genericDao.saveOrUpdate(recipeToUpdate);
        Recipe retrievedRecipe = (Recipe) genericDao.getById(2);
        assertEquals(newName, retrievedRecipe.getName());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(5);

        Recipe recipeToAdd = new Recipe("Brownies", "Delicious fudge brownies", true, user);
        user.addRecipe(recipeToAdd);

        int id = genericDao.insert(recipeToAdd);
        assertNotEquals(0, id);
        Recipe insertedRecipe = (Recipe) genericDao.getById(id);
        assertEquals(recipeToAdd, insertedRecipe);
        assertNotNull(insertedRecipe.getUser());
        assertEquals("Shirley", insertedRecipe.getUser().getFirstName());
    }

    /** Delete recipe and delete ingredients
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    } */
}