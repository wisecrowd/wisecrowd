package wisecrowd.site


/**
 * Purpose of this file is the main Server
 *
 * Created by Jorgen Andersson on 2018-01-25.
 */

/**
 * Main function to start Spark Server
 * @param args arguments for function
 */
fun startServer(args: Array<String>) {
     //
    // Spark WebServer, documentation : http://sparkjava.com/documentation
    // Setup Server
    SparkSetup()
    //
    // Controller for serving HTML files
    SparkHtmlController()
}

