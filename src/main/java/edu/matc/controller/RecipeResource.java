package edu.matc.controller;

import edu.matc.entity.Recipe;
import edu.matc.persistence.GenericDao;
import edu.matc.util.DaoFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Path("/recipes")
public class RecipeResource {

    GenericDao dao = new GenericDao(Recipe.class);
    // The Java method will process HTTP GET requests
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> list() {

        GenericDao dao = DaoFactory.createDao(Recipe.class);
        return (List<Recipe>) dao.getAll();
    }

    /**
     * Gets specific record based on id
     *
     * @param id id of recipe being retrieved
     * @return status based on result of get
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Recipe recipe = (Recipe) dao.getById(id);
        if (recipe != null) {
            return Response.ok(recipe, MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Adds a recipe to the database from parameters
     *
     * @param recipe recipe to be added
     * @return response showing results of adding
     * @throws URISyntaxException Bad syntax
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Recipe recipe) throws URISyntaxException {
        int newRecipeId = dao.insert(recipe);
        URI uri = new URI("/recipes/" + newRecipeId);
        return Response.created(uri).build();
    }

    /**
     * updates a record
     *
     * @param id id of the recipe being updated
     * @param recipe new recipe information
     * @return status based on result of update
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response update(@PathParam("id") int id, Recipe recipe) {
        recipe.setId(id);
        dao.saveOrUpdate(recipe);

        Recipe updatedRecipe = (Recipe) dao.getById(id);

        if (recipe.equals(updatedRecipe)) {
            return Response.ok().build();
        } else {
            return Response.notModified().build();
        }
    }
}
