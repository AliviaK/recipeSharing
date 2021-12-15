package edu.matc.controller;

import edu.matc.javamail.JavaMailSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        name = "dispatch-email",
        urlPatterns = {"/dispatch-email"}
)
public class DispatchEmail extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    JavaMailSender sender;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        sender = new JavaMailSender();
        String toEmail = "alivia.kleinfeldt@gmail.com";
        String subject = "Testing email sending";
        String emailContent = "dear goodness I hope this works";
        /** String toEmail = req.getParameter("email");
        String subject = req.getParameter("subject");
        String emailContent = req.getParameter("message"); */

        String emailSent = sender.sendEmail(toEmail, subject, emailContent);
        session.setAttribute("emailSent", emailSent);
        logger.info("Was email sent? " + emailSent);

        String url = "send-invite";
        resp.sendRedirect(url);
        return;
    }
}
