package com.example.tasktracker;

import java.util.ArrayList;
import java.util.List;

/** A tiny in-memory task tracker for the command line. */
public final class TaskTracker {
    private final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        TaskTracker app = new TaskTracker();
        if (args.length == 0 || args[0].equalsIgnoreCase("demo")) {
            app.add("Learn Java basics");
            app.add("Create a Jenkins pipeline");
            app.complete(1);
            app.list();
        } else {
            System.out.println("Usage: java -jar task-tracker-1.0.0.jar demo");
        }
    }

    private void add(String description) {
        tasks.add(new Task(description));
        System.out.println("Added task " + tasks.size() + ": " + description);
    }

    private void complete(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            tasks.get(taskNumber - 1).done = true;
        }
    }

    private void list() {
        System.out.println("\nTasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.printf("%d. [%s] %s%n", i + 1, task.done ? "x" : " ", task.description);
        }
    }

    private static final class Task {
        private final String description;
        private boolean done;

        private Task(String description) {
            this.description = description;
        }
    }
}
