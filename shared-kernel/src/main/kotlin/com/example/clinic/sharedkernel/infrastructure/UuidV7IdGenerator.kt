package com.example.clinic.sharedkernel.infrastructure

import com.fasterxml.uuid.Generators
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UuidV7IdGenerator : IdGenerator {

    companion object {
        private val GENERATOR = Generators.timeBasedEpochGenerator()
    }
    override fun generate(): UUID {
        return GENERATOR.generate()
    }
}