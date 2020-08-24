package com.example.intern_anrdoid_2020.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.intern_anrdoid_2020.HttpClient
import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

object QiitaListRepository {
    private val LOG_TAG = QiitaListRepository::class.java.simpleName
    fun listArticle(page: Int, per_page: Int, query: String?): LiveData<ArrayList<QiitaArticleResponse>> {
        val data = MutableLiveData<ArrayList<QiitaArticleResponse>>()
        val qiitaService = HttpClient.qiitaService
        qiitaService.getQiitaArticle(page, per_page, query).enqueue(object : Callback<ArrayList<QiitaArticleResponse>> {
            override fun onResponse(call: Call<ArrayList<QiitaArticleResponse>?>?, response: Response<ArrayList<QiitaArticleResponse>>) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                } else {
                    data.postValue(null)
                }
            }

            override fun onFailure(call: Call<ArrayList<QiitaArticleResponse>?>, t: Throwable) {
                data.postValue(null)
                Log.e(LOG_TAG, "API連携に失敗:" + t.message)
            }
        })
        return data
    }
}
