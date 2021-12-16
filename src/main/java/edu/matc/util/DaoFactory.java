package edu.matc.util;


import edu.matc.persistence.GenericDao;


/**
 * The type Dao factory which instantiates a new generic dao with a class type
 */
public class DaoFactory {

    private DaoFactory() {

    }

    /**
     * Create dao generic dao.
     *
     * @param type the type
     * @return the generic dao
     */
    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}