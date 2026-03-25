package io.peekandpoke.kraft.examples.helloworld.domain

import io.peekandpoke.mutator.Mutable
import kotlinx.serialization.Serializable

@Mutable
@Serializable
data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: Address,
)
