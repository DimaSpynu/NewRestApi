//package com.spynu.newrestapi.config;
//import org.hibernate.SessionFactory;
//import java.io.File;
//
////Специальный класс для инициализации Hibernate
//public class HibernateUtil {
//
//    //Фабрика для создания сессий(соединений)
//    private static final SessionFactory sessionFactory = initSessionFactory();
//
//    private static SessionFactory initSessionFactory() {
//        try {
//            return new org.hibernate.cfg.Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//    //Этот метода вызываем когда потребуется получить сессию SessionFactory
//    public static SessionFactory getSessionFactory() {
//        if(sessionFactory == null) {
//            initSessionFactory();
//        }
//        return sessionFactory;
//    }
//
//    //Закрываем сессию с помощью фабрики SessionFactory
//    public static void shutdown() {
//        getSessionFactory().close();
//    }
//}


