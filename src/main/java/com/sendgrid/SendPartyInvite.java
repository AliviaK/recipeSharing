package com.sendgrid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Recipe;
import edu.matc.entity.RecipeIngredient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class SendPartyInvite {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public void sendInvite() {

        Client client = ClientBuilder.newClient();
        // TODO read in uri from properties file

        // WebTarget target =
        //       client.target("https://api.sendgrid.com/v3/mail/send");
        // String response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(), String.class);

    }
}