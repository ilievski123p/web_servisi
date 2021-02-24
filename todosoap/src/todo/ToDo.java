package src.todo;

import javax.jws.WebService;
import javax.jws.WebMethod;
import src.users.User;
import src.tasks.Task;

import java.util.ArrayList;
import java.util.List;
    @WebService
public class ToDo {
  
    private List<Task> tasks;
    private List<User> users;
    
    public ToDo() {
    	tasks = new ArrayList<Task>();
        Task task1 = new Task();
        task1.setId(1);
        task1.setTitle("Task1");
        task1.setDescription("Go to the store");
        task1.setDate("1.3.2021");
        task1.setStatus(false);
        tasks.add(task1);
		Task task2 = new Task();
        task2.setId(2);
        task2.setTitle("Task2");
        task2.setDescription("Go to the school");
        task2.setDate("10.3.2021");
        task2.setStatus(false);
        tasks.add(task2);
		Task task3 = new Task();
        task3.setId(3);
        task3.setTitle("Task3");
        task3.setDescription("Finish homework");
        task3.setDate("15.3.2011");
        task3.setStatus(false);
        tasks.add(task3);
		Task task4 = new Task();
        task4.setId(4);
        task4.setTitle("Task4");
        task4.setDescription("Call my boss");
        task4.setDate("15.3.2021");
        task4.setStatus(false);
        tasks.add(task4);
		
		users = new ArrayList<User>();
        User user1 = new User();
        user1.setUsername("petar");
        user1.setPassword("petar.123");
        List<Integer> user1tasks = new ArrayList<Integer>();
        user1tasks.add(3);
        user1tasks.add(1);
        user1.setTasks(user1tasks);
        users.add(user1);
		 User user2 = new User();
        user2.setUsername("eleonora");
        user2.setPassword("eleonora.111");
        List<Integer> user2tasks = new ArrayList<Integer>();
        user2tasks.add(2);
        user2tasks.add(4);
        user2.setTasks(user2tasks);
        users.add(user2);
}
 public void getAllUsers() {
        for (int i=0; i<users.size(); i++) {
            System.out.println(users.get(i).getUsername());}
    }

    public void getAllTasks() {
        for (int i=0; i<tasks.size(); i++) {
            System.out.println(tasks.get(i).getTitle() + ", " + tasks.get(i).getDescription() + ", " + tasks.get(i).getDate());
		}
	}
	public void getTasksByUser(String username) {
		List<Integer> tasksByUser = new ArrayList<Integer>();
		Integer x = 0;
		for (int i=0; i<users.size(); i++){
			if (users.get(i).getUsername().equals(username)){
				x = 1;
				if(users.get(i).getTasks() != null) {
					tasksByUser = users.get(i).getTasks();
				} 
			} 
		}
		if (x == 0) {
			System.out.println("The user does not exist.");
			return;
		}
		if (tasksByUser.size() > 0) {
			for(int j=0; j<tasksByUser.size(); j++) {
				for (int z=0; z<tasks.size(); z++) {
					if (tasksByUser.get(j) == tasks.get(z).getId()) {
						System.out.println(tasks.get(z).getTitle());
						break;
					}
				}
			}
		} else {
			System.out.println("The user has no tasks.");
		}
	}
	
	//funkcija za zemanje na taskovi po datum
	public void getTasksByDate(String date) {
		
		List<Task> tsks = new ArrayList<Task>();
		  for (int i=0; i<tasks.size(); i++) {
				if (tasks.get(i).getDate() == date) {
					tsks.add(tasks.get(i));
				}
			}
		
		for (int j=0; j<tsks.size(); j++) {
			System.out.println(tsks.get(j).getTitle() );
			
		}
	}
	
	//funkcija za zemanje na taskovi po status
	public void getTasksByStatus(String status) {
		
		List<Task> taskss = new ArrayList<Task>();
		  for (int i=0; i<tasks.size(); i++) {
				if (tasks.get(i).getStatus() == status) {
					taskss.add(tasks.get(i));
				}
			}
		
		for (int j=0; j<taskss.size(); j++) {
			System.out.println(taskss.get(j).getTitle() );
			
		}
	}
	//funkcija za zemanje na taskovi po prioritet?
	
	
	
}
	
	
	
	
    
