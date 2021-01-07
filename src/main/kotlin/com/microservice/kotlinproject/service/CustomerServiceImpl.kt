package com.microservice.kotlinproject.service

import com.microservice.kotlinproject.data.Customer
import com.microservice.kotlinproject.data.Customer.TelePhone
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service


@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initCustomer = arrayOf(
            Customer(1 , "jisang" , TelePhone("1", "2"))
            , Customer(2 , "2" , null) , Customer(3 , "3" , null))
    }
    val customers = getCustomer()

    @Bean
    fun getCustomer(): HashMap<Int, Customer> {
        val hashMap : HashMap<Int , Customer> = mutableMapOf<Int, Customer>() as HashMap<Int, Customer>
        for (i in initCustomer.indices) {
            hashMap.put(i+1 , initCustomer[i])
        }
        return hashMap
    }

    override fun getCustomer(id: Int): Customer? = customers[id]

    override fun createCustomer(customer: Customer): Customer {
        customers[customer.id] = customer
        return customer
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer): Customer? {
        customers[id] = customer
        return customers[id]
    }

    override fun searchCustomer(nameFilter: String): List<Customer?> {
        return customers.filterValues {
            it.name.contains(nameFilter , true)
        }.keys.map { customers[it] }.sortedBy { it?.id }
    }

    override fun getCustomers(): List<Customer?> {
        return customers.keys.map { customers[it] }.toList()
    }
}