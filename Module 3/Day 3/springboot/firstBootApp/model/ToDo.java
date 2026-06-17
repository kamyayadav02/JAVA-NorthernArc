package com.northernArc.firstbootapp.model;

public class ToDo {
    private int id;
    private String content;
    private Boolean completed;

    public ToDo(int id, String content, Boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public ToDo(String content, Boolean completed) {
        this.content = content;
        this.completed = completed;
    }

    public ToDo() {
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", Completed=" + completed +
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

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean Completed) {
        completed = Completed;
    }

}
