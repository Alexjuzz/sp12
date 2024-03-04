package Spring.hm12.model;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;

public class CodingTaskCreator extends TaskFactory {
    @Override
    public iTask createTask(Long id, String name, String description) {
        return new CodingTask(id, name, description);
    }
}
