package dev.thiagoclemente.credit.application.system.service

import dev.thiagoclemente.credit.application.system.entity.Credit
import dev.thiagoclemente.credit.application.system.entity.Customer
import java.util.UUID

interface ICustomerService {
    fun save(customer: Customer): Customer

    fun  findById(id: Long): Customer

    fun delete(id: Long): Customer
}