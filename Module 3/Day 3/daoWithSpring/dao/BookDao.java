package dao;

import entity.Book;

import java.util.Collection;

public interface BookDao {
    public void save (Book book);
    public Book findById(int id);
    public void deleteById(int id);
    public void updateById(int id, Book book);
    public void deleteAll();
    public Collection<Book> findAll();
}
