package edu.deakin.sit707;

import java.util.*;

public class TaskFilter {
    private static final Map<String, Integer> gradeMap = Map.of(
        "Pass", 1,
        "Credit", 2,
        "Distinction", 3,
        "HD", 4
    );

    public static List<Task> filterTasksByGrade(String targetGrade, List<Task> allTasks) {
        int maxLevel = gradeMap.getOrDefault(targetGrade, 0);
        List<Task> result = new ArrayList<>();
        for (Task t : allTasks) {
            int taskLevel = gradeMap.getOrDefault(t.getGrade(), 0);
            if (taskLevel != 0 && taskLevel <= maxLevel) {
                result.add(t);
            }
        }
        return result;
    }
}