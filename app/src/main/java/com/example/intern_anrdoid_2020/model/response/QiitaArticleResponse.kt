package com.example.intern_anrdoid_2020.model.response

import java.io.Serializable
import java.util.*


@kotlinx.serialization.Serializable
data class QiitaArticleResponse(

        var rendered_body: String?,
        var body: String?,
        var coediting: Boolean?,
        var createdAt: String?,
        var group: Group?,
        var id: String?,
        var likesCount: Int?,
        var isPrivate: Boolean?,
        var reactionsCount: Int?,
        var tags: List<Tags>?,
        var title: String?,
        var updatedAt: String?,
        var url: String?,
        var user: User?,
        var pageViewsCount: String?
) : Serializable

@kotlinx.serialization.Serializable
data class Group(
        var createdAt: Date?,
        var id: Int?,
        var name: String?,
        var isPrivate: Boolean?,
        var updatedAt: String?,
        var urlName: String?
) : Serializable

@kotlinx.serialization.Serializable
data class Tags(
        var name: String?,
        var versions: List<String>?
) : Serializable

@kotlinx.serialization.Serializable
data class User(
        var description: String?,
        var facebookId: String?,
        var followeesCount: Int?,
        var followersCount: Int?,
        var githubLoginName: String?,
        var id: String?,
        var itemsCount: Int?,
        var linkedinId: String?,
        var location: String?,
        var name: String?,
        var organization: String?,
        var permanentId: Int?,
        var profileImageUrl: String?,
        var teamOnly: Boolean?,
        var twitterScreenName: String?,
        var websiteUrl: String?
) : Serializable
