package ObjectOperations;

public class Person {
    private String fname;
    private String lname;
    private int age;

    public Person(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getage() {
        return age;
    }

    public void setFname(String f) {
        this.fname = f;
    }

    public void setLname(String l) {
        this.lname = l;
    }

    public void setage(int a) {
        this.age = a;
    }
    @Override
    public boolean equals(Object o){
        Person p1=(Person)o;
        return this.fname.equalsIgnoreCase(p1.fname) && this.lname.equalsIgnoreCase(p1.lname);
    }
    @Override
    public int hashCode(){
        return fname.hashCode() + lname.hashCode();
    }
    @Override
    public String toString(){
        return "fname=" + fname + ", lname= " + lname + ",age= " + age;
    }
}
