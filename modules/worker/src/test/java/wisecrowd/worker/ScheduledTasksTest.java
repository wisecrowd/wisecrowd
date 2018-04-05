package wisecrowd.worker;

import com.atexpose.dispatcher.IDispatcher;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ScheduledTasksTest {

    @Test
    public void scheduledTasks_numberOfTasks_0() {
        List<IDispatcher> list = ScheduledTasks.create().getScheduledTasks();
        assertThat(list.size()).isEqualTo(0);
    }
}
