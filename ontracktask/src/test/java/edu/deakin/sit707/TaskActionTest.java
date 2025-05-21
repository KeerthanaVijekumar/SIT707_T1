package edu.deakin.sit707;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskActionTest {

    @Test
    public void testChangeStatus_ValidStatus() {
        Task task = new Task(1, "Credit");
        TaskAction.changeStatus(task, "Working on it");
        assertEquals("Working on it", task.getStatus());
    }

    @Test
    public void testChangeStatus_InvalidStatus() {
        Task task = new Task(2, "Distinction");
        TaskAction.changeStatus(task, "Almost done"); 
        assertEquals("Not Started", task.getStatus()); 
    }

    @Test
    public void testMarkAsSubmitted_Valid() {
        Task task = new Task(3, "Pass");
        TaskAction.changeStatus(task, "Ready for feedback");
        TaskAction.markAsSubmitted(task);
        assertTrue(task.isSubmitted());
    }

    @Test
    public void testMarkAsSubmitted_WithoutReadiness() {
        Task task = new Task(4, "HD");
        TaskAction.markAsSubmitted(task);
        assertFalse(task.isSubmitted());
    }

    @Test
    public void testCanDownloadTaskSheet_DefaultTrue() {
        Task task = new Task(5, "Credit");
        assertTrue(TaskAction.canDownloadTaskSheet(task));
    }

    @Test
    public void testCanDownloadTaskSheet_SetFalse() {
        Task task = new Task(6, "Credit");
        task.setHasTaskSheet(false);
        assertFalse(TaskAction.canDownloadTaskSheet(task));
    }

    @Test
    public void testCanViewTaskSheet_DefaultTrue() {
        Task task = new Task(7, "Distinction");
        assertTrue(TaskAction.canViewTaskSheet(task));
    }

    @Test
    public void testCanViewTaskSheet_SetFalse() {
        Task task = new Task(8, "Distinction");
        task.setHasTaskSheet(false);
        assertFalse(TaskAction.canViewTaskSheet(task));
    }

    @Test
    public void testTaskToStringAndEquality() {
        Task t1 = new Task(10, "HD");
        Task t2 = new Task(10, "HD");
        Task t3 = new Task(11, "Credit");

        assertTrue(t1.equals(t2));
        assertFalse(t1.equals(t3));
        assertTrue(t1.toString().contains("Task"));
    }

    @Test
    public void testTaskFieldAccessors() {
        Task task = new Task(9, "Distinction");
        task.setUnitName("SIT707");
        task.setStatus("Need Help");
        task.setSubmitted(true);
        task.setHasTaskSheet(false);

        assertEquals("SIT707", task.getUnitName());
        assertEquals("Need Help", task.getStatus());
        assertTrue(task.isSubmitted());
        assertFalse(task.hasTaskSheet());
    }
    
    @Test
    public void testGetTaskId() {
        Task task = new Task(5, "Pass");
        assertEquals(5, task.getTaskId());
    }

}
