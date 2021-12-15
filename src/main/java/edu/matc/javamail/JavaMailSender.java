package edu.matc.javamail;

import edu.matc.persistence.GenericDao;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailSender implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    Properties emailProps;
    Properties pwProps;
    GenericDao userDao;
    String username;
    String password;

    public String sendEmail(String toEmail, String subject, String emailContent) {
        emailProps = loadProperties("/javamail.properties");
        pwProps = loadProperties("/recipeSharing.properties");

        username = pwProps.getProperty("mail.smtp.username");
        password = pwProps.getProperty("mail.smtp.password");
        logger.info("before message try/catch");
        Session session = Session.getInstance(emailProps);
        try {
            logger.info("am i here ever?");
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject(subject);
            message.setText(emailContent);

            Transport.send(message, username, password);

            logger.info("we sent an email!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "This email was sent from the javamail sender!";
    }
}
