package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(4);
        assertNotNull(retrievedUser);
        assertEquals("Abed", retrievedUser.getFirstName());
    }

    /**
     * Verifies all users are returned
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verifies all users are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("lastName", "ben");
        assertEquals(1, users.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newLastName = "Starburns";
        User userToUpdate = dao.getById(3);
        userToUpdate.setLastName(newLastName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    @Test
    void insertSuccess() {
        User userToAdd = new User("Pierce", "Hawthorne","phawthore", "phawthorne@greendalecollege.edu");
        int id = dao.insert(userToAdd);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("Pierce", insertedUser.getFirstName());
    }

    @Test
    void insertWithRecipeSuccess() {
        User userToAdd = new User("Craig", "Pelton","cpelton", "cpelton@greendalecollege.edu");

        String recipeName = "Chocolate chip cookies";
        String recipeNote = "Delicious";
        Recipe recipe = new Recipe(recipeName, recipeNote, true, userToAdd);

        userToAdd.addRecipe(recipe);

        int id = dao.insert(userToAdd);

        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals(1, insertedUser.getRecipes().size());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }
}