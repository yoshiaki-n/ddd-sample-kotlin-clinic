package com.example.clinic.scheduling.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalTime

class TimeRangeTest {

    @Test
    fun `正常な時間帯を作成できる`() {
        val range = TimeRange(
            LocalTime.of(9, 0), LocalTime.of(9, 30)
        )
        assertEquals(Duration.ofMinutes(30), range.duration)
    }
    @Test
    fun `開始が終了より後だとエラー`() {
        assertThrows(IllegalArgumentException::class.java) {
            TimeRange(LocalTime.of(10, 0), LocalTime.of(9, 0))
        }
    }
    @Test
    fun `同じ値のTimeRangeは等しい`() {
        val a = TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
        val b = TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
        assertEquals(a, b)
    }
    @Test
    fun `時間帯の重複を検出できる`() {
        val r1 = TimeRange(LocalTime.of(9, 0), LocalTime.of(10, 0))
        val r2 = TimeRange(LocalTime.of(9, 30), LocalTime.of(10, 30))
        assertTrue(r1.overlapsWith(r2))
    }

    // --- 追加テスト ---

    @Test
    fun `同じ時刻ではTimeRangeを作成できない`() {
        assertThrows(IllegalArgumentException::class.java) {
            TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 0))
        }
    }

    @Test
    fun `接触する時間帯は重複しない`() {
        // r1 end == r2 start: start < other.end && other.start < end で重複判定しないケース
        val r1 = TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
        val r2 = TimeRange(LocalTime.of(9, 30), LocalTime.of(10, 0))
        assertFalse(r1.overlapsWith(r2))
    }

    @Test
    fun `時刻を含むか確認できる`() {
        val range = TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
        assertTrue(range.contains(LocalTime.of(9, 15)))
    }

    @Test
    fun `終端時刻は含む`() {
        val range = TimeRange(LocalTime.of(9, 0), LocalTime.of(9, 30))
        assertTrue(range.contains(LocalTime.of(9, 30)))
    }
}