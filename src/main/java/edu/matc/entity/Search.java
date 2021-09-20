package edu.matc.entity;

import java.util.*;


/**
 * The Search class is a javabean object that holds information about a search
 * item
 * @author Alivia Kleinfeldt
 */
public class Search {
    private String searchType;
    private String searchTerm;
    private ArrayList<Recipe> results;
    private boolean recipesFound;

    /**
     * Constructs a new search object
     */
    public Search() {
        results = new ArrayList<Recipe>();
    }

    /**
     * Returns value of searchType which determines which search method to be
     * called in generating the sql query
     * @return the string representing the search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets new value of searchType
     * @param searchType the string to determine the database search method
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * Returns value of searchTerm
     * @return the term to be searched
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets new value of searchTerm
     * @param searchTerm the string to be evaluated
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Returns value of results
     * @return the one or more recipes matching search criteria
     */
    public ArrayList<Recipe> getResults() {
        return results;
    }

    /**
     * Sets new value of results
     * @param results the ArrayList of recipes searched
     */
    public void setResults(ArrayList<Recipe> results) {
        this.results = results;
    }

    /**
     * Returns value of recipesFound
     * @return the boolean representing whether the search matched any results
     */
    public boolean isRecipesFound() {
        return recipesFound;
    }

    /**
     * Sets new value of recipesFound
     * @param recipesFound the boolean representing found recipes
     */
    public void setRecipesFound(boolean recipesFound) {
        this.recipesFound = recipesFound;
    }

    /**
     * Adds searched recipe to array list
     * @param recipe the recipe to be added to the database
     */
    public void addFoundEmployee(Recipe recipe) {
        results.add(recipe);
    }
}