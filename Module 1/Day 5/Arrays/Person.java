package arraysDemo;

public class Person implements Comparable<Person> {
    private String fname;
    private String lname;
    private int age;

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }
    public String toString(){
        return fname+ " " + lname+ " " +age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//compare by age
//    @Override
//    public int compareTo(Person o) {
//        return o.age-this.age;   //descending order
//    }

//compare by fname
//    @Override
//    public int compareTo(Person other) {
//        System.out.println("Comparing" + this.fname + "and" + other.fname);
//        return this.fname.compareTo(other.fname);   //ascending order
//    }
//compare by lname, if same lnmae then it check fname
    @Override
    public int compareTo(Person other) {
        System.out.println("Comparing" + this.lname + "and" + other.lname);
        return this.lname.compareTo(other.lname);   //ascending order
    }


}
