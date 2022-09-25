package com.hexagon.testapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hexagon.testapplication.databinding.ItemAirlinesBinding
import com.hexagon.testapplication.oldpackage.pojo.DataX

class AirlinesAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<DataX>()

    fun setList(artists:List<DataX>){
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemAirlinesBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_airlines,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }
}



class MyViewHolder(val binding: ItemAirlinesBinding):
    RecyclerView.ViewHolder(binding.root){

    fun bind(artist:DataX){
        binding.txtName.text = artist.name
        binding.txtCountry.text = artist.trips.toString()
    }

}