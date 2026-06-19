package service;

import entity.Book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LibraryAnalytics {

    private Map<String, Book> books = new HashMap<>();

    public void loadBooks(List<String> records) {

        if (records == null) {
            return;
        }

        for (String record : records) {

            if (record == null || record.trim().isEmpty()) {
                continue;
            }

            List<String> fields = new ArrayList<>();

            int start = 0;
            int index;

            while ((index = record.indexOf('|', start)) != -1) {
                fields.add(record.substring(start, index));
                start = index + 1;
            }

            fields.add(record.substring(start));

            if (fields.size() != 6) {
                continue;
            }

            String[] parts = fields.toArray(new String[6]);

            boolean hasEmptyField = Arrays.stream(parts).anyMatch(field -> field == null || field.trim().isEmpty());

            if (hasEmptyField) {
                continue;
            }

            try {

                String bookId = parts[0].trim();
                String title = parts[1].trim();
                String author = parts[2].trim();
                String category = parts[3].trim();

                int borrowCount = Integer.parseInt(parts[4].trim());
                double rating = Double.parseDouble(parts[5].trim());

                if (rating < 0 || rating > 5 || borrowCount < 0) {
                    continue;
                }

                Book newBook = new Book(bookId, title, author, category, borrowCount, rating
                );

                books.merge(bookId, newBook, (existingBook, incomingBook) -> {

                    if (incomingBook.getRating() > existingBook.getRating()) {
                        return incomingBook;
                    }

                    if (incomingBook.getRating() < existingBook.getRating()) {
                        return existingBook;
                    }

                    if (incomingBook.getBorrowCount() > existingBook.getBorrowCount()) {
                        return incomingBook;
                    }

                    if (incomingBook.getBorrowCount() < existingBook.getBorrowCount()) {
                        return existingBook;
                    }

                    return incomingBook.getTitle().compareTo(existingBook.getTitle()) < 0 ? incomingBook : existingBook;
                });

            } catch (Exception e) {
            }
        }
    }

// second..............


    public List<Book> topRatedBooks(int n) {

        if (n <= 0) {
            return new ArrayList<>();
        }

        return books.values()
                .stream()
                .sorted(Comparator.comparingDouble(Book::getRating)
                        .reversed()
                        .thenComparing(Comparator.comparingInt(Book::getBorrowCount)
                                        .reversed())
                        .thenComparing(Book::getTitle, Comparator.reverseOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }

    //third................

    public Map<String, Double> averageRatingByCategory() {

        return books.values().stream().collect(
                Collectors.groupingBy(Book::getCategory, TreeMap::new,
                        Collectors.collectingAndThen(Collectors.averagingDouble(Book::getRating),
                                avg -> Math.round(avg * 100.0) / 100.0)));
    }

    //fourth...........................

    public Optional<Book> mostBorrowedBook() {

        return books.values()
                .stream()
                .max(Comparator.comparingInt(Book::getBorrowCount).thenComparingDouble(Book::getRating)
                        .thenComparing(Book::getBookId, Comparator.reverseOrder()));
    }

    //fifth................................

    public Set<String> authorsWithMultipleCategories() {

        return books.values().stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.mapping(Book::getCategory, Collectors.toSet())))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    //sixth....................................

    public Map<String,List<Book>> groupBooksByAuthor() {
        return books.values()
                .stream()
                .sorted(Comparator.comparing(Book::getAuthor))
                .collect(Collectors.groupingBy(Book::getAuthor, LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Book::getRating).reversed()
                                                .thenComparing(Comparator.comparingInt(Book::getBorrowCount).reversed()))
                                        .collect(Collectors.toList()))));
    }

    //seventh...................................

    public List<String> suspiciousBooks() {

        Map<String, Double> categoryAverageBorrow = books.values()
                .stream()
                .collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingInt(Book::getBorrowCount)));

        Map<String, Double> categoryAverageRating = books.values()
                .stream()
                .collect(Collectors.groupingBy(Book::getCategory, Collectors.averagingDouble(Book::getRating)));
        return books.values()
                .stream()
                .filter(book -> {
                    String[] words = book.getTitle().split("\\s+");
                    boolean repeatedWord = java.util.stream.IntStream.range(0, words.length - 1)
                            .anyMatch(i -> words[i].equalsIgnoreCase(words[i + 1]));
                    boolean authorInTitle = book.getTitle()
                            .toLowerCase()
                            .contains(book.getAuthor().toLowerCase());

                    double avgBorrow = categoryAverageBorrow.get(book.getCategory());

                    boolean excessiveBorrow = book.getBorrowCount() > avgBorrow * 4;

                    double avgRating = categoryAverageRating.get(book.getCategory());

                    boolean lowRatingHighBorrow = book.getRating() < avgRating
                                    && book.getBorrowCount() > avgBorrow;

                    return repeatedWord || authorInTitle|| excessiveBorrow|| lowRatingHighBorrow;})
                .map(Book::getTitle)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //Eighth....................................

    public Map<String, Map<String, Book>> categoryWiseTopRatedBookByEachAuthor() {

        Comparator<Book> comparator =
                Comparator.comparingDouble(Book::getRating)
                        .reversed()
                        .thenComparing(
                                Comparator.comparingInt(Book::getBorrowCount)
                                        .reversed()
                        )
                        .thenComparing(Book::getTitle);

        return books.values()
                .stream()
                .collect(Collectors.groupingBy(
                        Book::getCategory,
                        TreeMap::new,
                        Collectors.toMap(
                                Book::getAuthor,
                                book -> book,
                                (b1, b2) ->
                                        comparator.compare(b1, b2) <= 0
                                                ? b1
                                                : b2,
                                LinkedHashMap::new
                        )
                ));
    }
}
