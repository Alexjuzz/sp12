package Spring.hm12.model;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;

public abstract class TaskFactory {
    public abstract iTask createTask(Long id,String name, String description);

}
