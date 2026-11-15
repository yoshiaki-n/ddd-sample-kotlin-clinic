package com.example.clinic.sharedkernel.infrastructure

import java.util.UUID

/// IDの生成を行います。
fun interface IdGenerator {
    fun generate() : UUID
}