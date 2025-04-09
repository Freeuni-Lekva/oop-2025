package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "idNumber", nullable = false)
        private String idNumber;

        @Column(name = "firstName")
        private String firstName;

        @Column(name = "lastName")
        private String lastName;

        @Column(name = "registrationDate")
        @Temporal(TemporalType.DATE)
        private Date registrationDate;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "student_courses",
                joinColumns = { @JoinColumn(name = "student_id") },
                inverseJoinColumns = { @JoinColumn(name = "course_id") }
        )
        private Set<Course> courses = new HashSet<>();

        // Constructors
        public Student() {
        }

        public Student(String idNumber, String firstName, String lastName, Date registrationDate) {
                this.idNumber = idNumber;
                this.firstName = firstName;
                this.lastName = lastName;
                this.registrationDate = registrationDate;
        }

        // Getters and setters
        public int getId() {
                return id;
        }

        public String getIdNumber() {
                return idNumber;
        }

        public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public Date getRegistrationDate() {
                return registrationDate;
        }

        public void setRegistrationDate(Date registrationDate) {
                this.registrationDate = registrationDate;
        }

        public Set<Course> getCourses() {
                return courses;
        }

        public void setCourses(Set<Course> courses) {
                this.courses = courses;
        }
}

