package dev.thiagoclemente.credit.application.system.service.impl

import dev.thiagoclemente.credit.application.system.entity.Credit
import dev.thiagoclemente.credit.application.system.repository.CreditRepository
import dev.thiagoclemente.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("creditCode $creditCode not found.")

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin")
    }
}