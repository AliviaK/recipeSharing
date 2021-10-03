package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Recipe.
 */
@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private User user;

    private String name;

    private String notes;

    @Column(name = "is_public")
    private boolean isPublic;



    /**
     * Instantiates a new Recipe.
     */
    public Recipe() {
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param name     the name
     * @param notes    the notes
     * @param isPublic the is public status
     * @param user     the user
     */
    public Recipe(String name, String notes, boolean isPublic, User user) {
        this.name = name;
        this.notes = notes;
        this.isPublic = isPublic;
        this.user = user;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Is public boolean.
     *
     * @return the boolean
     */
    public boolean isPublic() {
        return isPublic;
    }

    /**
     * Sets public.
     *
     * @param aPublic the a public
     */
    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && isPublic == recipe.isPublic && Objects.equals(user, recipe.user) && Objects.equals(name, recipe.name) && Objects.equals(notes, recipe.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, name, notes, isPublic);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", name='" + name + '\'' +
                ", notes='" + notes + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }
}
