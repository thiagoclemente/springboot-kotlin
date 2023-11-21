package dev.thiagoclemente.credit.application.system.dto

import dev.thiagoclemente.credit.application.system.entity.Credit
import dev.thiagoclemente.credit.application.system.entity.Customer
import dev.thiagoclemente.credit.application.system.enummeration.Status
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

/**
 * DTO for {@link dev.thiagoclemente.credit.application.system.entity.Credit}
 */
data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) : Serializable {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}