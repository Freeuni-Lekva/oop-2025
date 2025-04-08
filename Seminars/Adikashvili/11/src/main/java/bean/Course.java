package bean;

public class Course {

    private int id;
    private int course_id;
    private String course_name;
    private int course_credit;
    private String course_type;

    public Course(int id, int course_id, String course_name, int course_credit, String course_type) {
        this.id = id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_credit = course_credit;
        this.course_type = course_type;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_credit=" + course_credit +
                ", course_type='" + course_type + '\'' +
                '}' + "\n";
    }
}
