package dev.weazyexe.unsplsh.utils.extensions

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Converts date string to [LocalDate] with yyyy-MM-ddTHH:MM:SSZ format
 */
fun String.toDate(): LocalDate? {
    return LocalDate.parse(this, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
}