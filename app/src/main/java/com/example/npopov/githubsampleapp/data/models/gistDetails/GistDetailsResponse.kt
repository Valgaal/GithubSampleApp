package com.example.npopov.githubsampleapp.data.models.gistDetails

import com.example.npopov.githubsampleapp.data.models.gistList.FileResponse
import com.example.npopov.githubsampleapp.data.models.gistList.OwnerResponse
import com.google.gson.annotations.SerializedName

data class GistDetailsResponse(
        @SerializedName("files")
        val files: Map<String, FileResponse>?,

        @SerializedName("description")
        val description: String?,

        @SerializedName("owner")
        val owner: OwnerResponse?
)