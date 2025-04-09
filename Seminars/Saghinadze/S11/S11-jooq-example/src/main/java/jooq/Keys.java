/*
 * This file is generated by jOOQ.
 */
package jooq;


import jooq.tables.Courses;
import jooq.tables.StudentCourses;
import jooq.tables.Students;
import jooq.tables.records.CoursesRecord;
import jooq.tables.records.StudentCoursesRecord;
import jooq.tables.records.StudentsRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * students_db.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CoursesRecord> KEY_COURSES_PRIMARY = Internal.createUniqueKey(Courses.COURSES, DSL.name("KEY_courses_PRIMARY"), new TableField[] { Courses.COURSES.ID }, true);
    public static final UniqueKey<StudentCoursesRecord> KEY_STUDENT_COURSES_PRIMARY = Internal.createUniqueKey(StudentCourses.STUDENT_COURSES, DSL.name("KEY_student_courses_PRIMARY"), new TableField[] { StudentCourses.STUDENT_COURSES.STUDENT_ID, StudentCourses.STUDENT_COURSES.COURSE_ID }, true);
    public static final UniqueKey<StudentsRecord> KEY_STUDENTS_PRIMARY = Internal.createUniqueKey(Students.STUDENTS, DSL.name("KEY_students_PRIMARY"), new TableField[] { Students.STUDENTS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<StudentCoursesRecord, StudentsRecord> STUDENT_COURSES_IBFK_1 = Internal.createForeignKey(StudentCourses.STUDENT_COURSES, DSL.name("student_courses_ibfk_1"), new TableField[] { StudentCourses.STUDENT_COURSES.STUDENT_ID }, Keys.KEY_STUDENTS_PRIMARY, new TableField[] { Students.STUDENTS.ID }, true);
    public static final ForeignKey<StudentCoursesRecord, CoursesRecord> STUDENT_COURSES_IBFK_2 = Internal.createForeignKey(StudentCourses.STUDENT_COURSES, DSL.name("student_courses_ibfk_2"), new TableField[] { StudentCourses.STUDENT_COURSES.COURSE_ID }, Keys.KEY_COURSES_PRIMARY, new TableField[] { Courses.COURSES.ID }, true);
}
