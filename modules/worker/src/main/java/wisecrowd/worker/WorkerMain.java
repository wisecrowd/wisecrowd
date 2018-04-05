package wisecrowd.worker;

import com.atexpose.AtExpose;
import com.atexpose.dispatcherfactories.CliFactory;

/**
 * The purpose of this class is to start up the worker. The worker handles
 * background jobs such as generating fund lists and e-mailing up log reports.
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-12.
 */
public class WorkerMain {

    public static void main(String[] args) {
        WorkerMain.create();
    }


    public static WorkerMain create() {
        return new WorkerMain();
    }


    /**
     * Sets up the whole system.
     */
    private WorkerMain() {
        System.out.println("***************************************************");
        System.out.println("**  wisecrowd Worker                            **");
        System.out.println("***************************************************");
        //
        AtExpose atExpose = AtExpose.create();
        // Add Label
        atExpose.getAPI().addLabel("wisecrowd", "wisecrowd public API methods");
        //
        atExpose
                //Start command line interface
                .start(CliFactory.create())
                //Set up scheduled tasks
                .start(ScheduledTasks.create().getScheduledTasks())
                //Set up scheduled reports
                .start(ScheduledReports.create().getScheduledReports());
    }
}
