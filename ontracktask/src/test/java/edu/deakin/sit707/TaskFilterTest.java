package edu.deakin.sit707;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class TaskFilterTest {
	 @Test
	    public void testFilterByTargetGrade_PassOnly() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Pass"),
	            new Task(2, "Credit"),
	            new Task(3, "Distinction"),
	            new Task(4, "HD")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Pass");

	        assertEquals(1, result.size());
	        assertTrue(result.contains(new Task(1, "Pass")));
	        assertFalse(result.contains(new Task(2, "Credit")));
	    }

	    @Test
	    public void testFilterByTargetGrade_CreditIncludesPass() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Pass"),
	            new Task(2, "Credit"),
	            new Task(3, "HD")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertEquals(2, result.size());
	        assertTrue(result.contains(new Task(1, "Pass")));
	        assertTrue(result.contains(new Task(2, "Credit")));
	    }

	    @Test
	    public void testFilterByTargetGrade_HDIncludesAll() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Pass"),
	            new Task(2, "Credit"),
	            new Task(3, "Distinction"),
	            new Task(4, "HD")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "HD");

	        assertEquals(4, result.size());
	    }

	    @Test
	    public void testFilterWithEmptyList() {
	        List<Task> tasks = new ArrayList<>();

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertTrue(result.isEmpty());
	    }

	    @Test
	    public void testFilterWithUnknownGradeInList() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Pass"),
	            new Task(2, "UnknownGrade"),
	            new Task(3, "Credit")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertEquals(2, result.size());
	        assertTrue(result.contains(new Task(1, "Pass")));
	        assertTrue(result.contains(new Task(3, "Credit")));
	    }

	    @Test
	    public void testFilterWithInvalidTargetGrade() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Pass"),
	            new Task(2, "Credit")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Merit");

	        assertTrue(result.isEmpty());
	    }

	    @Test
	    public void testFilterWithDuplicates() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "Credit"),
	            new Task(2, "Credit"),
	            new Task(3, "HD")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertEquals(2, result.size());
	        assertTrue(result.contains(new Task(1, "Credit")));
	        assertTrue(result.contains(new Task(2, "Credit")));
	    }

	    @Test
	    public void testCaseSensitivityInGrades() {
	        List<Task> tasks = Arrays.asList(
	            new Task(1, "pass"),
	            new Task(2, "Credit")
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertEquals(1, result.size());
	        assertTrue(result.contains(new Task(2, "Credit")));
	    }


    // Intentionally failing: assumes Pass includes Credit — simulating a bug
//    @Test
//    public void testFilterByTargetGrade_FailIfCreditIncludedForPass() {
//        List<Task> tasks = Arrays.asList(
//            new Task(1, "Pass"),
//            new Task(2, "Credit")
//        );
//
//        TaskFilter filter = new TaskFilter();
//        List<Task> filtered = filter.filterByTargetGrade(tasks, "Pass");
//
//        // This should fail if Credit is wrongly included
//        assertEquals(2, filtered.size()); 
//    }
	

//    @Test
//    public void testFilterByTargetGradeFailure() {
//        List<Task> tasks = Arrays.asList(
//            new Task(1, "Pass"),
//            new Task(2, "Credit"),
//            new Task(3, "HD")
//        );
//
//        TaskFilter filter = new TaskFilter();
//        List<Task> filtered = filter.filterByTargetGrade(tasks, "Credit");
//
//        // This will fail because filterByTargetGrade() returns an empty list
//        assertEquals(2, filtered.size()); // expecting Pass and Credit
//    }
//    
}