package com.lukesmvc.utility;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by lyaegel on 08/20/2019
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                //Create Registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                //Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                //Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                //Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }catch (Exception e){
                e.printStackTrace();;
                if (registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return  sessionFactory;
    }

    public static void shutdown(){
        if(registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
