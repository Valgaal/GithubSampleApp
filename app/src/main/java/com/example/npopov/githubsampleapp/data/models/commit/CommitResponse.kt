package com.example.npopov.githubsampleapp.data.models.commit

import com.example.npopov.githubsampleapp.data.models.commit.CommitDataResponse
import com.google.gson.annotations.SerializedName

data class CommitResponse (
        @SerializedName("version")
        val version: String?,

        @SerializedName("change_status")
        val commitData: CommitDataResponse?
)