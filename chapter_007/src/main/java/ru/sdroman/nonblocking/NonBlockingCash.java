package ru.sdroman.nonblocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * @author sdroman
 * @since 08.2017
 */
public class NonBlockingCash {

    /**
     * Map.
     */
    private final ConcurrentHashMap<Long, Task> map = new ConcurrentHashMap<>();

    /**
     * Adds a new task to the map.
     * @param task Task.
     */
    public void add(Task task) {
        this.map.put(task.getId(), task);
    }

    /**
     * Removes a task from the map.
     * @param key long
     */
    public void delete(final long key) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else {
            System.out.println("task is not found.");
        }
    }

    /**
     * Task updates.
     * @param newTask Task
     */
    public void update(final Task newTask) {
        this.map.computeIfPresent(newTask.getId(), new BiFunction<Long, Task, Task>() {

            /**
             * Applies this function to the given arguments.
             *
             * @param id the first function argument
             * @param task the second function argument
             * @return the function result
             */
            @Override
            public Task apply(Long id, Task task) {
                if (task.getVersion() == newTask.getVersion()) {
                    task.setName(newTask.getName());
                    task.updateVersion();
                } else {
                    throw new OptimisticException("Version is not valid.");
                }
                return task;
            }
        });
    }
}
