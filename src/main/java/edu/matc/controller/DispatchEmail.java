package edu.matc.controller;

import edu.matc.entity.Party;
import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import edu.matc.javamail.JavaMailSender;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


/**
 * The type Dispatch email, which receives information about a party and notifies invited users through an email
 */
@WebServlet(
        name = "dispatch-email",
        urlPatterns = {"/dispatch-email"}
)
public class DispatchEmail extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Sender.
     */
    JavaMailSender sender;
    /**
     * The Session.
     */
    HttpSession session;
    /**
     * The Party dao.
     */
    GenericDao partyDao;
    /**
     * The Recipe dao.
     */
    GenericDao recipeDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        sender = new JavaMailSender();
        User user = (User) session.getAttribute("userSesh");
        String partyUrl = "https://recipesharing-env-1.eba-qbeexdvh.us-east-2.elasticbeanstalk.com/view-party?submit=";

        /**
         * Call methods to insert party and email invitees
         */
        Party party = prepareParty(req.getParameter("recipeName"), req.getParameter("details"), user);

        /**
         * Prepare email and party contents
         */
        String toEmail = req.getParameter("email");
        String subject = "You're Invited! A Party Starring: " + req.getParameter("recipeName");
        String emailContent = "RecipesAmongFriends Here! Your friend " + user.getUserName() + " AKA "
                + user.getFirstName() + " says: " + req.getParameter("details") + "\n" + partyUrl + party.getId()
                + "\n -Make this recipe and let your friends know what you think!";
        String emailSent = sender.sendEmail(toEmail, subject, emailContent);

        session.setAttribute("emailSent", emailSent);
        session.setAttribute("party", party);

        String url = "send-invite";
        resp.sendRedirect(url);
        return;
    }

    /**
     * Creates data to insert new party object to the database
     * @param recipeName
     * @param partyDetails
     * @return
     */
    private Party prepareParty(String recipeName, String partyDetails, User user) {
        partyDao = DaoFactory.createDao(Party.class);
        recipeDao = DaoFactory.createDao(Recipe.class);
        List<Recipe> recipes = recipeDao.getByPropertyLike("name", recipeName);

        Party newParty = new Party(user, recipes.get(0), partyDetails);
        int id = partyDao.insert(newParty);
        logger.info("party added to database: " + partyDao.getById(id));
        return newParty;
    }
}
