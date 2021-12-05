package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The type Recipe ingredient.
 */
@Entity(name = "RecipeStep")
@Table(name = "recipe_step")
public class RecipeStep implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "order_number")
    private int orderNumber;

    private String direction;

    @ManyToOne
    private Recipe recipe;

    /**
     * Instantiates a new Recipe step.
     */
    public RecipeStep() {
    }

    /**
     * Instantiates a new Recipe step.
     *
     * @param orderNumber     the order number
     * @param direction the direction
     * @param recipe    the recipe
     */
    public RecipeStep(int orderNumber, String direction, Recipe recipe) {
        this.orderNumber = orderNumber;
        this.direction = direction;
        this.recipe = recipe;
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
     * Gets order number.
     *
     * @return the order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets order number.
     *
     * @param orderNumber the order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets direction.
     *
     * @param direction the direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
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

    @Override
    public String toString() {
        return "RecipeStep{" +
                "id=" + id +
                ", order number=" + orderNumber +
                ", direction='" + direction + '\'' +
                ", recipe=" + recipe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeStep that = (RecipeStep) o;
        return id == that.id && orderNumber == that.orderNumber && Objects.equals(direction, that.direction) && Objects.equals(recipe, that.recipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNumber, direction, recipe);
    }
}