package wisecrowd.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * The purpose of this enum is to handle conversion between strings and instant
 * and date time representation.
 *
 * @author Jorgen Andersson <jorgen@kollektiva.se>
 */
public enum DateTimeFormat {
    S3_DIR_STRUCTURE(DateTimeFormatter.ofPattern("yyyy-MM/dd/HH_mm_ss"));

    private final DateTimeFormatter mFormatter;


    DateTimeFormat(DateTimeFormatter formatter) {
        mFormatter = formatter;
    }


    public String getNowUTC() {
        Instant instant = Instant.now();
        return LocalDateTime.ofInstant(instant, ZoneId.of("UTC")).format(mFormatter);
    }

}
