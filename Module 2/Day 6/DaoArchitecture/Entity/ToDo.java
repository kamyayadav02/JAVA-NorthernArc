package Entity;

public class ToDo {
    private int id;
    private String task;
    private boolean completed;

    public ToDo(int id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }
    public String toString(){
        return id+ " "+ task+ " "+ completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
