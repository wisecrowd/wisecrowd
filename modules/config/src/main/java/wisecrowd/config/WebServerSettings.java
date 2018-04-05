package wisecrowd.config;

import io.schinzel.basicutils.configvar.ConfigVar;

/**
 * Purpose of this class holding server settings for AtExpose setup
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-12.
 */

public class WebServerSettings {


    private final static ConfigVar config = ConfigVar.create(".env");
    private final static String mHerokuPort = config.getValue("PORT");
    private final static String mEnvironment = config.getValue("A_ENVIRONMENT");
    private final static String mHerokuWebServer = config.getValue("A_WEB");
    private final WebServerType mDevWebServer;

    public WebServerSettings(WebServerType webServer) {
        mDevWebServer = webServer;
    }

    public int getPort() {
        // If environment is on Heroku
        if (isProduction() || isStaging()) {
            return Integer.parseInt(mHerokuPort);
        }
        // If Local environment
        if (isDevelopment()) {
            return mDevWebServer.getDevPort();
        }
        // If invalid environment
        throw new RuntimeException("Illegal state when requesting port of environment and run mode.");
    }

    public int numberOfServerThreads() {
        return 5;
    }

    public boolean forceHttps() {
        return isProduction() || isStaging();
    }

    public boolean cacheFilesInRam() {
        return isProduction() || isStaging();
    }

    public boolean useLogger() {
        return isProduction() || isStaging();
    }

    public boolean isStagingOrProduction() {
        return isProduction() || isStaging();
    }


    public static boolean isProduction() {
        return mEnvironment.equalsIgnoreCase("PRODUCTION");
    }

    public static boolean isStaging() {
        return mEnvironment.equalsIgnoreCase("STAGING");
    }

    public static boolean isDevelopment() {
        return mEnvironment.equalsIgnoreCase("DEVELOPMENT");
    }

    public static boolean isAdmin() {
        return mHerokuWebServer.equalsIgnoreCase("admin");
    }

    public static boolean isSite() {
        return mHerokuWebServer.equalsIgnoreCase("site");
    }

    public static String getEnvironment() {
        return mEnvironment;
    }
}
