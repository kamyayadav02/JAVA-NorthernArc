

public class Person {
    String fname;
    public String getFname(){
        return fname;
    }
    String lname;
    public String getLname(){
        return lname;
    }

    int age;
    public int getAge(){
        return age;
    }
    public void setFname (String f){
        this.fname=f;
    }
    public void setLname( String l){
        this.lname=l;
    }
    public void setAge(int a){
        this.age=a;
    }

  
    public void eat(){
        System.out.println(fname + lname + " eats.");
    }
    public void walk(){
        System.out.println(fname + lname + " walks.");
    }
    public void talk(){
        System.out.println(fname + lname+ " talks.");
    } 
    public void getDetails(){
        System.out.println("fname: " + this.fname + "lname: " + this.lname + "age: " + this.age);
    }
    public void showDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showDetails'");
    }
}
