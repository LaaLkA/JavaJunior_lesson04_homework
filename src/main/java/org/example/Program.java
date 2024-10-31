package org.example;


import org.example.Models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        Configuration cfg = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class);

        try(SessionFactory sessionFactory = cfg.buildSessionFactory()) {
            //записываем данные
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            for (int i = 0; i < 10; i++) {
                Course course = Course.create();
                session.save(course);
            }

            System.out.println("Course created");
            session.getTransaction().commit();

            // считываем и выводим в консоль данные
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            ArrayList<Course> retrievedCourses = new ArrayList<>();
            System.out.println("Retrieved courses from DB:");
            for (int i = 1; i <= 10; i++) {
                Course course = session.get(Course.class, i);
                System.out.println(course);
                retrievedCourses.add(course);
            }
            session.getTransaction().commit();

            // Обновление данных
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            for (Course course : retrievedCourses) {
                course.setTitle("Изменили название");
                course.setDuration(0.1);
                System.out.println("Изменили - " + course);
                session.update(course);
            }
            session.getTransaction().commit();
            System.out.println("Course updated");


            // Удаляем всё
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            for (Course course : retrievedCourses) {
                session.delete(course);
            }
            session.getTransaction().commit();
            System.out.println("Courses deleted");

        }


    }
}