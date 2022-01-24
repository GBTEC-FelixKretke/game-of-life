package me.skulduggerry.gameoflife.utils;

import static java.time.Clock.systemUTC;
import static java.time.ZoneOffset.UTC;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDateTime;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class DateTimeUtils {

    public static long currentUtcTimeInMillis() {
        return LocalDateTime.now(systemUTC()).toInstant(UTC).toEpochMilli();
    }
}
