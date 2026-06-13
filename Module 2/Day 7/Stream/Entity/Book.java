package entity;

public class Book {
    private int id;
    private String Author;
    private String Title;

    public Book(int id, String author, String title) {
        this.id = id;
        Author = author;
        Title = title;
    }
    public String toString(){
        return id+" "+ Author+""+ Title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
