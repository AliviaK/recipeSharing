package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeIngredient;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeIngredientDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(RecipeIngredient.class);
    }

    /**
     * Verifies a recipe is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        RecipeIngredient retrievedRecipe = (RecipeIngredient) genericDao.getById(3);
        assertNotNull(retrievedRecipe);
        assertEquals("1 cup Coconut Oil", retrievedRecipe.getIngredient());
    }

    /**
     * Verifies all recipes are returned
     */
    @Test
    void getAllSuccess() {
        List<RecipeIngredient> recipes = genericDao.getAll();
        assertEquals(3, recipes.size());
    }

    /**
     * Verifies all recipes are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<RecipeIngredient> recipes = genericDao.getByPropertyLike("ingredient", "o", "RecipeIngredient");
        assertEquals(3, recipes.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newIngredient = "Butterscotch";
        RecipeIngredient recipeIngredientToUpdate = (RecipeIngredient) genericDao.getById(2);
        recipeIngredientToUpdate.setIngredient(newIngredient);
        genericDao.saveOrUpdate(recipeIngredientToUpdate);
        RecipeIngredient retrievedRecipeIngredient = (RecipeIngredient) genericDao.getById(2);
        assertEquals(newIngredient, retrievedRecipeIngredient.getIngredient());
    }

    @Test
    void insertSuccess() {
        GenericDao recipeDao = new GenericDao(Recipe.class);
        Recipe recipe = (Recipe) recipeDao.getById(2);

        RecipeIngredient recipeIngredientToAdd = new RecipeIngredient(recipe, "Honey");
        recipe.addRecipeIngredient(recipeIngredientToAdd);

        int id = genericDao.insert(recipeIngredientToAdd);
        assertNotEquals(0, id);
        RecipeIngredient insertedRecipeIngredient = (RecipeIngredient) genericDao.getById(id);
        assertEquals(recipeIngredientToAdd, insertedRecipeIngredient);
        assertNotNull(insertedRecipeIngredient.getRecipe());
        assertEquals("Mini Pie", insertedRecipeIngredient.getRecipe().getName());
    }

    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    }
}