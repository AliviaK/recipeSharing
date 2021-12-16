package edu.matc.persistence;

import edu.matc.entity.Party;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import edu.matc.util.DaoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        userDao = DaoFactory.createDao(User.class);
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) userDao.getById(4);
        assertNotNull(retrievedUser);
        assertEquals("Abed", retrievedUser.getFirstName());
    }

    /**
     * Verifies all users are returned
     */
    @Test
    void getAllSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verifies all users are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeLastNameSuccess() {
        List<User> users = userDao.getByPropertyLike("lastName", "ben", "User");
        assertEquals(1, users.size());
    }

    /**
     * Verifies all users are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeUserNameSuccess() {
        List<User> users = userDao.getByPropertyLike("userName", "jwing");
        assertEquals(1, users.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newLastName = "Starburns";
        User userToUpdate = (User) userDao.getById(3);
        userToUpdate.setLastName(newLastName);
        userDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) userDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    @Test
    void insertSuccess() {
        User userToAdd = new User("Pierce", "Hawthorne","phawthore", "phawthorne@greendalecollege.edu");
        int id = userDao.insert(userToAdd);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(userToAdd, insertedUser);
    }

    @Test
    void insertWithEmailUsernameSuccess() {
        User userToAdd = new User("TrinketAndBella", "tandb@greendalecollege.edu");
        int id = userDao.insert(userToAdd);
        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        System.out.println(insertedUser);
        assertEquals(userToAdd, insertedUser);
    }

    @Test
    void insertWithRecipeSuccess() {
        User userToAdd = new User("Craig", "Pelton","cpelton", "cpelton@greendalecollege.edu");

        String recipeName = "Chocolate chip cookies";
        String recipeNote = "Delicious";
        Recipe recipe = new Recipe(recipeName, recipeNote, true, userToAdd);

        userToAdd.addRecipe(recipe);

        int id = userDao.insert(userToAdd);

        assertNotEquals(0, id);
        User insertedUser = (User) userDao.getById(id);
        assertEquals(1, insertedUser.getRecipes().size());
    }

    @Test void insertWithPartyAttendingSuccess() {

    }

    /** Consider how to delete data w/cascades. DELETE ALL RECIPES? OR MAKE ID NULLABLE?
    @Test
    void deleteSuccess() {

        userDao.delete(userDao.getById(1));
        assertNull(userDao.getById(1));
    }
     */
}