package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "email_address")
    private String emailAddress;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();

    // TODO: Rename to parties hosting?
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Party> partiesHosting = new HashSet<>();


    /**
     * Instantiates a new User.
     */
    public User() {
    }


    /**
     * Instantiates a new User with only username and email provided.
     *
     * @param userName     the user name
     * @param emailAddress the email address
     */
    public User(String userName, String emailAddress) {
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName    the first name
     * @param userName     the username
     * @param emailAddress the email address
     */
    public User(String firstName, String userName, String emailAddress) {
        this.firstName = firstName;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName    the first name
     * @param lastName     the last name
     * @param userName     the username
     * @param emailAddress the email address
     */
    public User(String firstName, String lastName, String userName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
    }




    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username.
     *
     * @param userName the username
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * Gets email address.
     *
     * @return the email address
     */
    public String getEmailAddress() { return emailAddress; }

    /**
     * Sets email address.
     *
     * @param emailAddress the email address
     */
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    /**
     * Gets recipes.
     *
     * @return the recipes
     */
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets recipes.
     *
     * @param recipes the recipes
     */
    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Gets parties.
     *
     * @return the parties
     */
    public Set<Party> getPartiesHosting() {
        return partiesHosting;
    }

    /**
     * Sets parties.
     *
     * @param parties the parties
     */
    public void setPartiesHosting(Set<Party> parties) {
        this.partiesHosting = parties;
    }

    /**
     * Add recipe.
     *
     * @param recipe the recipe
     */
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setUser(this);
    }

    /**
     * Remove recipe.
     *
     * @param recipe the recipe
     */
    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        recipe.setUser(null);
    }

    /**
     * Add party.
     *
     * @param party the party
     */
    public void addParty(Party party) {
        partiesHosting.add(party);
        party.setUser(this);
    }

    /**
     * Remove party.
     *
     * @param party the party
     */
    public void removeParty(Party party) {
        partiesHosting.remove(party);
        party.setUser(null);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", userName= '" + userName + '\'' +
                ", id= '" + id + '\'' +
                ", emailAddress= '" + emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && userName.equals(user.userName) && emailAddress.equals(user.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, id, emailAddress);
    }
}