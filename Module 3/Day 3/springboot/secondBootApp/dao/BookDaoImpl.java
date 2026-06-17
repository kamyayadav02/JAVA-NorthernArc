package com.northernArc.secondbootapp.Dao;

import com.northernArc.secondbootapp.model.Book;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookDaoImpl implements BookDao {

    Map<Integer,Book> books;

    @PostConstruct
    public void init(){
        System.out.println("Initialising rows.");
        books=new HashMap<>();
        books.put(1,new Book(1,"Hamlet","William Shakespeare","New York Times"));
        books.put(2, new Book(2, "Harry Potter", "J.K. Rowling", "Bloomsbury"));
        books.put(3, new Book(3, "The Hobbit", "J.R.R. Tolkien", "Allen & Unwin"));
        books.put(4, new Book(4, "The Alchemist", "Paulo Coelho", "HarperCollins"));
        books.put(5, new Book(5, "The Kite Runner", "Khaled Hosseini", "Riverhead Books"));
    }

    @Override
    public int save(Book book) {
        books.put(book.getId(),book);
        return  0;
    }

    @Override
    public void deleteById(int id) {
        books.remove(id);

    }

    @Override
    public void updateById(int id, Book book) {
        Book book1=books.get(id);
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());

    }

    @Override
    public Book findById(int id) {
        return books.get(id);
    }

    @Override
    public Map<Integer, Book> findAll() {
        return books;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroying books.");
        books.clear();
    }
}
