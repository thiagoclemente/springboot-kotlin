package dev.thiagoclemente.credit.application.system.controller

import dev.thiagoclemente.credit.application.system.dto.CustomerDto
import dev.thiagoclemente.credit.application.system.dto.CustomerUpdateDto
import dev.thiagoclemente.credit.application.system.dto.CustomerView
import dev.thiagoclemente.credit.application.system.entity.Customer
import dev.thiagoclemente.credit.application.system.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun create(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @PatchMapping
    fun update(@RequestParam(value = "id") id: Long, @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView {
        val customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)

        return CustomerView(customerUpdated)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = this.customerService.delete(id)
}