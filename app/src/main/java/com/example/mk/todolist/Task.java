package com.example.mk.todolist;

/**
 * Created by Mk on 8/25/2016.
 */
public class Task {


    String Id;
    String TaskName;
    String Description;
    String Date;
    String Improtance;


    public Task(String id, String taskName, String date, String improtance, String description) {
        Id = id;
        TaskName = taskName;
        Date = date;
        Improtance = improtance;
        Description = description;
    }

    public Task() {

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImprotance() {
        return Improtance;
    }

    public void setImprotance(String improtance) {
        Improtance = improtance;
    }


    @Override
    public String toString() {
        return "Task{" +
                "Id='" + Id + '\'' +
                ", TaskName='" + TaskName + '\'' +
                ", Description='" + Description + '\'' +
                ", Date='" + Date + '\'' +
                ", Improtance='" + Improtance + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (Id != null ? !Id.equals(task.Id) : task.Id != null) return false;
        if (TaskName != null ? !TaskName.equals(task.TaskName) : task.TaskName != null)
            return false;
        if (Description != null ? !Description.equals(task.Description) : task.Description != null)
            return false;
        if (Date != null ? !Date.equals(task.Date) : task.Date != null) return false;
        return Improtance != null ? Improtance.equals(task.Improtance) : task.Improtance == null;

    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (TaskName != null ? TaskName.hashCode() : 0);
        result = 31 * result + (Description != null ? Description.hashCode() : 0);
        result = 31 * result + (Date != null ? Date.hashCode() : 0);
        result = 31 * result + (Improtance != null ? Improtance.hashCode() : 0);
        return result;
    }
}
