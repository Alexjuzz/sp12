package Spring.hm12.service;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;
import Spring.hm12.model.TaskFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class TaskService implements TaskFacadeService{
    private static volatile Long ID = 1l;
    @Autowired
    private TaskFactory factory;

    private final List<iTask> codingTasks = new CopyOnWriteArrayList();
    private final List<iTask> writeTasks = new CopyOnWriteArrayList();


    @Override
    public String createTask(String typeTask,String nameTask, String description) {

        StringBuilder response = new StringBuilder();

            if(typeTask.equals("coding")){
                iTask task = factory.createTask(ID++,nameTask,description);
                codingTasks.add(task);
                return response.append("Task ").append(ID).append(nameTask).append(" successfully created").toString();
            }

            if(typeTask.equals("write")){
                iTask task = factory.createTask(ID++,nameTask,description);
                writeTasks.add(task);
                return response.append("Task ").append(ID).append(nameTask).append(" successfully created").toString();
            }


        return "Bad type task";
    }

    @Override
    public List<iTask> getAllCodingTask() {
        return codingTasks;
    }

    @Override
    public List<iTask> getAllWritingTask() {
        return writeTasks;
    }


}
