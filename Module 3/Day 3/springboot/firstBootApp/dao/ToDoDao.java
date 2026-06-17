package com.northernArc.firstbootapp.dao;

import com.northernArc.firstbootapp.model.ToDo;

import java.sql.SQLException;
import java.util.Map;

public interface ToDoDao {
    int save(ToDo toDo) ;
    void deleteById(int id) ;
    void updateById(int id,ToDo toDo);
    ToDo findById(int id);
    Map<Integer,ToDo> findAll();

}
