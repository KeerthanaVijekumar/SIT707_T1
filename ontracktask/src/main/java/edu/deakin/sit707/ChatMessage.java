package edu.deakin.sit707;

public class ChatMessage {
    private String sender;
    private String message;
    private String fileName; // optional

    public ChatMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
        this.fileName = null;
    }

    public ChatMessage(String sender, String message, String fileName) {
        this.sender = sender;
        this.message = message;
        this.fileName = fileName;
    }

    public String getSender() { return sender; }
    public String getMessage() { return message; }
    public String getFileName() { return fileName; }

    @Override
    public String toString() {
        return sender + ": " + message + (fileName != null ? " [File: " + fileName + "]" : "");
    }
}
