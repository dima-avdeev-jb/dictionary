import java.text.SimpleDateFormat
import java.util.*

val COMPOSE_VERSION = "1.2.0"
val KOTLIN_VERSION = "1.7.10"
val SERIALIZATION_VERSION = "1.3.2"
val COROUTINES_VERSION = "1.6.0"
val BUILD_TIME_STR = Date().formatTo("yyyy-MM-dd' 'HH:mm", TimeZone.getTimeZone("Europe/Moscow"))

fun Date.formatTo(dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    formatter.timeZone = timeZone
    return formatter.format(this)
}

