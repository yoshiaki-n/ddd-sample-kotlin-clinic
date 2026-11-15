package com.example.clinic.scheduling.domain.model

import com.example.clinic.sharedkernel.infrastructure.UuidV7IdGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.UUID

class DoctorIdTest {

    @Test
    fun `同じUUIDのDoctorIdは等しい`() {
        val uuid = UUID.randomUUID()
        val id1 = DoctorId(uuid)
        val id2 = DoctorId(uuid)
        assertEquals(id1, id2)
    }

    @Test
    fun `異なるUUIDのDoctorIdは等しくない`() {
        val id1 = DoctorId(UUID.randomUUID())
        val id2 = DoctorId(UUID.randomUUID())
        assertNotEquals(id1, id2)
    }

    @Test
    fun `DoctorIdGeneratorは毎回異なるIDを生成する`() {
        val generator = DoctorIdGenerator(UuidV7IdGenerator())
        val id1 = generator.generate()
        val id2 = generator.generate()
        assertNotEquals(id1, id2)
    }

    @Test
    fun `DoctorIdGeneratorにUuidV7IdGeneratorを渡すとUUIDv7を生成する`() {
        val generator = DoctorIdGenerator(UuidV7IdGenerator())
        val id = generator.generate()
        assertEquals(7, id.value.version())
    }

    @Test
    fun `DoctorIdGeneratorに任意のIdGeneratorを注入してIDを生成できる`() {
        val fixedUuid = UUID.fromString("01234567-89ab-7cde-8f01-23456789abcd")
        val generator = DoctorIdGenerator { fixedUuid }
        val id = generator.generate()
        assertEquals(fixedUuid, id.value)
    }

    @Test
    fun `同じUUIDのPatientIdは等しい`() {
        val uuid = UUID.randomUUID()
        val id1 = PatientId(uuid)
        val id2 = PatientId(uuid)
        assertEquals(id1, id2)
    }

    @Test
    fun `PatientIdGeneratorは毎回異なるPatientIdを生成する`() {
        val generator = PatientIdGenerator(UuidV7IdGenerator())
        val id1 = generator.generate()
        val id2 = generator.generate()
        assertNotEquals(id1, id2)
    }

    @Test
    fun `PatientIdGeneratorにUuidV7IdGeneratorを渡すとUUIDv7を生成する`() {
        val generator = PatientIdGenerator(UuidV7IdGenerator())
        val id = generator.generate()
        assertEquals(7, id.value.version())
    }

    @Test
    fun `PatientIdGeneratorに任意のIdGeneratorを注入してIDを生成できる`() {
        val fixedUuid = UUID.fromString("01234567-89ab-7cde-8f01-23456789abcd")
        val generator = PatientIdGenerator { fixedUuid }
        val id = generator.generate()
        assertEquals(fixedUuid, id.value)
    }
}