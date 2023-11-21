package dev.thiagoclemente.credit.application.system.dto

import dev.thiagoclemente.credit.application.system.entity.Address
import dev.thiagoclemente.credit.application.system.entity.Customer
import java.io.Serializable
import java.math.BigDecimal

data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipcode: String,
    val street: String
) : Serializable {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        address = Address(
            zipcode = this.zipcode,
            street = this.street
        )
    )
}