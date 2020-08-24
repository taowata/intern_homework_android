package com.example.intern_anrdoid_2020

import com.example.intern_anrdoid_2020.model.response.QiitaArticleResponse

class ArticleList(val list: List<QiitaArticleResponse>) : ArrayList<QiitaArticleResponse>(list) {
}