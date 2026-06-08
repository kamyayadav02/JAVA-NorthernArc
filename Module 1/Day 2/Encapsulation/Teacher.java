public class Teacher {
    private String name;
    public String getName(){
        return name;
    }
    private String subject;
    public String getSubject(){
        return subject;
    }
    private int experience;
    public int getExperience(){
        return experience;
    }
    public void setName(String n){
        this.name=n;
    }
    public void setSubject(String s){
        this.subject=s;
    }
    public void setExperience(int e){
        this.experience=e;
    }
    public Teacher(String name,String subject, int experience){
        this.name=name;
        this.subject=subject;
        this.experience=experience;

    }
    public void teach(){
        System.out.println(this.name + "teaches" + this.subject + "and has experience of" + this.experience);
    }
    public void getDetails(){
        System.out.println("name:" + this.name + "subject:" + this.subject + "experience: " + this.experience);
    }
    
}
