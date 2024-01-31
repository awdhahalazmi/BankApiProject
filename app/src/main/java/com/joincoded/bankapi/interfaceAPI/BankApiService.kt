package com.joincoded.bankapi.interfaceAPI

import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.data.response.TransferResponse
import com.joincoded.bankapi.utils.Constants
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface BankApiService {

    @POST(Constants.signupEndpoint)
    suspend fun signup(@Body user: User): Response<TokenResponse>

    @POST(Constants.loginEndpoint)
    suspend fun login(@Body user: User): Response<TokenResponse>

    @GET(Constants.accountEndpoint)
    suspend fun getAccountInfo(@Header(Constants.authorization)token: String?): User



    @GET( Constants.transactionEndpoint)
            suspend fun getTransactions (@Header(Constants.authorization) token: String?): List<TransferResponse>

    @POST(Constants.transferEndPoint)
    suspend fun transferToUser(
        @Header(Constants.authorization) token: String?,
        @Path("username") username: String,
        @Body amountChange: AmountChange
    ): Response<Unit>



    @PUT(Constants.depositEndpoint)
    suspend fun deposit(@Header(Constants.authorization) token: String?,
                        @Body amountChange: AmountChange
    ): Response<Unit>

    @PUT(Constants.withdrawEndpoint)
    suspend fun withdraw(@Header(Constants.authorization) token: String?,
                        @Body amountChange: AmountChange
    ): Response<Unit>

    @Multipart
    @PUT(Constants.updateEndpoint)
    suspend fun updateProfile(
        @Header(Constants.authorization) token: String?,
        @Part("username") username: RequestBody,
        @Part("password") password: RequestBody,
        @Part image: MultipartBody.Part
    ): Response<Unit>
}

