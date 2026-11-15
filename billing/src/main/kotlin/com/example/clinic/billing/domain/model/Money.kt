package com.example.clinic.billing.domain.model

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
    val currency: Currency,
) {
    init {
        require(amount >= BigDecimal.ZERO) {
            "金額は0以上: $amount"
        }
    }

    operator fun plus(other: Money): Money {
        requireSameCurrency(other)
        return Money(amount + other.amount, currency)
    }

    operator fun times(factor: Int): Money =
        Money(amount * factor.toBigDecimal(), currency)

    private fun requireSameCurrency(other: Money) {
        require(currency == other.currency) {
            "通過が異なります: $currency vs ${other.currency}"
        }
    }

    companion object {
        fun jpy(amount: Int): Money =
            Money(amount.toBigDecimal(), Currency.JPY)
    }
}
