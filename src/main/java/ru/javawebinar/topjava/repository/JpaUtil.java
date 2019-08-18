package ru.javawebinar.topjava.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaUtil {

    @PersistenceContext
    private EntityManager em;

    //Hibernate 2nd level cache invalidation
    public void clear2ndLevelHibernateCache() {

        //Return the underlying provider object for the
        // EntityManager, if available. The result of this method is implementation specific.
        Session s = (Session) em.getDelegate();

        SessionFactory sf = s.getSessionFactory();
//        sf.evict(User.class);
//        sf.getCache().evictEntity(User.class, BaseEntity.START_SEQ);
//        sf.getCache().evictEntityRegion(User.class);

        //Evict data from all query regions.
        sf.getCache().evictAllRegions();
    }
}
