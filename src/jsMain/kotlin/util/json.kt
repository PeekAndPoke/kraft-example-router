package io.peekandpoke.kraft.examples.helloworld.util

import kotlinx.serialization.json.Json

object JsonUtil {
    val prettyJson: Json = Json { prettyPrint = true }
}
