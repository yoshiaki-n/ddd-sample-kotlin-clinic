package com.example.clinic.billing.domain.model

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
    val currency: Currency,
)
