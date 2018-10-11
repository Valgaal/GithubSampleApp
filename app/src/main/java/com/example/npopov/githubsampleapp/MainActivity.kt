package com.example.npopov.githubsampleapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.npopov.githubsampleapp.Details.DetailsActivity
import com.example.npopov.githubsampleapp.Details.DetailsModel
import com.example.npopov.githubsampleapp.Models.Repository
import com.example.npopov.githubsampleapp.UsersList.ListModel
import com.example.npopov.githubsampleapp.UsersList.UsersListAdapter

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), ListView {
    private var mAdapter: UsersListAdapter? = null

    @InjectPresenter
    lateinit var mListPresenter: ListPresenter

    @ProvidePresenter
    fun provideListPresenter(): ListPresenter {
        return ListPresenter(Repository.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rw_trending.layoutManager = LinearLayoutManager(this)
        mAdapter = UsersListAdapter(ArrayList(), this, {
            mListPresenter.userClicked(it)
        })
        rw_trending.adapter = mAdapter
        swipe_refresh.setOnRefreshListener{
            mListPresenter.loadUsers()
        }
    }

    override fun showUsers(users: List<ListModel>) {
        mAdapter?.setData(users)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun startLoading() {
        swipe_refresh.isRefreshing = true
    }

    override fun finishLoading() {
        swipe_refresh.isRefreshing = false
    }

    override fun showUserDetails(login: String) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.DETAILS, login)
        startActivity(intent)
    }

}
