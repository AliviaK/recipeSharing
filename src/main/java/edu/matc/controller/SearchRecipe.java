package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchRecipe extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        if (req.getParameter("submit").equals("searchLast")) {
            req.setAttribute("users", userDao.getByPropertyLike("lastName", req.getParameter("searchTerm"), "User"));
            logger.debug(req.getParameter("lastName"));
        } else if (req.getParameter("submit").equals("searchFirst")) {
            req.setAttribute("users", userDao.getByPropertyLike("firstName", req.getParameter("searchTerm"), "User"));
        } else {
            req.setAttribute("users", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}