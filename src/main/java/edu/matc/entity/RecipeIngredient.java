package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The type Recipe ingredient.
 */
@Entity(name = "RecipeIngredient")
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private Recipe recipe;

    private String ingredient;

    private String amount;


    /**
     * Instantiates a new Recipe ingredient.
     */
    public RecipeIngredient() {}

    /**
     * Instantiates a new Recipe ingredient.
     *
     * @param recipe     the recipe
     * @param ingredient the ingredient
     */
    public RecipeIngredient(Recipe recipe, String ingredient, String amount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.amount = amount;
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


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
     * Gets ingredient.
     *
     * @return the ingredient
     */
    public String getIngredient() {
        return ingredient;
    }

    /**
     * Sets ingredient.
     *
     * @param ingredient the ingredient
     */
    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }


    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", ingredient='" + ingredient + '\'' +
                ", amount='" + amount + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return id == that.id && ingredient.equals(that.ingredient) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, amount);
    }
}
