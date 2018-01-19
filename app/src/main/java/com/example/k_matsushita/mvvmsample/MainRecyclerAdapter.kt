package com.example.k_matsushita.mvvmsample

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.k_matsushita.mvvmsample.databinding.LayoutEventRowBinding

/**
 * [ConnpassEvent.Event] の一覧を表示するアダプタ
 *
 * Created by k-matsushita on 2018/01/19.
 */
class MainRecyclerAdapter(private val context: Context): RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    var events: List<ConnpassEvent.Event>? = null
        set(value) {
            DiffUtil.calculateDiff(DiffUtilCallback(field, value)).dispatchUpdatesTo(this)
            field = value
        }

    private var clickListener: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<LayoutEventRowBinding>(LayoutInflater.from(context), R.layout.layout_event_row, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = events?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ev = events?.getOrNull(position) ?: return
        holder.binding.event = ev
        holder.binding.root.setOnClickListener {
            clickListener?.invoke()
        }
    }

    fun setOnClickListener(callback: () -> Unit) {
        this.clickListener = callback
    }

    inner class ViewHolder(val binding: LayoutEventRowBinding): RecyclerView.ViewHolder(binding.root)
}