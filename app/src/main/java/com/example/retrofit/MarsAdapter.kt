package com.example.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.model.Terrain
import kotlinx.android.synthetic.main.item.view.*

class MarsAdapter(var mPassMars: Mars) : RecyclerView.Adapter<MarsAdapter.TaskViewHolder>() { // Paso 4 //Implementar RecyclerView

    private var dataList = emptyList<Terrain>() // Paso 1


    fun updateListMars(mDataList: List<Terrain>){ //Paso 2

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{ //Paso 3

        val imgTerrain = itemView.imageView
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) { // Paso 5

            mPassMars.passMars(dataList[adapterPosition])
        }

    }
    // Esto se implemento o NO? despues del paso 4
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder { // Paso 4.1.0.0

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return TaskViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) { //Paso 4.2.0.0

        val mTerrain: Terrain = dataList[position]

        Glide.with(holder.itemView.context).load(mTerrain.imgScr).into(holder.imgTerrain)

    }

    override fun getItemCount() = dataList.size  // Paso 4.3.0.0

    interface Mars{
        fun passMars(mTerrain: Terrain)

    }
}
