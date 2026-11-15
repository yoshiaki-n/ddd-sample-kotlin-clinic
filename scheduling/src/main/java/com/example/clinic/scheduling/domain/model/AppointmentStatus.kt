package com.example.clinic.scheduling.domain.model

import java.time.Instant

sealed class AppointmentStatus {
    data object  Pending : AppointmentStatus()

    data class Confirmed(
        val confirmedAt: Instant,
    ) : AppointmentStatus()

    data class Canceled(
        val cancelledAt: Instant,
        val reason: String,
    ) : AppointmentStatus()

    fun toDbValue(): String = when (this) {
        is Pending -> "PENDING"
        is Canceled -> "CANCELLED"
        is Confirmed -> "CONFIRMED"
    }

    companion object {
        fun fromDbValue(value: String): AppointmentStatus =
            when (value) {
                "PENDING" -> Pending
                "CONFIRMED" -> Confirmed(Instant.now())
                "CANCELLED" -> Canceled(Instant.now(), "")
                else -> throw IllegalArgumentException("不明なステータス: $value")
            }
    }
}