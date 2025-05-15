import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TaskFilterTest {

    @Test
    public void testFilterTasksByCredit() {
        TaskFilter filter = new TaskFilter();
        List<Task> tasks = Arrays.asList(
            new Task("HD Task", "HD"),
            new Task("Credit Task", "Credit"),
            new Task("Pass Task", "Pass")
        );

        List<Task> filtered = filter.filterByTargetGrade(tasks, "Credit");

        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().anyMatch(t -> t.getGrade().equals("Credit")));
        assertTrue(filtered.stream().anyMatch(t -> t.getGrade().equals("Pass")));
    }
}