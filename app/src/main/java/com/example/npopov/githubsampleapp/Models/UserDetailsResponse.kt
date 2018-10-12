package com.example.npopov.githubsampleapp.Models

data class UserDetailsResponse(
        val login: String,
        val id: Int,
        val node_id: String,
        val avatar_url: String,
        val gravatar_id:String,
        val url:String,
        val html_url:String,
        val name:String,
        val public_repos: Int)