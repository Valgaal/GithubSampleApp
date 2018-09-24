package com.example.npopov.githubsampleapp.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.npopov.githubsampleapp.R

class MainActivity : AppCompatActivity(), ListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showUsers(users: Users?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun finishLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
