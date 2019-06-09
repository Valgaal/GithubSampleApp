package com.example.npopov.githubsampleapp.domain.models

data class Gist (
        val id: String,
        val description: String,
        val owner: Owner
)