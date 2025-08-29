package io.peekandpoke.kraft.examples.helloworld.domain

import de.peekandpoke.mutator.Mutable
import kotlinx.serialization.Serializable

@Mutable
@Serializable
data class Address(
    val line1: String,
    val line2: String,
    val zip: String,
    val city: String,
    val country: String,
)
