package edu.matc.controller;

import edu.matc.auth.Keys;
import edu.matc.entity.Recipe;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.text.*;
import java.util.*;

/**
 * The ApplicationStartup class loads the context when the application
 * is first run. An object is created and added to the context
 * as well.
 * @author Alivia Kleinfeldt
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/recipes-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {
    Properties properties;
    String CLIENT_ID;
    String CLIENT_SECRET;
    String OAUTH_URL;
    String LOGIN_URL;
    String REDIRECT_URL;
    String REGION;
    String POOL_ID;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Loads the properties for project and adds the properties and a new
     * object to the servlet context
     * @throws ServletException if an error occurs with the servlet
     */
    public void init() throws ServletException {
        ServletContext context = getServletConfig().getServletContext();
        Properties recipeProperties = loadProperties("/recipeSharing.properties");

        loadProperties();

        context.setAttribute("recipeSharingProperties", recipeProperties);
        context.setAttribute("CLIENT_ID", CLIENT_ID);
        context.setAttribute("CLIENT_SECRET", CLIENT_SECRET);
        context.setAttribute("OAUTH_URL", OAUTH_URL);
        context.setAttribute("LOGIN_URL", LOGIN_URL);
        context.setAttribute("REDIRECT_URL", REDIRECT_URL);
        context.setAttribute("REGION", REGION);
        context.setAttribute("POOL_ID", POOL_ID);


        /** Set list of recipes */
        List<Recipe> recipes = new ArrayList<>();
        context.setAttribute("recipeDirectory", recipes);
    }

    /**
     * Reads in the cognito props file and get/set the client id, secret, and required urls
     * for authenticating a user.
     */
    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            CLIENT_SECRET = properties.getProperty("client.secret");
            OAUTH_URL = properties.getProperty("oauthURL");
            LOGIN_URL = properties.getProperty("loginURL");
            REDIRECT_URL = properties.getProperty("redirectURL");
            REGION = properties.getProperty("region");
            POOL_ID = properties.getProperty("poolId");
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }
}