package edu.matc.javamail;

import edu.matc.persistence.GenericDao;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * The type Java mail sender which sends an email notifying users of a Party invite with recipe information.
 * This resource was helpful in crafting this class with the App gmail account and SMTP server:
 * https://mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
 */
public class JavaMailSender implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Email props.
     */
    Properties emailProps;
    /**
     * The Pw props.
     */
    Properties pwProps;
    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Username.
     */
    String username;
    /**
     * The Password.
     */
    String password;

    /**
     * Send email string.
     *
     * @param toEmail      the to email
     * @param subject      the subject
     * @param emailContent the email content
     * @return the string
     */
    public String sendEmail(String toEmail, String subject, String emailContent) {
        emailProps = loadProperties("/javamail.properties");
        pwProps = loadProperties("/recipeSharing.properties");
        username = pwProps.getProperty("mail.smtp.username");
        password = pwProps.getProperty("mail.smtp.password");

        Session session = Session.getInstance(emailProps);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toEmail)
            );
            message.setSubject(subject);
            message.setText(emailContent);

            Transport.send(message, username, password);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Invites sent!";
    }
}
