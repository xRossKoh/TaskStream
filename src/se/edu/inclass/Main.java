package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

//        System.out.println("Printing deadlines");
//        printDeadlines(tasksData);
//
//        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));
//
//        printDataWithStreams(tasksData);
        printDeadlinesWithStreams(tasksData);
        System.out.println(countDeadlinesWithStreams(tasksData));

    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    private static int countDeadlinesWithStreams(ArrayList<Task> tasks){
        return (int) tasks.stream()
                .filter((t)->t instanceof Deadline)
                .count();
    }

    public static void printData(ArrayList<Task> tasksData) {
        System.out.println("Printing data by looping");
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    public static void printDataWithStreams(ArrayList<Task> tasks){
        System.out.println("Printing data using stream");
        tasks.stream() // convert to stream
                .forEach(System.out::println); // terminal operator
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        ArrayList<Task> deadlines = new ArrayList<>();
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                deadlines.add(t);
                System.out.println(t);
            }
        }
    }

    public static void printDeadlinesWithStreams(ArrayList<Task> tasks){
        System.out.println("Printing deadlines using stream");
        tasks.stream()
                .filter((t)->t instanceof Deadline) // filtering using lambda function
                .forEach(System.out::println);
    }
}
