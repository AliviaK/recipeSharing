package edu.matc.persistence;

import edu.matc.entity.Party;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(User.class);
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) genericDao.getById(4);
        assertNotNull(retrievedUser);
        assertEquals("Abed", retrievedUser.getFirstName());
    }

    /**
     * Verifies all users are returned
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verifies all users are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("lastName", "ben", "User");
        assertEquals(1, users.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newLastName = "Starburns";
        User userToUpdate = (User) genericDao.getById(3);
        userToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) genericDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    @Test
    void insertSuccess() {
        User userToAdd = new User("Pierce", "Hawthorne","phawthore", "phawthorne@greendalecollege.edu");
        int id = genericDao.insert(userToAdd);
        assertNotEquals(0, id);
        User insertedUser = (User) genericDao.getById(id);
        assertEquals(userToAdd, insertedUser);
    }

    @Test
    void insertWithRecipeSuccess() {
        User userToAdd = new User("Craig", "Pelton","cpelton", "cpelton@greendalecollege.edu");

        String recipeName = "Chocolate chip cookies";
        String recipeNote = "Delicious";
        Recipe recipe = new Recipe(recipeName, recipeNote, true, userToAdd);

        userToAdd.addRecipe(recipe);

        int id = genericDao.insert(userToAdd);

        assertNotEquals(0, id);
        User insertedUser = (User) genericDao.getById(id);
        assertEquals(1, insertedUser.getRecipes().size());
    }

    @Test void insertWithPartyAttendingSuccess() {

    }

    /** @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    } */
}