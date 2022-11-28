package com.example.algorithmvisualizer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.algorithmvisualizer.databinding.SingleNumberLayoutBinding

class NumbersAdapter :
    ListAdapter<Numbers, NumbersAdapter.NumbersViewHolder>(
        NewsDiffCallBack()
    ) {

//    private lateinit var itemClickListener: (ArticleDomain, Int) -> Unit

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): NumbersViewHolder {
        val binding =
            SingleNumberLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumbersViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bindData()
    }

    inner class NumbersViewHolder(private val binding: SingleNumberLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var model: Numbers? = null

        fun bindData() {
            model = getItem(adapterPosition)
            binding.apply {
                tvSingleNum.text = model?.number.toString()
            }

//            binding.ivNewsImage.setOnClickListener {
//                itemClickListener.invoke(model!!, absoluteAdapterPosition)
//            }
        }
    }

//    fun setOnItemClickListener(clickListener: (ArticleDomain, Int) -> Unit) {
//        itemClickListener = clickListener
//    }

}

class NewsDiffCallBack :
    DiffUtil.ItemCallback<Numbers>() {
    override fun areItemsTheSame(
        oldItem: Numbers,
        newItem: Numbers
    ): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(
        oldItem: Numbers,
        newItem: Numbers
    ): Boolean {
        return oldItem == newItem
    }


}