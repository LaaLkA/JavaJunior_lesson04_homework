package org.example.Models;

import jakarta.persistence.*;

import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {

    private static final String[] NAMES_COURSES = new String[]
            {"Java интенсив", "Java для начинающих", "Java для продвинутых", "Java для Pro","Не курс, а поток мысли"};
    private static final Random RANDOM = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private double duration;

    public Course() {}

    public Course(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create(){
        return new Course(NAMES_COURSES[RANDOM.nextInt(NAMES_COURSES.length)],
                Math.round(RANDOM.nextDouble(4.1, 7.2) * 10D) / 10D );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Название курса: " + title + ' ' +
                ", Длительность курса (в часах): " + duration +
                '}';
    }
}
