package com.example.npopov.githubsampleapp.Main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.npopov.githubsampleapp.Models.User
import com.example.npopov.githubsampleapp.R
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.rw_item.view.*

class UsersListAdapter(private var items: List<User>,
                       private val context: Context,
                       val listener: (User) -> Unit) : RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rw_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(data: List<User>){
        items = data
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       private val loginText = itemView.loginTextView
       private val poster = itemView.avatarImageView

        fun bindData(user: User) {
            with(itemView) {
                loginText.text = user.login

                Picasso.get()
                        .load(user.avatar_url)
                        .resize(150,150)
                        .centerInside()
                        .into(poster);

                itemView.setOnClickListener { listener(user) }
            }
        }

    }


}
