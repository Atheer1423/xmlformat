package com.example.xmlformat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemlayout.view.*

class Adapter(val context: Context, val input:ArrayList<Students>) : RecyclerView.Adapter<Adapter.itemViewHolder>() {

        class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


        override fun onBindViewHolder(holder: itemViewHolder, position: Int) {

            val message = input[position]

            holder.itemView.apply {

                tv1.text = "${message.name}\n ${message.marks} "


            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
            return itemViewHolder(

                LayoutInflater.from(context).inflate(
                    R.layout.itemlayout,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount() = input.size

    }

