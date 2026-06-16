package dao;

import config.dbManager;
import entity.ToDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ToDoDaoImplJDBC implements ToDoDao {
    private final dbManager dbmanager;

    public ToDoDaoImplJDBC(dbManager dbmanager) {
        this.dbmanager = dbmanager;
    }

    private ToDo mapToTodo(ResultSet rs) throws SQLException {
        return new ToDo(
                rs.getInt("id"),
                rs.getString("content"),
                rs.getBoolean("isDone")   // DB column
        );
    }

    @Override
    public int save(ToDo toDo) throws SQLException {
        int rows = 0;

        try (Connection con = dbmanager.getConnection()) {
            String sql = "INSERT INTO todo(content, isDone) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, toDo.getContent());
            stmt.setBoolean(2, toDo.isDone());

            rows = stmt.executeUpdate();
        }

        return rows;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        try (Connection con = dbmanager.getConnection()) {
            String sql = "DELETE FROM todo WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }


    @Override
    public void updateById(int id, ToDo toDo) {
        try (Connection con = dbmanager.getConnection()) {
            String sql = "UPDATE todo SET content=?, isDone=? WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, toDo.getContent());
            stmt.setBoolean(2, toDo.isDone());
            stmt.setInt(3, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }


    @Override
    public ToDo findById(int id) {
        try (Connection con = dbmanager.getConnection()) {
            String sql = "SELECT * FROM todo WHERE id=?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapToTodo(rs);
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return null;
    }


    @Override
    public Map<Integer, ToDo> findAll() {
        Map<Integer, ToDo> map = new HashMap<>();

        try (Connection con = dbmanager.getConnection()) {
            String sql = "SELECT * FROM todo";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ToDo todo = mapToTodo(rs);
                map.put(todo.getId(), todo);
            }

        } catch (SQLException e) {
            System.out.println("DB Error: " + e.getMessage());
        }

        return map;
    }
}