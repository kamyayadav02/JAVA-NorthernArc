package dao;


import entity.Todo;

import java.sql.SQLException;
import java.util.Collection;

public interface TodoDao {


        int save(Todo todo) throws SQLException;


        Collection<Todo> findAll() throws SQLException;


        Collection<Todo> findCompletedTasks() throws SQLException ;


        void markAsCompleted(int id) throws SQLException ;


        int countTasks() throws SQLException ;


        void groupByStatus() throws SQLException ;
    }

