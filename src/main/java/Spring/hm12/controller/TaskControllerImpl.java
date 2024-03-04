package Spring.hm12.controller;

import Spring.hm12.interfaces.iTask;
import Spring.hm12.model.Dto.TaskDto;
import Spring.hm12.service.TaskFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskControllerImpl implements iTaskController {

    @Autowired
    private final TaskFacadeService facadeService;

    public TaskControllerImpl(TaskFacadeService facadeService) {
        this.facadeService = facadeService;
    }

    @Override
    public ResponseEntity<String> createTask(String type, String nameTask, String description) {
        return ResponseEntity.ok(facadeService.createTask(type,nameTask,description));
    }

    @Override
    public ResponseEntity<List<iTask>> getAllTasks() {
        return ResponseEntity.ok(facadeService.getAllTasks());
    }


    @Override
    public ResponseEntity<TaskDto> getById(Long id) {
        return ResponseEntity.ok(facadeService.getTaskById(id));
    }

    @Override
    public ResponseEntity<TaskDto> setStatus(Long id, String status) {
        return ResponseEntity.ok(facadeService.changeStatus(id,status));
    }

}
