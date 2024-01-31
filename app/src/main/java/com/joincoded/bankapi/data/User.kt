package com.joincoded.bankapi.data

data class User(
    var username: String,
    var password: String,
    var image: String?,
    var balance: Double?,
    var token: String?
)
{
 constructor (username: String, password: String): this(username, password,"",0.0,"")

}