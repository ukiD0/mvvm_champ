package com.example.singleactivity.model

@kotlinx.serialization.Serializable
data class Order (
    var id: Int,
    var address: String,
    var country: String,
    var phone: Int,
    var others: String
)
