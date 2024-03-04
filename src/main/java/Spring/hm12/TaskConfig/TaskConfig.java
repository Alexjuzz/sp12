package Spring.hm12.TaskConfig;

import Spring.hm12.model.CodingTaskCreator;
import Spring.hm12.model.TaskFactory;
import Spring.hm12.model.WriteTaskCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {
    @Bean
   public TaskFactory codingTaskFactory(){
        return new CodingTaskCreator();
    }

    @Bean
    public TaskFactory writingTaskFactory(){
        return new WriteTaskCreator();
    }

}
