package com.example.npopov.githubsampleapp.Details

import java.io.Serializable

data class DetailsModel(val poster_url: String,
                        val linkToProfile: String,
                        val login:String,
                        val reposCount: Int):Serializable