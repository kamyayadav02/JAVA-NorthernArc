package com.northernArc.firstbootapp.dao;

import com.northernArc.firstbootapp.model.ToDo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ToDoDaoImpl implements ToDoDao{
    Map<Integer,ToDo> todos;

    @PostConstruct
    public void init(){
        System.out.println("Initializing rows.");
        todos=new HashMap<>();
        todos.put(1,new ToDo(1,"Wake up",true));
        todos.put(2,new ToDo(2,"Eat Breakfast",false));
        todos.put(3,new ToDo(3,"Go to work",true));
        todos.put(4,new ToDo(4,"Sleep",false));


    }
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
        toDo1.setCompleted(toDo.getCompleted());

    }

    @Override
    public ToDo findById(int id) {
        return todos.get(id);
    }

    @Override
    public Map<Integer, ToDo> findAll() {
        return todos;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroying todos");
        todos.clear();
    }
}
