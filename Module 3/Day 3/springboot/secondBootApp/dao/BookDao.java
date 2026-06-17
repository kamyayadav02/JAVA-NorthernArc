package com.northernArc.secondbootapp.Dao;

import com.northernArc.secondbootapp.model.Book;

import java.util.Map;

public interface BookDao {
    int save(Book book);
    void deleteById(int id);
    void updateById(int id, Book book);
    Book findById(int id);
    Map<Integer,Book> findAll();
}
