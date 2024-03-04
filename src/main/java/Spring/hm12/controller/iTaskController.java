package Spring.hm12.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public interface iTaskController {

    @PostMapping("/{type}")
    public ResponseEntity<String> createTask(@PathVariable("type") String type)

}
