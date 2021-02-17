package users;

import java.util.List;
import java.io.Serializable;
import tasks.Task;
public class User implements Serializable{
    private String username;
    private String password;
    private List<Integer> tasks;
    
    public User() { }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    public void setTasks(List<Integer> tasks) {
        this.tasks = tasks;
    }
    public List<Integer> getTasks() {
        return this.tasks;
    }
}
