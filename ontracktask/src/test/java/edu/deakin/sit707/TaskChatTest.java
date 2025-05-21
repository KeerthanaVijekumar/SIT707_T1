package edu.deakin.sit707;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class TaskChatTest {

    @Test
    public void testAddChatMessage() {
        Task task = new Task(7, "Pass");
        TaskAction.addChatMessage(task, "Student", "Is this correct?");
        List<ChatMessage> chat = task.getChatMessages();

        assertEquals(1, chat.size());
        assertEquals("Student", chat.get(0).getSender());
        assertEquals("Is this correct?", chat.get(0).getMessage());
        assertNull(chat.get(0).getFileName());
        assertTrue(chat.get(0).toString().contains("Is this correct?"));
    }

    @Test
    public void testSubmitFileInChat_ValidPdf() {
        Task task = new Task(8, "Credit");
        TaskAction.submitFileInChat(task, "submission.pdf");

        assertEquals(1, task.getSubmittedFiles().size());
        assertEquals("submission.pdf", task.getSubmittedFiles().get(0));

        List<ChatMessage> chat = task.getChatMessages();
        assertEquals(1, chat.size());
        assertEquals("Student", chat.get(0).getSender());
        assertEquals("Submitted file: submission.pdf", chat.get(0).getMessage());
        assertEquals("submission.pdf", chat.get(0).getFileName());
        assertTrue(chat.get(0).toString().contains("[File: submission.pdf]"));
    }

    @Test
    public void testSubmitFileInChat_InvalidFormat() {
        Task task = new Task(9, "Credit");
        TaskAction.submitFileInChat(task, "image.jpg");

        assertTrue(task.getSubmittedFiles().isEmpty());
        assertTrue(task.getChatMessages().isEmpty());
    }

    @Test
    public void testMixedMessageTypes() {
        Task task = new Task(10, "HD");
        TaskAction.addChatMessage(task, "Student", "I got 85%");
        TaskAction.addChatMessage(task, "Tutor", "Well done!");
        TaskAction.addChatMessage(task, "Student", "Can you check section 2.3?");

        List<ChatMessage> chat = task.getChatMessages();
        assertEquals(3, chat.size());
        assertEquals("I got 85%", chat.get(0).getMessage());
        assertEquals("Well done!", chat.get(1).getMessage());
        assertEquals("Can you check section 2.3?", chat.get(2).getMessage());
    }
}
