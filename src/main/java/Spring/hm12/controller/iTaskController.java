package Spring.hm12.controller;

import Spring.hm12.interfaces.iTask;
import Spring.hm12.model.Dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public interface iTaskController {

    @PostMapping("/{type}/{name}")
    public ResponseEntity<String> createTask(@PathVariable("type") String type,@PathVariable("name") String nameTask,@RequestBody String description);

    @GetMapping("/coding")
    public ResponseEntity<List<iTask>> getAllTasks();



    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable("id") Long id);

    @PostMapping("/{id}/{status}")
    public ResponseEntity<TaskDto> setStatus(@PathVariable("id")Long id, @PathVariable String status);


}

