package com.example.npopov.githubsampleapp.data.models.commit

import com.google.gson.annotations.SerializedName

data class CommitDataResponse (
        @SerializedName("deletions")
        val deletions: String?,

        @SerializedName("additions")
        val additions: String
)