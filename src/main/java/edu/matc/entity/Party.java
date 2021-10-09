package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The type Recipe ingredient.
 */
@Entity(name = "Party")
@Table(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Recipe recipe;

    @Column(name = "party_date", columnDefinition="DATETIME")
    private LocalDateTime partyDate;

    private String details;

    /**
     * Instantiates a new Party.
     */
    public Party() {
    }

    /**
     * Instantiates a new Party.
     *
     * @param user      the user
     * @param recipe    the recipe
     * @param partyDate the party date
     * @param details   the details
     */
    public Party(User user, Recipe recipe, LocalDateTime partyDate, String details) {
        this.user = user;
        this.recipe = recipe;
        this.partyDate = partyDate;
        this.details = details;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets recipe.
     *
     * @return the recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * Sets recipe.
     *
     * @param recipe the recipe
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    /**
     * Gets party date.
     *
     * @return the party date
     */
    public LocalDateTime getPartyDate() {
        return partyDate;
    }

    /**
     * Sets party date.
     *
     * @param partyDate the party date
     */
    public void setPartyDate(LocalDateTime partyDate) {
        this.partyDate = partyDate;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets details.
     *
     * @param details the details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", user=" + user +
                ", recipe=" + recipe +
                ", partyDate=" + partyDate +
                ", details='" + details + '\'' +
                '}';
    }
}
