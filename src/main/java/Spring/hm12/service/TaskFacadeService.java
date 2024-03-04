package Spring.hm12.service;


import Spring.hm12.interfaces.iTask;

import java.util.List;

public interface TaskFacadeService {

    String createTask(String typeTask,String nameTask, String description);
    List<iTask> getAllCodingTask();
    List<iTask> getAllWritingTask();


}
