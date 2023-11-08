package dev.thiagoclemente.credit.application.system.dto

import dev.thiagoclemente.credit.application.system.entity.Customer
import java.io.Serializable
import java.math.BigDecimal

data class CustomerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val email: String,
    val income: BigDecimal,
    val zipcode: String,
    val street: String
) : Serializable {
    constructor(customer: Customer) : this(
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        zipcode = customer.address.zipcode,
        street = customer.address.street
    )
}