package wisecrowd.starter;

import wisecrowd.site.ServerKt;

/**
 * Purpose of this class is to start the correct environment
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-12.
 */
public class StarterMain {
    public static void main(String[] args) {
        ServerKt.startServer(args);
        System.out.println("***************************************************");
        System.out.println("**              wisecrowd Site                  **");
        System.out.println("***************************************************");
    }
}
