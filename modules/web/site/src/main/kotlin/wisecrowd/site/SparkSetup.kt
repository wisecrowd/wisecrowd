package wisecrowd.site

import io.schinzel.basicutils.configvar.ConfigVar
import spark.Spark

/**
 * Purpose of this file is Holding all Setup variables for Spark server
 *
 * Created by Jorgen Andersson on 2018-03-13.
 */
class SparkSetup {
    val port: Int = ConfigVar.create(".env").getValue("PORT").toInt()
    val env: String = ConfigVar.create(".env").getValue("A_ENVIRONMENT").toString()
    val projectDir = System.getProperty("user.dir")
    val staticDir = "/modules/web/site/src/main/resources/websites/site"

    constructor() {
        // Port where Spark Server is running
        spark.kotlin.port(port)

        // From where should the non-HTML static files be served (.js, .css, .png, .svg etc)
        if (env.equals("development")) {
            Spark.staticFiles.externalLocation(projectDir + staticDir)
        } else {
            Spark.staticFiles.location("/websites/site")
        }

        Spark.init()
    }
}