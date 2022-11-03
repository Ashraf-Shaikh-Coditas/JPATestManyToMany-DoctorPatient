package com.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProvider {
    public static EntityManagerFactory entityManagerFactory ;

    public static EntityManagerFactory getFactory() {
        if(entityManagerFactory==null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("ashraf");
        }

        return entityManagerFactory;
    }

}
