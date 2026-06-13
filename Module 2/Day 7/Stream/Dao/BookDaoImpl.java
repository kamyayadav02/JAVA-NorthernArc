package LoanDao;

import entity.Book;
import entity.Loan;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao{
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

    }

    @Override
    public void update(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
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
    public Iterable<Book> findByAuthor(String Author) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(Author)) {
                result.add(b);
            }
        }
        return result;
    }

    @Override
    public Iterable<Book> findByTitle(String Title) {
        List<Book> result = new ArrayList<>();
        for (Book b: books) {
            if (b.getTitle().equalsIgnoreCase(Title)) {
                result.add(b);
            }
        }
        return result;
    }
}
