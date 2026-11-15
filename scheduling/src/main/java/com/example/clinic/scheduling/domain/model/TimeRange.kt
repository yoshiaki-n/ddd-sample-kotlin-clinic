package com.example.clinic.scheduling.domain.model

import java.time.Duration
import java.time.LocalTime

/// 期間のValue Objectです。
data class TimeRange(
    val start: LocalTime,
    val end: LocalTime,
) {
    init {
        require(start < end) {
            "開始時刻($start)は終了時刻($end)より前"
        }
    }

    val duration: Duration
        get() = Duration.between(start, end)

    fun overlapsWith(other: TimeRange): Boolean =
        start < other.end && other.start < end

    fun contains(time: LocalTime): Boolean =
        time in start..end

    override fun toString(): String =
        "$start-$end"
}
