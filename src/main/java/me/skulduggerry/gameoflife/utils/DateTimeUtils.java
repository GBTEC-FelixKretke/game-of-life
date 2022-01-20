package me.skulduggerry.gameoflife.utils;

import static java.time.Clock.systemUTC;
import static java.time.ZoneOffset.UTC;

import java.time.LocalDateTime;

public class DateTimeUtils {

    public static long currentUtcTimeInMillis() {
        return LocalDateTime.now(systemUTC()).toInstant(UTC).toEpochMilli();
    }
}
