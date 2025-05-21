package edu.deakin.sit707;

import java.util.Arrays;
import java.util.List;

public class TaskAction {

    private static final List<String> VALID_STATUSES = Arrays.asList(
        "Not Started", "Working on it", "Need Help", "Ready for feedback"
    );

    public static void changeStatus(Task task, String newStatus) {
        if (VALID_STATUSES.contains(newStatus)) {
            task.setStatus(newStatus);
        }
    }

    public static void markAsSubmitted(Task task) {
        if ("Ready for feedback".equals(task.getStatus())) {
            task.setSubmitted(true);
        }
    }

    public static boolean canDownloadTaskSheet(Task task) {
        return task.hasTaskSheet();
    }

    public static boolean canViewTaskSheet(Task task) {
        return task.hasTaskSheet();
    }

    public static void addChatMessage(Task task, String sender, String message) {
        task.getChatMessages().add(new ChatMessage(sender, message));
    }

    public static void submitFileInChat(Task task, String fileName) {
        if (fileName != null && fileName.toLowerCase().endsWith(".pdf")) {
            task.getSubmittedFiles().add(fileName);
            task.getChatMessages().add(new ChatMessage("Student", "Submitted file: " + fileName, fileName));
        }
    }
}

