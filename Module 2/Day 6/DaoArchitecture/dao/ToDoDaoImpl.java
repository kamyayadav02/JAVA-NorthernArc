package dao;

import Entity.ToDo;
import java.util.ArrayList;
import java.util.List;

public class ToDoDaoImpl implements ToDoDao {

    private List<ToDo> toDos = new ArrayList<>();

    @Override
    public void save(ToDo toDo) {
        toDos.add(toDo);
    }

    @Override
    public ToDo findById(int id) {
        for (ToDo t : toDos) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        toDos.removeIf(t -> t.getId() == id);
    }

    @Override
    public void update(ToDo toDo) {
        for (ToDo t : toDos) {
            if (t.getId() == toDo.getId()) {
                t.setTask(toDo.getTask());
                t.setCompleted(toDo.isCompleted());
                return;
            }
        }
    }

    @Override
    public void deleteAll() {
        toDos.clear();
    }

    @Override
    public Iterable<ToDo> findAll() {
        return toDos;
    }
}