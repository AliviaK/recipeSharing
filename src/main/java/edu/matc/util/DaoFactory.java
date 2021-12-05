package edu.matc.util;


import edu.matc.persistence.GenericDao;


public class DaoFactory {

    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}