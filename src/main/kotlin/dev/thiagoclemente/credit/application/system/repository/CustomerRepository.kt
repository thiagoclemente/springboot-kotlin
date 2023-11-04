package dev.thiagoclemente.credit.application.system.repository

import dev.thiagoclemente.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long>