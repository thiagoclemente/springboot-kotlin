package dev.thiagoclemente.credit.application.system.dto

import dev.thiagoclemente.credit.application.system.entity.Customer
import java.io.Serializable
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipcode: String,
    val street: String,
) : Serializable {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipcode = this.zipcode

        return customer
    }
}