package upcast;

public class Student {
    String course;
    public Student(String fname, String lname, String course){
        super ();
        this.course=course;
    }

    public String getCourse() {

        return course;
    }
    public String setCourse(String course){
        this.course=course;
        return course;
    }
}
