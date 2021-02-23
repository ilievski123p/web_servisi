<jsp:useBean id = "todo" 
	     type  = "todo.ToDo" 
	     class = "todo.ToDo"> 
  <% 
  String verb = request.getMethod();
  java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(request.getInputStream()));
  String str = "";
  String line = br.readLine();

  while (line != null) {
    str += line;
    line = br.readLine();
  }

  str = str.replace("'", "");
    todo.setServletContext(application);
    String [] elements = str.split(",",8);

    if (elements[0].equals("users")) {
      if (elements[1].equals("login")) {
        out.println(todo.login(elements[2], elements[3]));
      } else if (elements[1].equals("register")) {
        out.println(todo.register(elements[2], elements[3], elements[4]));
      } else if (elements[1].equals("unregister")) {
        out.println(todo.unregister(elements[2], elements[3]));
      } else if (elements[1].equals("getAllUsers")) {
        out.println(todo.getAllUsers());
      } else if (elements[1].equals("usersBtTask")) {
        out.println(todo.getUsersByTask(elements[2]));
      } else {
        out.println("Invalid.");
      }
    }
    else if (elements[0].equals("tasks")){
        if (elements[1].equals("add")) {
          elements[2] = elements[2].replace("_", " ");
          elements[3] = elements[3].replace("_", " ");
          out.println(todo.addTask(elements[2], elements[3], elements[4], elements[5], elements[6], elements[7]));
        } else if (elements[1].equals("delete")) {
          out.println(todo.deleteTask(elements[2]));
        } else if (elements[1].equals("update")) {
          if(elements[3] != "none"){
            elements[3] = elements[3].replace("_", " ");
          }
          if (elements[4] != "none"){
            elements[4] = elements[4].replace("_", " ");
          }
          out.println(todo.updateTask(elements[2], elements[3], elements[4], elements[5], elements[6], elements[7]));
        } else if (elements[1].equals("assign")) {
          elements[3] = elements[3].replace("_", " ");
          out.println(todo.assignTask(elements[2], elements[3]));
        } else if (elements[1].equals("remove")) {
          elements[3] = elements[3].replace("_", " ");
          out.println(todo.removeTask(elements[2], elements[3]));
        } else if (elements[1].equals("tasksByUser")) {
          out.println(todo.getTasksByUser(elements[2]));
        } else if (elements[1].equals("getAllTasks")) {
          out.println(todo.getAllTasks());
        } else if (elements[1].equals("byStatus")) {
        out.println(todo.getTasksByStatus(Boolean.parseBoolean(elements[2]))); 
        } else if (elements[1].equals("byDate")) {
        out.println(todo.getTasksByDate(elements[2]));
        }
       else if (elements[1].equals("byType")) {
        out.println(todo.getTasksByType(elements[2])); 
        } else if (elements[1].equals("byPriority")) {
        out.println(todo.getTasksByPriority(elements[2]));
        }
        else {
          out.println("Invalid.");
        }
      }
  %>
</jsp:useBean>