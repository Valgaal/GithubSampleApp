package com.example.npopov.githubsampleapp

import java.io.Serializable

data class DetailsModel(val poster_url: String,
                        val linkToProfile: String,
                        val name:String,
                        val reposCount: Int):Serializable