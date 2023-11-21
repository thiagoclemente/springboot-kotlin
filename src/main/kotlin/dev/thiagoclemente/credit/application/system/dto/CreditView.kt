package dev.thiagoclemente.credit.application.system.dto

import dev.thiagoclemente.credit.application.system.entity.Credit
import dev.thiagoclemente.credit.application.system.enummeration.Status
import java.io.Serializable
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,
    val status: Status,
    val emailCustomer: String?,
    val incomerCustomer: BigDecimal?
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        incomerCustomer = credit.customer?.income,
    )
}