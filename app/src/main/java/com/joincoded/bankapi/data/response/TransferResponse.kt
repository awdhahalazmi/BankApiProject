package com.joincoded.bankapi.data.response

data class TransferResponse(
    val senderId: String,
    val recieverId: String,
    val amount: Double,

)