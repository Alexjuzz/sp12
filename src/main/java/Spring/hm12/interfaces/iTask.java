package Spring.hm12.interfaces;

import Spring.hm12.enums.TaskStatus;

import java.time.LocalDate;

public interface iTask {
    Long getId();
    String getName();
    String getDescription();
    LocalDate getDate();

    void setStatus(TaskStatus status);
    TaskStatus getStatus();

}
