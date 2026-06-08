package Encapsulation;

public class Movie {
    private String title;
    public String getTitle(){
        return title;
    }
    private String director;
    public String getDirector(){
        return director;
    }
    private int releaseYear;
    public int getRealeaseYear(){
        return releaseYear;
    }
    public void setTitle(String t){
        this.title=t;
    }
    public void setDirector(String d){
        this.director=d;
    }
    public void setReleaseYear(int ry){
        this.releaseYear=ry;
    }
    public void play(){
        System.out.println(this.title + " was directed by " + this.director + " and was released on " + this.releaseYear);
    }
    public void getRating(){
        System.out.println(this.title + " was rated 5 stars. " );
    }
    public Movie(String title, String director, int releaseYear){
        this.title=title;
        this.director= director;
        this.releaseYear= releaseYear;
    }
}
