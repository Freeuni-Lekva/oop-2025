package bean;

import java.util.Date;

public class Student {

    private int id;

    private int student_id;

    private String idnumber;

    private String firstname;

    private String lastname;

    private Date register_date;

    public Student(int id,
                   int student_id,
                   String idnumber,
                   String firstname,
                   String lastname,
                   Date register_date) {
        this.id = id;
        this.student_id = student_id;
        this.idnumber = idnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.register_date = register_date;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", idnumber='" + idnumber + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", register_date=" + register_date +
                '}' + "\n";
    }
}
