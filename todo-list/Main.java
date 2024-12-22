import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Method to display to-do list
    public static void displayToDoList(ArrayList<ToDo> todoList) {
        System.out.println("--------------- To-Do List ---------------");
        for (int i = 0; i < todoList.size(); i++) {
            ToDo task = todoList.get(i);
            String status = task.isDone() ? "[Done]" : "[Not Done]";
            int num = i + 1;
            System.out.println(num + ": " + task.getDescription() + " - " + task.getDate() + " " + status);
        }
        System.out.println("------------------------------------------");
    }

    // Method to display menu
    public static void displayMenu() {
        System.out.println("Choose an option: ");
        System.out.println("1 - Show To-Do List");
        System.out.println("2 - Add Task");
        System.out.println("3 - Delete Task");
        System.out.println("4 - Modify Task");
        System.out.println("5 - Check Task");
        System.out.println("6 - Uncheck Task");
        System.out.println("0 - Exit");
    }

    // Method to add a task
    public static void addTask(ArrayList<ToDo> todoList, Scanner scanner) {
        System.out.println("Adding a task...");

        System.out.print("Task Description: ");
        scanner.nextLine();
        String description = scanner.nextLine();

        System.out.print("Task date (Month/Day): ");
        String date = scanner.nextLine();

        todoList.add(new ToDo(description, date));
        System.out.println("Task added.");
    }

    // Method to delete a task
    public static void deleteTask(ArrayList<ToDo> todoList, Scanner scanner) {
        System.out.println("Deleting a task...");
        displayToDoList(todoList);

        System.out.print("Select a task to delete: ");
        int index = scanner.nextInt();
        index -= 1;

        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to modify a task
    public static void modifyTask(ArrayList<ToDo> todoList, Scanner scanner) {
        System.out.println("Modifying a task...");
        displayToDoList(todoList);

        System.out.print("Select a task to modify: ");
        int index = scanner.nextInt();
        index -= 1;

        if (index >= 0 && index < todoList.size()) {
            ToDo task = todoList.get(index);

            System.out.println("1 - Change description");
            System.out.println("2 - Change date");
            System.out.print("Input: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("New task description: ");
                    String newDescription = scanner.nextLine();
                    task.setDescription(newDescription);
                    System.out.println("Task description updated.");
                    break;
                case 2:
                    System.out.print("New date (Day/Month/Time): ");
                    String newDate = scanner.nextLine();
                    task.setDate(newDate);
                    System.out.println("Task date updated.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to check a task
    public static void checkTask(ArrayList<ToDo> todoList, Scanner scanner) {
        System.out.println("Checking a task...");
        displayToDoList(todoList);

        System.out.print("Select a task to check: ");
        int index = scanner.nextInt();
        index -= 1;

        if (index >= 0 && index < todoList.size()) {
            ToDo task = todoList.get(index);
            if (task.isDone()) {
                System.out.println("Task is already checked.");
            } else {
                task.setDone(true);
                System.out.println("Task checked.");
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Method to uncheck a task
    public static void uncheckTask(ArrayList<ToDo> todoList, Scanner scanner) {
        System.out.println("Unchecking a task...");
        displayToDoList(todoList);

        System.out.print("Select a task to uncheck: ");
        int index = scanner.nextInt();
        index -= 1;

        if (index >= 0 && index < todoList.size()) {
            ToDo task = todoList.get(index);
            if (!task.isDone()) {
                System.out.println("Task is already unchecked.");
            } else {
                task.setDone(false);
                System.out.println("Task unchecked.");
            }
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void main(String[] args) {
        ArrayList<ToDo> todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            System.out.print("Option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayToDoList(todoList);
                    break;
                case 2:
                    addTask(todoList, scanner);
                    break;
                case 3:
                    deleteTask(todoList, scanner);
                    break;
                case 4:
                    modifyTask(todoList, scanner);
                    break;
                case 5:
                    checkTask(todoList, scanner);
                    break;
                case 6:
                    uncheckTask(todoList, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }
}