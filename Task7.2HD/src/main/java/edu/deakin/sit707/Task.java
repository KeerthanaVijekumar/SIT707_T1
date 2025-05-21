package edu.deakin.sit707;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int taskId;
    private String grade;

    // Newly added fields
    private String unitName;
    private String status = "Not Started";
    private boolean isSubmitted = false;
    private boolean hasTaskSheet = true;
    private List<ChatMessage> chatMessages = new ArrayList<>();
    private List<String> submittedFiles = new ArrayList<>();

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

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    public boolean hasTaskSheet() {
        return hasTaskSheet;
    }

    public void setHasTaskSheet(boolean hasTaskSheet) {
        this.hasTaskSheet = hasTaskSheet;
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public List<String> getSubmittedFiles() {
        return submittedFiles;
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
