package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.util.PropertiesLoader;

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

    /**
     * Loads the properties for project4 and adds the properties and a new
     * employeeDirectory object to the servlet context
     * @throws ServletException if an error occurs with the servlet
     */
    public void init() throws ServletException {
        Properties properties = loadProperties("");
        ServletContext context = getServletConfig().getServletContext();


        /** Set list of recipes */
        List<Recipe> recipes = new ArrayList<>();
        context.setAttribute("employeeDirectory", recipes);
    }
}