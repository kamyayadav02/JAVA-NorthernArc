package dao;

import entity.ToDo;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToDoDaoImplCollections implements ToDoDao{

        Map<Integer,ToDo> todos=new LinkedHashMap<>();
    @Override
    public int save(ToDo toDo) {
        todos.put(toDo.getId(), toDo);

        return 0;
    }

    @Override
    public void deleteById(int id) {
        todos.remove(id);

    }

    @Override
    public void updateById(int id, ToDo toDo) {
        ToDo toDo1=todos.get(id);
        toDo1.setContent(toDo.getContent());
        toDo1.setDone(toDo.isDone());

    }

    @Override
    public ToDo findById(int id) {
        return todos.get(id);
    }

    @Override
    public Map<Integer, ToDo> findAll() {
        return todos;
    }

}
