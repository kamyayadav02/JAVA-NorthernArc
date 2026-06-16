package dao;

import entity.ToDo;

import java.sql.SQLException;
import java.util.Map;

public interface ToDoDao {
    int save(ToDo toDo) throws SQLException;
    void deleteById(int id) throws SQLException;
    void updateById(int id,ToDo toDo);
    ToDo findById(int id);
    Map<Integer,ToDo> findAll();
}
