package wisecrowd.worker;

import com.atexpose.dispatcher.IDispatcher;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ScheduledReportsTest {

    @Test
    public void scheduledReports_numberOfReports_0() {
        List<IDispatcher> list = ScheduledReports.create().getScheduledReports();
        assertThat(list.size()).isEqualTo(0);
    }
}
