import client.ToDoService;
import client.ToDo;

public class ToDoClient {
    public static void main(String[] args) {

        ToDoService service = new ToDoService();
        ToDo port = service.getToDoPort();

        if (args.length != 0) {
            if (args[0].equals("allTasks")) {
                port.getAllTasks();
            } else if (args[0].equals("allUsers")) {
                port.getAllUsers();
            } else if (args[0].equals("tasksByDate")) {
                port.getTasksByDate(args[1]);
            } else if (args[0].equals("tasksByStatus")) {
                port.getTasksByStatus(args[1]);
            } else if (args[0].equals("TasksByUser")) {
                port.getTasksByUser(args[1]);
            } else if (args[0].equals("tasksByPriority")) {
                port.getTasksByPriority(args[1]);
            }  else {
                System.out.println("Invalid function.");
            }
             } else {
            System.out.println("No arguments inserted.");
        }        
    }
}
