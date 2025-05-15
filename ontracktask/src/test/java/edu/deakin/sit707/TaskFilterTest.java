package edu.deakin.sit707;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class TaskFilterTest {
	//Pass Test Cases
	
	//Test only Pass tasks when pass selected
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

	 //When credit select show both pass and credit tasks
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

	    //Test that selecting "HD" grade includes all valid task grade
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

	    //Test that an empty task list input results in an empty output.
	    @Test
	    public void testFilterWithEmptyList() {
	        List<Task> tasks = new ArrayList<>();

	        TaskFilter filter = new TaskFilter();
	        List<Task> result = filter.filterByTargetGrade(tasks, "Credit");

	        assertTrue(result.isEmpty());
	    }

	    //Test that tasks with unknown grade values are ignored and don't break filtering.
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
	    
	    //Test that selecting a grade not in the grade map results in no matches.

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

	    //Test that duplicate task grades are all correctly included.
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
	    
	    // Test that grade names are case-sensitive. Lowercase input should be ignored.

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

	    //Functional test case
	    @Test
	    public void testFilterByTargetGrade_FunctionalFlow() {
	        // Simulating a real-world scenario where a student selects "Credit"
	        List<Task> allTasks = Arrays.asList(
	            new Task(101, "Pass"),
	            new Task(102, "Credit"),
	            new Task(103, "Distinction"),
	            new Task(104, "HD"),
	            new Task(105, "UnknownGrade") // should be ignored
	        );

	        TaskFilter filter = new TaskFilter();
	        List<Task> filteredTasks = filter.filterByTargetGrade(allTasks, "Credit");

	        // Expected: Only "Pass" and "Credit" tasks should be returned
	        List<Task> expectedTasks = Arrays.asList(
	            new Task(101, "Pass"),
	            new Task(102, "Credit")
	        );

	        // Functional check: returned list matches expected content and size
	        assertEquals(expectedTasks.size(), filteredTasks.size());
	        assertTrue(filteredTasks.containsAll(expectedTasks));
	    }

	    
//Failure Test Cases
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