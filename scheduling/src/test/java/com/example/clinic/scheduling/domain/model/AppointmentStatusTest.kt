package com.example.clinic.scheduling.domain.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.UUID

class AppointmentStatusTest {

    @Test
    fun `PendingのtoDbValueはPENDING`() {
        val status = AppointmentStatus.Pending
        assertEquals("PENDING", status.toDbValue())
    }

    @Test
    fun `ConfirmedのtoDbValueはCONFIRMED`() {
        val status = AppointmentStatus.fromDbValue("CONFIRMED")
        assertEquals("CONFIRMED", status.toDbValue())
    }

    @Test
    fun `fromDbValue CONFIRMED はConfirmed型を返す`() {
        val status = AppointmentStatus.fromDbValue("CONFIRMED")
        assertInstanceOf(AppointmentStatus.Confirmed::class.java, status)
    }

    @Test
    fun `fromDbValue CANCELLED はCancelled型を返す`() {
        val status = AppointmentStatus.fromDbValue("CANCELLED")
        assertInstanceOf(AppointmentStatus.Canceled::class.java, status)
    }

    @Test
    fun `不明な値のfromDbValueはIllegalArgumentExceptionをスロー`() {
        assertThrows(IllegalArgumentException::class.java) {
            AppointmentStatus.fromDbValue("UNKNOWN")
        }
    }

//    @Test
//    fun `Cancelledにはreasonが保存される`() {
//        val appointment = Appointment.create(
//            patientId = PatientId(UUID.randomUUID()),
//            timeRange = DayScheduleFixture.aTimeRange(),
//        )
//        val reason = "体調不良のため"
//        appointment.cancel(reason)
//        val status = appointment.getStatus()
//        assertInstanceOf(AppointmentStatus.Cancelled::class.java, status)
//        assertEquals(reason, (status as AppointmentStatus.Cancelled).reason)
//    }

}
