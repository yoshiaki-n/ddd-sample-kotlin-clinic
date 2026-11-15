package com.example.clinic.scheduling.domain.model

import com.example.clinic.sharedkernel.infrastructure.IdGenerator
import org.springframework.stereotype.Component
import java.util.UUID

@JvmInline
value class DoctorId(val value: UUID)

@JvmInline
value class PatientId(val value: UUID)

@Component
class DoctorIdGenerator(
    private val idGenerator: IdGenerator,
) {
    fun generate(): DoctorId = DoctorId(idGenerator.generate())
}

@Component
class PatientIdGenerator(
    private val idGenerator: IdGenerator,
) {
    fun generate(): PatientId = PatientId(idGenerator.generate())
}