package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "courseName")
        private String courseName;

        @Column(name = "courseCredit")
        private int courseCredit;

        @Column(name = "courseType")
        private String courseType;

        @ManyToMany(mappedBy = "courses")
        private Set<Student> students = new HashSet<>();

        // Constructors
        public Course() {
        }

        public Course(String courseName, int courseCredit, String courseType) {
                this.courseName = courseName;
                this.courseCredit = courseCredit;
                this.courseType = courseType;
        }

        // Getters and setters
        public int getId() {
                return id;
        }

        public String getCourseName() {
                return courseName;
        }

        public void setCourseName(String courseName) {
                this.courseName = courseName;
        }

        public int getCourseCredit() {
                return courseCredit;
        }

        public void setCourseCredit(int courseCredit) {
                this.courseCredit = courseCredit;
        }

        public String getCourseType() {
                return courseType;
        }

        public void setCourseType(String courseType) {
                this.courseType = courseType;
        }

        public Set<Student> getStudents() {
                return students;
        }

        public void setStudents(Set<Student> students) {
                this.students = students;
        }
}
