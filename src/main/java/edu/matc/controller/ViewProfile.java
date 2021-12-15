package edu.matc.controller;


import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/viewProfile"}
)
public class ViewProfile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = DaoFactory.createDao(User.class);
        HttpSession session = req.getSession();

        List<User> userToSend = userDao.getByPropertyEqual("userName", (String) session.getAttribute("userName"));
        req.setAttribute("user", userToSend.get(0));
        logger.debug(userToSend.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewProfile.jsp");
        dispatcher.forward(req, resp);
    }
}
