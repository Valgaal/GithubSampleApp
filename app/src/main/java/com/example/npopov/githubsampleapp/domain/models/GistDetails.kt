package com.example.npopov.githubsampleapp.domain.models

data class GistDetails (
        val id: String,
        val description: String,
        val owner: Owner,
        val files: List<GistFileInfo>
)