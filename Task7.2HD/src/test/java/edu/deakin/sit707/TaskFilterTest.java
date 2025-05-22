package edu.deakin.sit707;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class TaskFilterTest {

    @Test
    public void testFilterTasksByGrade_PassOnly() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Credit"),
            new Task(3, "Distinction"),
            new Task(4, "HD")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Pass", tasks);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Task(1, "Pass")));
        assertFalse(result.contains(new Task(2, "Credit")));
    }

    @Test
    public void testFilterTasksByGrade_CreditIncludesPass() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Credit"),
            new Task(3, "HD")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Credit", tasks);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Task(1, "Pass")));
        assertTrue(result.contains(new Task(2, "Credit")));
    }

    @Test
    public void testFilterTasksByGrade_HDIncludesAll() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Credit"),
            new Task(3, "Distinction"),
            new Task(4, "HD")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("HD", tasks);

        assertEquals(4, result.size());
    }

    @Test
    public void testFilterTasksByGrade_EmptyList() {
        List<Task> tasks = new ArrayList<>();
        List<Task> result = TaskFilter.filterTasksByGrade("Credit", tasks);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilterTasksByGrade_WithUnknownGrade() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "UnknownGrade"),
            new Task(3, "Credit")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Credit", tasks);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Task(1, "Pass")));
        assertTrue(result.contains(new Task(3, "Credit")));
    }

    @Test
    public void testFilterTasksByGrade_InvalidTargetGrade() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Credit")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Merit", tasks);

        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilterTasksByGrade_Duplicates() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Credit"),
            new Task(2, "Credit"),
            new Task(3, "HD")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Credit", tasks);

        assertEquals(2, result.size());
        assertTrue(result.contains(new Task(1, "Credit")));
        assertTrue(result.contains(new Task(2, "Credit")));
    }

    @Test
    public void testFilterTasksByGrade_CaseSensitivity() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "pass"),
            new Task(2, "Credit")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Credit", tasks);

        assertEquals(1, result.size());
        assertTrue(result.contains(new Task(2, "Credit")));
    }

    @Test
    public void testFilterTasksByGrade_FunctionalFlow() {
        List<Task> allTasks = Arrays.asList(
            new Task(101, "Pass"),
            new Task(102, "Credit"),
            new Task(103, "Distinction"),
            new Task(104, "HD"),
            new Task(105, "UnknownGrade")
        );

        List<Task> filteredTasks = TaskFilter.filterTasksByGrade("Credit", allTasks);

        List<Task> expectedTasks = Arrays.asList(
            new Task(101, "Pass"),
            new Task(102, "Credit")
        );

        assertEquals(expectedTasks.size(), filteredTasks.size());
        assertTrue(filteredTasks.containsAll(expectedTasks));
    }

    @Test
    public void testFilterTasksByGrade_PassWithSameGradeOnly() {
        List<Task> tasks = Arrays.asList(
            new Task(1, "Pass"),
            new Task(2, "Pass")
        );

        List<Task> result = TaskFilter.filterTasksByGrade("Pass", tasks);

        assertEquals(2, result.size());
        for (Task t : result) {
            assertEquals("Pass", t.getGrade());
        }
    }
    
  //Failure Test Cases
    // Intentionally failing: assumes Pass includes Credit — simulating a bug
//    @Test
//    public void testFail_FilterPassIncludesCredit() {
//        List<Task> tasks = Arrays.asList(
//            new Task(1, "Pass"),
//            new Task(2, "Credit")
//        );
//
//        List<Task> result = TaskFilter.filterTasksByGrade("Pass", tasks);
//
//        // Intentionally wrong: this assumes both Pass and Credit are returned (they're not)
//        assertEquals(2, result.size());
//        assertTrue(result.contains(new Task(2, "Credit"))); // This will fail
//    }

}
