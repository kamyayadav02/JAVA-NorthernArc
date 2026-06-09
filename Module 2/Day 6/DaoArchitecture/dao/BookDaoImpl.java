package dao;

import Entity.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private List<Book> books = new ArrayList<>();

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) {
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
    public void update(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
                return;
            }
        }
    }

    @Override
    public void deleteAll() {
        books.clear();
    }

    @Override
    public Iterable<Book> findAll() {
        return books;
    }

    @Override
    public Iterable<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Iterable<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Iterable<Book> sortByTitleAsc() {
        List<Book> sorted = new ArrayList<>(books);
        Collections.sort(sorted, Comparator.comparing(Book::getTitle));
        return sorted;
    }

    @Override
    public Iterable<Book> sortByTitleDesc() {
        List<Book> sorted = new ArrayList<>(books);
        Collections.sort(sorted, Comparator.comparing(Book::getTitle).reversed());
        return sorted;
    }
}