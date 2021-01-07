package com.microservice.kotlinproject.data

import com.fasterxml.jackson.annotation.JsonInclude

// Null 인 객체는 포함 시키지 않는다.
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Customer(var id: Int, var name: String = "", var telePhone: TelePhone? = null) {
    data class TelePhone(var countryCode: String = "" , var telePhoneNumer: String = "")
}