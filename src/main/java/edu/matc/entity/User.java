package edu.matc.entity;

import java.time.LocalDate;
import java.time.Period;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate dateOfBirth;
    private int id;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userName  the user name
     * @param id        the id
     * @param dateOfBirth the date of birth
     */
    public User(String firstName, String lastName, String userName, int id, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
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
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", id=" + id +
                ", age=" + getAge() +
                '}';
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    /**
     * Calculate age int.
     *
     * @return the age of user
     */
    public int getAge() {
        int age;
        LocalDate today = LocalDate.now();
        Period difference = Period.between(dateOfBirth, today);
        age = difference.getYears();
        return age;
    }
}