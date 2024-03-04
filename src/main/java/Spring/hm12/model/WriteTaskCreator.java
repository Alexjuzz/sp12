package Spring.hm12.model;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;

public class WriteTaskCreator extends TaskFactory {
    @Override
    public iTask createTask(Long id, String name, String description) {
        return new WriteTask(id, name, description);
    }
}
