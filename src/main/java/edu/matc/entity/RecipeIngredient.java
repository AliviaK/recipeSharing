package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The type Recipe ingredient.
 */
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private Recipe recipe;

    private String name;

    private String measurement;

    /**
     * Instantiates a new RecipeIngredient
     */
    public RecipeIngredient() {}

    /**
     * Instantiates a new RecipeIngredient with params
     *
     * @param recipe
     * @param name
     * @param measurement
     */
    public RecipeIngredient(Recipe recipe, String name, String measurement) {
        this.recipe = recipe;
        this.name = name;
        this.measurement = measurement;
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
     * Gets measurement.
     *
     * @return the measurement
     */
    public String getMeasurement() {
        return measurement;
    }

    /**
     * Sets measurement.
     *
     * @param measurement the measurement
     */
    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", name='" + name + '\'' +
                ", measurement='" + measurement + '\'' +
                '}';
    }
}
