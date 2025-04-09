package org.example;

import jooq.tables.Courses;
import jooq.tables.StudentCourses;
import jooq.tables.Students;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        // Database connection settings
        String url = "jdbc:mysql://localhost:3306/students_db";
        String username = "admin";
        String password = "admin";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);

            // Reference the generated tables
            Students s = Students.STUDENTS;
            Courses c = Courses.COURSES;
            StudentCourses sc = StudentCourses.STUDENT_COURSES;

            // Joining students, student_courses and courses with jOOQ's generated classes
            Result<Record> result = create.select()
                    .from(s)
                    .join(sc).on(s.ID.eq(sc.STUDENT_ID))
                    .join(c).on(c.ID.eq(sc.COURSE_ID))
                    .fetch();

            // Iterate over the results and print
            result.forEach(record -> {
                System.out.println("Student: "
                        + record.get(s.FIRSTNAME) + " "
                        + record.get(s.LASTNAME));
                System.out.println("ID Number: " + record.get(s.IDNUMBER));
                System.out.println("Registration Date: " + record.get(s.REGISTRATIONDATE));
                System.out.println("Course: " + record.get(c.COURSENAME) +
                        " | Credit: " + record.get(c.COURSECREDIT) +
                        " | Type: " + record.get(c.COURSETYPE));
                System.out.println("------------------------------");
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
