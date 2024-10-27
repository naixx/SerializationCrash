package org.example

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.KeepGeneratedSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@kotlinx.serialization.Serializable(UnwrappingTypeSerializer::class)
open class Wrapper<T : Wrapper<T>>

@KeepGeneratedSerializer
@Serializable(UnwrappingTypeSerializer::class)
data class Issue(
    val data: Boolean,
) : Wrapper<Issue>()

@OptIn(ExperimentalSerializationApi::class)
class UnwrappingTypeSerializer<T : Wrapper<T>>(
    private val dataSerializer: KSerializer<T>
) : KSerializer<Wrapper<T>> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("NotificationSettings")

    override fun deserialize(decoder: Decoder): Wrapper<T> {
        TODO()
    }

    override fun serialize(encoder: Encoder, value: Wrapper<T>) {
        TODO("Not yet implemented")
    }
}


fun main() {
    println("Hello World!")
}
