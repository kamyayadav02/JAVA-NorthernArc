package dao;

import entity.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImplCollections implements BookDao{
    private List<Book> books=new ArrayList<>();
    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public Book findById(int id) {
        for(Book b:books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        books.removeIf(b -> b.getId() == id);

    }

    @Override
    public void updateById(int id, Book book) {
        for(Book b:books){
            if(b.getId()==id){
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                return;
            }
        }

    }

    @Override
    public void deleteAll() {
        books.clear();

    }

    @Override
    public Collection<Book> findAll() {
        return books;
    }
}
