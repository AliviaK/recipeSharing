package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Recipe.
 */
@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe implements Serializable {

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

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RecipeIngredient> recipeIngredients = new HashSet<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RecipeStep> recipeSteps = new HashSet<>();

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Party> parties = new HashSet<>();


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

    /**
     * Gets recipe ingredients.
     *
     * @return the recipe ingredients
     */
    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    /**
     * Sets recipe ingredients.
     *
     * @param recipeIngredients the recipe ingredients
     */
    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    /**
     * Gets recipe steps.
     *
     * @return the recipe steps
     */
    public Set<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    /**
     * Sets recipe steps.
     *
     * @param recipeSteps the recipe steps
     */
    public void setRecipeSteps(Set<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    /**
     * Gets parties.
     *
     * @return the parties
     */
    public Set<Party> getParties() {
        return parties;
    }

    /**
     * Sets parties.
     *
     * @param parties the parties
     */
    public void setParties(Set<Party> parties) {
        this.parties = parties;
    }

    /**
     * Add recipe ingredient.
     *
     * @param recipeIngredient the recipe
     */
    public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.add(recipeIngredient);
        recipeIngredient.setRecipe(this);
    }

    /**
     * Remove recipe ingredient.
     *
     * @param recipeIngredient the recipe ingredient
     */
    public void removeRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredients.remove(recipeIngredient);
        recipeIngredient.setRecipe(null);
    }

    /**
     * Add recipe step.
     *
     * @param recipeStep the recipe step
     */
    public void addRecipeStep(RecipeStep recipeStep) {
        recipeSteps.add(recipeStep);
        recipeStep.setRecipe(this);
    }

    /**
     * Remove recipe step.
     *
     * @param recipeStep the recipe step
     */
    public void removeRecipeStep(RecipeStep recipeStep) {
        recipeSteps.remove(recipeStep);
        recipeStep.setRecipe(null);
    }

    /**
     * Add party.
     *
     * @param party the party
     */
    public void addParty(Party party) {
        parties.add(party);
        party.setRecipe(this);
    }

    /**
     * Remove party.
     *
     * @param party the recipe step
     */
    public void removeParty(Party party) {
        parties.remove(party);
        party.setRecipe(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id && isPublic == recipe.isPublic && Objects.equals(user, recipe.user) && Objects.equals(name, recipe.name) && Objects.equals(notes, recipe.notes) && Objects.equals(recipeIngredients, recipe.recipeIngredients) && Objects.equals(recipeSteps, recipe.recipeSteps) && Objects.equals(parties, recipe.parties);
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
