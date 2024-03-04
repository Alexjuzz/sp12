package Spring.hm12.model;

import Spring.hm12.enums.TaskStatus;
import Spring.hm12.interfaces.iTask;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AbstractTask implements iTask {
    protected Long id;
    protected String name;
    protected String description;
    protected TaskStatus status;
    protected LocalDate date;
    public AbstractTask(Long id,String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = TaskStatus.NOT_STARTED;
        this.date = LocalDate.now();
    }


}
