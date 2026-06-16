package entity;

public class ToDo {
    private int id;
    private String content;
    private boolean done;

    public ToDo(int id, String content, boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public ToDo(String content, boolean done) {
        this.content = content;
        this.done = done;
    }

    public ToDo() {
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", done=" + done +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
