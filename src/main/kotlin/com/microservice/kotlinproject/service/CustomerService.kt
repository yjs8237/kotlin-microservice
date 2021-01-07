package com.microservice.kotlinproject.service

import com.microservice.kotlinproject.data.Customer
import sun.jvm.hotspot.tools.jcore.NameFilter

interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun createCustomer(customer: Customer) : Customer?
    fun deleteCustomer(id: Int)
    fun updateCustomer(id: Int , customer: Customer) : Customer?
    fun searchCustomer(nameFilter: String) : List<Customer?>
    fun getCustomers() : List<Customer?>
}