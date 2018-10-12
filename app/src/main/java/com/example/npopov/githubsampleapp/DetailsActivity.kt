package com.example.npopov.githubsampleapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.npopov.githubsampleapp.Models.Repository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsActivity: MvpAppCompatActivity(), DetailsView {

    @InjectPresenter
    lateinit var detailsPresenter: DetailsPresenter



    @ProvidePresenter
    fun provideDetailsPresenter(): DetailsPresenter {

        return DetailsPresenter(intent.getStringExtra(DETAILS), Repository.getInstance(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_details)
    }

    override fun showDetails(detailsModel: DetailsModel) {

        if(detailsModel.poster_url != "") {
            Picasso.get()
                    .load(detailsModel.poster_url)
                    .resize(300, 300)
                    .centerInside()
                    .into(posterBig)
        }
        repos_count.text = detailsModel.reposCount.toString()
        linkToProfile.text = detailsModel.linkToProfile
        titleName.text = detailsModel.name
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        val DETAILS = "DETAILS_MODEL"
    }
}