package com.lukesmvc.services;

import com.lukesmvc.model.Person;
import com.lukesmvc.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lyaegel on 08/20/2019
 */
@Service
public class PersonServiceImpl {

    public void printVersion(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            String sql = "select version()";

            String result = (String) session.createNativeQuery(sql).getSingleResult();
            System.out.println(result);

            session.getTransaction().commit();
            session.close();

        }
    }

    public void printList(){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();

            String hql = "FROM Person p WHERE p.firstName = :firstName";
            Query query = session.createQuery(hql, Person.class);
            query.setParameter("firstName", "Luke");
            List results = query.getResultList();

            String hql2 = "FROM Person";

            List<Person> results2 = session.createQuery(hql2, Person.class).list();

            session.getTransaction().commit();
            session.close();

        }
    }


}
