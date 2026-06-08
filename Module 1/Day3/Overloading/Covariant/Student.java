package covariant;

public class Student extends Person {
    private String course;
    public Student(String fname, String lname, String course){
        super(fname, lname);
        this.course=course;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course=course;
    }
    @Override
    public Student getDemo(){
        return new Student("kamya", "yadav", "Java");
    }
}
