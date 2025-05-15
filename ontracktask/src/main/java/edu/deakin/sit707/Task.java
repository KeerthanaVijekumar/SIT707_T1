package edu.deakin.sit707;

public class Task {
    private int taskId;
    private String grade;

    public Task(int taskId, String grade) {
        this.taskId = taskId;
        this.grade = grade;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Task)) return false;
        Task t = (Task) obj;
        return taskId == t.taskId && grade.equals(t.grade);
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", grade='" + grade + "'}";
    }
}