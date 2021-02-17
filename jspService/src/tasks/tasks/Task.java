package tasks;

import java.io.Serializable;
import java.util.List;
import users.User;
public class 
Task implements Serializable {
    private Integer id;
    private String title;
    private String date;
    private String description;
    private Boolean status;

    private List<String> users;

    public Task() {}

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return this.title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return this.date;
    }
    public Boolean getStatus() {
        return this.status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public List<String> getUsers() {
        return this.users;
    }
    public void setUsers(List<String> users) {
        this.users = users;
    }
}