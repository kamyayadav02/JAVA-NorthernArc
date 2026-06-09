package dao;
import Entity.Book;
public interface BookDao {
    public void save(Book book);
    public Book findById(int id);
    public void deleteById(int id);
    public void update(Book book);
    public void deleteAll();
    public Iterable<Book> findAll();
    public Iterable<Book> findByAuthor(String Author);
    public Iterable<Book> findByTitle(String Title);
    public Iterable<Book> sortByTitleAsc();
    public Iterable<Book> sortByTitleDesc();

}
