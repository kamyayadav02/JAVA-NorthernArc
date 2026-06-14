package dao;

import entity.Book;

import java.util.Collection;

public interface BookDao {
    public int save(Book book);
    public Book findById(int id);
    public void deleteById(int id);
    public void updateById(int id,Book book);
    public void deleteAll();
    public Collection<Book> findAll();
    public Collection<Book> findByAuthor(String Author);
    public Collection<Book> findByTitle(String Title);
    public Collection<Book> findByPublisher(String Publisher);
    public Collection<Book> findSortedByTitleAsc();
    public Collection<Book> findSortedByTitleDesc();
    public Collection<Book> findByTitleAndPublisher(String title,String publisher);

}