package Encapsulation;

public class BookMain {
    public static void main(String[] args) {
        Book b=new Book();
        b.setTitle("Harry Potter");
        b.setAuthor("JK Rowling");
        b.setPages(400);
        b.read();
        b.getSummary();

    }
}
