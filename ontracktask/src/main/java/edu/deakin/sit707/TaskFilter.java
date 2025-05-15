package edu.deakin.sit707;

import java.util.*;

public class TaskFilter {
    private static final Map<String, Integer> gradeMap = Map.of(
        "Pass", 1,
        "Credit", 2,
        "Distinction", 3,
        "HD", 4
    );

    // For optional usage
    public static List<Task> filterTasksByGrade(String targetGrade, List<Task> allTasks) {
        int maxLevel = gradeMap.getOrDefault(targetGrade, 0);
        List<Task> result = new ArrayList<>();
        for (Task t : allTasks) {
            if (gradeMap.getOrDefault(t.getGrade(), 0) <= maxLevel) {
                result.add(t);
            }
        }
        return result;
    }

    // ✅ Working version for test cases
    public List<Task> filterByTargetGrade(List<Task> tasks, String grade) {
        int maxLevel = gradeMap.getOrDefault(grade, 0);
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            int taskLevel = gradeMap.getOrDefault(t.getGrade(), 0);
            if (taskLevel != 0 && taskLevel <= maxLevel) {
                result.add(t);
            }
        }
        return result;
    }
}
