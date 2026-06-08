package Encapsulation;

public class Book {
    public static Book b;
    private String title;
    private String author;
    private int pages;
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getPages(){
        return pages;
    }
    public void setTitle(String n){
        this.title =n;
    }
    public void setAuthor(String au){
        this.author=au;
    }
    public void setPages( int pg){
        this.pages=pg;
    }
    public void read(){
        System.out.println( this.title + " is written by " + this.author + " and has " +  pages + " pages");
    }
    public void getSummary(){
        System.out.println(this.title + " has summary.");
    }

}