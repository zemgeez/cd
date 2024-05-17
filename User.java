import java.util.ArrayList;
import java.util.List;
import java.util.Scanner    ;


class Task {
    String title;
    String description;
    boolean status;
    String dueDate;
    User assignedUser;

    // constructor, getters, and setters
}
public class User {
    String name;
    String email;
    String password;
    String role;
    String status;

    // constructor, getters, and setters
}
class ToDoList {

private List <Task> tasks ;
    public ToDoList() {
        tasks = new ArrayList<>();

    }
public Task findTaskByTitle(String title) {
        for (Task t : tasks) {
            if (t.title.equals(title)) {
                return t;
            }
        }
        return null;
    }



    void addTask(Task task) {
        this.tasks.add(task);
    }

    void removeTask(Task task) {
        this.tasks.remove(task);
    }

    void markTaskAsComplete(Task task) {
        task.status = true;
    }

    List<Task> listAllTasks() {
        return tasks;
    }
}
 class Main {
    public static void main(String[] args) {
        // create an instance of ToDoList
        // display a menu to the user
        // based on the user's choice, perform the appropriate action
 

        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Mark task as complete");
            System.out.println("4. List all tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // code to add a task

                    System.out.print("Enter the title of the task: ");
                    String title = scanner.next();
                    System.out.print("Enter the description of the task: ");
                    String description = scanner.next();
                    System.out.print("Enter the due date of the task: ");
                    String dueDate = scanner.next();
                    System.out.print("Enter the Your name for the task: ");
                    String name = scanner.next();


                    User user = new User();
                    user.name = name;


                    Task task = new Task();
                    task.title = title;
                    task.description = description;
                    task.dueDate = dueDate;
                    task.status = false;
                    task.assignedUser = user;

                    toDoList.addTask(task);
                    
                    System.out.println("Task added successfully from ( "+user.name+" )");
                    break;
                case 2:
                // code to remove a task

                System.out.print("Enter the title of the task: ");
                String titleToRemove = scanner.next();
                Task taskToRemove = toDoList.findTaskByTitle(titleToRemove);
                if (taskToRemove != null) {
                    toDoList.removeTask(taskToRemove);
                    System.out.println("Task removed successfully.");
                } else {
                    System.out.println("Task not found.");
                }

                break;
            case 3:
                // code to mark a task as complete

                System.out.print("Enter the title of the task: ");
                String titleToMark = scanner.next();
                Task taskToMark = toDoList.findTaskByTitle(titleToMark);
                if (taskToMark != null) {
                    toDoList.markTaskAsComplete(taskToMark);
                    System.out.println("Task marked as complete.");
                } else {
                    System.out.println("Task not found.");
                }

                break;
            case 4:
                // code to list all tasks

                List<Task> tasks = toDoList.listAllTasks();
                for (Task t : tasks) {
                    System.out.println("Title: " + t.title);
                    System.out.println("Description: " + t.description);
                    System.out.println("Due date: " + t.dueDate);
                    System.out.println("Status: " + (t.status ? "Complete" : "Incomplete"));
                    System.out.println();
                }
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }
}
}
    
    
   