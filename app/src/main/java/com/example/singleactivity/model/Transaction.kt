package com.example.singleactivity.model

@kotlinx.serialization.Serializable
data class Transaction(
    var id: Int,
    var date: String,
    var money: Float,
    var name_trans: String,
    var description: String
)
