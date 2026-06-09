package dao;

import Entity.Book;
import Entity.ToDo;

public interface ToDoDao {
    public void save(ToDo toDo);
    public ToDo findById(int id);
    public void deleteById(int id);
    public void update(ToDo toDo);
    public void deleteAll();
    public Iterable<ToDo> findAll();
}
