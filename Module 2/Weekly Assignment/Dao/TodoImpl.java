package dao;

import connection.dbManager;
import entity.Todo;

import java.sql.*;
import java.util.*;

public class TodoImpl implements TodoDao {

    public Todo mapToTodo(ResultSet rs) throws SQLException {
        return new Todo(
                rs.getInt("id"),
                rs.getString("task"),
                rs.getBoolean("isfinished")
        );
    }

    @Override
    public int save(Todo todo) throws SQLException {
        Connection con = dbManager.getConnection();
        String sql = "INSERT INTO todo(task, isfinished) VALUES (?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, todo.getTask());
        stmt.setBoolean(2, todo.isIsfinish());

        int row = stmt.executeUpdate();
        dbManager.closeConnection(con);
        return row;
    }

    @Override
    public Collection<Todo> findAll() throws SQLException {
        Connection con = dbManager.getConnection();
        List<Todo> list = new LinkedList<>();

        String sql = "SELECT * FROM todo";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            list.add(mapToTodo(rs));
        }

        dbManager.closeConnection(con);
        return list;
    }

    @Override
    public Collection<Todo> findCompletedTasks() throws SQLException {
        Connection con = dbManager.getConnection();
        List<Todo> list = new LinkedList<>();

        String sql = "SELECT * FROM todo WHERE isfinished = true";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            list.add(mapToTodo(rs));
        }

        dbManager.closeConnection(con);
        return list;
    }

    @Override
    public void markAsCompleted(int id) throws SQLException {
        Connection con = dbManager.getConnection();

        String sql = "UPDATE todo SET isfinished = true WHERE id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        int row = stmt.executeUpdate();
        System.out.println("Rows updated: " + row);

        dbManager.closeConnection(con);
    }

    @Override
    public int countTasks() throws SQLException {
        Connection con = dbManager.getConnection();

        String sql = "SELECT COUNT(*) FROM todo";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        int count = 0;
        if (rs.next()) {
            count = rs.getInt(1);
        }

        dbManager.closeConnection(con);
        return count;
    }

    @Override
    public void groupByStatus() throws SQLException {
        Connection con = dbManager.getConnection();

        String sql = "SELECT isfinished, COUNT(*) FROM todo GROUP BY isfinished";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            boolean status = rs.getBoolean("isfinished");
            int count = rs.getInt(2);

            System.out.println("Status: " + status + " | Count: " + count);
        }

        dbManager.closeConnection(con);
    }
}