package wisecrowd.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * Purpose of this enumeration is holding type of WebServer to run
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-12.
 */
@Accessors(prefix = "m")
@AllArgsConstructor
@Getter
public enum WebServerType {
    SITE(5555),
    ADMIN(5556);

    private int mDevPort;
}
