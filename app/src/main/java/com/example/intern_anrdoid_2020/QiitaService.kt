package com.example.intern_anrdoid_2020

import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*

interface QiitaService {
    @GET("items")
    @Headers("Content-Type: application/json")
    fun getQiitaArticle(@Query("page") page: Int,
                        @Query("per_page") per_page: Int,
                        @Query("query") query: String?): Call<ArrayList<QiitaArticleResponse>>
}
