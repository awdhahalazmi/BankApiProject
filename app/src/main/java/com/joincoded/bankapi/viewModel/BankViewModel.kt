package com.joincoded.bankapi.viewModel

import android.app.Application
import android.content.Context
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.data.response.TransferResponse
import com.joincoded.bankapi.interfaceAPI.BankApiService
import com.joincoded.bankapi.singleton.RetrofitHelper
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody

class BankViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BankApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)
    var currentUser: User? by mutableStateOf(null)
    var transactions: List<TransferResponse> by mutableStateOf(emptyList())
    private val sharedPreferencesKey = "user_token"
    var application: Application? = null
    var balance: Double = 0.0
    // variable for balance = 0.0

    init {
        retrieveToken()
    }

    private val sharedPreferences = application?.getSharedPreferences(
        "Saved account", Context.MODE_PRIVATE
    )

    // Retrieve the token from SharedPreferences
    fun retrieveToken(): String? {
        return sharedPreferences?.getString(sharedPreferencesKey, null)
    }

    // Save the token to SharedPreferences
    private fun saveToken(token: String?) {
        sharedPreferences?.edit()?.putString(sharedPreferencesKey, token)?.commit()
    }

    fun signup(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, image, 0.0, null))
                token = response.body()
                saveToken(token?.token)
                getAccountInfo()
            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = apiService.login(User(username, password))
                println(response.code())
                println(response.message())
                println(response.body())
                token = response.body()
                saveToken(token?.token)
                getAccountInfo()
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun deposit(amount: Double) {
        viewModelScope.launch {
            try {
                if (token != null && currentUser != null) {
                    val response =
                        apiService.deposit(token = token?.getBearerToken(), AmountChange(amount))
                    if (response.isSuccessful) {
                        updateBalance(amount + balance)


                        println("Successful Deposit. Amount: $amount")
                    }
                } else {
                    print("please log in ")
                }


            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }

    fun withdraw(amount: Double) {
        viewModelScope.launch {
            try {
                if (token != null && currentUser != null) {
                    val response =
                        apiService.withdraw(token = token?.getBearerToken(), AmountChange(amount))
                    if (amount <= balance) {
                        updateBalance(amount - balance)

                        println("Successful Withdraw. Amount: $amount")
                    }

                } else {
                    print("please log in ")

                }

            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }

    fun transactionToUser(username: String, amount: Double) {
        viewModelScope.launch {
            try {
                if (token != null && currentUser != null) {
                    val response = apiService.transferToUser(
                        token = token?.getBearerToken(),
                        username,
                        AmountChange(amount)
                    )
                    println("Successful Transfer. Amount: $amount to user: $username")

                } else {
                    println("you are not logged in")
                }

            } catch (e: Exception) {
                println("Error $e")
            }

        }
    }

    fun getTransactions() {
        viewModelScope.launch {
            try {
                // Check if the user is logged in
                //if (token != null) {
                transactions = apiService.getTransactions(token?.getBearerToken())

            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun updateProfile(username: String, password: String, image: MultipartBody.Part) {
        viewModelScope.launch {
            try {
                // Check if the user is logged in
                //if (token != null) {
                val response = apiService.updateProfile(
                    token?.getBearerToken(),
                    username.toRequestBody(),
                    password.toRequestBody(),
                    image
                )

                if (response.isSuccessful) {
                    // Handle the update profile success
                    println("Profile updated successfully.")
                } else {
                    println("Error: ${response.code()} - ${response.message()}")
                }

            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun getAccountInfo() {
        viewModelScope.launch {
            try {
                currentUser = apiService.getAccountInfo(token?.getBearerToken())
                println(currentUser?.username)
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun updateBalance(newBalance: Double) {
        viewModelScope.launch {
            balance = newBalance
            try {
                if (token != null) {
                    val response =
                        apiService.deposit(token?.getBearerToken(), AmountChange(newBalance))
                    if (response.isSuccessful) {
                        println("Balance updated successfully. New Balance: $newBalance")
                    } else {
                        println("Error updating balance: ${response.code()} - ${response.message()}")
                    }
                } else {
                    println("You are not logged in")
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }
}





