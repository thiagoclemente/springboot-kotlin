package dev.thiagoclemente.credit.application.system.service.impl

import dev.thiagoclemente.credit.application.system.entity.Customer
import dev.thiagoclemente.credit.application.system.repository.CustomerRepository
import dev.thiagoclemente.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id no found")
        }

    override fun delete(id: Long) =
        this.customerRepository.deleteById(id)

}