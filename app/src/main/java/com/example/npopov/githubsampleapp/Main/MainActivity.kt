package com.example.npopov.githubsampleapp.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.npopov.githubsampleapp.Models.User
import com.example.npopov.githubsampleapp.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListView {
    private var mAdapter: UsersListAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rw_trending.layoutManager = LinearLayoutManager(this)
        mAdapter = UsersListAdapter(ArrayList<User>(), this ,{
            //open Fragment details in Presenter
        })
        rw_trending.adapter = mAdapter
    }

    override fun showUsers(users: List<User>) {
        mAdapter?.setData(users)
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
