package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * Gets all users.
     *
     * @return all users
     */
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        logger.info("Select sql statement: " + sql);
        return excecuteQuery(sql);
    }

    /**
     * Gets user by last name.
     *
     * @param lastName the last name
     * @return the users by last name
     */
    public List<User> getUsersByLastName(String lastName) {
        String sql = "SELECT * FROM user WHERE last_name like '%" + lastName + "%'";
        return excecuteQuery(sql);
    }

    /**
     * Gets users by first name.
     *
     * @param firstName the first name
     * @return the users by first name
     */
    public List<User> getUsersByFirstName(String firstName) {
        String sql = "SELECT * FROM user WHERE first_name like '%" + firstName + "%'";
        return excecuteQuery(sql);
    }

    private List<User> excecuteQuery(String sql) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("UserData SQL Error occurring: " + e);
        } catch (Exception e) {
            logger.error("UserData Error occurring: " + e);
        }
        return users;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setUserName(results.getString("user_name"));
        user.setDateOfBirth(results.getDate("date_of_birth").toLocalDate());
        user.setId(results.getInt("id"));
        return user;
    }

}