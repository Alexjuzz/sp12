package Spring.hm12.model.Dto;

import Spring.hm12.enums.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    protected Long id;
    protected String name;
    protected String description;
    protected TaskStatus status;
    protected LocalDate date;

}
