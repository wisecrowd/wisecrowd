package wisecrowd.worker;

import com.atexpose.dispatcher.IDispatcher;
import com.google.common.collect.ImmutableList;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Purpose of this class is holding all Scheduled Reports for Worker
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-12.
 */
@Accessors(prefix = "m")
public class ScheduledReports {

    @Getter
    private final List<IDispatcher> mScheduledReports = new ImmutableList.Builder<IDispatcher>()
            .build();

    protected static ScheduledReports create() {
        return new ScheduledReports();
    }

}
