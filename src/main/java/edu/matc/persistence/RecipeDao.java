package edu.matc.persistence;

import edu.matc.entity.Recipe;
import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class RecipeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get recipe by id
     */
    public Recipe getById(int id) {
        Session session = sessionFactory.openSession();
        Recipe recipe = session.get( Recipe.class, id );
        session.close();
        return recipe;
    }

    /**
     * update recipe
     * @param recipe  User to be inserted or updated
     */
    public void saveOrUpdate(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(recipe);
        transaction.commit();
        session.close();
    }

    /**
     * update recipe
     * @param recipe  User to be inserted or updated
     */
    public int insert(Recipe recipe) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(recipe);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a recipe
     * @param recipe Recipe to be deleted
     */
    public void delete(Recipe recipe) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(recipe);
        transaction.commit();
        session.close();
    }


    /** Return a list of all recipes
     *
     * @return All recipes
     */
    public List<Recipe> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery( Recipe.class );
        Root<Recipe> root = query.from( Recipe.class );
        List<Recipe> recipes = session.createQuery( query ).getResultList();

        logger.debug("The list of recipes " + recipes);
        session.close();

        return recipes;
    }

    /**
     * Get user by property (exact match)
     */
    public List<Recipe> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for recipe with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery( Recipe.class );
        Root<Recipe> root = query.from( Recipe.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Recipe> recipes = session.createQuery( query ).getResultList();

        session.close();
        return recipes;
    }

    /**
     * Get recipe by property (like)
     */
    public List<Recipe> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for recipe with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Recipe> query = builder.createQuery( Recipe.class );
        Root<Recipe> root = query.from( Recipe.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<Recipe> recipes = session.createQuery( query ).getResultList();
        session.close();
        return recipes;
    }

}