package edu.matc.persistence;

import edu.matc.entity.Party;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PartyDaoTest {
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        genericDao = new GenericDao(Party.class);
    }

    /**
     * Verifies a Party is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        Party retrievedParty = (Party) genericDao.getById(3);
        assertNotNull(retrievedParty);
        assertEquals("Baking brownies", retrievedParty.getDetails());
    }

    /**
     * Verifies all Parties are returned
     */
    @Test
    void getAllSuccess() {
        List<Party> parties = genericDao.getAll();
        assertEquals(3, parties.size());
    }

    /**
     * Verifies all parties are correctly returned based on criteria
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Party> parties = genericDao.getByPropertyLike("details", "b", "Party");
        assertEquals(3, parties.size());
    }

    @Test
    void saveOrUpdateSuccess() {
        String newDetails = "Baking a cake";
        Party partyToUpdate = (Party) genericDao.getById(2);
        partyToUpdate.setDetails(newDetails);
        genericDao.saveOrUpdate(partyToUpdate);
        Party retrievedParty = (Party) genericDao.getById(2);
        assertEquals(newDetails, retrievedParty.getDetails());
    }

    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        GenericDao recipeDao = new GenericDao(Recipe.class);
        User user = (User) userDao.getById(5);
        Recipe recipe = (Recipe) recipeDao.getById(3);
        LocalDateTime date = LocalDateTime.of(2020, 04, 20, 20, 12);

        Party partyToAdd = new Party(user, recipe, date, "Baking muffins");
        user.addParty(partyToAdd);
        recipe.addParty(partyToAdd);

        int id = genericDao.insert(partyToAdd);
        assertNotEquals(0, id);
        Party insertedParty = (Party) genericDao.getById(id);
        assertEquals(partyToAdd, insertedParty);
        assertNotNull(insertedParty.getUser());
        assertEquals("Shirley", insertedParty.getUser().getFirstName());
    }

    @Test
    void insertWithAttendeesTest() {

    }

    /** TODO Delete user
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1));
        assertNull(genericDao.getById(1));
    } */
}
