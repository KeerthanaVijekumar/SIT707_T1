package edu.deakin.sit707;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class TaskFilterTest {

    @Test
    public void testFilterByTargetGradeFailure() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Credit"),
            new Task(3, "HD")
        );

        TaskFilter filter = new TaskFilter();
        List<Task> filtered = filter.filterByTargetGrade(tasks, "Credit");

        // This will fail because filterByTargetGrade() returns an empty list
        assertEquals(2, filtered.size()); // expecting Pass and Credit
    }
}