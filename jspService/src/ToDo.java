package todo;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.net.*;
import java.io.*;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.beans.XMLEncoder;
import javax.servlet.ServletContext;
import java.util.Arrays;
import users.User;
import tasks.Task;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ToDo {
    private List<Task> tasks;
	private List<User> users;
	private ServletContext sctx;

    public ToDo() {
	}

	public void setServletContext(ServletContext sctx) {
		this.sctx = sctx;
	}

	public ServletContext getServletContext() {
		return this.sctx;
	}

    public void populateTasks(){
        if (getServletContext() == null)
        return;
    String filename = "/WEB-INF/data/tasks.db";
    InputStream in = sctx.getResourceAsStream(filename);
    if (in != null) {
        try {
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader reader = new BufferedReader(isr);
            tasks = new ArrayList<Task>();
            String record = null;
            while ((record = reader.readLine()) != null) {
                String[] parts = record.split("!");
                Task t = new Task();
                t.setId(Integer.valueOf(parts[0]));
                t.setTitle(parts[1]);
                t.setDescription(parts[2]);
                t.setDate(parts[3]);
                t.setStatus(Boolean.parseBoolean(parts[4]));
                t.setPriority(parts[5]);
                t.setType(parts[6]);
                String usersArray = parts[7];
					if (!usersArray.equals("X")) {
						List<String> usersByTask = new ArrayList<String>();
						String[] users = usersArray.split(",");
						for (int i = 0; i < users.length; i++) {
							usersByTask.add(users[i]);
						}
						t.setUsers(usersByTask);
					}
                    	tasks.add(t);
				}
			} catch (Exception e) {
				e.printStackTrace();
            }
            }
        }

        public void populateUsers() {
            if (getServletContext() == null)
                return;
            String filename = "/WEB-INF/data/users.db";
            InputStream in = sctx.getResourceAsStream(filename);
    
            if (in != null) {
                try {
                    InputStreamReader isr = new InputStreamReader(in);
                    BufferedReader reader = new BufferedReader(isr);
                    users = new ArrayList<User>();
                    String record = null;
                    while ((record = reader.readLine()) != null) {
                        String[] parts = record.split("!");
                        User p = new User();
                        p.setUsername(parts[0]);
                        p.setPassword(parts[1]);
                        String tasksArray = parts[2];
                        if (!tasksArray.equals("X")) {
                            List<Integer> tasksByUser = new ArrayList<Integer>();
                            String[] tasks = tasksArray.split(",");
                            for (int i = 0; i < tasks.length; i++) {
                                tasksByUser.add(Integer.valueOf(tasks[i]));
                            }
                            p.setTasks(tasksByUser);
                        }
                        users.add(p);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        public boolean writeTasksToDB(List<Task> tasks) {
            if (getServletContext() == null)
                return false;
            String taskRecord = "";
    
            try {
                File f = new File(getServletContext().getRealPath("/WEB-INF/data/tasks.db"));
                FileWriter fout = new FileWriter(f);
                int size = tasks.size();
                int i = 0;
    
                while (size > 0) {
                    taskRecord = tasks.get(i).getId() + "!" + tasks.get(i).getTitle() + "!" + tasks.get(i).getDescription() + "!"
                            + tasks.get(i).getDate() + "!" + tasks.get(i).getStatus() + "!" + tasks.get(i).getPriority() + "!" + tasks.get(i).getType();
                    if (tasks.get(i).getUsers() == null) {
                        taskRecord += "X" + "\n";
                    } else {
                        for (int j = 0; j < tasks.get(i).getUsers().size(); j++) {
                            if (j == (tasks.get(i).getUsers().size() - 1)) {
                                taskRecord += tasks.get(i).getUsers().get(j);
                            } else {
                                taskRecord += tasks.get(i).getUsers().get(j) + ",";
                            }
                        }
                        taskRecord += "\n";
                    }
                    fout.append(taskRecord);
                    i++;
                    size--;
                }
                fout.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    
        public boolean writeUsersToDB(List<User> users) {
            if (getServletContext() == null)
                return false;
            String userRecord = "";
    
            try {
                File f = new File(getServletContext().getRealPath("/WEB-INF/data/users.db"));
                FileWriter fout = new FileWriter(f);
                int size = users.size();
                int i = 0;
    
                while (size > 0) {
                    userRecord = users.get(i).getUsername() + "!" + users.get(i).getPassword() + "!";
                    if (users.get(i).getTasks() == null) {
                        userRecord += "X" + "\n";
                    } else {
                        for (int j = 0; j < users.get(i).getTasks().size(); j++) {
                            if (j == (users.get(i).getTasks().size() - 1)) {
                                userRecord += users.get(i).getTasks().get(j);
                            } else {
                                userRecord += users.get(i).getTasks().get(j) + ",";
                            }
                        }
                        userRecord += "\n";
                    }
                    fout.append(userRecord);
                    i++;
                    size--;
                }
                fout.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    
        public boolean login(String username, String password) {
            populateUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    if (users.get(i).getPassword().equals(password)) {
                        return true;
                    }
                }
            }
            return false;
        }
    
        public boolean register(String username, String p1, String p2) {
            populateUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    return false;
                }
            }
            if (!(p1.equals(p2))) {
                return false;
            }
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(p1);
            users.add(newUser);
            writeUsersToDB(users);
            return true;
        }
    
        public boolean unregister(String username, String password) {
            populateUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    if (users.get(i).getPassword().equals(password)) {
                        users.remove(i);
                        writeUsersToDB(users);
                        return true;
                    }
                }
            }
            return false;
        }
    
        public String getAllUsers() {
            populateUsers();
            return usersToJSON(users);
        }



        public boolean addTask(String title, String description, String date, String Status, String priority, String type) {
            populateTasks();
            Boolean status = Boolean.parseBoolean(Status);
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getTitle().equals(title)) {
                    return false;
                }
            }
            Integer newId = tasks.get(tasks.size() - 1).getId() + 1;
            Task newTask = new Task();
            newTask.setTitle(title);
            newTask.setDescription(description);
            newTask.setStatus(status);
            newTask.setDate(date);
            newTask.setId(newId);
            newTask.setPriority(priority);
            newTask.setType(type);
            tasks.add(newTask);
            writeTasksToDB(tasks);
            return true;
        }
    
        public boolean deleteTask(String Id) {
            populateTasks();
            Integer id = Integer.valueOf(Id);
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(id)) {
                    tasks.remove(i);
                    writeTasksToDB(tasks);
                    return true;
                }
            }
            return false;
        }
    
        public boolean updateTask(String Id, String newTitle, String newDescription, String newDate, String newPriority, String newType) {
            populateTasks();
            Integer id = Integer.valueOf(Id);
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId().equals(id)) {
                    if (!newTitle.equals("none")) {
                        tasks.get(i).setTitle(newTitle);
                    }
                    if (!newDescription.equals("none")) {
                        tasks.get(i).setDescription(newDescription);
                    }
                    if (!newDate.equals("none")) {
                        tasks.get(i).setDate(newDate);

                    }
                    if (!newPriority.equals("none")) {
                        tasks.get(i).setPriority(newPriority);
                    }
                    if (!newType.equals("none")) {
                        tasks.get(i).setType(newType);

                    }
                    writeTasksToDB(tasks);
                    return true;
                }
            }
            return false;
        }




        public boolean assignTask(String username, String title) {
            populateTasks();
            populateUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    for (int j = 0; j < tasks.size(); j++) {
                        if (tasks.get(j).getTitle().equals(title) && tasks.get(j).getStatus() == true) {
                            tasks.get(j).setStatus(false);
                            List<Integer> updatedtasks = new ArrayList<Integer>();
                            if (users.get(i).getTasks() != null) {
                                updatedtasks = users.get(i).getTasks();
                            }
                            updatedtasks.add(tasks.get(j).getId());
                            users.get(i).setTasks(updatedtasks);
                            List<String> usrs = tasks.get(j).getUsers();
                            if (usrs != null) {
                                Integer x = 0;
                                for (int z = 0; z < usrs.size(); z++) {
                                    if (usrs.get(z).equals(username)) { // ako vekje bil toj task za konkretniot korisnik, da ne
                                                                        // se zapisuva pak
                                        x = 1;
                                    }
                                }
                                if (x == 0) {
                                    usrs.add(username);
                                    tasks.get(j).setUsers(usrs);
                                }
                            } else {
                                usrs = new ArrayList<String>();
                                usrs.add(username);
                                tasks.get(j).setUsers(usrs);
                            }
                            writeUsersToDB(users);
                            writeTasksToDB(tasks);
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    
        public boolean removeTask(String username, String title) {
            populateTasks();
            populateUsers();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    for (int j = 0; j < users.get(i).getTasks().size(); j++) {
                        for (int z = 0; z < tasks.size(); z++) {
                            if (tasks.get(z).getTitle().equals(title)) {
                                if (users.get(i).getTasks().get(j) == tasks.get(z).getId()) {
                                    List<Integer> tsks = users.get(i).getTasks();
                                    tsks.remove(j);
                                    if (tsks.size() == 0) {
                                        users.get(i).setTasks(null);
                                    } else {
                                        users.get(i).setTasks(tsks);
                                    }
                                    tasks.get(z).setStatus(true);
                                    writeUsersToDB(users);
                                    writeTasksToDB(tasks);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    
        public String getAllTasks() {
            populateTasks();
            return tasksToJSON(tasks);
        }
    
        public String getTasksByUser(String username) {
            populateUsers();
            populateTasks();
            List<Integer> tasksByUser = new ArrayList<Integer>();
            Integer x = 0;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)) {
                    x = 1;
                    if (users.get(i).getTasks() != null) {
                        tasksByUser = users.get(i).getTasks();
                    }
                }
            }
            if (x == 0) {
                return "The user does not exist.";
            }
            List<Task> tsks = new ArrayList<Task>();
            if (tasksByUser.size() > 0) {
                for (int j = 0; j < tasksByUser.size(); j++) {
                    for (int z = 0; z < tasks.size(); z++) {
                        if (tasksByUser.get(j) == tasks.get(z).getId()) {
                            tsks.add(tasks.get(z));
                            break;
                        }
                    }
                }
                return tasksToJSON(tsks);
            } else {
                return "The user has no tasks.";
            }
        }
    
        public String getUsersByTask(String id) {
            populateTasks();
            populateUsers();
            Integer Id = Integer.valueOf(id);
            List<String> usersByTask = new ArrayList<String>();
            Integer x = 0;
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == Id) {
                    x = 1;
                    if (tasks.get(i).getUsers() != null) {
                        usersByTask = tasks.get(i).getUsers();
                    }
                }
            }
            if (x == 0) {
                return "The Task does not exist.";
            }
            List<User> usrs = new ArrayList<User>();
            if (usersByTask.size() > 0) {
                for (int j = 0; j < usersByTask.size(); j++) {
                    for (int z = 0; z < users.size(); z++) {
                        if (usersByTask.get(j).equals(users.get(z).getUsername())) {
                            usrs.add(users.get(z));
                            break;
                        }
                    }
                }
                return usersToJSON(usrs);
            } else {
                return "The Task hasn't been assigned yet.";
            }
        }
    

        private String tasksToJSON(List<Task> tasks) {
            String json = "";
            ObjectMapper mapper = new ObjectMapper();
            for (int i=0; i<tasks.size(); i++) {
                try {
                    String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tasks.get(i));
                    json = json + jsonString + "\n";
                }catch (Exception e) {
                    return e.getMessage();
                }
            }
            return json;
        }
    
        private String usersToJSON(List<User> users) {
            String json = "";
            ObjectMapper mapper = new ObjectMapper();
            for (int i=0; i<users.size(); i++) {
                try {
                    String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users.get(i));
                    json = json + jsonString + "\n";
                }catch (Exception e) {
                    return e.getMessage();
                }
            }
            return json;
        }
        
        public String getTasksByStatus(Boolean status)
        {
            populateTasks();;
            List <Task> tks = new ArrayList<Task>();
            for (int i=0; i < tasks.size();i++){
            if (tasks.get(i).getStatus() == status)
            tks.add(tasks.get(i));
            }  
            return tasksToJSON(tks);
         }

        public String getTasksByDate(String date)
        {
            populateTasks();
            List <Task> tks = new ArrayList<Task>();
            for (int i=0; i < tasks.size();i++){
            if (tasks.get(i).getDate().equals(date) )
            tks.add(tasks.get(i));
            }  
            return tasksToJSON(tks);

        }

        public String getTasksByPriority(String priority)
        {
            populateTasks();
            List <Task> tks = new ArrayList<Task>();
            for (int i=0; i < tasks.size();i++){
            if (tasks.get(i).getPriority().equals(priority) )
            tks.add(tasks.get(i));
            }  
            return tasksToJSON(tks);

        }

        public String getTasksByType(String type)
        {
            populateTasks();
            List <Task> tks = new ArrayList<Task>();
            for (int i=0; i < tasks.size();i++){
            if (tasks.get(i).getType().equals(type) )
            tks.add(tasks.get(i));
            }  
            return tasksToJSON(tks);

        }

}
