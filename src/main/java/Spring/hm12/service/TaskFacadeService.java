package Spring.hm12.service;


import Spring.hm12.interfaces.iTask;
import Spring.hm12.model.Dto.TaskDto;

import java.util.List;

public interface TaskFacadeService {

    String createTask(String typeTask,String nameTask, String description);
    List<iTask> getAllTasks();

    TaskDto getTaskById(Long id);

    TaskDto changeStatus(Long id,String status);


}
