package Spring.hm12.service;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;
import Spring.hm12.model.CodingTaskCreator;
import Spring.hm12.model.Dto.TaskDto;

import Spring.hm12.model.WriteTaskCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;


@Service
public class TaskService implements TaskFacadeService {
    @Autowired
    private final CodingTaskCreator codingTaskCreator;

    @Autowired
    private final WriteTaskCreator writeTaskCreator;

    private static volatile Long ID = 1L;

    public TaskService(CodingTaskCreator codingTaskCreator, WriteTaskCreator writeTaskCreator) {
        this.codingTaskCreator = codingTaskCreator;
        this.writeTaskCreator = writeTaskCreator;
    }


    private final List<iTask> taskList = new CopyOnWriteArrayList<>();


    public String createTask(String typeTask, String nameTask, String description) {
        iTask task;
        if ("coding".equals(typeTask)) {
            task = codingTaskCreator.createTask(ID++, nameTask, description);
        } else if ("write".equals(typeTask)) {
            task = writeTaskCreator.createTask(ID++, nameTask, description);
        } else {
            return "Bad type task";
        }

        taskList.add(task);
        return "Task " + (ID - 1) + " " + nameTask + " successfully created";
    }

    public TaskDto getTaskById(Long id) {
        iTask task = taskList.stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("task not found"));
        return convertToTaskDto(task);
    }

    @Override
    public TaskDto changeStatus(Long id, String status) {
        iTask task = taskList.stream().filter(t -> t.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("task not found"));
        TaskDto response = convertToTaskDto(task);

        switch (status) {
            case "start":
                response.setStatus(TaskStatus.AT_WORK);
                break;
            case "stop":
                response.setStatus(TaskStatus.COMPLITED);
                break;
            case "non":
                response.setStatus(TaskStatus.NOT_STARTED);
            default:
                throw new NoSuchElementException("Status not found");
        }

        return response;
    }

    private TaskDto convertToTaskDto(iTask task) {
        TaskDto response = new TaskDto();
        response.setId(task.getId());
        response.setDate(task.getDate());
        response.setName(task.getName());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        return response;
    }


    @Override
    public List<iTask> getAllTasks() {
        return taskList;
    }


}
