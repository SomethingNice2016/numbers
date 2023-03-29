package com.somenthingnice.testtask.datasource.remote.numbers

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApi {


    @GET("{number}")
    suspend fun getInfoByNumber(@Path("number") number: Long): ResponseBody

}