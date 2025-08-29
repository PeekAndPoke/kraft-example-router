package io.peekandpoke.kraft.examples.helloworld.domain

import de.peekandpoke.mutator.Mutable
import kotlinx.serialization.Serializable

@Mutable
@Serializable
data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: Address,
)
